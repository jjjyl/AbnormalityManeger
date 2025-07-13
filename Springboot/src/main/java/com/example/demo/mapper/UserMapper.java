package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author XiaoFan
 * @version 1.0
 * {@code @description:}
 * @since 2025-07-08
 */

@Mapper
public interface UserMapper {
    /**
     * 查询所有用户
     */
    List<User> getAllUsers();

    /**
     * 按照id查询用户
     */
    User getUserById(Integer id);

    /**
     * 添加用户
     */
    Integer addUser(User user);

    /**
     * 删除用户
     */
    int deleteUserById(Integer id);

    /**
     * 更新用户
     */
    int updateUser(User user);

}
