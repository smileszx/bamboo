package com.bamboo.test.ssm;

import com.bamboo.ssm.po.Item;
import com.bamboo.ssm.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/29 11:18
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*.xml")
public class SaveTest {


    @Autowired
    private ItemService service;

    @Test
    public void saveItem () {

        Item item = new Item();
        item.setId(5);
        item.setName("文玩核桃");
        item.setPrice((float) 120.0);
        item.setPic("picture.img");
        item.setCreatetime(new Date());

        int result = service.saveItem(item);
        System.out.println(result);
    }

}
