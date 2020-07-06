package com.example.order_server.controller;

import com.example.order_server.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Y.sh
 * @date: Created in 2020/5/28 17:38
 * @description:
 */
@RestController
@RequestMapping(value = "order",produces = { "application/json;charset=UTF-8"})
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("save")
    @HystrixCommand(fallbackMethod = "defaultsave")
    public Object save(int userId,int productId){
        Map data=new HashMap();
        data.put("code",0);
        data.put("data",orderService.save(userId,productId));
        return data;
    }


    public Object defaultsave(int userId,int productId){
        Map data=new HashMap();
        data.put("code",1);
        data.put("data","系统繁忙，请稍后重试");
        return data;
    }
}
