package com.project.service.impl;

import com.project.api.StockService;
import com.project.dao.mapper.StockMapper;
import com.project.util.NTPTime;
import com.project.vo.Result;
import com.project.vo.ResultStock;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
public class StockServiceImpl implements StockService {

    @Autowired
    private StockMapper stockMapper;

    @Override
    public ResultStock subtractById(Long id, Integer num) {
        Integer allStock = stockMapper.checkStock(id);
        if (allStock < num) {
            throw new IllegalArgumentException("Stock is less than the number of items");
        }

        String subtractTime = NTPTime.getNTPTime();
        stockMapper.subtractStock(id, num);
        stockMapper.setSubtractTime(id, subtractTime);
        Integer newStock = stockMapper.checkStock(id);
        return ResultStock.success(newStock);
    }

    @Override
    public Result checkById(Long id) {
        Integer stock = stockMapper.checkStock(id);
        return Result.success(stock);
    }
}
