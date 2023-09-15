package com.example.retro_care.order.service;

import com.example.retro_care.order.model.Orders;
import com.example.retro_care.order.repository.IOrderRepository;
import com.sun.tools.javac.util.List;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.time.LocalDateTime;

@Service
public class OrderService implements  IOrderService{
    @Autowired
    private IOrderRepository iOrderRepository;


    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: displays a paginated list of order;
     * @param : page (page number), limit(number of elements in the page);
     * @return : paginated order list with limit number of molecules per page.
     */
    @Override
    public Page<Orders> getListOrder(Pageable pageable) {
        return iOrderRepository.getAllList(pageable);
    }

    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: get list for order by id;
     * @Param Long id;
     * @return : If the id parameter is found, the data of that id will be displayed.
     */
    @Override
    public Orders findOrderById(Long id) {
        return iOrderRepository.findByOrder(id);
    }
    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: Delete for order by id;
     * @Param Long id;
     * @return :If the passed id parameter is found, the word with that id will be removed from the list
     */
    @Override
    public void deleteOrderById(Long id) {
        iOrderRepository.deleteOrder(id);
    }

    /**
     * Create by: VuDT;
     * Date create: 15/09/2023
     * Function: Filter for order by datetime;
     * @return : If the correct parameter is passed, the list will be filtered according to that parameter,
     * otherwise the original list will be returned.
     */
    @Override
    public List<Orders> findByDateTimeRange(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return iOrderRepository.findByDateTimeRange(startDateTime,endDateTime);
    }
}
