package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 全局公共参数
 */
//@Configuration
//@EnableSwagger2
public class SwaggerConfig_2 {

  @Value("${swagger.enable}")
  private boolean enableSwagger;

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .globalOperationParameters(operationParameters())
        .enable(enableSwagger);
  }

  private List<Parameter> operationParameters() {
    //添加head参数start
    ParameterBuilder tokenPar = new ParameterBuilder();
    List<Parameter> pars = new ArrayList<>();
    tokenPar.name("x-access-token")
        .description("令牌")
        .modelRef(new ModelRef("string"))
        .parameterType("header")
        .required(false)
        .build();
    pars.add(tokenPar.build());
    //添加head参数end
    return pars;
  }
}