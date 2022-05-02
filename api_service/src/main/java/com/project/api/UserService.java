package com.project.api;

import com.project.vo.Result;

/***
 * UserService interface
 */
public interface UserService {
    Result getUserById(Long id);
}
