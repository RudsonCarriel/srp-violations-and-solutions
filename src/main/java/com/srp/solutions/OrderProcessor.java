package com.srp.solutions;

import com.srp.dto.OrderDTO;

public class OrderProcessor {
    private final OrderValidator validator;
    private final OrderCalculator calculator;
    private final OrderRepository repository;
    private final EmailService emailService;

    public OrderProcessor() {
        this.validator = new OrderValidator();
        this.calculator = new OrderCalculator();
        this.repository = new OrderRepository();
        this.emailService = new EmailService();
    }

    public void processOrder(OrderDTO order) {
        validator.validate(order);
        double total = calculator.calculateTotal(order);
        repository.save(order);
        emailService.sendConfirmationEmail(order);
    }
}