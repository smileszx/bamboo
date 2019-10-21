package com.bamboo.distribute.po;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/30 14:48
 **/
@Data
@Accessors(chain = true)
public class Product implements Serializable {

    private static final long serialVersionUID = -6391763207138670285L;

    private long productId;

    private String productName;

    private String brand;

    private transient double price;
}
