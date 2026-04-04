package com.bankpay;

import com.bankpay.model.Payment;
import com.bankpay.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;

    @Test
    void testCreatePayment() {
        Payment p = new Payment();
        p.setFrom("Alice");
        p.setTo("Bob");
        p.setAmount(100.0);

        Payment created = paymentService.createPayment(p);

        assertNotNull(created.getId());
        assertEquals("SUCCESS", created.getStatus());
        assertEquals("Alice", created.getFrom());
        assertEquals(100.0, created.getAmount());
    }

    @Test
    void testGetAllPayments() {
        Payment p = new Payment();
        p.setFrom("Alice");
        p.setTo("Bob");
        p.setAmount(50.0);
        paymentService.createPayment(p);

        assertFalse(paymentService.getAllPayments().isEmpty());
    }

    @Test
    void testGetPaymentById() {
        Payment p = new Payment();
        p.setFrom("Alice");
        p.setTo("Charlie");
        p.setAmount(200.0);
        Payment created = paymentService.createPayment(p);

        Payment found = paymentService.getPaymentById(created.getId());
        assertNotNull(found);
        assertEquals(created.getId(), found.getId());
    }

    @Test
    void testDeletePayment() {
        Payment p = new Payment();
        p.setFrom("Alice");
        p.setTo("Dave");
        p.setAmount(75.0);
        Payment created = paymentService.createPayment(p);

        assertTrue(paymentService.deletePayment(created.getId()));
        assertNull(paymentService.getPaymentById(created.getId()));
    }

    @Test
    void testGetPaymentByIdNotFound() {
        assertNull(paymentService.getPaymentById("invalid-id"));
    }
}
