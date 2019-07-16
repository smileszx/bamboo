package com.bamboo.ssm.service.impl;

import com.bamboo.ssm.mapper.ItemMapper;
import com.bamboo.ssm.po.Item;
import com.bamboo.ssm.po.ItemExample;
import com.bamboo.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired(required = true)
	private ItemMapper mapper;
	
	@Override
	public List<Item> queryItemList() {
		
		ItemExample example = new ItemExample();
		List<Item> list = mapper.selectByExample(example);
		
		return list;
	}

}
