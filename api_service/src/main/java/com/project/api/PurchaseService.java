package com.project.api;

import com.project.vo.Result;

/***
 * PurchaseService interface
 */
public interface PurchaseService {
    Result purchase(Long userId, Long bookId, Integer count);
}
