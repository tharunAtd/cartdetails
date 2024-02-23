package com.atd.microservice.controller;

import com.atd.microservice.domain.request.CartServiceRequest;
import com.atd.microservice.domain.response.CartServiceResponse;
import com.atd.microservice.service.CartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import javax.validation.Valid;


@Slf4j
@Api(value = "Cart Service Controller", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class CartServiceController {

    @Autowired
    CartService cartService;
    @PostMapping(value = "/cart")
    public CartServiceResponse cartApi(
            @ApiParam(value = "CART SERVICE BFF", required = true) @Valid @RequestHeader HttpHeaders headers, @RequestBody CartServiceRequest request) throws JsonProcessingException {
        return cartService.CartService(request, headers);
    }
}
