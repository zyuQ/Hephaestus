package com.zyu.zeus.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 功能描述
 *
 * @author: zyu
 * @description:
 * @date: 2019/6/11 10:06
 */
public class OrderUtil {

    /**
     * 订单号生成
     * 1、获取当前日期作为订单号前8位
     * 2、获取uuid，uuid是通用唯一识别码，具有唯一性，进行hashcode转码后依旧可以保证其唯一性，用其作为订单尾号再合适不过，我们取其11位
     * 3、拼接日期及uuid hash码，即生成了高度唯一的订单号
     * @return
     */
    public static String getOrderIdByUUId() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        String time = format.format(date);
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return time + String.format("%011d", hashCodeV);
    }
}
