package com.project.controller;

import com.project.api.StockService;
import com.project.vo.Result;
import com.project.vo.ResultBook;
import com.project.vo.ResultStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/***
 * BookController, responsible for processing incoming REST API requests,
 * preparing a model, and returning the view to be rendered as a response.
 */
@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    StockService stockService;

    // http://localhost:6600/stock/check?id=1
    @GetMapping("/check")
    public Result checkStock(@RequestParam("id") Long id) {
        return stockService.checkById(id);
    }

    // http://localhost:6600/stock/subtract?id=1&num=5
    @GetMapping ("/subtract")
    public ResultStock subtractStock(@RequestParam("id") Long id, @RequestParam("num") Integer num) {
        return stockService.subtractById(id, num);
    }
}
