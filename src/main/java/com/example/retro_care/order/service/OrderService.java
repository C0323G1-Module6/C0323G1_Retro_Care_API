package com.example.retro_care.order.service;

import com.example.retro_care.order.model.IOrderProjection;
import com.example.retro_care.order.model.Orders;
import com.example.retro_care.order.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository iOrderRepository;


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
        LocalDateTime localDateTime = LocalDateTime.now();
        iOrderRepository.createOrder(code, LocalDate.from(localDateTime), note);
    }

    /**
     * author: VuNL
     * date: 15/09/2023
     * function: create only order detail when pay
     */
    @Override
    public void createOrderDetail() {
        Orders orders = iOrderRepository.getLastInsertOrders();

    }

    /**
     * author: VuNL
     * date: 15/09/2023
     * function: create only user order when pay
     *
     * @param orderId
     * @param userId
     */
    @Override
    public void createUserOrder(Long orderId, Long userId) {

    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: create new order and update loyalty point of a customer;
     * @param : appUserId, loyaltyPoint;
     */
    @Override
    public void createOrderForUser(Long appUserId, Long loyaltyPoint) {
        iOrderRepository.createOrderForUser(appUserId, loyaltyPoint);
    }


}
