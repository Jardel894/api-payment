package com.jardelbarbosa.payment.repository;

import com.jardelbarbosa.payment.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.function.Function;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
