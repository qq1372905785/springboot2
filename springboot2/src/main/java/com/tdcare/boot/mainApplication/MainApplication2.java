package com.tdcare.boot.mainApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*@SpringBootConfiguration        //让Springboot知道这个一个Springboot的配置类
@EnableAutoConfiguration*/        //开启自动配置
//@ComponentScan("com.tdcare.boot.mainApplication")   //自定义包扫描路径
@SpringBootApplication(scanBasePackages = "com.tdcare.boot.mainApplication") //这个也是自定义包扫描路径
public class MainApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication2.class);
    }
}
