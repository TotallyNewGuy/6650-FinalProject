package com.project.service.impl;

import com.project.api.*;
import com.project.dao.pojo.BookInfo;
import com.project.vo.Result;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class is the implementation of purchase service, it deal with purchase book transaction.
 */

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

    /***
     * this method deal with our main function, purchase a book. One transaction is only success if all sub services
     * are successful.
     * @param userId UserID
     * @param bookId bookID
     * @param count count of book
     * @return the result of the purchase transaction
     */
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
