package com.khaind.microservices.order.controller;

import com.khaind.microservices.order.dto.OrderDTO;
import com.khaind.microservices.order.entity.OrderEntity;
import com.khaind.microservices.order.mapper.OrderMapper;
import com.khaind.microservices.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @PostMapping
    public OrderDTO upsert(@RequestBody OrderDTO dto) {
        OrderEntity entity = orderRepository.save(orderMapper.toEntity(dto));
        return orderMapper.toDTO(entity);
    }

    @GetMapping("/{id}")
    public OrderDTO getOrder(@PathVariable Long id) {
        Optional<OrderEntity> entity = orderRepository.findById(id);
        if (entity.isPresent()) {
            return orderMapper.toDTO(entity.get());
        }
        return null;
    }

    @GetMapping
    public List<OrderDTO> getOrders() {
        return orderMapper.toDTOs(orderRepository.findAll());
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        try {
            orderRepository.deleteById(id);
            return "success";
        } catch (Exception e) {
            System.out.printf("Delete order error: " + e);
        }
        return "fail";
    }
}
