package com.abdur.BillingSoftware.service;

import com.abdur.BillingSoftware.io.RazorpayOrderResponse;
import com.razorpay.RazorpayException;

public interface RazorpayService {
    RazorpayOrderResponse createOrder(Double amount , String currency) throws RazorpayException;
}
