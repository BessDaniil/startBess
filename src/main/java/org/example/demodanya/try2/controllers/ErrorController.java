package org.example.demodanya.try2.controllers;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ErrorController {
    private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorInfo processException(Exception e) {
        logger.error("unexpected error", e);
        return new ErrorInfo(e.getMessage());
    }
}
