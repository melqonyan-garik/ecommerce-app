# E-Commerce Application with Spring Boot and PayPal Integration

## Overview

This Spring Boot application serves as a simple e-commerce platform with essential features such as browsing products, adding items to the cart, placing orders, and integrating PayPal for secure payment processing.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
    - [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [PayPal Integration](#paypal-integration)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Features

- Browse products
- Add items to the cart
- Place orders
- PayPal integration for secure payment processing

## Prerequisites

- Java 8 or later
- Maven
- MySQL or another relational database
- PayPal Business Account

## Getting Started

### Configuration

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/e-commerce-spring-boot.git
Navigate to the project directory:

bash
Copy code
cd e-commerce-spring-boot
Set up your database configuration in src/main/resources/application.properties:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
Configure PayPal properties in src/main/resources/application.properties:

properties
Copy code
paypal.client-id=your-paypal-client-id
paypal.secret=your-paypal-secret
paypal.mode=sandbox
Running the Application
Build the project:

bash
Copy code
mvn clean install
Run the application:

bash
Copy code
mvn spring-boot:run
Access the application at http://localhost:8080.

API Endpoints
/api/products: Retrieve all products
/api/products/{productId}: Retrieve product details by ID
/api/users/{userId}: Retrieve user details by ID
/api/cart/{userId}/add-to-cart: Add an item to the user's cart
/api/cart/{userId}/cart: Retrieve items in the user's cart
/api/cart/{userId}/remove-from-cart/{productId}: Remove an item from the user's cart
/api/orders/{userId}/place-order: Place an order for the items in the user's cart
PayPal Integration
Create a PayPal Business Account.
Log in to the PayPal Developer Dashboard and create a new application to obtain the client ID and secret.
Configure PayPal properties in application.properties (as mentioned in the Configuration section).
Testing
Run unit tests using the following command:

bash
Copy code
mvn test
## Conversation Logs

ChatGPT conversation logs are available in the file [chat.log](src/main/resources/chat.log).
Conversation link: https://chat.openai.com/share/081e2e4b-c4a7-4d04-a717-302e1a09e20d

# Project Feedback

- **Was it easy to complete the task using AI?**
    - Absolutely, leveraging AI made the task significantly more straightforward.

- **How long did the task take you to complete?**
    - The task was completed in approximately 2 hour.

- **Was the code ready to run after generation? What did you have to change to make it usable?**
    - The generated code was ready to run; I made minor adjustments to the readme for clarity.

- **Which challenges did you face during completion of the task?**
    - The primary challenge revolved around formulating questions in a manner that AI could understand, leading to satisfactory responses.


Contributing
Contributions are welcome! Please follow the Contribution Guidelines.

This revision aims to make the document clearer, organized, and visually ap