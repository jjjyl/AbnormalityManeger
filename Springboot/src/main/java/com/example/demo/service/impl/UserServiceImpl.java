package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XiaoFan
 * @version 1.0
 * {@code @description:}
 * @since 2025-07-08
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    /**
     * 查询所有用户
     */
    @Override
    public PageInfo<User> getAllUsers(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.getAllUsers();
        return PageInfo.of(list);
    }

    /**
     * 按照id查询用户
     */
    @Override
    public User getUserById(Integer id){
        return userMapper.getUserById(id);
    }

    /**
     * 添加用户
     */
    @Override
    public boolean addUser(User user){
        Integer re = userMapper.addUser(user);
        return re>0;
    }

    /**
     * 删除用户
     */
    @Override
    public int deleteUserById(Integer id){
        return userMapper.deleteUserById(id);
    }

    /**
     * 更新用户
     *
     */
    @Override
    public boolean updateUser(User user) {
        int re = userMapper.updateUser(user);
        return re>0;
    }
}
