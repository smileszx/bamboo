package com.bamboo.distribute.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/4 10:01
 **/
@RestController
public class WelcomeController {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome () {
        return "index.html";
    }
}
