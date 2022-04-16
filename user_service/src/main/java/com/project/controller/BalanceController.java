package com.project.controller;

import com.project.api.BalanceService;
import com.project.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user/balance", method = RequestMethod.GET)
public class BalanceController {

    List<Integer> list = new ArrayList<>();

    @Autowired
    BalanceService balanceService;

    // http://localhost:6500/balance/check?id=1
    @GetMapping ("/check")
    public Result checkBalanceById(@RequestParam("id") Long id) {
        return balanceService.checkById(id);
    }

    // http://localhost:6500/balance/subtract?id=1&num=5
    @GetMapping ("/subtract")
    public Result subtractBalanceById(@RequestParam("id") Long id, @RequestParam("num") double num) {
        return balanceService.subtractById(id, num);
    }
}