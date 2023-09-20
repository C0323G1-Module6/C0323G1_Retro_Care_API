package com.example.retro_care.order.controller;

import com.example.retro_care.order.projection.*;
import com.example.retro_care.order.service.ICartDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@CrossOrigin
@RequestMapping("/api/carts")
public class CartDetailsController {

    @Autowired
    private ICartDetailsService iCartDetailsService;

    @PostMapping("/add-from-home-details")
    public ResponseEntity<?> addToCartFromHomeAndDetails(@RequestParam("appUserId") Long appUserId,
                                                         @RequestParam("medicineId") Long medicineId,
                                                         @RequestParam("newQuantity") Integer newQuantity) {
        iCartDetailsService.addToCartFromDetailsAndHome(appUserId, medicineId, newQuantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add-from-cart")
    public ResponseEntity<?> addToCartCart(@RequestParam("appUserId") Long appUserId,
                                           @RequestParam("medicineId") Long medicineId,
                                           @RequestParam("quantity") Integer quantity) {
        System.out.println(appUserId);
        System.out.println(medicineId);
        System.out.println(quantity);
        iCartDetailsService.addToCart(appUserId, medicineId, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @DeleteMapping("/delete-all")
    public ResponseEntity<?> clearAllCartFrom(@RequestParam("appUserId") Long appUserId) {
        iCartDetailsService.clearAllCartFromUser(appUserId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete-cart")
    public ResponseEntity<?> clearACartFrom(@RequestParam("cartId") Long cartId) {
        iCartDetailsService.deleteCartDetailsById(cartId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/checkQuantity")
    public ResponseEntity<?> checkQuantity(@RequestParam("medicineId") Long medicineId,
                                           @RequestParam("inputQuantity") Long inputQuantity) {
        System.out.println(medicineId);

        MedicineQuantityProjection quantityBasedOnUnit = iCartDetailsService.checkQuantityBasedOnUnit(medicineId);
        if (quantityBasedOnUnit.getQuantity() > (inputQuantity * quantityBasedOnUnit.getConversion_Rate())) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }


    /**
     * author: VuNL
     * date create: 17/09/2023
     * function: get list medicine by name
     * @param name
     * @return list medicine
     */
    @GetMapping("/getMedicine")
    public ResponseEntity<?> getMedicine(@RequestParam("name") String name) {
        List<IMedicineWhenSell> list = iCartDetailsService.getMedicineByNameWhenOrder(name);
        System.out.println(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * author: VuNL
     * date create: 17/09/2023
     * function: get all cart details by user
     * @param id
     * @return
     */
    @GetMapping("/getAllCartDetailsByUser")
    public ResponseEntity<?> getAllCartDetailByUser(@RequestParam("id") Long id) {
        List<ICartDetailProjectionWhenSell> list = iCartDetailsService.getAllCardByAppUserId(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    /**
     * author: VuNL
     * date create: 17/09/2023
     * function: get prescription by name
     * @param name
     * @return list prescription
     */
    @GetMapping("/getPrescriptionByName")
    public ResponseEntity<?> getAllPrescriptionByName(@RequestParam("name") String name) {
        List<IPrescriptionProjectionOrder> list = iCartDetailsService.getAllPrescriptionByName(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    /**
     * author: VuNL
     * date create: 17/09/2023
     * function: get prescription by sumptoms
     * @param symptoms
     * @return list prescription
     */
    @GetMapping("/getPrescriptionBySymptoms")
    public ResponseEntity<?> getAllPrescriptionBySymptoms(@RequestParam("symptoms") String symptoms) {
        List<IPrescriptionProjectionOrder> list = iCartDetailsService.getAllPrescriptionBySymptoms(symptoms);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    /**
     * author: VuNL
     * date create: 17/09/2023
     * function: get indication by prescription id
     * @param id
     * @return list indication
     */
    @GetMapping("/getIndication")
    public ResponseEntity<?> getAllIndication(@RequestParam("id") Long id) {
        List<IIndicationProjectionOrder> list = iCartDetailsService.getAllIndicationByPrescriptionId(id);
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getInforCustomer")
    public ResponseEntity<?> getInformationCustomer(@RequestParam("phone")String phone){
        ICustomerProjectionWhenSell customer = iCartDetailsService.getCustomerNameAndUserId(phone);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}
