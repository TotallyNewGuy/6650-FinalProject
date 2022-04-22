package com.project.controller;

import com.project.api.BookService;
import com.project.api.UserService;
import com.project.config.RefreshConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {

    @Autowired
    RefreshConfig commonConfig;

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @GetMapping
    public String index(){
        return "version = " + commonConfig.getVersion();
    }

    @GetMapping("userLoadBalance")
    public String testUserLoadBalance(){
        return userService.testRoundRobin();
    }

    @GetMapping("bookLoadBalance")
    public String testBookLoadBalance(){
        return bookService.testRoundRobin();
    }
}
