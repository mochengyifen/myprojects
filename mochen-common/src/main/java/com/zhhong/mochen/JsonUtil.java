package com.zhhong.mochen;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 董仁亮
 * @date 2020-01-04 17:24
 * @Description:json转换工具类
 */
public class JsonUtil {

    /**
     * json字符串转map集合
     *
     * @param jsonStr
     * @return
     */
    public static HashMap<String, String> jsonToMap(String jsonStr) {
        return JSON.parseObject(jsonStr, new HashMap<String, String>().getClass());
    }

    /**
     * map转json字符串
     *
     * @param map
     * @return
     */
    public static String mapToJson(Map<String, String> map) {
        String jsonStr = JSON.toJSONString(map);
        return jsonStr;
    }

    /**
     * json字符串转换成对象
     *
     * @param jsonString
     * @param cls
     * @return
     */
    public static <T> T jsonToBean(String jsonString, Class<T> cls) {
        T t = null;
        try {
            t = JSON.parseObject(jsonString, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 对象转换成json字符串
     *
     * @param obj
     * @return
     */
    public static String beanToJson(Object obj) {
        return JSON.toJSONString(obj);
    }

    /**
     * json字符串转换成List对象集合
     *
     * @param jsonString
     * @return
     */
    public static <T> List<T> jsonToList(String jsonString, Class cls) {
        List<T> list = null;
        try {
            list = JSON.parseArray(jsonString, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * json字符串转换成ArrayList对象集合
     *
     * @param jsonString
     * @return
     */
    public static <T> ArrayList<T> jsonToArrayList(String jsonString, Class cls) {
        ArrayList<T> list = null;
        try {
            list = (ArrayList<T>) JSON.parseArray(jsonString, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * List集合转换成json字符串
     *
     * @param obj
     * @return
     */
    public static String listToJson(Object obj) {
        return JSONArray.toJSONString(obj, true);
    }

    /**
     * json转JSONArray
     *
     * @param jsonStr
     * @return
     */
    public static JSONArray jsonToArray(String jsonStr) {
        return JSON.parseArray(jsonStr);
    }

    /**
     * json字符串转JSONObject
     *
     * @param jsonStr
     * @return
     */
    public static JSONObject jsonTObject(String jsonStr) {
        return JSONObject.parseObject(jsonStr);
    }

}
