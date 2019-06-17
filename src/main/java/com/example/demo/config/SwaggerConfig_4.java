package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Api tags 测试
 */
//@Configuration
//@EnableSwagger2
public class SwaggerConfig_4 {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .tags(new Tag("苍天已死","汉王朝完蛋了",2),getTags());

  }

  private Tag[] getTags() {
    return new Tag[]{
        new Tag("黄天当立", "黄巾军当立",1)
    };
  }
}