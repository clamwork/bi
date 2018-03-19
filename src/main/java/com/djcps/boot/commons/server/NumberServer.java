package com.djcps.boot.commons.server;

import com.alibaba.fastjson.JSONObject;
import com.djcps.boot.commons.reuquest.NumberServerHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rpc.plugin.http.HTTPResponse;

/**
 * @author Chengw
 * @create 2018/3/16 17:51.
 * @since 1.0.0
 */
@Component
public class NumberServer {

    @Autowired
    private NumberServerHttpRequest numberServerHttpRequest;

    public String getNumber(int count) {
        String param = "count="+count;
        okhttp3.RequestBody rb = okhttp3.RequestBody.create(okhttp3.MediaType.parse("application/x-www-form-urlencoded; charset=utf-8"),param);
        //调用借口获取信息
        HTTPResponse http = numberServerHttpRequest.getNumber(rb);
        return JSONObject.toJSONString(http);
    }

}
