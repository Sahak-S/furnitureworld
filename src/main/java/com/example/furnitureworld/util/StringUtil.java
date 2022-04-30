package com.example.furnitureworld.util;

import org.springframework.stereotype.Component;

@Component
public class StringUtil {

    public String trim(String msg){
        if (msg == null){
            return "";
        }
        return msg.trim();
    }

    public String revers(String msg){
        if (msg == null){
            return null;
        }
        return new StringBuilder(msg).reverse().toString();
    }
}
