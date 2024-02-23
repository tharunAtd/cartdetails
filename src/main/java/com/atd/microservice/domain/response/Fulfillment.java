package com.atd.microservice.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fulfillment {
    private String status;
    private double freight;
    private String shipmethod;
    private String estimateddelivery;
    private String sourcedc;
    private String sourcedcname;
    private int qty;
}
