package com.epam.ecommerceapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PayPalService {

    @Value("${paypal.client-id}")
    private String clientId;

    @Value("${paypal.secret}")
    private String secret;

    @Value("${paypal.mode}")
    private String mode;

    public String getClientId() {
        return clientId;
    }

    public String getSecret() {
        return secret;
    }

    public String getMode() {
        return mode;
    }
}
