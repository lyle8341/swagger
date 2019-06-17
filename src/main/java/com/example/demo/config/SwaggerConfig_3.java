package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 分组
 */
//@Configuration
//@EnableSwagger2
public class SwaggerConfig_3 {

  @Value("${swagger.enable}")
  private boolean enableSwagger;

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .enable(enableSwagger).groupName("web_api");
  }
  @Bean
  public Docket api2() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .enable(enableSwagger).groupName("app_api");//groupName不能用中文
  }
}