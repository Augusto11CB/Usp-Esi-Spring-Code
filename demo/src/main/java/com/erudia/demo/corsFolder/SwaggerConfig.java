package com.erudia.demo.corsFolder;

import com.google.common.base.Predicates;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.builders.ApiInfoBuilder;

@Configurable
@EnableScheduling
@Component("com.erudia.demo")
public class SwaggerConfig {

@Bean
public Docket api() {                
    return new Docket(DocumentationType.SWAGGER_2)          
      .select()
      .apis(RequestHandlerSelectors.basePackage("com.erudia.demo.resource"))
      .paths(PathSelectors.ant("/foos/*"))
      .build()
      .apiInfo(apiInfo());
}


    private ApiInfo apiInfo() {
        String description = "Projeto Enjoei2";
        return new ApiInfoBuilder()
                .title("Enjoei 2")
                .description(description)
                .termsOfServiceUrl("")
                .license("")
                .licenseUrl("")
                .version("1.0")
                .build();
    }

}