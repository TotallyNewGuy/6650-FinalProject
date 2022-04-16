package com.project.controller;

import com.project.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/error")
public class ErrorHandlerController {

    @GetMapping
    public Result purchaseFail() {
        return Result.fail(403, "Book service is failed");
    }
}