package com.example.demo.service;

import com.example.demo.entity.Student;
import com.github.pagehelper.PageInfo;

/**
 * @author XiaoFan
 * @version 1.0
 * {@code @description:}
 * @since 2025-07-10
 */
public interface StudentService {
    /**
     * 查询所有用户
     */
    PageInfo<Student> getAllStudent(Integer pageNum, Integer pageSize);

    /**
     * 按照id查询用户
     */
    Student getStudentById(Integer id);

    /**
     * 添加用户
     */
    boolean addStudent(Student student);

    /**
     * 删除用户
     */
    int deleteStudentById(Integer id);

    /**
     * 更新用户
     */
    boolean updateStudent(Student student);

    /**
     * 筛选用户
     */
    PageInfo<Student> getStudentBySelect(Integer pageNum, Integer pageSize, Student student);
}
