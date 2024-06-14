package com.sparta.myselectshop.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message) {
        super(message); // super를 활용하면 RuntimeException 쪽으로 메세지를 전달해 줄 수 있음
    }
}
