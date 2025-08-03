package com.abdur.BillingSoftware.service;

import com.abdur.BillingSoftware.io.OrderRequest;
import com.abdur.BillingSoftware.io.OrderResponse;
import com.abdur.BillingSoftware.io.PaymentVerificationRequest;

import java.util.List;

public interface OrderService {
    OrderResponse createOrder(OrderRequest request);

    void deleteOrder(String orderId);

    List<OrderResponse> getLatestOrders();

    OrderResponse verifyPayment(PaymentVerificationRequest request);
}


