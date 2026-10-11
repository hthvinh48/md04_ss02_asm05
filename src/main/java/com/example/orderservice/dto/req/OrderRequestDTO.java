package com.example.orderservice.dto.req;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderRequestDTO {

    @NotNull(message = "studentId không được để trống")
    @Positive(message = "studentId phải lớn hơn 0")
    private Long studentId;

    @NotNull(message = "courseId không được để trống")
    @Positive(message = "courseId phải lớn hơn 0")
    private Long courseId;
}
