package cn.dingyufan.blog.demo.deepinvalidandvalidated.controller;

import cn.dingyufan.blog.demo.deepinvalidandvalidated.controller.param.Student;
import cn.dingyufan.blog.demo.deepinvalidandvalidated.service.DemoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;
import javax.validation.constraints.Min;
import java.util.Map;

/**
 * @author yfding10
 * @date 2022/7/7 10:47
 */
@RestController
@Validated
public class DemoController2 {

    private final DemoService demoService;

    public DemoController2(DemoService demoService) {
        this.demoService = demoService;
    }


    @PostMapping(value = "/method")
    public Object method(@Min(7) int age) {
        return age;
    }

    @PostMapping(value = "/invoke")
    public Object invoke() {
        return demoService.invoke("abc", new Student());
    }

    @PostMapping(value = "/invoke2")
    public Object invoke2() {
        return demoService.invoke2();
    }

    @ExceptionHandler(ValidationException.class)
    public Object exceptionHandler(ValidationException e) {
        return Map.of("msg", e.getMessage());
    }
}
