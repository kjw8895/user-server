package com.user.api.common.handler;

import com.user.common.code.CommonExceptionCode;
import com.user.common.exception.CommonException;
import com.user.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalException(final Exception e) {
        log.error(e.getClass().getName(), e);
        return CommonResponse.error(CommonExceptionCode.UNKNOWN_SEVER_ERROR);
    }

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<?> commonException(final CommonException e) {
        return CommonResponse.error(e);
    }
}
