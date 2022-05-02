package com.project.api;

import com.project.vo.Result;

/***
 * BalanceService interface
 */

public interface BalanceService {
    Result subtractById(Long id, Double num);
    Result checkById(Long id);
}
