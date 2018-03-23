package com.djcps.boot.commons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chengw
 * @create 2018/3/19 16:58.
 * @since 1.0.0
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new SysAuthInterceptor()).addPathPatterns("/**");
//        registry.addInterceptor(new ChildAccountAuthInteceptor()).addPathPatterns("/**/order/saveOrder.do",
//                "/**/grouponpay/paymentOfBlance.do", "/**/grouponpay/payorder.do", "/**/grouponpay/mixPayment.do",
//                "/**/order/deliveryOrder.do");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Bean(name = "mappingJackson2HttpMessageConverter")
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(new MediaType("application", "json", Charset.forName("UTF-8")));
        converter.setSupportedMediaTypes(supportedMediaTypes);
        return converter;
    }

    @Bean(name = "stringHttpMessageConverter")
    public StringHttpMessageConverter stringHttpMessageConverter() {
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<>(4);
        supportedMediaTypes.add(new MediaType("text", "html", Charset.forName("UTF-8")));
        supportedMediaTypes.add(new MediaType("text", "plain", Charset.forName("UTF-8")));
        supportedMediaTypes.add(new MediaType("application", "json", Charset.forName("UTF-8")));
        stringHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
        return stringHttpMessageConverter;
    }
}
