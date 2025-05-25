package com.order.order_service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse {
    private CustomerBO customer;
    private boolean error;
    private String errorMsg;

    public CustomerBO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerBO customer) {
        this.customer = customer;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
