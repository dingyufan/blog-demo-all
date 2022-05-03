package cn.dingyufan.blog.demo.dubbostackoverflowduetojkd8instantprovider.api.dto;

import cn.dingyufan.blog.demo.dubbostackoverflowduetojkd8instantprovider.api.dto.handle.DemoDTOHandle;

import java.io.Serializable;
import java.time.Instant;

public class DemoDTO implements Serializable {

    private static final long serialVersionUID = -311647434535770294L;

    private String consumer;
    private Instant instant;


    // private DemoDTOHandle writeReplace() {
    //     System.out.println("call writeReplace");
    //     DemoDTOHandle repl = new DemoDTOHandle();
    //     repl.setConsumer(consumer);
    //     if (instant != null) {
    //         repl.setSeconds(instant.getEpochSecond());
    //         repl.setNanos(instant.getNano());
    //     }
    //     return repl;
    // }


    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    @Override
    public String toString() {
        return "DemoDTO{" +
                "consumer='" + consumer + '\'' +
                ", instant=" + instant +
                '}';
    }
}
