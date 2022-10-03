package com.tdcare.boot.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //RestController是responseBody和Controller的结合体
public class HelloController {
    @RequestMapping("/hello")
    public String helloController(){
        return "Hello SpringBoot";//因为返回的是字符串.所以需要用@responsebody

    }
}
