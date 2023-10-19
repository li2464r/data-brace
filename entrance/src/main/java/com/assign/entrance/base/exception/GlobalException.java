package com.assign.entrance.base.exception;

import com.assign.entrance.base.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = Exception.class)
    public Result doHandlerRuntimeException(Exception e) {
        logger.error("处理异常:", e);
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler(value = LibertyException.class)
    public Result doHandlerLibertyException(LibertyException libertyException) {
        logger.error(libertyException.getMessage() + ": ", libertyException);
        return Result.fail(libertyException.getMessage());
    }

}
