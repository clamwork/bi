package com.djcps.boot.commons.config;

import com.djcps.boot.commons.base.HttpBaseParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Chengw
 * @since 2018/3/16 15:39.
 * @version 1.0.0
 */
@Configuration
public class ParamsConfig {

    @Value("${cps.user.cookie.name}")
    public void setUserCookieName(String userCookieName) {
        HttpBaseParam.userCookieName = userCookieName;
    }

    @Value("${cps.user.cookie.timeout}")
    public void setUserCookieTimeout(Integer userCookieTimeout) {
        HttpBaseParam.userCookieTimeout = userCookieTimeout;
    }

    @Value("${cps.server.message}")
    public void setMessageServer(String messageServer) {
        HttpBaseParam.messageServer = messageServer;
    }

    @Value("${cps.server.wms}")
    public void setWmsServer(String wmsServer) {
        HttpBaseParam.wmsServer = wmsServer;
    }

    @Value("${cps.server.number}")
    public void setNumberServer(String numberServer) {
        HttpBaseParam.numberServer = numberServer;
    }

    @Value("${cps.server.address}")
    public void setAddressServer(String addressServer) {
        HttpBaseParam.addressServer = addressServer;
    }

    @Value("${cps.server.inner-user}")
    public void setInnerUserServer(String innerUserServer) {
        HttpBaseParam.innerUserServer = innerUserServer;
    }

    @Value("${cps.server.map}")
    public void setMapServer(String mapServer) {
        HttpBaseParam.mapServer = mapServer;
    }

    @Value("${cps.server.order}")
    public void setOrderServer(String orderServer) {
        HttpBaseParam.orderServer = orderServer;
    }
}





