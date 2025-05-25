package com.order.order_service.client;
import com.order.order_service.model.CustomerBO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service", url = "http://localhost:8082")
public interface CustomerClient {
    @GetMapping("/customer/{id}")
    CustomerBO getCustomerById(@PathVariable("id") Integer id);

}
