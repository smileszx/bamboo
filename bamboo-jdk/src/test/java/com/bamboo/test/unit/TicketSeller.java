package com.bamboo.test.unit;

/**
 * @Description
 * 模拟售票器类
 * @Author victor su
 * @Date 2019/10/28 18:48
 **/
public class TicketSeller {

    private volatile long inventory;

    public String sell (long sellnum) {
        this.inventory = inventory - sellnum;
        return "剩余票数：" + inventory;
    }

    public long getInventory() {
        return inventory;
    }

    public void setInventory(long inventory) {
        this.inventory = inventory;
    }
}
