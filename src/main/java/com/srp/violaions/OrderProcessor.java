package com.srp.violaions;

import com.srp.dto.OrderDTO;
import com.srp.dto.OrderItemDTO;
import org.springframework.web.client.RestTemplate;

public class OrderProcessor {
    private final RestTemplate restTemplate;

    public OrderProcessor() {
        this.restTemplate = new RestTemplate();
    }

    public void processOrder(OrderDTO orderDTO) {
        if (orderDTO == null || orderDTO.getItems().isEmpty()) {
            throw new IllegalArgumentException("O pedido é inválido!");
        }

        double total = 0;
        for (OrderItemDTO item : orderDTO.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        orderDTO.setTotal(total);

        String saveUrl = "http://fake-api.com/orders";
        restTemplate.postForObject(saveUrl, orderDTO, Void.class);

        String emailUrl = "http://fake-api.com/emails";
        restTemplate.postForObject(emailUrl, orderDTO, Void.class);
    }
}