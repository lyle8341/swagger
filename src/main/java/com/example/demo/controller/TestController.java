package com.example.demo.controller;

import com.example.demo.model.WebResult;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 测试
 * @author Lyle
 * @date 2019-10-14 下午6:12
 * @version v1.0
 * @since 1.8  
 */
@Controller
public class TestController {

  @GetMapping("/hczz")
  public void doGet(HttpServletRequest request, HttpServletResponse response)throws Exception{
    response.sendRedirect("https://www.baidu.com");
  }

  @GetMapping("/void")
  public WebResult<Void> genericVoid(){
    return new WebResult<>();
  }
}