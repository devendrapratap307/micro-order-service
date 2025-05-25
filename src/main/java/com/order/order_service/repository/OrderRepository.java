package com.order.order_service.repository;

import com.order.order_service.model.OrderBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderBO, Integer> {
}
