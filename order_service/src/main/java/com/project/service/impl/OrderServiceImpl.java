package com.project.service.impl;
import com.project.api.BookService;
import com.project.api.OrderService;
import com.project.api.UserService;
import com.project.dao.mapper.OrderMapper;
import com.project.dao.pojo.BookInfo;
import com.project.dao.pojo.OrderItem;
import com.project.util.NTPTime;
import com.project.vo.Result;
import com.project.dao.pojo.User;
import com.project.vo.ResultBook;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@DubboService
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    @Override
    public Result getAllOrder() {
        List<OrderItem> res = orderMapper.getAllOrder();
        for(OrderItem orderItem : res) {
            System.out.println(orderItem);
        }
        return Result.success(res);
    }

    @Override
    public Result getOrderById(Long id) {
        User user = (User) userService.getUserById(id).getData();
        String name = user.getNAME();
        List<OrderItem> res = orderMapper.getOrderByName(name);
        return Result.success(res);
    }

    @Override
    public Result addOrder(Long userId, Long bookId, Integer count) {
        // name and address can be got by user_service
        Result userRes = userService.getUserById(userId);
        User user = (User)userRes.getData();

        String userName = user.getNAME();
        String address = user.getADDRESS();

        // balance can be got by balance_service
        ResultBook bookRes = bookService.getBookById(bookId);
        BookInfo bookInfo = bookRes.getData();
        String bookName = bookInfo.getNAME();

        // NTP time from NIST time service
        String orderTime = NTPTime.getNTPTime();

//        long time = System.currentTimeMillis();
//        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
//        Date date = new Date(time);
//        String orderTime = formatter.format(date);

        orderMapper.addOrder(userName, address, bookName, count, orderTime);
        return Result.success("add order is successful");
    }
}
