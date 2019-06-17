package com.example.demo.config;

import java.util.Arrays;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.service.TokenRequestEndpoint;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;

/**
 * 安全管理接口
 * oauth2如何限定只能访问授权过的资源?scope
 * 是开放授权的一个标准，旨在让用户允许第三方应用去访问改用户在某服务器中的特定私有资源，而可以不提供其在某服务器的账号密码给到第三方应用
 * https://www.jianshu.com/p/9d0264d27c3b 解释什么是oauth2
 */
//@Configuration
//@EnableSwagger2
public class SwaggerConfig_7 {

  private static final String CLIENT_ID = "";
  private static final String CLIENT_SECRET = "";
  private static final String AUTH_SERVER = "";

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .securitySchemes(Collections.singletonList(securityScheme()))
        .securityContexts(Collections.singletonList(securityContext()));
  }

  @Bean
  public SecurityConfiguration security() {
    return SecurityConfigurationBuilder.builder()
        .clientId(CLIENT_ID)
        .clientSecret(CLIENT_SECRET)
        .scopeSeparator(" ")
        .useBasicAuthenticationWithAccessCodeGrant(true)
        .build();
  }

  private SecurityScheme securityScheme() {
    GrantType grantType = new AuthorizationCodeGrantBuilder()
        .tokenEndpoint(new TokenEndpoint(AUTH_SERVER + "/token", "oauthtoken"))
        .tokenRequestEndpoint(
            new TokenRequestEndpoint(AUTH_SERVER + "/authorize", CLIENT_ID, CLIENT_ID))
        .build();
    return new OAuthBuilder().name("spring_oauth")
        .grantTypes(Collections.singletonList(grantType))
        .scopes(Arrays.asList(scopes()))
        .build();
  }

  //Note how the name we used here, in the reference – spring_oauth – syncs up with the name we used previously, in the SecurityScheme.
  private SecurityContext securityContext() {
    return SecurityContext.builder()
        .securityReferences(
            Collections.singletonList(new SecurityReference("spring_oauth", scopes())))
        .forPaths(PathSelectors.regex("/foos.*"))
        .build();
  }

  private AuthorizationScope[] scopes() {
    return new AuthorizationScope[]{
        new AuthorizationScope("read", "for read operations"),
        new AuthorizationScope("write", "for write operations"),
        new AuthorizationScope("foo", "Access foo API")};
  }
}