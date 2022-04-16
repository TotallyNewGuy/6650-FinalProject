package com.project.controller;

import com.project.vo.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/error", method = RequestMethod.GET)
public class ErrorHandlerController {

    @GetMapping
    public Result purchaseFail() {
        return Result.fail(403, "User service is failed");
    }
}