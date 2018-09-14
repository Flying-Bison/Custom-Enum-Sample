package com.flyingbison.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        String apiTitle = "Sample Complex Enum Test";
        String apiDesc = "Tests saving object with enums as it's fields";
        String apiVersion = "v1";
        String apiCreator = "Flying Bison";
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(regex("/Test.*"))
                .build()
                .apiInfo(new ApiInfo(
                        apiTitle,               // Title displayed at top of page
                        apiDesc,                // Description of api under title
                        apiVersion,             // Version number found at bottom of page
                        (String) null,                   // Not used
                         new Contact(apiCreator, "", ""),             // Area responsible for API
                        (String) null,
                        (String) null,
                        new ArrayList<>())
                );
    }
}