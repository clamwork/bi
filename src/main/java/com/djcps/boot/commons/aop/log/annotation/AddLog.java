package com.djcps.boot.commons.aop.log.annotation;

import java.lang.annotation.*;

/**
 * @author Chengw
 * @create 2018/3/16 15:22.
 * @since 1.0.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AddLog {
    /**
     * 操作内容描述
     * @return
     */
    String value();
    /**
     * 系统模块名
     * @return
     */
    String module();
}

