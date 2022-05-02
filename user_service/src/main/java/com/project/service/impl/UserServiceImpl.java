package com.project.service.impl;

import com.project.api.UserService;
import com.project.dao.mapper.UserMapper;
import com.project.dao.pojo.User;
import com.project.vo.Result;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/***
 * This is the implementation of user service, get user with userID.
 */
@DubboService
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public Result getUserById(Long id) {
        User user = userMapper.findUserById(id);
        if (user == null) {
            throw new IllegalArgumentException("user id is invalid");
        }
        return Result.success(user);
    }
}
