package com.srp.solutions;

import com.srp.dto.OrderDTO;
import org.springframework.web.client.RestTemplate;

public class EmailService {
    private final RestTemplate restTemplate;

    public EmailService() {
        this.restTemplate = new RestTemplate();
    }

    public void sendConfirmationEmail(OrderDTO order) {
        String url = "http://fake-api.com/emails";
        restTemplate.postForObject(url, order, Void.class);
    }
}
