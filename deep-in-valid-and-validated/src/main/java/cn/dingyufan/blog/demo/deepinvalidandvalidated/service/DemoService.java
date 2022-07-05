package cn.dingyufan.blog.demo.deepinvalidandvalidated.service;

import cn.dingyufan.blog.demo.deepinvalidandvalidated.controller.param.Student;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yfding10
 * @date 2022/7/4 15:54
 */
@Validated
public interface DemoService {

    Student invoke(@NotBlank String str, @NotNull @Valid Student student);

}
