package com.elm.config;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class DefaultFallbackFilter extends AbstractGatewayFilterFactory<Object> {


    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> chain.filter(exchange)
                .onErrorResume(throwable -> fallback(exchange));
    }

    private Mono<Void> fallback(ServerWebExchange exchange) {
        String errorMessage = "Service ERROR";
        exchange.getResponse().setStatusCode(HttpStatus.SERVICE_UNAVAILABLE);
        exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
        return exchange.getResponse().writeWith(Mono.just(exchange.getResponse().bufferFactory().wrap(errorMessage.getBytes())));
    }
}

