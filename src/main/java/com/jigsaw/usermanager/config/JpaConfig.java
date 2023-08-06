package com.jigsaw.usermanager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableTransactionManagement
public class JpaConfig implements WebMvcConfigurer {

}