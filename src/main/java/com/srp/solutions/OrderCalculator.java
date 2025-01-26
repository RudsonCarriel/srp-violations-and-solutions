package com.srp.solutions;

import com.srp.dto.OrderDTO;
import com.srp.dto.OrderItemDTO;

public class OrderCalculator {
    public double calculateTotal(OrderDTO order) {
        double total = 0;
        for (OrderItemDTO item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}