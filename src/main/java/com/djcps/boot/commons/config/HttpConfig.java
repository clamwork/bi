package com.djcps.boot.commons.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import rpc.plugin.spring.HTTPBeanProcessor;

/**
 * @author Chengw
 * @create 2018/3/16 17:36.
 * @since 1.0.0
 */
@Configuration
public class HttpConfig {

    @Value("${cps.rpc.package}") String rpcPackage;

    @Value("${cps.rpc.connectTimeout}") int connectTimeout;

    @Value("${cps.rpc.readTimeout}") int readTimeout;

    @Bean
    @Qualifier(value = "httpClientFactory")
    public SimpleClientHttpRequestFactory httpClientFactory() {
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setConnectTimeout(connectTimeout);
        simpleClientHttpRequestFactory.setReadTimeout(readTimeout);
        return simpleClientHttpRequestFactory;
    }

    @Bean
    RestTemplate restTemplate(SimpleClientHttpRequestFactory httpClientFactory){
        return new RestTemplate(httpClientFactory) ;
    }

    @Bean
    HTTPBeanProcessor httpBeanProcessor(){
        HTTPBeanProcessor httpBeanProcessor =  new HTTPBeanProcessor();
        httpBeanProcessor.setPrefix(rpcPackage);
        return httpBeanProcessor;
    }
}
