package com.giri.order_service.web.controllers;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import com.giri.order_service.domain.OrderService;
import com.giri.order_service.domain.SecurityService;
import com.giri.order_service.domain.models.CreateOrderRequest;
import com.giri.order_service.domain.models.CreateOrderResponse;

import jakarta.validation.Valid;

class OrderController {
              private static final Logger log = LoggerFactory.getLogger(OrderController.class);
              private final OrderService orderService;
              private final SecurityService securityService;

              OrderController(OrderService orderService, SecurityService securityService) 
              {
                            this.orderService = orderService;
                            this.securityService = securityService;
              }


              @PostMapping
              @ResponseStatus(HttpStatus.CREATED)
              CreateOrderResponse createOrder(@Valid @RequestBody CreateOrderRequest request )
              {
                            String username = securityService.getLoginUserName();
                            log.info("Creating order for user: {}", username);
                            return orderService.createOrder(username, request);
              }
}
