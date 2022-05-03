package cn.dingyufan.blog.demo.dubbostackoverflowduetojkd8instantprovider.api.dto.handle;

import cn.dingyufan.blog.demo.dubbostackoverflowduetojkd8instantprovider.api.dto.DemoDTO;
import com.alibaba.com.caucho.hessian.io.HessianHandle;

import java.io.Serializable;
import java.time.Instant;

public class DemoDTOHandle implements HessianHandle, Serializable {

    private static final long serialVersionUID = -8532997896892606136L;

    private String consumer;

    private long seconds;
    private int nanos;


    private DemoDTO readResolve() {
        System.out.println("call readResolve");
        DemoDTO dto = new DemoDTO();
        dto.setConsumer(consumer);
        dto.setInstant(Instant.ofEpochSecond(seconds, nanos));
        return dto;
    }


    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public long getSeconds() {
        return seconds;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    public int getNanos() {
        return nanos;
    }

    public void setNanos(int nanos) {
        this.nanos = nanos;
    }
}
