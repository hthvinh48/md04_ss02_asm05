package com.example.orderservice.dto.res;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private Long studentId;
    private Long courseId;
    private BigDecimal totalAmount;
    private String status;
    private LocalDateTime createdAt;
}
