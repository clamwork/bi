package com.djcps.boot.commons.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Chengw
 * @create 2018/3/16 15:39.
 * @since 1.0.0
 */
@Component
@PropertySource(value = "classpath:params-config.yml",ignoreResourceNotFound = true)
public class ParamsConfig {

    @Value("${cps.user.cookie.name}")
    private String userCookieName;

    @Value("${cps.user.cookie.timeout}")
    private Integer userCookieTimeout;

    @Value("${cps.server.message}")
    private String messageServer;

    @Value("${cps.server.wms}")
    private String wmsServer;

    @Value("${cps.server.number}")
    private String numberServer;

    @Value("${cps.server.address}")
    private String addressServer;

    @Value("${cps.server.inner-user}")
    private String innerUserServer;

    @Value("${cps.server.map}")
    private String mapServer;

    @Value("${cps.server.order}")
    private String orderServer;

    public String getUserCookieName() {
        return userCookieName;
    }

    public Integer getUserCookieTimeout() {
        return userCookieTimeout;
    }

    public String getMessageServer() {
        return messageServer;
    }

    public String getWmsServer() {
        return wmsServer;
    }

    public String getNumberServer() {
        return numberServer;
    }

    public String getAddressServer() {
        return addressServer;
    }

    public String getInnerUserServer() {
        return innerUserServer;
    }

    public String getMapServer() {
        return mapServer;
    }

    public String getOrderServer() {
        return orderServer;
    }
}





