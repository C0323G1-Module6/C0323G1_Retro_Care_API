package com.example.retro_care.order.service;

import com.example.retro_care.order.projection.*;

import java.util.List;

public interface ICartDetailsService {
    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: add product to cart on home/ details screen, if product already exists then updates quantity;
     * @param : appUserId, medicineId, newQuantity;
     */
    void addToCartFromDetailsAndHome(Long appUserId, Long medicineId, Integer newQuantity);


    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: update quantity of product cart;
     * @param : appUserId, medicineId, quantity;
     */
    void addToCart(Long appUserId, Long medicineId, Integer quantity);
    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: clears all products in cart;
     * @param : appUserId;
     */
    int clearAllCartFromUser(Long appUserId);

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: delete a specific product in cart;
     * @param : cartId;
     */
    int deleteCartDetailsById(Long cartId);

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: gets all needed info of a product;
     * @param : medicineId;
     * @return : MedicineProjection that holds all info of product;
     */
    MedicineProjection getMedicineToCheckAndDisplay(Long medicineId);

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: get product and customer's info for display and mailing purpose;
     * @param : appUserId;
     * @return : list of CartProjection that holds some info of product,
     * as well as customer for display and mailing purpose;
     */
    List<CartProjection> findCartDetailsByUserId(Long appUserId);

    /**
     * author: VuNL
     * date: 15/09/2023
     * function: get list medicine by name
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

    /**
     * author: VuNL
     * date create: 18/09/2023
     * function: get name and user id of customer
     * @param phone
     * @return
     */
    ICustomerProjectionWhenSell getCustomerNameAndUserId(String phone);
    /**

     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: get quantity of a product in cart;
     * @param : appUserId, medicineId;
     * @return : product's quantity;
     */
    Long findMedicineQuantityInCart(Long appUserId, Long medicineId);

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: get loyalty point of customer;
     * @param : appUserId;
     * @return : loyalty point;
     */
    Long getLoyaltyPoint(Long appUserId);
}
