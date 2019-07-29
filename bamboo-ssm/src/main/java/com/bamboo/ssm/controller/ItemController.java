package com.bamboo.ssm.controller;

import java.util.List;

import javax.annotation.Resource;

import com.bamboo.ssm.po.Item;
import com.bamboo.ssm.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ItemController {

	@Resource
	private ItemService service;

	@RequestMapping("queryItemList")
	@ResponseBody
	public List<Item> queryItemList() {
		return service.queryItemList();
	}

	@RequestMapping(value = "/saveItem", method = RequestMethod.POST)
	public void saveItem(@RequestBody Item item) {
		int result = service.saveItem(item);
		System.out.println(result);
	}
}
