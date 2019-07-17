package com.springboot.demo.exception;


//import lombok.extern.java.Log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 异常处理器
 */

@ControllerAdvice
public class MyExceptionHandle {


    @ExceptionHandler(Exception.class)
    public void HandleException(Exception e) {
        Logger log = LoggerFactory.getLogger(MyExceptionHandle.class);

        log.error("异常：" + e.getMessage());
    }

}
