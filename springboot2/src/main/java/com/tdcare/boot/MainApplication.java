package com.tdcare.boot;

import com.tdcare.boot.bean.Dog;
import com.tdcare.boot.bean.User;
import com.tdcare.boot.config.MyConfig;
import org.apache.logging.slf4j.MDCContextMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication  //用注解声明这是SpringBoot的主程序类
public class MainApplication {
    public static void main(String[] args) {
        // SpringApplication.run(MainApplication.class,args);  SpringApplication.run方法中带入主程序类和args字符串
        //1.获取返回的到ioc容器对象
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class,args);
        //2.容器对象拿到所有组件名称
        String[] names = run.getBeanDefinitionNames();
       for (String name : names)
       {
           System.out.println(name);
       }
       /**
        * 3.通过容器的getBean()方法获取对应的组件类和实例
        * getBean方法的参数分别是实例的名称(id)和实例的类型
        *
        * **/
        Dog dog01 = run.getBean("dog01",Dog.class);
        Dog dog02 = run.getBean("dog01",Dog.class);
        /**
         * 配置类也是组件,在proxyBeanMethod为true的时候，myConfig就会变成代理对象
         * 代理对象每次调用注册bean方法的时候Sprinboot就会去容器中检查是否注册了该组件，如果注册了就不会创建新的组件
         * com.tdcare.boot.config.MyConfig$$EnhancerBySpringCGLIB$$ecc2558a@6ad5923a
         */
        MyConfig myConfig = run.getBean(MyConfig.class);
        User user01 = myConfig.user01();
        User user02 = myConfig.user01();
        System.out.println(dog02==dog01);   //输出为true,不管获取再多都是单例

        System.out.println(myConfig);   //com.tdcare.boot.config.MyConfig$$EnhancerBySpringCGLIB$$ecc2558a@6ad5923a
        System.out.println(user01==user02); //输出为true,不管获取再多都是单例
        System.out.println("组件"+dog01);

       /* String[] beanNames =  run.getBeanNamesForType(User.class);  //通过类名拿到容器中注册User组件的名字
        MDCContextMap map = run.getBean(MDCContextMap.class);       //获取到容器中MDCContextMap类型的对象
        System.out.println("+++++++++++++++");
        for (String beaName:beanNames){
            System.out.println(beaName);
        }
        System.out.println(map);
        boolean dog01 = run.containsBean("dog01");
        boolean user01 = run.containsBean("user01");
        System.out.println("_______________");
        System.out.println("dog组件为"+dog01);
        System.out.println("user组件为"+user01);*/
    }
}
