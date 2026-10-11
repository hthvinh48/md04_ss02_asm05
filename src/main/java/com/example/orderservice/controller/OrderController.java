package com.example.orderservice.controller;

import com.example.orderservice.dto.req.OrderRequestDTO;
import com.example.orderservice.dto.res.BaseResponse;
import com.example.orderservice.dto.res.OrderDTO;
import com.example.orderservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<BaseResponse<OrderDTO>> createOrder(@Valid @RequestBody OrderRequestDTO request) {
        OrderDTO orderDTO = orderService.createOrder(request);
        BaseResponse<OrderDTO> response = new BaseResponse<>(true, "Order created successfully", orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
