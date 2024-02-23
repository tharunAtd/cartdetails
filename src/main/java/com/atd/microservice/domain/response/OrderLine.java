package com.atd.microservice.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderLine {
    private int cartlinenumber;
    private boolean quickship;
    private String billto;
    private String description;
    private double cost;
    private double fet;
    private double linetotal;
    private boolean discontinued;
    private boolean replaced;
    private List<Fulfillment> fulfillments;
    private List<Object> addons;
    private List<Object> statusmessages;
    private String atdproductnumber;
    private int quantityordered;
}
