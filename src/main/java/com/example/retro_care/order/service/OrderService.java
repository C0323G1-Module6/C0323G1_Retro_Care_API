package com.example.retro_care.order.service;

import com.example.retro_care.order.model.OrderDetails;
import com.example.retro_care.order.projection.ICartDetailProjectionWhenSell;
import com.example.retro_care.order.projection.IOrderProjection;
import com.example.retro_care.order.model.Orders;
import com.example.retro_care.order.repository.ICartDetailsRepository;
import com.example.retro_care.order.repository.IOrderDetailsRepository;
import com.example.retro_care.order.repository.IOrderRepository;
import com.example.retro_care.order.repository.IUserOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository iOrderRepository;
    @Autowired
    private ICartDetailsRepository iCartDetailsRepository;
    @Autowired
    private IOrderDetailsRepository iOrderDetailsRepository;
    @Autowired
    private IUserOrderRepository iUserOrderRepository;


    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: displays a paginated list of order;
     *
     * @param : page (page number), limit(number of elements in the page);
     * @return : paginated order list with limit number of molecules per page.
     */
    @Override
    public Page<IOrderProjection> getListOrder(Pageable pageable) {
        return iOrderRepository.getAllList1(pageable);
    }

    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: get list for order by id;
     *
     * @return : If the id parameter is found, the data of that id will be displayed.
     * @Param Long id;
     */
    @Override
    public Orders findOrderById(Long id) {
        return iOrderRepository.findByOrder(id);
    }

    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: Delete for order by id;
     *
     * @return :If the passed id parameter is found, the word with that id will be removed from the list
     * @Param Long id;
     */
    @Override
    public void deleteOrderById(Long id) {
        iOrderRepository.deleteOrder(id);
    }

    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: Filter for order by datetime;
     *
     * @return : If the correct parameter is passed, the list will be filtered according to that parameter,
     * otherwise the original list will be returned.
     */
    @Override
    public List<Orders> findByDateTimeRange(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return iOrderRepository.findByDateTimeRange(startDateTime, endDateTime);
    }


    /**
     * author: VuNL
     * date: 15/09/2023
     * function: create orders, order detail, user order when pay offline
     *
     * @param code
     * @param customerUserId
     * @param employeeUserId
     */
    @Override
    public void createOfflineOrders(String code, String note, Long customerUserId, Long employeeUserId) {

    }

    /**
     * author: VuNL
     * date: 15/09/2023
     * function: create only order when pay
     *
     * @param code
     * @param note
     */
    @Override
    public void createOrders(String code, String note) {
        iOrderRepository.createOrder(code, note);
    }


    /**
     * author: VuNL
     * date: 15/09/2023
     *
     * @param customerUserId
     * @param employeeUserId
     * @param code
     * @param note
     * @return return true if success, false if fail
     */
    @Override
    public String doEverythingWhenPay(Long customerUserId, Long employeeUserId, String code, String note) {
        String name = "";
        //check quantity
        double point = 0;

        List<ICartDetailProjectionWhenSell> list = (List<ICartDetailProjectionWhenSell>) iCartDetailsRepository.getAllCardByAppUserId(employeeUserId);
        for (ICartDetailProjectionWhenSell cart : list) {
            if (cart.getCd_quantity() > cart.getM_quantity()) {
                name += cart.getName() + " ";
            }
        }
        if (!name.equals("")) {
            return name;
        }

        //create order
        createOrders(code, note);
        Long id = iOrderRepository.getLastInsertOrders();

        //create order detail
        for (ICartDetailProjectionWhenSell cart : list) {
            iOrderRepository.updateMedicineQuantity(cart.getM_quantity() - cart.getCd_quantity(), cart.getM_id());
            iOrderDetailsRepository.createOrderDetails(cart.getPrice(), id, cart.getM_id(), cart.getCd_quantity());
            point += cart.getCd_quantity() * cart.getPrice();
        }
        iCartDetailsRepository.clearAllCartFromUser(employeeUserId);

        //create user order
        iUserOrderRepository.createUserOrder(employeeUserId, id);
        if (customerUserId != -1) {
            iUserOrderRepository.createUserOrder(customerUserId, id);
            Long currentPoint = iOrderRepository.getPointCustomerByAppUserId(customerUserId);
            Long newPoint = currentPoint + (long) Math.floor(point * 0.1);
            iOrderRepository.updatePointCustomer(newPoint, customerUserId);
        }
        return "true";
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: create new order and update loyalty point of a customer;
     *
     * @param : appUserId, loyaltyPoint;
     */
    @Override
    public void createOrderForUser(Long appUserId, Long loyaltyPoint) {
        iOrderRepository.createOrderForUser(appUserId, loyaltyPoint);
    }


}
