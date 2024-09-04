package com.jardelbarbosa.payment.service.impl;

import com.jardelbarbosa.payment.converter.PaymentConverter;
import com.jardelbarbosa.payment.dto.request.PaymentRequest;
import com.jardelbarbosa.payment.dto.response.PaymentResponse;
import com.jardelbarbosa.payment.entities.Payment;
import com.jardelbarbosa.payment.enuns.Status;
import com.jardelbarbosa.payment.repository.PaymentRepository;
import com.jardelbarbosa.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Page<PaymentResponse> findAll(Pageable pageable) {
        return paymentRepository.findAll(pageable)
                .map(PaymentConverter::toPaymentResponse);
    }

    @Override
    public PaymentResponse findById(Long id) {
        return paymentRepository.findById(id)
                .map(PaymentConverter::toPaymentResponse)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public void createPayment(PaymentRequest paymentRequest) {
        Payment payment = PaymentConverter.toPayment(paymentRequest);
        payment.setStatus(Status.CRIADO);
        paymentRepository.save(payment);
    }

    @Override
    public void updatePayment(Long id, PaymentRequest paymentRequest) {
        paymentRepository.findById(id)
                .map(PaymentConverter::toPaymentResponse)
                .orElseThrow(RuntimeException::new);
    }

    public void deletePayment(Long id) {
        paymentRepository.findById(id)
                .ifPresent(paymentRepository::delete);
    }


}
