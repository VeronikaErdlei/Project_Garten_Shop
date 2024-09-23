package org.example.mapper;

import org.example.dto.OrderDTO;
import org.example.dto.OrderItemDTO;
import org.example.entity.Order;
import org.example.entity.OrderItem;
import org.example.entity.Product;
import org.example.entity.OrderStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setOrderDate(order.getCreatedAt());
        dto.setStatus(order.getStatus().name());
        dto.setItems(order.getOrderItems().stream()
                .map(this::toDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    public Order toEntity(OrderDTO dto, List<OrderItem> items) {
        Order order = new Order();
        order.setCreatedAt(dto.getOrderDate());
        order.setStatus(OrderStatus.valueOf(dto.getStatus()));
        order.setOrderItems(items);
        return order;
    }

    public OrderItemDTO toDTO(OrderItem orderItem) {
        OrderItemDTO dto = new OrderItemDTO();
        dto.setProductId(orderItem.getProduct().getId());
        dto.setQuantity(orderItem.getQuantity());
        return dto;
    }

    public OrderItem toEntity(OrderItemDTO dto, Product product, Order order) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(dto.getQuantity());
        orderItem.setOrder(order);
        return orderItem;
    }
}