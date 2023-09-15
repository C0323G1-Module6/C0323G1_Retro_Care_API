package com.example.retro_care.order.service;

import com.example.retro_care.order.repository.ICartDetailsRepository;
import com.example.retro_care.order.repository.MedicineQuantityProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return iCartDetailsRepository.checkQuantityBasedOnUnit(medicineId);
    }
}
