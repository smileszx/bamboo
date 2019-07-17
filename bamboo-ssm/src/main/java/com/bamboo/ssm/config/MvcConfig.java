package com.bamboo.ssm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import java.io.IOException;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/17 18:56
 **/
@ContextConfiguration
public class MvcConfig {

    @Bean
    public MultipartResolver multipartResolver () throws IOException {
        return new StandardServletMultipartResolver();
    }

    @Bean
    public MultipartResolver multipartResolver2 () throws IOException {

        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setUploadTempDir(new FileSystemResource("classpath:/uploads"));
        multipartResolver.setMaxUploadSize(2097152);
        multipartResolver.setMaxInMemorySize(0);
        return multipartResolver;
    }
}
