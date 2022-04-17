package cn.dingyufan.blog.demo.dubbostackoverflowduetojkd8instantprovider.api.dto;

import java.io.Serializable;
import java.time.Instant;

public class DemoDTO implements Serializable {

    private static final long serialVersionUID = -311647434535770294L;

    private String consumer;
    private Instant instant;

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
