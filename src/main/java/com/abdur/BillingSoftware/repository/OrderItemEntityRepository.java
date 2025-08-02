package com.abdur.BillingSoftware.repository;

import com.abdur.BillingSoftware.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemEntityRepository extends JpaRepository<OrderItemEntity ,Long> {

}
