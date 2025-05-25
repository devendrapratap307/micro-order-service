package com.order.order_service.controller;

import com.order.order_service.dto.OrderTO;
import com.order.order_service.model.CustomerResponse;
import com.order.order_service.service.CustomerService;
import com.order.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/place-order")
    public ResponseEntity<String> placeOrder(@RequestBody OrderTO order){
        CustomerResponse customerResponse = customerService.getCustomer(order.getCustomerId());
        if(customerResponse !=null && customerResponse.isError() && customerResponse.getErrorMsg() !=null){
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(customerResponse.getErrorMsg());
        }
        if(customerResponse !=null && (customerResponse.getCustomer() == null || customerResponse.getCustomer().getId() ==null)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("customer not found");
        }
        return ResponseEntity.ok().body("Order placed for customer: "+ orderService.createOrder(order));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderTO>> getOrders(){
        return ResponseEntity.ok(orderService.getAllOrder());
    }
}
