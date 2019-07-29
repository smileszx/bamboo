package com.bamboo.test.ssm;

import com.bamboo.ssm.po.Item;
import com.bamboo.ssm.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/29 10:33
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*.xml")

public class SelectTest {

    @Autowired
    private ItemService itemService;

    @Test
    public void testSelect() {
        List<Item> list = itemService.queryItemList();

        System.out.println(list);
    }
}
