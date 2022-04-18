package com.project.service.impl;

import com.project.api.*;
import com.project.dao.pojo.BookInfo;
import com.project.vo.Result;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    StockService stockService;

    @Autowired
    BalanceService balanceService;

    @Autowired
    OrderService orderService;

    @Autowired
    BookService bookService;

    @Override
    @GlobalTransactional
    public Result purchase(Long userId, Long bookId, Integer count) {
        BookInfo book = bookService.getBookById(bookId).getData();
        Double price = book.getPRICE();
        Double total = count * price;

        balanceService.subtractById(userId, total);
        stockService.subtractById(bookId, count);
        orderService.addOrder(userId, bookId, count);

        return orderService.getOrderById(userId);
    }
}
