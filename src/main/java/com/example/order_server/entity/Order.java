package com.example.order_server.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: Y.sh
 * @date: Created in 2020/5/28 17:28
 * @description:
 */
@Data
public class Order implements Serializable {

    private int id;

    private String productName;   //商品名称

    private String taddeNo;    //订单编号

    private int price;    //订单价格

    private Date createDate;

    private int userId;

    private String userName;
}
