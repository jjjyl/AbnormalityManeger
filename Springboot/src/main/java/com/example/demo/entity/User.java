package com.example.demo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*
 * @author xiaofanyuan
 * @version 1.0
 * {@code @description:} 用户实体类
 * @since 2025-07-08
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "用户信息")
public class User {
    /**
    * pk_id
    */
    @Schema(description = "pk_id")
    private Integer id;

    /**
    * 用户名
    * */
    @Schema(description = "用户名")
    private String username;

    /**
     * 昵称
     */
    @Schema(description = "昵称")
    private String nickname;

    /**
     * 密码
     */
    @Schema(description = "密码")
    private String password;

    /**
     * 电话
     */
    @Schema(description = "手机")
    private String phone;

    /**
     *邮箱
     */
    @Schema(description = "邮箱")
    private String email;

    /**
     * 等级
     */
    @Schema(description = "级别 >> 1：初级讲师 2：中级讲师 3：高级讲师")
    private Integer level;

    @Schema(description = "照片")
    private String photo;

    @Schema(description = "个人简介")
    private String introduction;

    @Schema(description = "角色 >> 0：管理员  2：老师")
    private Integer role;

    @Schema(description = "是否活动，用于标识数据逻辑删除")
    private Integer isActive;

    @Schema(description = "操作人")
    private String operator;

    @Schema(description = "最后更新时间")
    private Date lastUpdate;



}
