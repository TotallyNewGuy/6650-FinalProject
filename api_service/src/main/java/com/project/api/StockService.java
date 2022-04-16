package com.project.api;

import com.project.vo.Result;
import com.project.vo.ResultBook;
import com.project.vo.ResultStock;

public interface StockService {
    ResultStock subtractById(Long id, Integer num);
    Result checkById(Long id);
}
