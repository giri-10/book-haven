package com.giri.order_service.web.controllers;

import org.apache.catalina.servlets.DefaultServlet.SortManager.Order;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ResponseStatus;

class OrderController {
              private static final Logger log = LoggerFactory.getLogger(OrderController.class);
              private final OrderService orderService;
              private final SecurityService securityService;

              OrderController(OrderService orderService, SecurityService securityService) 
              {
                            this.orderService = orderService;
                            this.securityService = securityService;
              }


              @PostMapping("/orders")
              @ResponseStatus(HttpStatus.CREATED)
              CreateOrderResponse createOrder(@Valid @RequestBody CreateOrderRequest request )
              {
                            String username = securityService.getLoginUserName();
                            log.info("Creating order for user: {}", username);
                            return orderService.createOrder(username, request);
              }
}
