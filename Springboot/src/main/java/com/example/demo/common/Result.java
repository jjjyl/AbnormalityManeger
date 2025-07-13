package com.example.demo.common;

import lombok.Data;

/**
 * @author XiaoFan
 * @version 1.0
 * {@code @description:} 统一返回结果类
 * @since 2025-07-09
 */

@Data
public class Result<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态信息
     */
    private String message;

    /**
     * 数据
     */
    private Object data;

    private T result;

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, String message,T data,T result) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.result = result;
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success(T data){
        return new Result<>(200,"操作成功",data);
    }

    public static <T> Result<T> success(Integer code,T data){
        return new Result<>(code,"操作成功",data);
    }

    public static <T> Result<T> success(Integer code,T data,T result){
        return new Result<>(code,"操作成功",data,result);
    }

    public static <T> Result<T> fail(Integer code, String message){
        return new Result<>(code,message,null);
    }
}
