package com.example.retro_care.order.controller;

import com.example.retro_care.medicine.service.IMedicineService;
import com.example.retro_care.order.projection.*;
import com.example.retro_care.order.service.ICartDetailsService;
import com.example.retro_care.user.service.IAppUserService;
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

    @Autowired
    private IAppUserService iAppUserService;

    @Autowired
    private IMedicineService iMedicineService;

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: add or update product and its quantity to cart at home or details screen;
     *
     * @param : appUserId, medicineId, newQuantity;
     * @return : HTTPStatus;
     */
    @PostMapping("/add-from-home-details")
    public ResponseEntity<?> addToCartFromHomeAndDetails(@RequestParam("appUserId") Long appUserId,
                                                         @RequestParam("medicineId") Long medicineId,
                                                         @RequestParam("newQuantity") Integer newQuantity) {
        if (!iAppUserService.existsById(appUserId) || !iMedicineService.existsByIdAndFlagDeletedIsFalse(medicineId)) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else {
            iCartDetailsService.addToCartFromDetailsAndHome(appUserId, medicineId, newQuantity);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: add or update product and its quantity to right at cart screen;
     *
     * @param : appUserId, medicineId, quantity;
     * @return : HTTPStatus;
     */
    @PostMapping("/add-from-cart")
    public ResponseEntity<?> addToCartCart(@RequestParam("appUserId") Long appUserId,
                                           @RequestParam("medicineId") Long medicineId,
                                           @RequestParam("quantity") Integer quantity) {

        if (!iAppUserService.existsById(appUserId) || !iMedicineService.existsByIdAndFlagDeletedIsFalse(medicineId)) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else {
            iCartDetailsService.addToCart(appUserId, medicineId, quantity);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: delete all products in cart based on appUserId;
     *
     * @param : appUserId;
     * @return : HTTPStatus;
     */
    @DeleteMapping("/delete-all")
    public ResponseEntity<?> clearAllCartFrom(@RequestParam("appUserId") Long appUserId) {
        if (iAppUserService.existsById(appUserId) && iCartDetailsService.clearAllCartFromUser(appUserId) > 0) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: delete a specific product in cart based on cartId;
     *
     * @param : cartId;
     * @return : HTTPStatus;
     */
    @DeleteMapping("/delete-cart")
    public ResponseEntity<?> clearACartFrom(@RequestParam("cartId") Long cartId) {
        if (iCartDetailsService.deleteCartDetailsById(cartId) > 0) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: check availability of a product based on input quantity,
     *
     * @param : medicineId, inputQuantity;
     * @return : if product's quantity is greater than input quantity
     * then returns status OK to inform that product could be added to cart
     * else deny to add product to cart;
     */
    @GetMapping("/check-quantity")
    public ResponseEntity<?> checkQuantity(@RequestParam("medicineId") Long medicineId,
                                           @RequestParam("inputQuantity") Long inputQuantity) {
        MedicineProjection med = iCartDetailsService.getMedicineToCheckAndDisplay(medicineId);
        if (iMedicineService.existsByIdAndFlagDeletedIsFalse(medicineId)
                && med.getQuantity() >= (inputQuantity * med.getConversion_Rate())) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    /**
     * author: VuNL
     * date create: 17/09/2023
     * function: get list medicine by name
     *
     * @param name
     * @return list medicine
     */
    @GetMapping("/getMedicine")
    public ResponseEntity<?> getMedicine(@RequestParam("name") String name) {
        List<IMedicineWhenSell> list = iCartDetailsService.getMedicineByNameWhenOrder(name);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * author: VuNL
     * date create: 17/09/2023
     * function: get all cart details by user
     *
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
     *
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
     *
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
     *
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
    public ResponseEntity<?> getInformationCustomer(@RequestParam("phone") String phone) {
        ICustomerProjectionWhenSell customer = iCartDetailsService.getCustomerNameAndUserId(phone);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: get all info of a product to display on details screen,
     *
     * @param : medicineId;
     * @return : product with all info;
     */
    @GetMapping("/get-details")
    public ResponseEntity<?> getMedicineDetailsForDisplay(@RequestParam("medicineId") String medicineId) {
        try {
            Long id = Long.parseLong(medicineId);
            if (iMedicineService.existsByIdAndFlagDeletedIsFalse(id)) {
                return new ResponseEntity<>(iCartDetailsService.getMedicineToCheckAndDisplay(id), HttpStatus.OK);
            }
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: get all products in cart to display on cart screen,
     *
     * @param : appUserId;
     * @return : all products in cart;
     */
    @GetMapping("/get-all")
    public ResponseEntity<?> getAllCarts(@RequestParam("appUserId") Long appUserId) {

        if (iAppUserService.existsById(appUserId)) {
            return new ResponseEntity<>(iCartDetailsService.findCartDetailsByUserId(appUserId), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: get quantity of a product in cart to check the availability of the product for selling ,
     *
     * @param : appUserId, medicineId;
     * @return : quantity of a product in cart;
     */
    @GetMapping("/get-quantity-in-cart")
    public ResponseEntity<?> getQuantityInCart(@RequestParam("appUserId") Long appUserId,
                                               @RequestParam("medicineId") Long medicineId) {

        if (iAppUserService.existsById(appUserId) && iMedicineService.existsByIdAndFlagDeletedIsFalse(medicineId)) {
            return new ResponseEntity<>(iCartDetailsService.findMedicineQuantityInCart(appUserId, medicineId), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    /**
     * Create by: HanhNLM;
     * Create Date: 15/09/2023;
     * Function: get loyalty point of a customer;
     *
     * @param : appUserId;
     * @return : loyalty point;
     */
    @GetMapping("/get-loyalty-point")
    public ResponseEntity<?> getLoyaltyPoint(@RequestParam("appUserId") Long appUserId) {

        if (iAppUserService.existsById(appUserId)) {
            return new ResponseEntity<>(iCartDetailsService.getLoyaltyPoint(appUserId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }


    /**
     * Create by: HanhNLM;
     * Create Date: 18/09/2023;
     * Function: get availability of products and show if products aren't enuf when user clicks on 'proceed payment' btn;
     *
     * @param : appUserId;
     * @return : loyalty point;
     */
    @GetMapping("/check-availability")
    public ResponseEntity<?> checkAvailability(@RequestParam("appUserId") Long appUserId) {

        if (iAppUserService.existsById(appUserId)) {
            List<CartProjection> carts = iCartDetailsService.findCartDetailsByUserId(appUserId);
            Map<Long, Long> meds = new HashMap<>();
            MedicineProjection temp;
            for (CartProjection med : carts) {
                temp = iCartDetailsService.getMedicineToCheckAndDisplay(med.getMedicineId());
                // hihii
                if (med.getQuantityInCart() * temp.getConversion_Rate() > temp.getQuantity()) {
                    if (temp.getQuantity() >= temp.getConversion_Rate()) {
                        meds.put(temp.getId(), (temp.getQuantity() / temp.getConversion_Rate()));
                    } else {
                        meds.put(temp.getId(), 0L);
                    }
                }
            }
            return new ResponseEntity<>(meds, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

        }
    }


    /**
     * author: VuNL
     * Date start: 20/09/2023
     *
     * @param appUserId
     * @return name
     */
    @GetMapping("/getNameEmployee")
    public ResponseEntity<String> getEmployeeName(@RequestParam("appUserId") Long appUserId) {
        String name = iCartDetailsService.getNameEmployeeByAppUserId(appUserId);
        return new ResponseEntity<>(name, HttpStatus.OK);
    }
}
