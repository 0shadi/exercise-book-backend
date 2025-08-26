package com.bit.backend.repositories;

import com.bit.backend.entities.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity,Long> {
    Optional<OrderDetailsEntity> findByOrderId(long orderId);

    @Query(nativeQuery = true, value = "SELECT DATE_FORMAT(date, '%Y-%m') AS orderMonth, count(order_id) as cnt FROM `order-details` group by orderMonth order by orderMonth")
    List<Map<String, Object>> getMonthlySales();

    @Query(nativeQuery = true, value = "SELECT DATE_FORMAT(date, '%Y-%m') AS orderMonth, sum(total_cost) as summation FROM `order-details` group by orderMonth order by orderMonth")
    List<Map<String, Object>> getMonthlySalesIncome();

    @Query(nativeQuery = true, value = "SELECT order_status as status, count(order_status) as cnt FROM `order-details` WHERE YEARWEEK(date, 1) = YEARWEEK(CURDATE(), 1) group by order_status")
    List<Map<String, Object>> getNoOfOrdersPlaceThisWeekByStatus();
}
