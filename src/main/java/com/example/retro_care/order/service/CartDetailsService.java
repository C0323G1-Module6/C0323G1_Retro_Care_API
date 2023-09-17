package com.example.retro_care.order.service;

import com.example.retro_care.medicine.model.Medicine;
import com.example.retro_care.medicine.repository.IMedicineRepository;
import com.example.retro_care.order.model.ICartDetailProjectionWhenSell;
import com.example.retro_care.order.model.IIndicationProjectionOrder;
import com.example.retro_care.order.model.IMedicineWhenSell;
import com.example.retro_care.order.model.IPrescriptionProjectionOrder;
import com.example.retro_care.order.projection.CartProjection;
import com.example.retro_care.order.repository.ICartDetailsRepository;
import com.example.retro_care.order.projection.MedicineQuantityProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDetailsService implements ICartDetailsService{


    @Autowired
    private ICartDetailsRepository iCartDetailsRepository;


    @Override
    public void addToCartFromDetailsAndHome(Long appUserId, Long medicineId, Integer newQuantity) {
        iCartDetailsRepository.addToCartFromDetailsAndHome(appUserId,medicineId,newQuantity);
    }

    @Override
    public void addToCart(Long appUserId, Long medicineId, Integer quantity) {
            iCartDetailsRepository.addToCart(appUserId,medicineId,quantity);
    }

    @Override
    public void clearAllCartFromUser(Long appUserId) {
            iCartDetailsRepository.clearAllCartFromUser(appUserId);
    }

    @Override
    public void deleteCartDetailsById(Long cartId) {
        iCartDetailsRepository.deleteCartDetailsById(cartId);
    }

    @Override
    public MedicineQuantityProjection checkQuantityBasedOnUnit(Long medicineId) {
        return iCartDetailsRepository.getQuantityBasedOnUnit(medicineId);
    }

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


}
