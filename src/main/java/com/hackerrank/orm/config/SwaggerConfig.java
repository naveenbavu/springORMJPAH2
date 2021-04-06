package com.hackerrank.orm.config;/*
package com.hackerrank.orm.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

  */
/**
   * To create Docket for all the controllers in specified package.n
   *
   * @return Docket created docket for the specified controller package
   *//*

  @Bean
  public Docket apiDocV1() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("v1")
        .select()
        .apis(
            RequestHandlerSelectors.basePackage("com.hackerrank.orm.controller"))
        .paths(regex("/api/v1.*"))
        .build()
        .apiInfo(metadata("1.1"));
  }

  */
/**
   * To create Docket for all the controllers in specified package.n
   *
   * @return Docket created docket for the specified controller package
   *//*

  @Bean
  public Docket apiDocV2() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("v2")
        .select()
        .apis(
            RequestHandlerSelectors.basePackage("com.hackerrank.orm.controller"))
        .paths(regex("/api/v2.*"))
        .build()
        .apiInfo(metadata("1.2"));
  }

  private ApiInfo metadata(String version) {
    return new ApiInfoBuilder()
        .title("Inventory Management services")
        .description("REST API - Order Management services")
        .version(version)
        .license("@Albertsons Companies")
        .licenseUrl("http://www.safeway.com")
        .build();
  }
}*/
