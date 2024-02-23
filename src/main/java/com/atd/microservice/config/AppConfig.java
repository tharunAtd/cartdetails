package com.atd.microservice.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
@Getter
@Configuration
public class AppConfig {

    @Value("${spring.application.name:#{null}}")
    public String applicationName;

    //MBL DOMAIN URL
    @Value("${mbl.domain.url:#{null}}")
    public String mblDomainUrl;

    //MBL CREATE QUOTE URL
    @Value("${mbl.create.cartpreview.url:#{null}}")
    public String createCartPreviewUrl;

}
