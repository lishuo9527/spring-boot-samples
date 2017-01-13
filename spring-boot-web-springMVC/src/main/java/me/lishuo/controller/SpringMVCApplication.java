package me.lishuo.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by lis on 17/1/6.
 */
@SpringBootApplication
public class SpringMVCApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringMVCApplication.class, args);
    }
}
