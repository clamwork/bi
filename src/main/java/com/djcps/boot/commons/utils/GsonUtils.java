package com.djcps.boot.commons.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Chengw
 * @since 2017/12/5 09:23.
 */
public class GsonUtils {

    /**
     * gson 转换静态类
     */
    public static Gson gson = new GsonBuilder().serializeNulls().create();
}
