package com.example.retro_care.order.model;

import com.example.retro_care.customer.model.Customer;

import java.util.List;

public class ReqBody {
        private List<String> cartIDs;
        private Customer customerInfo;

    public ReqBody(List<String> cartIDs, Customer customerInfo) {
        this.cartIDs = cartIDs;
        this.customerInfo = customerInfo;
    }

    public List<String> getCartIDs() {
        return cartIDs;
    }

    public void setCartIDs(List<String> cartIDs) {
        this.cartIDs = cartIDs;
    }

    public Customer getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(Customer customerInfo) {
        this.customerInfo = customerInfo;
    }
}
