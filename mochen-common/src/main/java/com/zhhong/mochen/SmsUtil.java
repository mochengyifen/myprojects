package com.zhhong.mochen;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @date:2020-01-14 12:13
 * @description:发送短信工具类,阿里云api
 */
@Slf4j
public class SmsUtil {

    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)

    private static String accessKeyId = YamlConfigurerUtil.getStrYmlVal("accessKeyId");
    private static String accessKeySecret = YamlConfigurerUtil.getStrYmlVal("accessKeySecret");

    public static StringBuilder createRandomVode() {
        StringBuilder vode = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            vode.append((int) (Math.random() * 9));
        }
        return vode;
    }


    public static String sendSms(String phone, HttpServletRequest req, String codeType) throws ClientException {
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("蜂窝");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(codeType);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        String code = String.valueOf(createRandomVode().toString());
        request.setTemplateParam("{\"code\":\"" + code + "\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        log.info("短信发送状态码：" + sendSmsResponse.getCode());
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            return code;
        }
        return null;
    }


    //短信通知审核状态模版
    public static String sendSmstz(String phone, String state, HttpServletRequest req) throws ClientException {
        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("杭州众蓦网络科技有限公司");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_158947701");
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{\"status\":\"" + state + "\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        log.info("短信通知发送状态---" + sendSmsResponse.getCode());
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            return sendSmsResponse.getCode();
        }
        return null;
    }
}
