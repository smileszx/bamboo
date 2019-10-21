package com.bamboo.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {


	@ModelAttribute
	@ResponseBody
	public String init()
	{
		System.out.println("@ModelAttribute init");
		return "@ModelAttribute init";
	}

	@ModelAttribute
	@ResponseBody
	public String start()
	{
		System.out.println("@ModelAttribute start");
		return "@ModelAttribute start";
	}

	@RequestMapping("hello")
	@ResponseBody
	public String hello() {
		System.out.println(Thread.currentThread().getName() + " hello world");
		return "hello controller";
	}
}
