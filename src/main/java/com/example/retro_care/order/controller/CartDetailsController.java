package com.example.retro_care.order.controller;

import com.example.retro_care.order.projection.MedicineQuantityProjection;
import com.example.retro_care.order.service.ICartDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin
@RequestMapping("/api/carts")
public class CartDetailsController {

    @Autowired
    private ICartDetailsService iCartDetailsService;
    @PostMapping("/add-from-home-details")
    public ResponseEntity<?> addToCartFromHomeAndDetails(@RequestParam("appUserId") Long appUserId,
                                                         @RequestParam("medicineId") Long medicineId,
                                                         @RequestParam("newQuantity") Integer newQuantity){
        iCartDetailsService.addToCartFromDetailsAndHome(appUserId, medicineId, newQuantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add-from-cart")
    public ResponseEntity<?> addToCartCart(@RequestParam("appUserId") Long appUserId,
                                                         @RequestParam("medicineId") Long medicineId,
                                                         @RequestParam("quantity") Integer quantity){
        iCartDetailsService.addToCart(appUserId, medicineId, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<?> clearAllCartFrom(@RequestParam("appUserId") Long appUserId){
        iCartDetailsService.clearAllCartFromUser(appUserId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete-cart")
    public ResponseEntity<?> clearACartFrom(@RequestParam("cartId") Long cartId){
        iCartDetailsService.deleteCartDetailsById(cartId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/checkQuantity")
    public ResponseEntity<?> checkQuantity(@RequestParam("medicineId") Long medicineId,
                                           @RequestParam("inputQuantity") Long inputQuantity){
        MedicineQuantityProjection quantityBasedOnUnit = iCartDetailsService.checkQuantityBasedOnUnit(medicineId);
        if(quantityBasedOnUnit.getQuantity() > (inputQuantity * quantityBasedOnUnit.getConversionUnit())){
            return new ResponseEntity<>(HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }


}
