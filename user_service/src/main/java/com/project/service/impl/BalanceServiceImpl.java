package com.project.service.impl;

import com.project.api.BalanceService;
import com.project.dao.mapper.BalanceMapper;
import com.project.vo.Result;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private BalanceMapper balanceMapper;

    @Override
    public Result subtractById(Long id, Double num) {
        double allBalance = balanceMapper.checkBalance(id);
        if (allBalance < num) {
            throw new IllegalArgumentException("balance is less than price");
        }
        balanceMapper.subtractBalance(id, num);
        double newBalance = balanceMapper.checkBalance(id);
        return Result.success(newBalance);
    }

    @Override
    public Result checkById(Long id) {
        double balance = balanceMapper.checkBalance(id);
        return Result.success(balance);
    }
}
