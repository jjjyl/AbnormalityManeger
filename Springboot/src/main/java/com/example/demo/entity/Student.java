package com.example.demo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author XiaoFan
 * @version 1.0
 * {@code @description:}
 * @since 2025-07-10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "学生信息")
public class Student {
    @Schema(description = "pk_id")
    private Integer id;

    @Schema(description = "用户名")
    private String  username;

    @Schema(description = "昵称")
    private String  nickname;

    @Schema(description = "密码")
    private String  password;

    @Schema(description = "学号")
    private  String  stuNumber;

    @Schema(description = "性别")
    private  Integer  sex;

    @Schema(description = "电话")
    private String  phone;

    @Schema(description = "邮箱")
    private  String  email;

    @Schema(description = "QQ号")
    private String qqNumber;

    @Schema(description = "身份证")
    private String identityCard;

    @Schema(description = "照片")
    private String photo;

    @Schema(description = "个人签名")
    private String signature;

    @Schema(description = "个人简介")
    private String introduction;

    @Schema(description = "是否活动，用于标识数据逻辑删除")
    private Integer isActive;

    @Schema(description = "最后更新时间")
    private Date lastUpdate;
}
