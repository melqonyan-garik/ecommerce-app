package com.epam.ecommerceapp.controller;

import com.epam.ecommerceapp.model.Order;
import com.epam.ecommerceapp.service.PayPalService;
import com.paypal.core.PayPalHttpClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class PayPalControllerTest {

    @Mock
    private PayPalService payPalService;

    @Mock
    private PayPalHttpClient payPalHttpClient;

    @InjectMocks
    private PayPalController payPalController;

    @Test
    void createOrder_Success() throws IOException {
        // Mocking PayPalService
        Mockito.when(payPalService.getClientId()).thenReturn("mocked-client-id");
        Mockito.when(payPalService.getSecret()).thenReturn("mocked-secret");

        // Mocking PayPalHttpClient
        Order order = new Order();
        order.setOrderId(10L);
//        Mockito.when(payPalHttpClient.execute(any())).thenReturn(ResponseEntity.ok());

        // Test the controller
        ResponseEntity<String> response = payPalController.createOrder();

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("mocked-order-id", response.getBody());
    }

    @Test
    void createOrder_Failure() throws IOException {
        // Mocking PayPalService
        Mockito.when(payPalService.getClientId()).thenReturn("mocked-client-id");
        Mockito.when(payPalService.getSecret()).thenReturn("mocked-secret");

        // Mocking PayPalHttpClient to throw an exception
        Mockito.when(payPalHttpClient.execute(any())).thenThrow(new IOException("Mocked exception"));

        // Test the controller
        ResponseEntity<String> response = payPalController.createOrder();

        // Assertions
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Error creating PayPal order", response.getBody());
    }
}
