package org.example.service;

import org.example.dto.OrderDTO;
import org.example.entity.Order;
import org.example.entity.OrderItem;
import org.example.entity.OrderStatus;
import org.example.entity.Product;
import org.example.mapper.OrderMapper;
import org.example.mapper.ProductMapper;
import org.example.repository.OrderRepository;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, OrderMapper orderMapper, ProductMapper productMapper) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderMapper = orderMapper;
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return orderMapper.toDTO(order);
    }

    public void createOrder(OrderDTO dto) {
        List<OrderItem> items = dto.getItems().stream().map(itemDTO -> {
            Product product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not Found"));
            return orderMapper.toEntity(itemDTO, product, null);
        }).collect(Collectors.toList());

        Order order = orderMapper.toEntity(dto, items);
        items.forEach(item -> item.setOrder(order));
        orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public List<Order> getOrdersByStatus(OrderStatus status) {
        return orderRepository.findByStatus(status);
    }

    public Order updateOrderStatus(Long id, OrderStatus status) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }

    @Scheduled(fixedRate = 30000)
    public void updateOrderStatuses() {
        LocalDate thresholdDate = LocalDate.now().minusDays(30);
        List<Order> orders = orderRepository.findOrdersPendingForMoreThanNdays(thresholdDate);
        for (Order order : orders) {
            if (order.getStatus().equals(OrderStatus.PENDING)) {
                order.setStatus(OrderStatus.PROCESSING);
            } else if (order.getStatus().equals(OrderStatus.PROCESSING)) {
                order.setStatus(OrderStatus.SHIPPED);
            } else if (order.getStatus().equals(OrderStatus.SHIPPED)) {
                order.setStatus(OrderStatus.DELIVERED);
            }
            orderRepository.save(order);
        }
    }

    public Double getProfit(LocalDate startDate, LocalDate endDate) {
        return orderRepository.calculateProfit(startDate, endDate);
    }

    public List<Object[]> getDailyProfit(LocalDate startDate, LocalDate endDate) {
        return orderRepository.calculateDailyProfit(startDate, endDate);
    }
}