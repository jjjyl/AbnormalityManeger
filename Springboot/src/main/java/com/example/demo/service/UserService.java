package com.example.demo.service;

import com.example.demo.entity.User;
import com.github.pagehelper.PageInfo;

/**
 * @author XiaoFan
 * @version 1.0
 * {@code @description:}
 * @since 2025-07-08
 */
public interface UserService {
    /**
     * 查询所有用户
     */
    PageInfo<User> getAllUsers(Integer pageNum, Integer pageSize);

    /**
     * 按照id查询用户
     */
    User getUserById(Integer id);

    /**
     * 添加用户
     */
    boolean addUser(User user);

    /**
     * 删除用户
     */
    int deleteUserById(Integer id);

    /**
     * 更新用户
     */
    boolean updateUser(User user);
}
