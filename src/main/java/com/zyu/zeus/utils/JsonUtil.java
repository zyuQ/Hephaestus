package com.zyu.zeus.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.List;

/**
 * 功能描述
 *
 * @author: zyu
 * @description:
 * @date: 2019/5/25 22:18
 */
@Slf4j
public class JsonUtil {
    public static JSONObject toJson(String jsonString) {
        JSONObject result;
        try {
            result = JSON.parseObject(jsonString);
        } catch (Exception e) {
            log.error("Invalid jsonString : \n" + jsonString);
            throw e;
        }
        return result;
    }

    public static JSONObject toJson(Object object) {
        return (JSONObject) JSON.toJSON(object);
    }

    public static <T> List<T> toObjectList(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz);
    }

    public static <T> List<T> toObjectList(Collection<String> collection, Class<T> clazz) {
        List<T> ret = Lists.newArrayList();
        for (String item : collection) {
            ret.add(JSON.parseObject(item, clazz));
        }
        return ret;
    }

    public static <T> T toObject(JSON json, Class<T> clazz) {
        try {
            return JSON.toJavaObject(json, clazz);
        } catch (Exception e) {
            log.error("json to object err, json is : " + json.toJSONString(), e);
            return null;
        }
    }

    public static <T> T toObject(String jsonString, Class<T> clazz) {
        try {
            if (StringUtil.isEmpty(jsonString)) {
                return null;
            }

            return JSON.parseObject(jsonString, clazz);
        } catch (Exception e) {
            log.error("json string to object err:", e);
            return null;
        }
    }

    public static String toJsonString(Object object) {
        return JSON.toJSONString(object);
    }

    public static String [] toJsonStringArray(Collection collection) {
        List<String> jsonStringList = Lists.newArrayList();
        for (Object object : collection) {
            jsonStringList.add(JSON.toJSONString(object));
        }

        return jsonStringList.toArray(new String[jsonStringList.size()]);
    }

}
