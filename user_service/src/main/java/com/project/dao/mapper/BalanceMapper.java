package com.project.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BalanceMapper {
    double checkBalance(@Param("id") Long id);
    void subtractBalance(@Param("id") Long id, @Param("num") Double num);
}
