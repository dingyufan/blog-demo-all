package cn.dingyufan.blog.demo.dubbostackoverflowduetojkd8instantprovider;

import cn.dingyufan.blog.demo.dubbostackoverflowduetojkd8instantprovider.api.DemoService;
import cn.dingyufan.blog.demo.dubbostackoverflowduetojkd8instantprovider.api.dto.DemoDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("spring-dubbo.xml")
public class DubboStackOverflowDueToJkd8InstantConsumerApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DubboStackOverflowDueToJkd8InstantConsumerApplication.class, args);

        DemoService demoService = applicationContext.getBean(DemoService.class);
        DemoDTO dto = demoService.invoke("DubboStackOverflowDueToJkd8InstantConsumerApplication");

        System.out.println(dto);
    }

}
