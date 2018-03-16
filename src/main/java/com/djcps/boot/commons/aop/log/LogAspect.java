package com.djcps.boot.commons.aop.log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.djcps.boot.commons.aop.log.annotation.AddLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Chengw
 * @create 2018/3/16 15:18.
 * @since 1.0.0
 */
@Aspect
@Component
public class LogAspect {

    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Around("@annotation(addLog)")
    public Object validIdentityAndSecure(ProceedingJoinPoint pjp, AddLog addLog) throws Throwable{
        long start = System.currentTimeMillis();
        Object proceed = pjp.proceed();
        try{
            getParameter(pjp, addLog,proceed);
        }catch (Exception e){
            logger.error("Log {}",e.getStackTrace());
        }
        long end = System.currentTimeMillis();
        logger.info("方法运行时间 {}",(end - start));
        return proceed;
    }

    public HttpServletRequest getRequest(ProceedingJoinPoint pjp) {
        Object[] args = pjp.getArgs();
        HttpServletRequest request = null;
        if (args != null) {
            for (Object object : args) {
                if (object instanceof HttpServletRequest) {
                    request = (HttpServletRequest) object;
                    return request;
                }
            }
        }
        try {
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;
            request = sra.getRequest();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return request;
    }

    public void getParameter(ProceedingJoinPoint pjp, AddLog addLog,Object proceed) throws InterruptedException, IOException {
        HttpServletRequest request = getRequest(pjp);
        Map<String, String> linkMap = new LinkedHashMap<>(15);
        if (request != null) {
            // ip
            String ip = request.getHeader("X-real-IP");
            linkMap.put("ip", ip);
            // 参数
            Map<String, String[]> requestParam = request.getParameterMap();
            String jsonString = JSON.toJSONString(requestParam);
            linkMap.put("requestParam", jsonString);
            Object[] args = pjp.getArgs();
            if (!ObjectUtils.isEmpty(args)) {
                for (Object object : args) {
                    if (object instanceof String) {
                        linkMap.put("requestBody", (String) object);
                        break;
                    }
                }
            }
            if (!(proceed instanceof String)) {
                linkMap.put("responseBody", JSONObject.toJSONString(proceed));
            }
            String os = request.getHeader("User-Agent");
            linkMap.put("OS", os);
        }
        // 操作时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        linkMap.put("operatingTime", simpleDateFormat.format(date));
        // 最小功能
        String signature = pjp.getSignature().toString();
        linkMap.put("signature", signature);
        // 操作内容
        String value = addLog.value();
        linkMap.put("operatingValue", value);
        // 系统模块
        String module = addLog.module();
        linkMap.put("systemModule", module);
        logger.info(JSON.toJSONString(linkMap));
    }

}
