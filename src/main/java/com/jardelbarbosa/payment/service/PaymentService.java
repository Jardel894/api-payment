package com.jardelbarbosa.payment.service;

import com.jardelbarbosa.payment.dto.request.PaymentRequest;
import com.jardelbarbosa.payment.dto.response.PaymentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentService {

    Page<PaymentResponse> findAll(Pageable pageable);
    PaymentResponse findById(Long id);
    void createPayment(PaymentRequest paymentRequest);
    void updatePayment(Long id, PaymentRequest paymentRequest);
    void deletePayment(Long id);

}
