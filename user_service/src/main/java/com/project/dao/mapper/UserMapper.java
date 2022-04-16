package com.project.dao.mapper;

import com.project.dao.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findUserById(Long id);
}
