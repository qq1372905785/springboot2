package com.tdcare.boot.config;

import com.tdcare.boot.bean.Dog;
import com.tdcare.boot.bean.User;
import org.apache.logging.slf4j.MDCContextMap;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 通过@bean标注到方法上面来给容器注册组件，默认是单实例
 * 单实例就是无论你从容器中获取多少次组件，都只会有一个组件实例
 * 组件是抽象的概念而已，通俗的说是一些符合某种规范的类组合在一起就构成了组件。他可以提供某些特定的功能。
 * 那么配置类本身也是组件
 * proxyBeanMethods 是否代理bean的方法 默认为true,
 * 所以在不写proxyBeanMethods的情况下默认用的是代理对象调用的方法，保持组件单例
 * Full(proxyBeanMethods = true) 不管多少次调用@Bean的时候，返回的都是单例对象，也就是第一次创建的对象
 * lite(proxyBeanMethods = false) 不管多少次调用@Bean的时候，都会返回新的对象
 * 类组件之间是否有组件依赖，如果有就是true，如果没有就用false
 * **/
@Import({User.class,MDCContextMap.class})      //向容器中随便导入两个类,这里是导入了User类和MDCContextMap类
@Configuration(proxyBeanMethods = true) //告诉Springboot这是一个配置类==配置文件
public class MyConfig {

    /**
     * 在外部无论对配置类的注册组件方法调用多少次，获取的都是之前注册在容器中的单例对象
     * @return
     * */
    @Bean  //如果想要更改组件的名字，可以写成@Bean("你想要的组件id")
    public Dog dog01(){
        return  new Dog("xiaoMi");
    }
    @ConditionalOnBean(name = "dog01")        //条件装配
    @Bean //给容器中注册组件，方法名默认是组件的id,返回类型就是组件的类型，返回值就是组件在容器中的实例
    public User user01(){
        User zhangsan = new User("zhangsan",20);
        zhangsan.setDog(dog01());
        return  zhangsan;
    }

}
