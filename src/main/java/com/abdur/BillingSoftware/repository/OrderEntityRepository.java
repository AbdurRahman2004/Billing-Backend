package com.abdur.BillingSoftware.repository;

import com.abdur.BillingSoftware.entity.OrderEntity;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OrderEntityRepository extends JpaRepository <OrderEntity, Long>{
    Optional<OrderEntity> findByOrderId(String orderId);

    List<OrderEntity> findAllByOrderByCreatedAtDesc();

    @Query("SELECT SUM(o.grandTotal) from OrderEntity o where Date(o.createdAt) = :date")
    Double sumSaleByDate(@Param("date") LocalDate date);

    @Query("select count(o) from OrderEntity  o where Date(o.createdAt) = :date")
    Long countByOrderDate(@Param("date") LocalDate date);

    @Query("select o from OrderEntity o order by o.createdAt desc")
    List<OrderEntity> findRecentOrders(Pageable pageable);
}
