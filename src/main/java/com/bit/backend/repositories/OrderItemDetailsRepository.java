package com.bit.backend.repositories;

import com.bit.backend.entities.OrderItemDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface OrderItemDetailsRepository extends JpaRepository<OrderItemDetailsEntity,Long> {
    Optional<List<OrderItemDetailsEntity>> findByOrderId(long orderId);

    @Query(nativeQuery = true, value = "SELECT item_name as itemName, sum(item_price * ord_qty) as cnt FROM `order-item_Details` group by item_name")
    List<Map<String, Object>> getSalesPerOrderItem();
}
