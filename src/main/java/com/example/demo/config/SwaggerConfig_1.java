package com.example.demo.config;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * api info 配置
 */
//@Configuration
//@EnableSwagger2
public class SwaggerConfig_1 {

  //是否显示文档
  @Value("${swagger.enable}")
  private boolean enableSwagger;

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .enable(enableSwagger).apiInfo(apiInfo()).protocols(Collections.singleton("http"));
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("某某项目接口文档")
        .description("用户管理接口,单点登录模块，购票接口") //描述
        .contact(new Contact("lyle", "https://www.limuyi.com.cn", "lyllyl0000@126.com"))
        .version("2.1.5.RELEASE") //版本号
        .termsOfServiceUrl("Terms of service")  //（不可见）条款地址
        .license("License of API")
        .licenseUrl("API license URL")
        .extensions(Collections.emptyList())
        .build();
  }

}