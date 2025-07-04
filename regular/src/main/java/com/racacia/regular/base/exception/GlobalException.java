package com.racacia.regular.base.exception;

import love.racacia.result.HttpStatus;
import love.racacia.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException extends RuntimeException {

    private static final Logger logger = LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler(value = Exception.class)
    public Result doHandlerRuntimeException(Exception exception) {
        logger.error("处理异常:", exception);
        return Result.fail(exception.getMessage());
    }

    @ExceptionHandler(value = LibertyException.class)
    public Result doHandlerLibertyException(LibertyException libertyException) {
        logger.error("{}", libertyException.getMessage(), libertyException);
        return Result.fail(libertyException.getMessage());
    }

    @ExceptionHandler(value = ParametersException.class)
    public Result doHandlerParametersException(ParametersException parametersException) {
        logger.error("{}", parametersException.getMessage(), parametersException);
        return Result.fail(HttpStatus.BAD_REQUEST, parametersException.getMessage());
    }

}
