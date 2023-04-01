package com.aiguigu.boot.config;

//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//@Configuration
//@EnableOpenApi
//public class SwaggerConfig {
//    /**
//     * 用于读取配置文件 application.properties 中 swagger 属性是否开启
//     */
//    @Value("${swagger.enabled}")
//    Boolean swaggerEnabled;
//
//    @Bean
//    public Docket docket() {
//        return new Docket(DocumentationType.OAS_30)
//                .apiInfo(apiInfo())
//                // 是否开启swagger
//                .enable(true)
//                .select()
//                // 过滤条件，扫描指定路径下的文件
//                .apis(RequestHandlerSelectors.basePackage("com.bjtu"))
//                // 指定路径处理，PathSelectors.any()代表不过滤任何路径
//                //.paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        /*作者信息*/
//        Contact contact = new Contact("test", "test", "test");
//        return new ApiInfo(
//                "Spring Boot 集成 Swagger3 测试",
//                "Spring Boot 集成 Swagger3 测试接口文档",
//                "v1.0",
//                "test",
//                contact,
//                "Apache 2.0",
//                "http://www.apache.org/licenses/LICENSE-2.0",
//                new ArrayList()
//        );
//    }
//}

//import io.swagger.v3.oas.models.ExternalDocumentation;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.info.License;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//public class SwaggerConfig {
//
//    @Bean
//    public OpenAPI springShopOpenAPI() {
//        return new OpenAPI()
//                .info(new Info().title("****系统API")
//                        .description("****系统 Restfull API")
//                        .version("v0.0.1")
//                        .termsOfService("https://www.jianshu.com/u/c8c1e5ac61e0")
//                        .license(new License().name("****").url("https://www.jiahetng.com")))
//                .externalDocs(new ExternalDocumentation()
//                        .description("**** Issues Documentation")
//                        .url("https://****"));
//    }
//}