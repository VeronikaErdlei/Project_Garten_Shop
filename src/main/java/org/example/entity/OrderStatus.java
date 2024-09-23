package org.example.entity;


public enum OrderStatus {
    PENDING,         // Ожидание оплаты
    PROCESSING,      // Обрабатывается
    SHIPPED,         // Отправлен
    DELIVERED,       // Доставлен
    CANCELED         // Отменен
}
