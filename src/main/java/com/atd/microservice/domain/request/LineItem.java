package com.atd.microservice.domain.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LineItem {
    private String atdproductnumber ;
    private Integer quantity;
    private String shippingmethod;
    private Integer quickship;
}
