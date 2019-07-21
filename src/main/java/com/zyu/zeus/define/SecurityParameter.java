package com.zyu.zeus.define;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * 功能描述
 *
 * @author: zyu
 * @description:    请求数据解密
 * @date: 2019/6/14 17:11
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Mapping
@Documented
public @interface SecurityParameter {

    /**
     * 入参是否解密，默认解密
     */
    boolean inDecode() default true;

    /**
     * 出参是否加密，默认加密
     */
    boolean outEncode() default true;

}
