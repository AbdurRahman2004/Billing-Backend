package com.abdur.BillingSoftware.controller;

import com.abdur.BillingSoftware.io.OrderResponse;
import com.abdur.BillingSoftware.io.PaymentRequest;
import com.abdur.BillingSoftware.io.PaymentVerificationRequest;
import com.abdur.BillingSoftware.io.RazorpayOrderResponse;
import com.abdur.BillingSoftware.service.OrderService;
import com.abdur.BillingSoftware.service.RazorpayService;
import com.razorpay.RazorpayException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final RazorpayService razorpayService;
    private final OrderService orderService;

    @PostMapping("/create-order")
    @ResponseStatus(HttpStatus.CREATED)
    public RazorpayOrderResponse createRazorpayOrder(@RequestBody PaymentRequest request) throws RazorpayException {
          return razorpayService.createOrder(request.getAmount(),request.getCurrency());
    }



    @PostMapping("/verify")
    public OrderResponse verifyPayment(@RequestBody PaymentVerificationRequest request){
         return orderService.verifyPayment(request);
    }
}
