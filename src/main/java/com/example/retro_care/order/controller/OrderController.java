package com.example.retro_care.order.controller;

import com.example.retro_care.order.model.IOrderProjection;
import com.example.retro_care.order.model.Orders;
import com.example.retro_care.order.service.IOrderService;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import com.example.retro_care.order.model.EmailMessage;
import com.example.retro_care.order.projection.CartProjection;
import com.example.retro_care.order.service.ICartDetailsService;
import com.example.retro_care.order.service.IOrderService;
import com.example.retro_care.order.service.mail.IEmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/api/orders")
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;
    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: displays a paginated list of order;
     * @param : page (page number), limit(number of elements in the page);
     * @return : paginated order list with limit number of molecules per page.
     */
    @GetMapping(value = {"/", "/list"})
    public ResponseEntity<Page<IOrderProjection>> getListOrder(@PageableDefault(size = 5)Pageable pageable,@RequestParam("page") String page) {
        int currentPage;

        try {
            currentPage = Integer.parseInt(page);
        } catch (NumberFormatException e) {
            currentPage = 0;
        }

        pageable = PageRequest.of(currentPage, pageable.getPageSize(), pageable.getSort());
        Page<IOrderProjection> ordersPage = iOrderService.getListOrder(pageable);
        System.out.println("00000"+currentPage);
        return  new ResponseEntity<>(ordersPage,HttpStatus.OK);
    }
    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: get list for order by id;
     * @Param Long id;
     * @return : If the id parameter is found, the data of that id will be displayed.
     */
    @GetMapping({"/id"})
    public ResponseEntity<?> getOrderById(@PathVariable Long id){
        Orders orders = iOrderService.findOrderById(id);
        if(orders==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: Delete for order by id;
     * @Param Long id;
     * @return :If the passed id parameter is found, the word with that id will be removed from the list
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        this.iOrderService.deleteOrderById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: Filter for order by datetime;
     * @return : If the correct parameter is passed, the list will be filtered according to that parameter,
     * otherwise the original list will be returned.
     */
    @GetMapping()
    public ResponseEntity<List<Orders>> getOrdersByDateTimeRange(
            @RequestParam("startDateTime") LocalDateTime startDateTime,
            @RequestParam("endDateTime") LocalDateTime endDateTime) {

        List<Orders> orders = iOrderService.findByDateTimeRange(startDateTime, endDateTime);

        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @Autowired
    private IOrderService iOrderService;

    @Autowired
    private ICartDetailsService iCartDetailsService;

    @Autowired
    private IEmailSenderService iEmailSenderService;
    @PostMapping()
    public ResponseEntity<?> createNewOrder(@RequestParam("appUserId") Long appUserId){
        iOrderService.createOrderForUser(appUserId);
        // prepare and send email
        List<CartProjection> cartsForBill = iCartDetailsService.findCartDetailsByUserId(appUserId);
        String subject = "Billing and Thank You Letter from RetroCare!";
        String message = "Hi " + cartsForBill.get(0).getCustomerEmail() + "!";
        EmailMessage emailMessage = new EmailMessage(cartsForBill.get(0).getCustomerEmail(), subject, message, cartsForBill);
        iEmailSenderService.sendEmail(emailMessage);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
