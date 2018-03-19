package com.djcps.boot.commons.reuquest;

import com.djcps.boot.commons.config.ParamsConfig;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rpc.plugin.http.HTTPResponse;
import rpc.plugin.http.RPCClientFields;

/**
 * @author Chengw
 * @create 2018/3/16 17:49.
 * @since 1.0.0
 */
@RPCClientFields(urlfield = "NUMBER_SERVER", urlbean = ParamsConfig.class)
public interface NumberServerHttpRequest {

    /**
     * 获取随机编号http接口
     * @param json
     * @author wzy
     * @return
     */
    @Headers("content-type:application/json")
    @POST("getnumber.do")
    HTTPResponse getNumber(@Body RequestBody json);
}
