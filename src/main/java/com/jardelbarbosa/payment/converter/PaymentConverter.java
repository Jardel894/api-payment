package com.jardelbarbosa.payment.converter;

import com.jardelbarbosa.payment.dto.request.PaymentRequest;
import com.jardelbarbosa.payment.dto.response.PaymentResponse;
import com.jardelbarbosa.payment.entities.Payment;

public class PaymentConverter {

    public static PaymentResponse toPaymentResponse(Payment payment) {
      return   PaymentResponse.builder()
                .id(payment.getId())
                .name(payment.getName())
                .code(payment.getCode())
                .orderId(payment.getOrderId())
                .status(payment.getStatus())
                .expiration(payment.getExpiration())
                .number(payment.getNumber())
                .amount(payment.getAmount())
                .paymentMethodId(payment.getPaymentMethodId())
                .build();
    }

    public static Payment toPayment(PaymentRequest paymentRequest) {
        return   Payment.builder()
                .name(paymentRequest.getName())
                .code(paymentRequest.getCode())
                .orderId(paymentRequest.getOrderId())
                .status(paymentRequest.getStatus())
                .expiration(paymentRequest.getExpiration())
                .number(paymentRequest.getNumber())
                .amount(paymentRequest.getAmount())
                .paymentMethodId(paymentRequest.getPaymentMethodId())
                .build();
    }
}
