package com.example.retro_care.order.controller;

import com.example.retro_care.order.common.SortOrders;
import com.example.retro_care.order.dto.OrderDto;
import com.example.retro_care.order.projection.IOrderProjection;
import com.example.retro_care.order.model.Orders;
import com.example.retro_care.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import com.example.retro_care.order.model.EmailMessage;
import com.example.retro_care.order.projection.CartProjection;
import com.example.retro_care.order.service.ICartDetailsService;
import com.example.retro_care.order.service.mail.IEmailSenderService;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/api/orders")
@RestController
public class OrderController {
    @Autowired
    private IOrderService iOrderService;

    @Autowired
    private ICartDetailsService iCartDetailsService;

    @Autowired
    private IEmailSenderService iEmailSenderService;

    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: displays a paginated list of order;
     *
     * @param : page (page number), limit(number of elements in the page);
     * @return : paginated order list with limit number of molecules per page.
     */
    @GetMapping(value = { "/list"})
    public ResponseEntity<?> getListOrder(@RequestParam("page") int page,
                                          @RequestParam(defaultValue = "") String sortBy,
                                          @RequestParam(defaultValue = "") String startDateTime,
                                          @RequestParam(defaultValue = "") String endDateTime) {
        Map<String,String> errorMap = OrderDto.validateOrder(startDateTime,endDateTime);
        if(!errorMap.isEmpty()){
            return new ResponseEntity<>(errorMap,HttpStatus.NOT_ACCEPTABLE);
        }
        Pageable pageable = SortOrders.sortBy(sortBy,page);
        if(!startDateTime.equals("")||!endDateTime.equals("")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            LocalDateTime localStartDateTime = LocalDateTime.parse(startDateTime, formatter);
            LocalDateTime localEndDateTime = LocalDateTime.parse(endDateTime, formatter);
            Page<IOrderProjection> orders = iOrderService.findByDateTimeRange(pageable, localStartDateTime, localEndDateTime);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }else {
            Page<IOrderProjection> ordersPage = iOrderService.getListOrder(pageable);
            return new ResponseEntity<>(ordersPage, HttpStatus.OK);
        }
    }

    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: get list for order by id;
     *
     * @return : If the id parameter is found, the data of that id will be displayed.
     * @Param Long id;
     */

    @GetMapping({"/{id}"})
    public ResponseEntity<?> getOrderById(@PathVariable Long id){
        Orders orders = iOrderService.findOrderById(id);
        if (orders == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: Delete for order by id;
     *
     * @return :If the passed id parameter is found, the word with that id will be removed from the list
     * @Param Long id;
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        this.iOrderService.deleteOrderById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/createOrder")
    public ResponseEntity<?> createNewOrderWhenSell(@RequestParam("customerUserId") Long customerUserId,
                                                    @RequestParam("employeeUserId") Long employeeUserId,
                                                    @RequestParam("code") String code,
                                                    @RequestParam("note") String note) {

        String str = iOrderService.doEverythingWhenPay(customerUserId, employeeUserId, code, note);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: create order and update loyalty point, then send email as billing;
     * @param : appUserId, loyalty point;
     * @return : HTTPStatus;
     */
    @PostMapping("/create")
    public ResponseEntity<?> createNewOrder(@RequestParam("appUserId") Long appUserId,
                                            @RequestParam("loyaltyPoint") Long loyaltyPoint,
                                            @RequestParam("totalPrice") Long totalPrice){
        System.out.println(totalPrice);
        System.out.println(loyaltyPoint);
        // prepare and send email
        List<CartProjection> cartsForBill = iCartDetailsService.findCartDetailsByUserId(appUserId);
        System.out.println(cartsForBill);
        String subject = "Billing and Thank You Letter from RetroCare!";
        String message = "Hi " + cartsForBill.get(0).getCustomerEmail() + "!";
        EmailMessage emailMessage = new EmailMessage(cartsForBill.get(0).getCustomerEmail(), subject, message, totalPrice, cartsForBill);
        iEmailSenderService.sendEmail(emailMessage);
        // after sending mail then create order and clear cart
        iOrderService.createOrderForUser(appUserId,loyaltyPoint);
        return new ResponseEntity<>( totalPrice, HttpStatus.OK);
    }
}
