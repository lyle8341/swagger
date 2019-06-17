package com.example.demo.model;

import io.swagger.annotations.ApiModel;

/**
 * @author Lyle
 * @version v1.0
 * @date 2019-06-16 下午4:33
 * @since 1.8
 */

/*
    1.对象作为出参的时候就会出现在swagger models下
    2.@ApiResponse中response指定的对象会出现在swagger models下
 */
//ApiModel的value默认是类名
//ApiModel只在response区域和Models区域有说明作用
@ApiModel(value = "类名WebResult", description = "用于判断用户是否存在")
public class WebResult {

  private String error_code;

  private String error_message;

  public String getError_code() {
    return error_code;
  }

  public void setError_code(String error_code) {
    this.error_code = error_code;
  }

  public String getError_message() {
    return error_message;
  }

  public void setError_message(String error_message) {
    this.error_message = error_message;
  }
}