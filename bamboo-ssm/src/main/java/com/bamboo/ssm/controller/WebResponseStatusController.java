package com.bamboo.ssm.controller;

import com.bamboo.ssm.exception.DataNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/18 20:05
 **/
@Controller
public class WebResponseStatusController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String queryData (@PathVariable("id") long id, Model model) {
        throw new DataNotFoundException();
    }
}
