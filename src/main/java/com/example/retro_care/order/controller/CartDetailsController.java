package com.example.retro_care.order.controller;

import com.example.retro_care.order.projection.CartProjection;
import com.example.retro_care.order.projection.MedicineProjection;
import com.example.retro_care.order.service.ICartDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@CrossOrigin
@RequestMapping("/api/carts")
public class CartDetailsController {

    @Autowired
    private ICartDetailsService iCartDetailsService;


    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: add or update product and its quantity to cart at home or details screen;
     * @param : appUserId, medicineId, newQuantity;
     * @return : HTTPStatus;
     */
    @PostMapping("/add-from-home-details")
    public ResponseEntity<?> addToCartFromHomeAndDetails(@RequestParam("appUserId") Long appUserId,
                                                         @RequestParam("medicineId") Long medicineId,
                                                         @RequestParam("newQuantity") Integer newQuantity){
        iCartDetailsService.addToCartFromDetailsAndHome(appUserId, medicineId, newQuantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: add or update product and its quantity to right at cart screen;
     * @param : appUserId, medicineId, quantity;
     * @return : HTTPStatus;
     */
    @PostMapping("/add-from-cart")
    public ResponseEntity<?> addToCartCart(@RequestParam("appUserId") Long appUserId,
                                                         @RequestParam("medicineId") Long medicineId,
                                                         @RequestParam("quantity") Integer quantity){

        iCartDetailsService.addToCart(appUserId, medicineId, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: delete all products in cart based on appUserId;
     * @param : appUserId;
     * @return : HTTPStatus;
     */
    @DeleteMapping("/delete-all")
    public ResponseEntity<?> clearAllCartFrom(@RequestParam("appUserId") Long appUserId){
        if( iCartDetailsService.clearAllCartFromUser(appUserId) > 0){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: delete a specific product in cart based on cartId;
     * @param : cartId;
     * @return : HTTPStatus;
     */
    @DeleteMapping("/delete-cart")
    public ResponseEntity<?> clearACartFrom(@RequestParam("cartId") Long cartId){
        if (iCartDetailsService.deleteCartDetailsById(cartId) > 0){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: check availability of a product based on input quantity,
     * @param : medicineId, inputQuantity;
     * @return : if product's quantity is greater than input quantity
     * then returns status OK to inform that product could be added to cart
     * else deny to add product to cart;
     */
    @GetMapping("/check-quantity")
    public ResponseEntity<?> checkQuantity(@RequestParam("medicineId") Long medicineId,
                                           @RequestParam("inputQuantity") Long inputQuantity){
        System.out.println(medicineId);

        MedicineProjection med = iCartDetailsService.getMedicineToCheckAndDisplay(medicineId);
        if(med.getQuantity() >= (inputQuantity * med.getConversion_Rate())){
            return new ResponseEntity<>( HttpStatus.OK);
        } else return new ResponseEntity<>( HttpStatus.NOT_ACCEPTABLE);
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: get all info of a product to display on details screen,
     * @param : medicineId;
     * @return : product with all info;
     */
    @GetMapping("/get-details")
    public ResponseEntity<?> getMedicineDetailsForDisplay(@RequestParam("medicineId") Long medicineId) {
        return new ResponseEntity<>(iCartDetailsService.getMedicineToCheckAndDisplay(medicineId), HttpStatus.OK);
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: get all products in cart to display on cart screen,
     * @param : appUserId;
     * @return : all products in cart;
     */
    @GetMapping("/get-all")
    public ResponseEntity<?> getAllCarts(@RequestParam("appUserId") Long appUserId){
        return new ResponseEntity<>(iCartDetailsService.findCartDetailsByUserId(appUserId), HttpStatus.OK);
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: get quantity of a product in cart to check the availability of the product for selling ,
     * @param : appUserId, medicineId;
     * @return : quantity of a product in cart;
     */
    @GetMapping("/get-quantity-in-cart")
    public ResponseEntity<?> getQuantityInCart(@RequestParam("appUserId") Long appUserId,
                                              @RequestParam("medicineId") Long medicineId){
        return new ResponseEntity<>(iCartDetailsService.findMedicineQuantityInCart(appUserId,medicineId), HttpStatus.OK);
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: get loyalty point of a customer;
     * @param : appUserId;
     * @return : loyalty point;
     */
    @GetMapping("/get-loyalty-point")
    public ResponseEntity<?> getLoyaltyPoint(@RequestParam("appUserId") Long appUserId){
        return new ResponseEntity<>(iCartDetailsService.getLoyaltyPoint(appUserId), HttpStatus.OK);
    }


    /**
     * Create by: HanhNLM;
     * Create Date: 18/09/2023;
     * Function: get availability of products and show if products aren't enuf when user clicks on 'proceed payment' btn;
     * @param : appUserId;
     * @return : loyalty point;
     */
    @GetMapping("/check-availability")
    public ResponseEntity<?> checkAvailability(@RequestParam("appUserId") Long appUserId){
        List<CartProjection> carts = iCartDetailsService.findCartDetailsByUserId(appUserId);
        Map<Long, Long> meds = new HashMap<>();
        MedicineProjection temp;
        for (CartProjection med: carts) {
            temp = iCartDetailsService.getMedicineToCheckAndDisplay(med.getMedicineId());
            // hihii
                if(med.getQuantityInCart() * temp.getConversion_Rate() > temp.getQuantity()){
                    if(temp.getQuantity() >= temp.getConversion_Rate()) {
                        meds.put(temp.getId(), (temp.getQuantity()/ temp.getConversion_Rate()));
                    } else {
                        meds.put(temp.getId(), 0L);
                    }
                }
        }
        return new ResponseEntity<>(meds, HttpStatus.OK);
    }
}
