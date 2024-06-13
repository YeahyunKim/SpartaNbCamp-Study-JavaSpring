package com.sparta.myselectshop.controller;

import com.sparta.myselectshop.exception.RestApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller

public class FolderController {
    @ExceptionHandler({IllegalArgumentException.class}) // 이 컨트롤러에서 IllegalArgumentException 에러가 터졌을때, 여기로 보내서 잡아준다.
    public ResponseEntity<RestApiException> handleException(IllegalArgumentException ex) {
        RestApiException restApiException = new RestApiException(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(
                // HTTP body
                restApiException,
                // HTTP status code
                HttpStatus.BAD_REQUEST
        );
    }
}
