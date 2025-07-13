package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XiaoFan
 * @version 1.0
 * {@code @description:}
 * @since 2025-07-10
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;

    /**
     * 查询所有用户
     */
    @Override
    public PageInfo<Student> getAllStudent(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Student> allStud = studentMapper.getAllStudent();
        return PageInfo.of(allStud);
    }

    /**
     * 按照id查询用户
     */
    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.getStudentById(id);
    }

    /**
     * 添加用户r
     */
    @Override
    public boolean addStudent(Student student) {
        return studentMapper.addStudent(student)>0;
    }

    /**
     * 删除用户
     *
     */
    @Override
    public int deleteStudentById(Integer id) {
        return studentMapper.deleteStudentById(id);
    }

    /**
     * 更新用户
     */
    @Override
    public boolean updateStudent(Student  student) {
        return studentMapper.updateStudent(student)>0;
    }

    /**
     * 筛选学生
     */
    @Override
    public PageInfo<Student> getStudentBySelect(Integer pageNum, Integer pageSize, Student student) {
        PageHelper.startPage(pageNum, pageSize);
        List<Student> allStud = studentMapper.getAllStudent();
        List<Student> selectedStud;
        selectedStud = new ArrayList<>();
        for (Student s : allStud) {
            if ((student.getId()==0 || s.getId().toString().contains(student.getId().toString()))
                    &&s.getUsername().contains(student.getUsername())
                    &&s.getNickname().contains(student.getNickname())
                    &&s.getStuNumber().contains(student.getStuNumber())
                    &&(student.getSex()==2||s.getSex().toString().contains(student.getSex().toString()))
                    &&s.getPhone().toString().contains(student.getPhone().toString())
                    &&s.getEmail().contains(student.getEmail())
                    &&s.getQqNumber().contains(student.getQqNumber())
                    &&s.getIdentityCard().contains(student.getIdentityCard())
                    &&s.getSignature().contains(student.getSignature())
                    &&s.getIntroduction().contains(student.getIntroduction())
            ) {
                selectedStud.add(s);
            }
        }
        return PageInfo.of(selectedStud);
    }
}
