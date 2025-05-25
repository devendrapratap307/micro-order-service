package com.order.order_service.service;

import com.order.order_service.dto.OrderTO;
import com.order.order_service.model.OrderBO;
import com.order.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MapperService mapperService;

    @Override
    public OrderTO createOrder(OrderTO orderTO) {
        OrderBO orderReturn= orderRepository.save(mapperService.map(orderTO, OrderBO.class));
        return mapperService.map(orderReturn,OrderTO.class) ;
    }

    @Override
    public OrderTO updateOrder(OrderTO orderTO) {
        OrderBO orderReturn= orderRepository.save(mapperService.map(orderTO, OrderBO.class));
        return mapperService.map(orderReturn,OrderTO.class) ;
    }

    @Override
    public OrderTO getOrderById(Integer orderId) {
        Optional<OrderBO> orderReturn= orderRepository.findById(orderId);
        return mapperService.map(orderReturn,OrderTO.class);
    }

    @Override
    public void deleteOrderById(Integer orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public List<OrderTO> getAllOrder() {
        return mapperService.map(orderRepository.findAll(), OrderTO.class);
    }
}
