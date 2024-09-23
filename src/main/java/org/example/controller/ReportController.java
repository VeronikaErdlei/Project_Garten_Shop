package org.example.controller;

import org.example.entity.Product;
import org.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/reports/top-products")
    public List<Product> getTop10Products() {
        return reportService.getTop10Products();
    }

    @GetMapping("/reports/cancelled-products")
    public List<Product> getTop10CancelledProducts() {
        return reportService.getTop10CancelledProducts();
    }

    @GetMapping("/reports/pending-products")
    public List<Product> getProductsPendingForMoreThanNDays(@RequestParam int days) {
        return reportService.getProductsPendingForMoreThanNDays(days);
    }
}