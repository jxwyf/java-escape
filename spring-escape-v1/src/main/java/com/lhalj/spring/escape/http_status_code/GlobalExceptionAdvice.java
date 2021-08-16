package com.lhalj.spring.escape.http_status_code;

import com.lhalj.spring.escape.transaction_lost.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述:全局通一异常处理
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<GeneralResponse<String>> handleCustonException(
            HttpServletRequest request, CustomException ex
    ){
        GeneralResponse<String> result = new GeneralResponse<>(0,"");
        result.setData(ex.getMessage());
        //400
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}
