package com.example.order_server.service.impl;

import com.example.order_server.entity.Order;
import com.example.order_server.service.OrderClient;
import com.example.order_server.service.OrderService;
import com.example.order_server.utils.JsonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @author: Y.sh
 * @date: Created in 2020/5/28 17:49
 * @description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private OrderClient orderClient;

    /**
     * create by: Y.sh
     * create time: 2020/6/4 16:10
     * description: ribbon完成服务之间的调用
     */
//    @Override
//    public Order save(int userId, int productId) {
//
//        ServiceInstance instance = loadBalancer.choose("product-server");
//        String url=String.format("http://%s:%s/product/get?id="+productId,instance.getHost(),instance.getPort());
//        RestTemplate restTemplate=new RestTemplate();
//        Map<String,Object> product = restTemplate.getForObject(url, Map.class);
//
//        Order order=new Order();
//        order.setCreateDate(new Date());
//        order.setUserId(userId);
//        order.setTaddeNo(UUID.randomUUID().toString());
//        order.setPrice(Integer.parseInt(product.get("price").toString()));
//        order.setProductName(product.get("name").toString());
//        return order;
//    }

    /**
     * create by: Y.sh
     * create time: 2020/6/4 16:12
     * description: feign完成服务之间的调用
     */
    @Override
    public Order save(int userId, int productId) {

        String response= orderClient.get(productId);
        JsonNode product= JsonUtils.strJsonNode(response);

        Order order=new Order();
        order.setCreateDate(new Date());
        order.setUserId(userId);
        order.setTaddeNo(UUID.randomUUID().toString());
        order.setPrice(Integer.parseInt(product.get("price").toString()));
        order.setProductName(product.get("name").toString());
        return order;
    }
}
