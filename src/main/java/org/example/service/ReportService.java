package org.example.service;

import org.example.entity.Product;
import org.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Product> getTop10Products() {
        return orderRepository.findTop10CancelledProducts().stream()
                .map(result -> (Product) result[0])
                .collect(Collectors.toList());
    }

    public List<Product> getTop10CancelledProducts() {
        return orderRepository.findTop10CancelledProducts().stream()
                .map(result -> (Product) result[0])
                .collect(Collectors.toList());
    }

    public List<Product> getProductsPendingForMoreThanNDays(int days) {
        LocalDate date = LocalDate.now().minusDays(days);
        return orderRepository.findProductsPendingForMoreThanNDays(date);
    }

    public Double getTotalRevenue(LocalDate startDate, LocalDate endDate) {
        return orderRepository.findTotalRevenue(startDate, endDate);
    }
}