package com.example.order_server.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author: Y.sh
 * @date: Created in 2020/6/4 16:15
 * @description:
 */
public class JsonUtils {

    public static final ObjectMapper objectMapper=new ObjectMapper();

    
    /**
     * create by: Y.sh
     * create time: 2020/6/4 16:18
     * description: json字符串转JsonNode对象的方法
     */
    public static JsonNode strJsonNode(String str){
        try {
            return objectMapper.readTree(str);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
