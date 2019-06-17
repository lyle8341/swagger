package com.example.demo.model;

/**
 * 
 * @author Lyle
 * @date 2019-06-13 下午2:54
 * @version v1.0
 * @since 1.8  
 */
/**
 * @ApiModel注解的时候有个坑 就是必须在controller 使用 @RequestBody 注解 否则无法显示models
 * @ApiModel这个可以不写
 */

//@ApiModel(value = "用户注册的实体",description = "说明")
public class UserModel {
//  @ApiModelProperty(name = "userName",notes = "用户名",dataType = "String",required = true)
  private String userName;

//  @ApiModelProperty(name = "nickName",notes = "用户昵称",dataType = "String",required = true)
  private String nickName;

//  @ApiModelProperty(name = "age",notes = "用户年龄",dataType = "int",required = true)
  private int age;
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
  @Override
  public String toString() {
    return "Register{" +
        "userName='" + userName + '\'' +
        ", nickName='" + nickName + '\'' +
        ", age=" + age +
        '}';
  }
}