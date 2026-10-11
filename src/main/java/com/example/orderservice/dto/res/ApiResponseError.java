package com.example.orderservice.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponseError {
    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String message;
}
