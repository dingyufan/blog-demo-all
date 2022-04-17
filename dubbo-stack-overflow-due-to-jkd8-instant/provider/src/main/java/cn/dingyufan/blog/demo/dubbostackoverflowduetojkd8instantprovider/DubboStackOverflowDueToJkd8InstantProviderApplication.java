package cn.dingyufan.blog.demo.dubbostackoverflowduetojkd8instantprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("spring-dubbo.xml")
public class DubboStackOverflowDueToJkd8InstantProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboStackOverflowDueToJkd8InstantProviderApplication.class, args);
    }

}
