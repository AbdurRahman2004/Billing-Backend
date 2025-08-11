package com.abdur.BillingSoftware.service;

import com.abdur.BillingSoftware.io.OrderRequest;
import com.abdur.BillingSoftware.io.OrderResponse;
import com.abdur.BillingSoftware.io.PaymentVerificationRequest;

import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    OrderResponse createOrder(OrderRequest request);

    void deleteOrder(String orderId);

    List<OrderResponse> getLatestOrders();

    OrderResponse verifyPayment(PaymentVerificationRequest request);

    Double sumSalesByDate(LocalDate date);

    long countByOrderDate(LocalDate date);

    List<OrderResponse> findRecentOrders();
}


