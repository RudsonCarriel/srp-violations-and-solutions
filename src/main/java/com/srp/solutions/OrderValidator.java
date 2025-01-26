package com.srp.solutions;

import com.srp.dto.OrderDTO;

public class OrderValidator {
    public void validate(OrderDTO order) {
        if (order == null || order.getItems().isEmpty()) {
            throw new IllegalArgumentException("O pedido é inválido!");
        }
    }
}