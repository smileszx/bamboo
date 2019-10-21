package com.bamboo.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReturnValueController {
	// 不使用注解的
	@RequestMapping(value = "/returnValue1")
	public ModelAndView returnValue1() {
		return null;
	}

	@RequestMapping(value = "/returnValue2")
	public void returnValue2(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("get");
	}

	
	@RequestMapping("returnValue3")
	public String returnValue3() {
		return "viewValue";
	}

	//使用@ResponseBody注解的，使用该注解，都是返回给前端数据的，而不是页面
	//作用：
	// 1、根据返回值类型，匹配合适的HttpMessageConverter（接口）
	// 2、让HttpMessageConverter对返回值进行处理
	
	//HttpMessageConverter:StringHttpMessageConverter\MappingJacksonHttpMessageConverter
	// 作用：1、设置ContentType（String和MappingJackson的不一样）
	//       2、比如MappingJackson会使用Jackson工具类将返回值对象，转成JSON字符串
	//       3、调用response.getwriter.write(字符串)
	@RequestMapping("returnValue4")
	@ResponseBody
	public String returnValue4() {
		return "returnValue4";
	}
}
