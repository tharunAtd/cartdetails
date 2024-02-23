package com.atd.microservice.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsumerData {
    private Map<String, Object> consumershipto;
    private Map<String, Object> consumerbillto;
    private Map<String, Object> consumerattributes;
}
