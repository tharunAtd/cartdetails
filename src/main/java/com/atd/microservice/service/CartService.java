package com.atd.microservice.service;

import com.atd.microservice.domain.request.CartServiceRequest;
import com.atd.microservice.domain.response.CartServiceResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpHeaders;

public interface CartService {
public CartServiceResponse CartService(CartServiceRequest request, HttpHeaders headers) throws JsonProcessingException;

}
