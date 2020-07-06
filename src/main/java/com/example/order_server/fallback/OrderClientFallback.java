package com.example.order_server.fallback;

import com.example.order_server.service.OrderClient;
import org.springframework.stereotype.Component;

/**
 * @author: Y.sh
 * @date: Created in 2020/6/10 14:59
 * @description:   product-server降级处理类
 */
@Component
public class OrderClientFallback implements OrderClient {

    @Override
    public String get(int id) {
        System.out.println("调用成功");
        return null;
    }
}
