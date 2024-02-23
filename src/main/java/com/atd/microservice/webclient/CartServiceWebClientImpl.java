package com.atd.microservice.webclient;

import com.atd.microservice.config.AppConfig;
import com.atd.microservice.config.Constants;
import com.atd.microservice.domain.request.CartServiceRequest;
import com.atd.microservice.domain.response.CartServiceResponse;
import com.atd.microservice.exception.ExternalAPIException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class CartServiceWebClientImpl implements CartServiceWebClient {


//    @Autowired
//    AppConfig appConfig;

    private AppConfig appConfig;
    public CartServiceWebClientImpl(AppConfig appConfig) {
        this.appConfig = appConfig;
    }
    @Autowired
    WebClient webClient;


    @Override
    public Mono<CartServiceResponse> createCartPreviewOrder(CartServiceRequest request, HttpHeaders headers) {
        final String METHOD_NAME = "createCartPreviewOrder";
        String url = String.format(this.appConfig.getMblDomainUrl().concat(this.appConfig.getCreateCartPreviewUrl()));
        try {
            log.info("Aggregator Response -> {}", new ObjectMapper().writeValueAsString(request));
        }catch (Exception e){

        }
        return this.webClient
                .post()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .header(Constants.XATOM_CLIENTID, Constants.XATOM_CLIENTID_VALUE)
                .header(HttpHeaders.AUTHORIZATION, headers.getFirst(HttpHeaders.AUTHORIZATION))
                .header(Constants.CLIENT_ID, Constants.ATD_MOBILE)
                .header(Constants.CLIENT_WEBSITE, headers.getFirst(Constants.CLIENT_WEBSITE))
                .bodyValue(request)
                .retrieve()
                .bodyToMono(CartServiceResponse.class)
                .doOnError(error -> log.info("errrrrrr"+error.getMessage()));
//                .onErrorMap(ex -> (new ExternalAPIException(CartServiceWebClient.class.getName(), METHOD_NAME, ex,
//                Constants.CART_API_ERROR, Constants.CART_API_ERROR,
//                ex.getMessage())));
    }


}
