package com.apartment.gateway.filter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouteValidator {

    List<String> openApiEndpoints = Arrays.asList("/user/create",
            "/auth/generate",
            "/eureka");
    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints.stream().noneMatch(uri ->request.getURI().getPath().contains(uri));


}
