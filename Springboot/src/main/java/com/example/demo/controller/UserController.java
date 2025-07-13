package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
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
 * @since 2025-07-08
 */
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "用户管理")
public class UserController {

    private final UserService userService;

    @Operation(summary = "查询所有用户")
    @GetMapping("/list")
    public Result<PageInfo<User>> getAllUsers(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<User> allUsers = userService.getAllUsers(pageNum, pageSize);
        return Result.success(allUsers);
    }

    @Operation(summary = "根据id查询用户")
    @Parameter(name = "id",description = "id",required = true,example = "1")
    @GetMapping("/{id}")
    public Result<User> getUserById(@PathVariable Integer id){
        User userById = userService.getUserById(id);
        if (userById!=null) {
            return Result.success(200,userById);
        }else{
            return Result.fail(500,String.format("未找到id为%d的学生",id));
        }
    }

    @Operation(summary = "添加用户")
    @PostMapping("/new")
    public Result<String> addUser(@RequestBody User user){
        if (userService.addUser(user)) {
            return Result.success(200,"用户添加成功");
        }
        else {
            return Result.fail(500,"添加失败");
        }
    }

    @Operation(summary = "更新信息")
    @PutMapping("/put")
    public Result<String> updateUser(@RequestBody User user){
        if(userService.updateUser(user)) {
            return Result.success(200,"数据更新成功");
        }
        else{
            return Result.fail(500,"更新失败");
        }
    }

    @Operation(summary = "根据id删除用户")
    @Parameter(name = "id",description = "id",required = true,example = "1")
    @DeleteMapping("/{id}")
    public Result<String> deleteUserById(@PathVariable Integer id){
        int del = userService.deleteUserById(id);
        if (del>0) {
            return Result.success(200,String.format("成功删除%d条数据",del));
        }
        else{
            return Result.fail(500,"删除失败");
        }
    }


}
