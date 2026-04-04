package com.bankpay.service;

import com.bankpay.model.Payment;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PaymentService {

    private final Map<String, Payment> payments = new HashMap<>();

    public Payment createPayment(Payment payment) {
        payment.setId(UUID.randomUUID().toString());
        payment.setStatus("SUCCESS");
        payments.put(payment.getId(), payment);
        return payment;
    }

    public List<Payment> getAllPayments() {
        return new ArrayList<>(payments.values());
    }

    public Payment getPaymentById(String id) {
        return payments.get(id);
    }

    public boolean deletePayment(String id) {
        return payments.remove(id) != null;
    }
}
