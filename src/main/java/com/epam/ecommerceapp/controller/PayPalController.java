package com.epam.ecommerceapp.controller;
import com.epam.ecommerceapp.service.PayPalService;
import com.paypal.core.PayPalHttpClient;
import com.paypal.http.HttpResponse;
import com.paypal.orders.Order;
import com.paypal.orders.OrdersCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/paypal")
public class PayPalController {

    private final PayPalService payPalService;
    private final PayPalHttpClient payPalHttpClient;

    @Autowired
    public PayPalController(PayPalService payPalService, PayPalHttpClient payPalHttpClient) {
        this.payPalService = payPalService;
        this.payPalHttpClient = payPalHttpClient;
    }

    @PostMapping("/create-order")
    public ResponseEntity<String> createOrder() {
        try {
            OrdersCreateRequest request = new OrdersCreateRequest();
            request.prefer("return=representation");
            request.requestBody(new Order().checkoutPaymentIntent("CAPTURE"));

            HttpResponse<Order> execute = payPalHttpClient.execute(request);
            // Extract the order ID and return it to the frontend for further processing

            return ResponseEntity.ok(execute.result().id());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating PayPal order");
        }
    }
}
