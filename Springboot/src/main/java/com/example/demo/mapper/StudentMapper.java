package com.example.demo.mapper;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author XiaoFan
 * @version 1.0
 * {@code @description:}
 * @since 2025-07-10
 */
@Mapper
public interface StudentMapper {
    /**
     * 添加用户
     */
    int addStudent(Student student);

    /**
     * 查询所有用户
     */
    List<Student> getAllStudent();

    /**
     * 按照id查询用户
     */
    Student getStudentById(Integer id);

    /**
     * 删除用户
     */
    int deleteStudentById(Integer id);

    /**
     * 更新用户
     */
    int updateStudent(Student student);

}
