package com.example.demo.config;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 自定义全局错误码
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig_5 {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build().useDefaultResponseMessages(false)
        .globalResponseMessage(RequestMethod.GET,
            new ArrayList<ResponseMessage>() {
              private static final long serialVersionUID = -5185950729102763422L;

              {
                add(new ResponseMessageBuilder()
                    .code(500)
                    .message("500 message")
                    .responseModel(new ModelRef("ApiError"))//必须有一个@ApiResponse，并且其response的类名为此处的type
                    .build());
                add(new ResponseMessageBuilder()
                    .code(403)
                    .message("Forbidden!!!!")
                    .build());
              }
            }
        );
  }
}