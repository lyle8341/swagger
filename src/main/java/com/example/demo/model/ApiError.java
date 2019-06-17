package com.example.demo.model;

/**
 * 
 * @author Lyle
 * @date 2019-06-16 下午7:01
 * @version v1.0
 * @since 1.8  
 */
public class ApiError {
  private String code;
  private String message;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}