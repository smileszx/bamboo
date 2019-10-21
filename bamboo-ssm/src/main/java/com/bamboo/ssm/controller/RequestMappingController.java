package com.bamboo.ssm.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("requestMapping")
public class RequestMappingController {


	@RequestMapping("viewValue")
	@ResponseBody
	public String value() {
		return "viewValue";
	}
	//解决乱码，响应乱码
	@RequestMapping(value="viewValue2",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf8")
	@ResponseBody
	public String value2() {
		return "响应乱码";
	}
	
	@RequestMapping(value="/findItem",method=RequestMethod.GET)
	@ResponseBody
	public String findItem() {
		return "GET";
	}
	@RequestMapping(value="/findItem",method = RequestMethod.POST)
	@ResponseBody
	public String findItem2() {
		return "POST";
	}
}
