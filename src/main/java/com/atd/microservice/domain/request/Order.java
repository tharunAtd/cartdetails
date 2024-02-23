package com.atd.microservice.domain.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    private String customerponumber;
    private String customercomment;
    private boolean pickup;
    private boolean localplus;
    private String ordertype;
    private List<LineItem> lineitems;

    // Getters and setters
}
