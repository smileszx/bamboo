package com.bamboo.ssm.controller;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/18 19:55
 **/
@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public String handleException() {
        return "error";
    }

    @InitBinder
    public String handleBinder () {
        return "";
    }

    @ModelAttribute
    public String handleModel () {
        return "";
    }
}
