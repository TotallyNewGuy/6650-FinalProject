package com.project.controller;

import com.project.api.BalanceService;
import com.project.api.UserService;
import com.project.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user", method = RequestMethod.GET)
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public Result getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
}
