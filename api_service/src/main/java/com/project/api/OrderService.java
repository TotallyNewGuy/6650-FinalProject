package com.project.api;

import com.project.vo.Result;

public interface OrderService {
    Result getAllOrder();
    Result getOrderById(Long id); // user ID
    Result addOrder(Long userId, Long bookId, Integer count);
    Result deleteOrder(Long orderId);
}
