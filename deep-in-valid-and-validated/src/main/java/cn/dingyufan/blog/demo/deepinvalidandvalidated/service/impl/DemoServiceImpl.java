package cn.dingyufan.blog.demo.deepinvalidandvalidated.service.impl;

import cn.dingyufan.blog.demo.deepinvalidandvalidated.controller.param.Student;
import cn.dingyufan.blog.demo.deepinvalidandvalidated.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author yfding10
 * @date 2022/7/4 15:55
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public Student invoke(String str, Student student) {
        return student;
    }
}
