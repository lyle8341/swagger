package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 当不使用@ApiResponses的时候，useDefaultResponseMessages(false)，不生成40x,201等错误码
 * 禁用默认response message
 */
//@Configuration
//@EnableSwagger2
public class SwaggerConfig_6 {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build().useDefaultResponseMessages(false);
  }


}