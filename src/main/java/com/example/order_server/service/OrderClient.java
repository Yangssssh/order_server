package com.example.order_server.service;

import com.example.order_server.fallback.OrderClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "product-server",fallback = OrderClientFallback.class)
public interface OrderClient {

    @RequestMapping(value = "product/get")
    String get(@RequestParam(value = "id") int id);
}
