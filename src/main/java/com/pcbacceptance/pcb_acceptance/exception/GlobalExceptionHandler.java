package com.pcbacceptance.pcb_acceptance.exception;


import com.pcbacceptance.pcb_acceptance.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Order // 가장 마지막에 실행시키고 싶다면 Integer.MAX_VALUE를 value 값으로 주면 된다. 먼저는 Integer.MIN_VALUE.
//Integer.MAX_VALUE는 default 값이다.
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    //예측하지 못하는 예외들을 잡는 최후의 보루이기 때문에 최상위 클래스인 Exception으로 선언
    public ResponseEntity<Api> exception(
            Exception e
    ){
        log.error("final error catch",e);

        var response = Api.builder()
                .resultCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .resultMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .build();
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
