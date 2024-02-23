package com.atd.microservice.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    private String customerponumber;
    private String customercomment;
    private String consumername;
    private String needbydate;
    private String fillkill;
    private boolean pickup;
    private boolean localplus;
    private String ordertype;
    private double ordertotal;
    private String thresholdmessage;
    private ConsumerData consumerdata;
    private List<OrderLine> orderlines;
}
