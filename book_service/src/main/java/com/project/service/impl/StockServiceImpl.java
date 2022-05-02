package com.project.service.impl;

import com.project.api.StockService;
import com.project.dao.mapper.StockMapper;
import com.project.util.NTPTime;
import com.project.vo.Result;
import com.project.vo.ResultStock;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The implementation of stock service, deal with operations with book stock.
 */
@DubboService
public class StockServiceImpl implements StockService {

    @Autowired
    private StockMapper stockMapper;

    /**
     * subtract the number from a book's stock if stock is sufficient.
     * @param id book id
     * @param num number of book to be subtracted
     * @return result
     */
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

    /**
     * Check the book stock by book id
     * @param id book ID
     * @return result
     */
    @Override
    public Result checkById(Long id) {
        Integer stock = stockMapper.checkStock(id);
        return Result.success(stock);
    }
}
