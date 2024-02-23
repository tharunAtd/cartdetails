package com.atd.microservice.webclient;


import com.atd.microservice.domain.request.CartServiceRequest;
import com.atd.microservice.domain.response.CartServiceResponse;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;

public interface CartServiceWebClient {
    Mono<CartServiceResponse> createCartPreviewOrder(CartServiceRequest request, HttpHeaders headers);
}
