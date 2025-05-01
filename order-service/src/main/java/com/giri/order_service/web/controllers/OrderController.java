package com.giri.order_service.web.controllers;

import org.slf4j.LoggerFactory;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.giri.order_service.domain.OrderNotFoundException;
import com.giri.order_service.domain.OrderService;
import com.giri.order_service.domain.SecurityService;
import com.giri.order_service.domain.models.CreateOrderRequest;
import com.giri.order_service.domain.models.CreateOrderResponse;
import com.giri.order_service.domain.models.OrderDTO;
import com.giri.order_service.domain.models.OrderSummary;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/orders")
@SecurityRequirement(name = "security_auth")
class OrderController {
              private static final Logger log = LoggerFactory.getLogger(OrderController.class);
              private final OrderService orderService;
              private final SecurityService securityService;

              OrderController(OrderService orderService, SecurityService securityService) {
                            this.orderService = orderService;
                            this.securityService = securityService;
              }

              @PostMapping
              @ResponseStatus(HttpStatus.CREATED)
              CreateOrderResponse createOrder(@Valid @RequestBody CreateOrderRequest request) {
                            String username = securityService.getLoginUserName();
                            log.info("Creating order for user: {}", username);
                            return orderService.createOrder(username, request);
              }

              @GetMapping
              List<OrderSummary> getOrders() {
                            String userName = securityService.getLoginUserName();
                            log.info("Fetching orders for user: {}", userName);
                            return orderService.findOrders(userName);
              }

              @GetMapping(value = "/{orderNumber}")
              OrderDTO getOrder(@PathVariable(value = "orderNumber") String orderNumber) {
                            log.info("Fetching order by id: {}", orderNumber);
                            String userName = securityService.getLoginUserName();
                            return orderService
                                                        .findUserOrder(userName, orderNumber)
                                                        .orElseThrow(() -> new OrderNotFoundException(orderNumber));
              }
}
