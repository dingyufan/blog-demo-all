package cn.dingyufan.blog.demo.dubbostackoverflowduetojkd8instantprovider.api;


import cn.dingyufan.blog.demo.dubbostackoverflowduetojkd8instantprovider.api.dto.DemoDTO;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service("demoService")
public class DemoServiceImpl implements DemoService {

    @Override
    public DemoDTO invoke(String consumer) {
        DemoDTO dto = new DemoDTO();
        dto.setConsumer(consumer);
        dto.setInstant(Instant.now());
        return dto;
    }
}
