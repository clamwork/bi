package com.djcps.boot;

import java.lang.reflect.Field;

/**
 * @author Chengw
 * @create 2018/3/20 09:39.
 * @since 1.0.0
 */

public class FieldTest {

    public static String name = "sss";

    public static void main(String[] args) throws Exception{
        Class classs = FieldTest.class;
        Field field = classs.getField("name");
        if (field != null) {
            String s  = (String)field.get((Object)null);
            System.out.println("args = [" + s + "]");
        }
    }
}
