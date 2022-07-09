package cn.dingyufan.blog.demo.deepinvalidandvalidated;

import cn.dingyufan.blog.demo.deepinvalidandvalidated.controller.param.Student;
import cn.dingyufan.blog.demo.deepinvalidandvalidated.service.DemoService;
import cn.dingyufan.blog.demo.deepinvalidandvalidated.service.impl.DemoServiceImpl;
import org.springframework.util.ReflectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author yfding10
 * @date 2022/7/7 20:26
 */
public class Temp {

    public static void main(String[] args) {
        String str = "abc";
        Student student = new Student();

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        // 对象校验
        Set<ConstraintViolation<Student>> set = validator.validate(student);
        System.out.println(set);


        ExecutableValidator executableValidator = validator.forExecutables();

        DemoService demoService = new DemoServiceImpl();
        Method method = ReflectionUtils.findMethod(DemoService.class, "invoke", String.class, Student.class);
        // 方法入参校验
        Set<ConstraintViolation<DemoService>> set2 = executableValidator.validateParameters(demoService, method, new Object[]{str, student});
        System.out.println(set2);
    }
}
