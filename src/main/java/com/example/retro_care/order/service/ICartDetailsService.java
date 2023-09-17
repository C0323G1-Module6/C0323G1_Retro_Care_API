package com.example.retro_care.order.service;

import com.example.retro_care.order.model.ICartDetailProjectionWhenSell;
import com.example.retro_care.order.model.IIndicationProjectionOrder;
import com.example.retro_care.order.model.IMedicineWhenSell;
import com.example.retro_care.order.model.IPrescriptionProjectionOrder;
import com.example.retro_care.order.projection.CartProjection;
import com.example.retro_care.order.projection.MedicineQuantityProjection;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICartDetailsService {
    void addToCartFromDetailsAndHome(Long appUserId, Long medicineId, Integer newQuantity);

    void addToCart(Long appUserId, Long medicineId, Integer quantity);

    void clearAllCartFromUser(Long appUserId);

    void deleteCartDetailsById(Long cartId);

    MedicineQuantityProjection checkQuantityBasedOnUnit(Long medicineId);

    List<CartProjection> findCartDetailsByUserId(Long appUserId);

    /**
     * author: VuNL
     * date: 15/09/2023
     * function: get list medicine by name
     *
     * @param name
     * @return List Medicine
     */
    List<IMedicineWhenSell> getMedicineByNameWhenOrder(String name);

    /**
     * author: VuNL
     * date create: 16/09/2023
     *
     * @param id
     * @return List cart when sell
     */
    List<ICartDetailProjectionWhenSell> getAllCardByAppUserId(Long id);


    /**
     * author: VuNL
     * date create: 17/09/2023
     * function: get all prescription by name
     *
     * @param name
     * @return list prescription
     */
    List<IPrescriptionProjectionOrder> getAllPrescriptionByName(String name);

    /**
     * author: VuNL
     * date create: 17/09/2023
     * function: get all prescription by symptoms
     *
     * @param symptoms
     * @return list prescription
     */
    List<IPrescriptionProjectionOrder> getAllPrescriptionBySymptoms(String symptoms);

    /**
     * author: VuNL
     * date create: 17/09/2023
     * function: get all indication from prescription id
     *
     * @param id
     * @return list indication
     */
    List<IIndicationProjectionOrder> getAllIndicationByPrescriptionId(Long id);
}
