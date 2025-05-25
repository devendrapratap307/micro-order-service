package com.order.order_service.service;

import com.order.order_service.dto.OrderTO;

import java.util.List;

public interface OrderService {
    OrderTO createOrder(OrderTO orderTO);
    OrderTO updateOrder(OrderTO orderTO);
    OrderTO getOrderById(Integer orderId);
    void deleteOrderById(Integer orderId);
    List<OrderTO> getAllOrder();

}
