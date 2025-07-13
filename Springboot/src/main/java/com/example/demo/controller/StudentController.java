package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author XiaoFan
 * @version 1.0
 * {@code @description:}
 * @since 2025-07-10
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/stud")
@Tag(name = "学生管理")
public class StudentController {

    private final StudentService studentService;

    @Operation(summary = "添加学生")
    @PostMapping("/new")
    public Result<String> newStudent(@RequestBody Student student) {
        if(studentService.addStudent(student)) {
            return Result.success(200,"添加学生成功");
        }
        else {
            return Result.fail(500,"添加学生失败");
        }
    }

    @Operation(summary = "查询所有学生")
    @GetMapping("/list")
    public Result<PageInfo<Student>> allStudent(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Student> allStudents = studentService.getAllStudent(pageNum, pageSize);
        return Result.success(200,allStudents);
    }

    @Operation(summary = "根据id查询学生")
    @Parameter(name = "id",description = "id",required = true,example = "1")
    @GetMapping("/{id}")
    public Result<Student> getStudentById(@PathVariable int id){
        Student studentById = studentService.getStudentById(id);
        if(studentById != null) {
            return Result.success(200,studentById);
        }else{
            return Result.fail(500,"未找到该学生");
        }
    }

    @Operation(summary = "根据id删除学生")
    @Parameter(name = "id",description = "学生id",required = true,example = "1")
    @DeleteMapping("/{id}")
    public Result<String> deleteStudentById(@PathVariable Integer id){
        int delete = studentService.deleteStudentById(id);
        if(delete > 0) {
            return Result.success(200,String.format("成功删除了id为%d的学生",id));
        }
        else {
            return Result.fail(500,"删除失败");
        }
    }

    @Operation(summary = "更改学生信息")
    @PutMapping("/put")
    public Result<String> updateStudent(@RequestBody Student student){
        boolean b = studentService.updateStudent(student);
        if(b) {
            return Result.success(200,"数据更新成功");
        }else {
            return Result.fail(500,"数据更新失败");
        }
    }

    @Operation(summary = "筛选学生")
    @PutMapping("/find")
    public Result<PageInfo<Student>> selectStudent(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "10") Integer pageSize,@RequestBody Student student){
        /*Integer pageNum = 1;
        Integer pageSize = 10;*/
        PageInfo<Student> studentBySelect = studentService.getStudentBySelect(pageNum, pageSize, student);
        if(studentBySelect != null) {
            return Result.success(200,studentBySelect);
        }else {
            return Result.fail(500,"未查询到相关信息");
        }
    }
}
