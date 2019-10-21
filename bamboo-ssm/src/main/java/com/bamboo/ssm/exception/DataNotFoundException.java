package com.bamboo.ssm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/18 20:09
 **/
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Data Not Found.")
public class DataNotFoundException extends RuntimeException {
}
