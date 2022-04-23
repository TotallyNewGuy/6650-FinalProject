package com.project.controller;

import com.project.api.OrderService;
import com.project.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order", method = RequestMethod.GET)
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/all")
    public Result checkAllOrder() {
        return orderService.getAllOrder();
    }

    @GetMapping("/{id}")
    public Result checkOrderById(@PathVariable("id") Long id) {
        System.out.println("checkOrderById activated");
        // userId
        return orderService.getOrderById(id);
    }

    @GetMapping("/add")
    public Result addOrder(@RequestParam("userId") Long userId,
                           @RequestParam("bookId") Long bookId,
                           @RequestParam("cnt") Integer count) {

        return orderService.addOrder(userId, bookId, count);
    }

    @GetMapping("/delete")
    public Result addOrder(@RequestParam("orderId") Long orderId) {
        return orderService.deleteOrder(orderId);
    }
}
