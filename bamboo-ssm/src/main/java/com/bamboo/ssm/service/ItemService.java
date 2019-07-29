package com.bamboo.ssm.service;

import com.bamboo.ssm.po.Item;

import java.util.List;


public interface ItemService {

	List<Item> queryItemList();

	int saveItem(Item item);
}
