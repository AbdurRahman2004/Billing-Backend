package com.abdur.BillingSoftware.repository;

import com.abdur.BillingSoftware.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderEntityRepository extends JpaRepository {
    Optional<OrderEntity> findByOrderId(String orderId);

    List<OrderEntity> findAllOrderByCreatedAtDesc();

}
