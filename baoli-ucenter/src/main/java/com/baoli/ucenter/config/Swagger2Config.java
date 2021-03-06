package com.baoli.ucenter.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ys
 * @create 2020-01-08-20:59
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket pmsApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("pmsApi")
                .apiInfo(adminApiInfo("商品管理"))
                .select()
                .paths(Predicates.and(PathSelectors.regex("/pms/.*")))
                .build();
    }

    @Bean
    public Docket omsApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("omsApi")
                .apiInfo(adminApiInfo("订单管理"))
                .select()
                .paths(Predicates.and(PathSelectors.regex("/oms/.*")))
                .build();
    }

    private ApiInfo adminApiInfo(String section) {

        return new ApiInfoBuilder()
                .title("宝励app-" + section + "API文档")
                .description("本文档描述了宝励app" + section + "接口定义")
                .version("1.0")
                .contact(new Contact("ys", "http://baoli.com", "1101998350@qq.com"))
                .build();
    }
}
