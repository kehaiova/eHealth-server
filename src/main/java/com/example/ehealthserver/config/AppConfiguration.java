package com.example.ehealthserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class AppConfiguration extends WebMvcConfigurationSupport {

    @Override
    protected PathMatchConfigurer getPathMatchConfigurer() {
        PathMatchConfigurer pathMatchConfigurer = super.getPathMatchConfigurer();
        pathMatchConfigurer.setUseSuffixPatternMatch(false);

        return pathMatchConfigurer;
    }
}
