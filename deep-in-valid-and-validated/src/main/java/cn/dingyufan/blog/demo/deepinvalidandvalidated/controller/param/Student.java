package cn.dingyufan.blog.demo.deepinvalidandvalidated.controller.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

/**
 * @author yfding10
 * @date 2022/7/4 20:08
 */
@Data
public class Student {

    @NotNull(groups = Group.Update.class)
    private Long id;

    @NotBlank
    private String name;

    @Min(7)
    private Integer age;

    @NotEmpty
    List<@Valid Performance> performances;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Performance {
        @NotBlank
        private String subject;
        @Range(min = 0, max = 100)
        private Double score;
    }
}
