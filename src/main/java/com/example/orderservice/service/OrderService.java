package com.example.orderservice.service;

import com.example.orderservice.dto.req.OrderRequestDTO;
import com.example.orderservice.dto.res.OrderDTO;
import com.example.orderservice.entity.Course;
import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.OrderStatus;
import com.example.orderservice.exception.ResourceNotFoundException;
import com.example.orderservice.repository.CourseRepository;
import com.example.orderservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CourseRepository courseRepository;

    @Transactional
    public OrderDTO createOrder(OrderRequestDTO request) {
        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Không tìm thấy khóa học id = " + request.getCourseId()));

        Order order = new Order();
        order.setStudentId(request.getStudentId());
        order.setCourseId(course.getId());
        order.setTotalAmount(course.getPrice());
        order.setStatus(OrderStatus.PENDING);
        order.setCreatedAt(LocalDateTime.now());

        return toDTO(orderRepository.save(order));
    }

    private OrderDTO toDTO(Order o) {
        return new OrderDTO(o.getId(), o.getStudentId(), o.getCourseId(),
                o.getTotalAmount(), o.getStatus().name(), o.getCreatedAt());
    }
}