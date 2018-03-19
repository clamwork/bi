package com.djcps.boot.commons.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Chengw
 * @create 2018/3/16 15:39.
 * @since 1.0.0
 */
@Configuration
public class ParamsConfig {

    public String USER_COOKIE_NAME;

    public Integer USER_COOKIE_TIMEOUT;

    public String MESSAGE_SERVER;

    public String WMS_SERVER;

    public String NUMBER_SERVER;

    public String ADDRESS_SERVER;

    public String INNERUSER_SERVER;

    public String MAP_SERVER;

    public String ORDER_SERVER;

    @Value("${cps.user.cookie.name}")
    public void setUserCookieName(String userCookieName) {
        this.USER_COOKIE_NAME = userCookieName;
    }

    @Value("${cps.user.cookie.timeout}")
    public void setUserCookieTimeout(Integer userCookieTimeout) {
        this.USER_COOKIE_TIMEOUT = userCookieTimeout;
    }

    @Value("${cps.server.message}")
    public void setMessageServer(String messageServer) {
        this.MESSAGE_SERVER = messageServer;
    }

    @Value("${cps.server.wms}")
    public void setWmsServer(String wmsServer) {
        this.WMS_SERVER = wmsServer;
    }

    @Value("${cps.server.number}")
    public void setNumberServer(String numberServer) {
        this.NUMBER_SERVER = numberServer;
    }

    @Value("${cps.server.address}")
    public void setAddressServer(String addressServer) {
        this.ADDRESS_SERVER = addressServer;
    }

    @Value("${cps.server.inner-user}")
    public void setInnerUserServer(String innerUserServer) {
        this.INNERUSER_SERVER = innerUserServer;
    }

    @Value("${cps.server.map}")
    public void setMapServer(String mapServer) {
        this.MAP_SERVER = mapServer;
    }

    @Value("${cps.server.order}")
    public void setOrderServer(String orderServer) {
        this.ORDER_SERVER = orderServer;
    }
}





