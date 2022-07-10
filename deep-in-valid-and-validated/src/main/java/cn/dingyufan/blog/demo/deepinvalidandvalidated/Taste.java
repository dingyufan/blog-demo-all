package cn.dingyufan.blog.demo.deepinvalidandvalidated;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;


public class Taste {

    @NotBlank
    private String val;


    public static void main(String[] args) throws NoSuchMethodException {
        int num = -1;
        Taste obj = new Taste();

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        // 对象校验
        Set<ConstraintViolation<Taste>> set = validator.validate(obj);
        System.out.println(set);

        ExecutableValidator executableValidator = validator.forExecutables();
        // 方法入参校验
        TempService service = new TempService();
        Method method = TempService.class.getDeclaredMethod("method", int.class, Taste.class);

        Object[] params = new Object[]{num, obj};

        Set<ConstraintViolation<TempService>> set2 = executableValidator.validateParameters(service, method, params);
        System.out.println(set2);
    }

    static class TempService {
        @NotNull String method(@PositiveOrZero int num, @Valid Taste obj) {
            return null;
        }
    }



    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
