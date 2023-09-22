package com.example.retro_care.order.service;

import com.example.retro_care.order.projection.*;
import com.example.retro_care.order.repository.ICartDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDetailsService implements ICartDetailsService{


    @Autowired
    private ICartDetailsRepository iCartDetailsRepository;

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: add product to cart on home/ details screen, if product already exists then updates quantity;
     * @param : appUserId, medicineId, newQuantity;
     */
    @Override
    public void addToCartFromDetailsAndHome(Long appUserId, Long medicineId, Integer newQuantity) {
        iCartDetailsRepository.addToCartFromDetailsAndHome(appUserId,medicineId,newQuantity);
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: update quantity of product cart;
     * @param : appUserId, medicineId, quantity;
     */
    @Override
    public void addToCart(Long appUserId, Long medicineId, Integer quantity) {
            iCartDetailsRepository.addToCart(appUserId,medicineId,quantity);
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: clears all products in cart;
     * @param : appUserId;
     */
    @Override
    public int clearAllCartFromUser(Long appUserId) {
        return iCartDetailsRepository.clearAllCartFromUser(appUserId);
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: delete a specific product in cart;
     * @param : cartId;
     */
    @Override
    public int deleteCartDetailsById(Long cartId) {
        return iCartDetailsRepository.deleteCartDetailsById(cartId);
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: gets all needed info of a product;
     * @param : medicineId;
     * @return : MedicineProjection that holds all info of product;
     */
    @Override
    public MedicineProjection getMedicineToCheckAndDisplay(Long medicineId) {
        return iCartDetailsRepository.getMedicine(medicineId);
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: get product and customer's info for display and mailing purpose;
     * @param : appUserId;
     * @return : list of CartProjection that holds some info of product,
     * as well as customer for display and mailing purpose;
     */
    @Override
    public List<CartProjection> findCartDetailsByUserId(Long appUserId) {
        return iCartDetailsRepository.findCartDetailsByUserId(appUserId);
    }

    /**

     * author: VuNL
     * date: 15/09/2023
     * function: get list medicine by name
     * @param name
     * @return List Medicine
     */
    @Override
    public List<IMedicineWhenSell> getMedicineByNameWhenOrder(String name) {
        List<IMedicineWhenSell> list = iCartDetailsRepository.getMedicineByNameWhenSell(name);
        System.out.println(list);
        return list;
    }


    /**
     * author: VuNL
     * date create: 16/09/2023
     * @param id
     * @return List cart when sell
     */
    @Override
    public List<ICartDetailProjectionWhenSell> getAllCardByAppUserId(Long id) {
        return iCartDetailsRepository.getAllCardByAppUserId(id);
    }


    /**
     * author: VuNL
     * date create: 17/09/2023
     * function: get all prescription by name
     * @param name
     * @return list prescription
     */
    @Override
    public List<IPrescriptionProjectionOrder> getAllPrescriptionByName(String name) {
        return iCartDetailsRepository.getAllPrescriptionByName(name);
    }


    /**
     * author: VuNL
     * date create: 17/09/2023
     * function: get all prescription by symptoms
     * @param symptoms
     * @return list prescription
     */
    @Override
    public List<IPrescriptionProjectionOrder> getAllPrescriptionBySymptoms(String symptoms) {
        return iCartDetailsRepository.getAllPrescriptionBySymptoms(symptoms);
    }


    /**
     * author: VuNL
     * date create: 17/09/2023
     * function: get all indication from prescription id
     *
     * @param id
     * @return list indication
     */
    @Override
    public List<IIndicationProjectionOrder> getAllIndicationByPrescriptionId(Long id) {
        return iCartDetailsRepository.getAllIndicationByPrescriptionId(id);
    }

    /**
     * author: VuNL
     * date create: 18/09/2023
     * function: get name and user id of customer
     * @param phone
     * @return
     */
    @Override
    public ICustomerProjectionWhenSell getCustomerNameAndUserId(String phone) {
        return iCartDetailsRepository.getCustomerName(phone);
    }

    /**

     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: get quantity of a product in cart;
     * @param : appUserId, medicineId;
     * @return : product's quantity;
     */
    @Override
    public Long findMedicineQuantityInCart(Long appUserId, Long medicineId) {
        return iCartDetailsRepository.findMedicineQuantityInCart(appUserId, medicineId);
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: get loyalty point of customer;
     * @param : appUserId;
     * @return : loyalty point;
     */
    @Override
    public Long getLoyaltyPoint(Long appUserId) {
        return iCartDetailsRepository.getLoyaltyPoint(appUserId);
    }

}
