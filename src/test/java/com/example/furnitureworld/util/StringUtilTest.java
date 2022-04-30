package com.example.furnitureworld.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    private StringUtil stringUtil = new StringUtil();

    @Test
    void trim() {
        String trim = stringUtil.trim("  poxos  ");
        assertEquals("poxos",trim);
    }

    @Test
    void trim_ko() {
        String trim = stringUtil.trim("  po xos  ");
        assertEquals("po xos",trim);
    }
    @Test
    void trim_null(){
        String trim = stringUtil.trim(null);
        assertNotNull(trim);
        assertEquals("",trim);
    }
    @Test
    void revers() {
        String name = "poxos";
        String reversName =stringUtil.revers(name);
        assertEquals("soxop",reversName);
    }
    @Test
    void revers_null() {
        String name = null;
        String reversName =stringUtil.revers(name);
        assertNull(reversName);
    }
}