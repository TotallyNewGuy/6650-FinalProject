package com.project.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StockMapper {
    void subtractStock(@Param("id") Long id, @Param("num") Integer num);
    Integer checkStock(Long id);
    void setSubtractTime(@Param("id") Long id, @Param("time") String time);
}
