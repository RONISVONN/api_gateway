package com.ronisvonn.apigateway.exeption;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptionPedido extends RuntimeException {
    public ResourceNotFoundExceptionPedido(String message) {
        super(message);
    }
}