package com.lhalj.spring.escape.http_status_code;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 描述:
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "This is Second Way To Set Http Status Code!")
public class BadRequestException extends RuntimeException{
}
