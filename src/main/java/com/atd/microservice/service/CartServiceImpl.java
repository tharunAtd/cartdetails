package com.atd.microservice.service;

import com.atd.microservice.domain.request.CartServiceRequest;
import com.atd.microservice.domain.response.CartServiceResponse;
import com.atd.microservice.domain.response.Fulfillment;
import com.atd.microservice.domain.response.OrderLine;
import com.atd.microservice.webclient.CartServiceWebClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartServiceWebClient cartServiceWebClient;
    @Override
    public CartServiceResponse CartService(CartServiceRequest request, HttpHeaders headers) throws JsonProcessingException {
        try {
        CartServiceResponse cartServiceResponse = cartServiceWebClient.createCartPreviewOrder(request,headers).block();
        log.info("before..."+cartServiceResponse);
        log.info("..."+cartServiceResponse.getOrder().isPickup());
        // Condition 1: If pickup is true
        if (cartServiceResponse.getOrder().isPickup()) {
            List<OrderLine> orderLines = cartServiceResponse.getOrder().getOrderlines();
            for (OrderLine orderLine : orderLines) {
                List<Fulfillment> fulfillments = orderLine.getFulfillments().stream()
                        .filter(fulfillment -> "FILLED".equals(fulfillment.getStatus()))
                        .collect(Collectors.toList());
                orderLine.setFulfillments(fulfillments);
            }
        }

        // Condition 2: If needbydate is not null, filter out fulfillments where status is not FILLED or shipmethod is not "RouteTruck"
        if (cartServiceResponse.getOrder().getNeedbydate() != null) {
            List<OrderLine> orderLines = cartServiceResponse.getOrder().getOrderlines();
            for (OrderLine orderLine : orderLines) {
                List<Fulfillment> fulfillments = orderLine.getFulfillments().stream()
                        .filter(fulfillment -> "FILLED".equals(fulfillment.getStatus()) && "RouteTruck".equals(fulfillment.getShipmethod()))
                        .collect(Collectors.toList());
                orderLine.setFulfillments(fulfillments);
            }
        }

        // Condition 3: If pickup is false and needbydate is null do nothing

        log.info("after..."+cartServiceResponse);
        return cartServiceResponse;
        } catch (Exception e) {
            // Log the error
            log.error("Error occurred while processing cart service: " + e.getMessage(), e);
            return null;
        }
    }


}
