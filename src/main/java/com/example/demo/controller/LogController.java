package com.example.demo.controller;

import com.example.demo.model.WebResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Lyle
 * @date 2019-06-16 下午9:21
 * @version v1.0
 * @since 1.8  
 */
@Api(tags = "苍天已死")
@RestController
public class LogController {

  @GetMapping("/index_2")
  public String index2() {
    return "index2";
  }

  @GetMapping("/lyle")
  public WebResult<?> testResponseModel(){
    WebResult<String> result = new WebResult<>();
    result.setError_code("000");
    result.setError_message("test");
    result.setData("lyle");
    return result;
  }
}