package com.elm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController

public class FallbackController {

    @GetMapping("/fallback")
    public Mono<ResponseEntity<String>> fallback(ServerWebExchange exchange) {
        String errorMessage = "服务链接异常";
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .contentType(MediaType.TEXT_PLAIN)
                .body(errorMessage));
    }


}