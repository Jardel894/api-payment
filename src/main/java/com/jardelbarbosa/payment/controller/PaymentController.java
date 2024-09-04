package com.jardelbarbosa.payment.controller;

import com.jardelbarbosa.payment.dto.request.PaymentRequest;
import com.jardelbarbosa.payment.dto.response.PaymentResponse;
import com.jardelbarbosa.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<PaymentResponse> findAll(Pageable pageable){
        return paymentService.findAll(pageable);
    }

    @GetMapping("/{id}/id")
    @ResponseStatus(HttpStatus.OK)
    public PaymentResponse findById(Long id){
        return paymentService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPayment(@RequestBody PaymentRequest paymentRequest){
         paymentService.createPayment(paymentRequest);
    }

    @PutMapping("/{id}/id")
    @ResponseStatus(HttpStatus.OK)
    public void updatePayment(@PathVariable Long id, @RequestBody PaymentRequest paymentRequest){
         paymentService.updatePayment(id, paymentRequest);
    }
    @DeleteMapping("/{id}/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePayment(@PathVariable Long id){
        paymentService.deletePayment(id);
    }
}
