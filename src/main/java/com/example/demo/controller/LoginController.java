package com.example.demo.controller;

import com.example.demo.model.ApiError;
import com.example.demo.model.WebResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Api用在类上
@Api(tags = "苍天已死")
@Controller
@RequestMapping(value = "/dc")
public class LoginController {

  //@ApiResponses 会覆盖 useDefaultResponseMessages(false)
  //也会覆盖掉全局配置中的response message
  @ApiResponses({
      @ApiResponse(code = 0, message = "执行成功"),
      @ApiResponse(code = 500, message = "执行失败", response = ApiError.class),//此处的message尽可能和配置文件中有相同错误码的message一致
      @ApiResponse(code = 405, message = "Invalid input", response = Integer.class),
      @ApiResponse(code = 400, message = "请求参数没填好"),
      @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
  })
  @ApiOperation(value = "首页", notes = "用户默认首页，无需登录")
  @GetMapping("/index")
  public String index() {
    return "index";
  }

  @ResponseBody
  @PostMapping("/add")
  public WebResult check(){
    return new WebResult();
  }

}