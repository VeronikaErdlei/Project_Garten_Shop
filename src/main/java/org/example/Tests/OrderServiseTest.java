/* package org.example.Tests;

import org.example.service.OrderService;

@RunWith(SpringRunner)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @MockBean
    private OrderRepository orderRepository;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private OrderMapper orderMapper;

    @MockBean
    private ProductMapper productMapper;

    @Test
    public void testCreateOrder() {
        OrderDTO dto = new OrderDTO();
        dto.setOrderDate(LocalDate.now());
        dto.setStatus("PENDING");
        Order order = new Order();
        Product product = new Product();
        OrderItem orderItem = new OrderItem();
        OrderItemDTO itemDTO = new OrderItemDTO();

        Mockito.when(orderMapper.toEntity(dto, Collections.singletonList(orderItem))).thenReturn(order);
        Mockito.when(productRepository.findById(itemDTO.getProductId())).thenReturn(Optional.of(product));
        Mockito.when(orderRepository.save(order)).thenReturn(order);

        orderService.createOrder(dto);
        Mockito.verify(orderRepository).save(order);
    }

    @Test
    public void testUpdateOrderStatus() {
        Order order = new Order();
        order.setStatus(OrderStatus.PENDING);

        Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        Order updatedOrder = orderService.updateOrderStatus(1L, OrderStatus.PROCESSING);
        assertEquals(OrderStatus.PROCESSING, updatedOrder.getStatus());
    }

    @Test(expected = RuntimeException.class)
    public void testUpdateOrderStatusNotFound() {
        Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.empty());
        orderService.updateOrderStatus(1L, OrderStatus.PROCESSING);
    }
}


 */