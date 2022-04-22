package com.project.service.impl;

import com.project.api.BookService;
import com.project.config.CommonConfig;
import com.project.dao.mapper.BookInfoMapper;
import com.project.dao.pojo.BookInfo;
import com.project.vo.ResultBook;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
public class BookServiceImpl implements BookService {

    @Autowired
    private BookInfoMapper bookInfoMapper;

    @Autowired
    private CommonConfig commonConfig;

    @Override
    public ResultBook getBookById(Long id) {
        BookInfo book = bookInfoMapper.findBookById(id);
        if (book == null) {
            throw new IllegalArgumentException("book id is invalid");
        }
        return ResultBook.success(book);
    }

    @Override
    public String testRoundRobin() {
        return "Provider port: " + commonConfig.getPort();
    }
}
