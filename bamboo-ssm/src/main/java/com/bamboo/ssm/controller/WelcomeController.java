package com.bamboo.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/18 19:50
 **/
@Controller
public class WelcomeController {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    @ResponseBody
    public String welcome () {
        System.out.println(1/0);
        return "welcome to bamboo.";
    }

    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirectTest() {
        return "redirect:error";
    }
}
