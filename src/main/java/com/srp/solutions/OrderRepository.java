package com.srp.solutions;

import com.srp.dto.OrderDTO;
import org.springframework.web.client.RestTemplate;

public class OrderRepository {
    private final RestTemplate restTemplate;

    public OrderRepository() {
        this.restTemplate = new RestTemplate();
    }

    public void save(OrderDTO order) {
        String url = "http://fake-api.com/orders";
        restTemplate.postForObject(url, order, Void.class);
    }
}