package com.zhhong.mochen;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:董仁亮
 * @Description:身份证号和姓名对比工具类,阿里云api
 */
public class IDCardNameUtil {
    public static boolean verification(String idCard, String trueName) {
        String host = "https://idcert.market.alicloudapi.com";
        String path = "/idcard";
        String method = "GET";
        String appcode = "2b41479add724370938d3b8c160b579a";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("idCard", idCard);
        querys.put("name", trueName);
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //System.out.println(response.toString());如不输出json, 请打开这行代码，打印调试头部状态码。
            //状态码: 200 正常；400 URL无效；401 appCode错误； 403 次数用完； 500 API网管错误
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
            String result = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject = JsonUtil.jsonTObject(result);
            if ("01".equals(jsonObject.getString("status"))) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}