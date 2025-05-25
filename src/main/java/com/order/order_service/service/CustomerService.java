package com.order.order_service.service;

import com.order.order_service.client.CustomerClient;
import com.order.order_service.model.CustomerBO;
import com.order.order_service.model.CustomerResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerClient customerClient;

    @CircuitBreaker(name = "customerServiceCB", fallbackMethod = "fallbackGetCustomer")
    public CustomerResponse getCustomer(Integer id){
        CustomerResponse customerResponse = new CustomerResponse();
        CustomerBO customer = customerClient.getCustomerById(id);
        if(customer !=null){
            customerResponse.setCustomer(customer);
            customerResponse.setError(false);
        }
        return customerResponse;
    }

    public CustomerResponse fallbackGetCustomer(Integer id, Throwable t){
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setError(true);
        customerResponse.setErrorMsg("Customer Service temporarily unavailable. Please Try later.");
        return customerResponse;
    }
}
