package com.example.order_server.service;

import com.example.order_server.entity.Order;

/**
 * @author: Y.sh
 * @date: Created in 2020/5/28 17:41
 * @description:
 */

public interface OrderService {

    Order save(int userId , int productId);
}
