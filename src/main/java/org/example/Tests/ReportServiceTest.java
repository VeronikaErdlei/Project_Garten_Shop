/* package org.example.Tests;

import org.example.entity.Order;
import org.example.entity.OrderStatus;
import org.example.entity.Product;
import org.example.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Rollback(false)
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void testFindByStatus() {

        Order order = new Order();
        order.setStatus(OrderStatus.DELIVERED);
        orderRepository.save(order);


        List<Order> deliveredOrders = orderRepository.findByStatus(OrderStatus.DELIVERED);
        assertThat(deliveredOrders).isNotEmpty();
        assertThat(deliveredOrders.get(0).getStatus()).isEqualTo(OrderStatus.DELIVERED);
    }

    @Test
    public void testFindTop10BoughtProducts() {


        List<Object[]> topProducts = orderRepository.findTop10BoughtProducts();

        assertThat(topProducts).isNotEmpty();
    }

    @Test
    public void testFindProductsPendingForMoreThanNDays() {
        LocalDate date = LocalDate.now().minusDays(30);

        Order order = new Order();
        order.setStatus(OrderStatus.PENDING);
        order.setCreatedDate(LocalDate.now().minusDays(31)); // Устанавливаем старую дату
        orderRepository.save(order);

        List<Product> pendingProducts = orderRepository.findProductsPendingForMoreThanNDays(date);
        assertThat(pendingProducts).isNotEmpty();
    }

    @Test
    public void testCalculateTotalRevenue() {

        Order order1 = new Order();
        order1.setTotalPrice(100.0);
        order1.setCreatedDate(LocalDate.now().minusDays(10));
        orderRepository.save(order1);

        Order order2 = new Order();
        order2.setTotalPrice(200.0);
        order2.setCreatedDate(LocalDate.now().minusDays(5));
        orderRepository.save(order2);

        Double totalRevenue = orderRepository.findTotalRevenue(LocalDate.now().minusDays(15), LocalDate.now());
        assertThat(totalRevenue).isEqualTo(300.0);
    }
}

 */
