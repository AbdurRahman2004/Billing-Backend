package com.abdur.BillingSoftware.service;

import com.abdur.BillingSoftware.io.OrderRequest;
import com.abdur.BillingSoftware.io.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse createOrder(OrderRequest request);

    void deleteOrder(String orderId);

    List<OrderResponse> getLatestOrders();
}


