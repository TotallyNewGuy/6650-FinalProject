package com.project.dao.mapper;

import com.project.dao.pojo.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderItem> getAllOrder();
    List<OrderItem> getOrderByName(String username);
    void addOrder(@Param("name") String name,
                  @Param("address") String address,
                  @Param("purchase") String purchase,
                  @Param("count") Integer count,
                  @Param("time") String time);
    void deleteOrderById(Long orderId);
}
