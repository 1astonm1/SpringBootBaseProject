package com.astonm.springbootBaseProject.config.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Astonm
 * @Date 2021/7/3
 * @Description: Swagger配置类
 **/

//标明是配置类
@Configuration
//开启swagger功能
@EnableSwagger2
public class Swagger2Conf {

    @Value("${swagger.is.enable}")
    private boolean SWAGGER_IS_ENABLE;

    @Bean
    public Docket getUserDocket() {

        // 添加全局请求头
        List<Parameter> params = new ArrayList<>();
        // ajax请求头
        ParameterBuilder ajax = new ParameterBuilder();
        ajax.name("x-requested-with").description("ajax请求头").modelRef(new ModelRef("string"))
                .parameterType("header").required(true).defaultValue("XMLHttpRequest").build();
        params.add(ajax.build());

        // Authorization请求头
        ParameterBuilder token = new ParameterBuilder();
        token.name("Authorization").description("请求需要的token，不指定时尝试从cookie中获取（提前进行登录）。")
                .modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        params.add(token.build());

        // callback-url请求头
        ParameterBuilder callback = new ParameterBuilder();
        callback.name("callback-url").description("登录后的回调地址（登录时需要添加，否则无法提供登录地址）")
                .modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        params.add(callback.build());

        ApiInfo apiInfo = new ApiInfoBuilder()
                // api标题
                .title("SpringBootBaseProject后台接口文档")
                // api描述
                .description("调用服务接口需要提前进行登录，调用[用户管理模块]下的[用户登录]接口，然后手动跳转到结果附带的登录地址")
                .termsOfServiceUrl("http://localhost:8080/")
                // 版本号
                .version("1.0.0")
                .build();
        //文档类型（swagger2）
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(SWAGGER_IS_ENABLE)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.astonm.springbootBaseProject"))
//                .paths(PathSelectors.any())
                .paths(PathSelectors.regex("/.*"))
                .build()
                .globalOperationParameters(params);
    }
}
