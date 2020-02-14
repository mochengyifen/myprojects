package com.zhhong.mochen;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 董仁亮
 * @date 2020-01-14 14:27
 * @Description:身份证正反面识别和活体检测工具类,百度api
 */
public class IDCardDiscernUtil {
    //身份证正反识别
    private static String character_client_id = YamlConfigurerUtil.getStrYmlVal("character_client_id");
    private static String character_client_secret = YamlConfigurerUtil.getStrYmlVal("character_client_secret");

    //活体检测
    private static String face_client_id = YamlConfigurerUtil.getStrYmlVal("face_client_id");
    private static String face_client_secret = YamlConfigurerUtil.getStrYmlVal("face_client_secret");


    /**
     * 身份证正反面识别
     *
     * @param imgBase64
     * @param imgType   0正面,1反面
     * @return
     */
    public static String discern(String imgBase64, String imgType) {
        // 身份证识别url
        String idcardIdentificate = "https://aip.baidubce.com/rest/2.0/ocr/v1/idcard";
        try {

            // 识别身份证正面id_card_side=front;识别身份证背面id_card_side=back;
            if (imgType.equals("0")) {
                imgType = "front";
            }

            if (imgType.equals("1")) {
                imgType = "back";
            }
            String params = "id_card_side=" + imgType + "&" + URLEncoder.encode("image", "UTF-8") + "="
                    + URLEncoder.encode(imgBase64, "UTF-8");

            String accessToken = getAuth(character_client_id, character_client_secret);

            String result = HttpUtil.post(idcardIdentificate, accessToken, params);
            JSONObject joReturn = JSONObject.parseObject(result);
            String strReturn = "";
            if (imgType.equals("front")) {
                String strIDNum = joReturn.getJSONObject("words_result").getJSONObject("公民身份号码").getString("words");
                String strName = joReturn.getJSONObject("words_result").getJSONObject("姓名").getString("words");
                strReturn = strIDNum + "-" + strName;
            }
            if (imgType.equals("back")) {
                String strExpireDay = joReturn.getJSONObject("words_result").getJSONObject("失效日期").getString("words");
                strReturn = strExpireDay;
            }
            return strReturn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String getAuth(String ak, String sk) {
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + ak
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + sk;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.err.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            JSONObject jsonObject = JSONObject.parseObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return null;
    }

    public boolean faceComparison(String strIDPicBase64, String strHeadBase64) {
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";
        List<Map<String, Object>> images = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("image", strIDPicBase64);
        map1.put("image_type", "BASE64");
        map1.put("face_type", "LIVE");
        map1.put("quality_control", "LOW");
        map1.put("liveness_control", "NONE");


        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("image", strHeadBase64);
        map2.put("image_type", "BASE64");
        map2.put("face_type", "LIVE");
        map2.put("quality_control", "LOW");
        map2.put("liveness_control", "NORMAL");

        images.add(map1);
        images.add(map2);

        String param = JsonUtil.listToJson(images);
        // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间，
        // 客户端可自行缓存，过期后重新获取。
        String accessToken = getAuth(face_client_id, face_client_secret);
        try {
            String result = HttpUtil.post(url, accessToken, "application/json", param);
            JSONObject jo = JsonUtil.jsonTObject(result);
            if (jo.getInteger("error_code") == 0 && jo.getJSONObject("result").getDouble("score") >= 60.00) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
