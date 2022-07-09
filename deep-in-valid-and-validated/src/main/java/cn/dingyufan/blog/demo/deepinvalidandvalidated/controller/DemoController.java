package cn.dingyufan.blog.demo.deepinvalidandvalidated.controller;

import cn.dingyufan.blog.demo.deepinvalidandvalidated.annotation.ValidYoYoYo;
import cn.dingyufan.blog.demo.deepinvalidandvalidated.controller.param.Group;
import cn.dingyufan.blog.demo.deepinvalidandvalidated.controller.param.Student;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author yfding10
 * @date 2022/7/5 11:08
 */
@RestController
public class DemoController {


    @PostMapping("/methodA")
    public Object methodA(@RequestBody @Validated Student student) {
        return student;
    }

    @PostMapping("/methodB")
    public Object methodB(@RequestBody @Valid Student student) {
        return student;
    }

    @PostMapping("/methodC")
    public Object methodC(@RequestBody @Validated Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder builder = new StringBuilder();
            for (FieldError fe : bindingResult.getFieldErrors()) {
                builder.append(fe.getField()).append(fe.getDefaultMessage()).append("; ");
            }
            return Map.of("message", builder.toString());
        }
        return student;
    }


    @PostMapping("/methodD")
    public Object methodD(@RequestBody @Validated(Group.Update.class) Student student) {
        return student;
    }


    @PostMapping("/methodE")
    public Object methodE(@RequestBody @ValidYoYoYo Student student) {
        return student;
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object exceptionHandler(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder builder = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            builder.append(fieldError.getField()).append(fieldError.getDefaultMessage()).append("; ");
        }
        return Map.of("msg", builder.toString());
    }
}
