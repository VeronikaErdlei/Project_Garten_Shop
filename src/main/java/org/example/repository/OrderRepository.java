package org.example.repository;

import org.example.entity.Order;
import org.example.entity.OrderStatus;
import org.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByStatus(OrderStatus status);

    @Query("SELECT p, COUNT(p) AS purchases FROM Order o JOIN o.products p WHERE o.status = 'DELIVERED' GROUP BY p ORDER BY purchases DESC")
    List<Object[]> findTop10BoughtProducts();

    @Query("SELECT p, COUNT(p) AS cancellations FROM Order o JOIN o.products p WHERE o.status = 'CANCELLED' GROUP BY p ORDER BY cancellations DESC")
    List<Object[]> findTop10CancelledProducts();

    @Query("SELECT o.products FROM Order o WHERE o.status = 'PENDING' AND o.createdAt < :date")
    List<Product> findProductsPendingForMoreThanNDays(@Param("date") LocalDate date);

    @Query("SELECT SUM(o.createdAt) FROM Order o WHERE o.createdAt BETWEEN :startDate AND :endDate")
    Double findTotalRevenue(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT SUM(o.totalPrice) FROM Order o WHERE o.status = 'DELIVERED' AND o.createdAt BETWEEN :startDate AND :endDate")
    Double calculateProfit(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT o FROM Order o WHERE o.status = 'PENDING' AND o.createdAt < :thresholdDate")
    List<Order> findOrdersPendingForMoreThanNdays(@Param("thresholdDate") LocalDate thresholdDate);

    @Query("SELECT YEAR(o.createdAt), MONTH(o.createdAt), SUM(o.createdAt) FROM Order o WHERE o.status = 'DELIVERED' AND o.createdAt BETWEEN :startDate AND :endDate GROUP BY YEAR(o.createdAt), MONTH(o.createdAt)")
    List<Object[]> calculateMonthlyProfit(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT DATE(o.createdAt), SUM(o.totalPrice) FROM Order o WHERE o.status = 'DELIVERED' AND o.createdAt BETWEEN :startDate AND :endDate GROUP BY DATE(o.createdAt)")
    List<Object[]> calculateDailyProfit(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT YEAR(o.createdAt), SUM(o.totalPrice) FROM Order o WHERE o.status = 'DELIVERED' AND o.createdAt BETWEEN :startDate AND :endDate GROUP BY YEAR(o.createdAt)")
    List<Object[]> calculateYearlyProfit(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT o FROM Order o WHERE o.status IN ('PENDING', 'PROCESSING')")
    List<Order> findOrdersForAnalysis();
}


