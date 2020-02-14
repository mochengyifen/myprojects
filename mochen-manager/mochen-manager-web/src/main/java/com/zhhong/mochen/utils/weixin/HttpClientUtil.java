// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HttpClientUtil.java

package com.zhhong.mochen.utils.weixin;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

// Referenced classes of package com.zhhong.mapping.util.http:
//            CertUtil

public class HttpClientUtil
{

    public HttpClientUtil()
    {
    }

    public static HttpResponse sendXMLDataByPost(String url, String xmlData)
        throws ClientProtocolException, IOException
    {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);
        StringEntity entity = new StringEntity(xmlData);
        httppost.setEntity(entity);
        httppost.setHeader("Content-Type", "text/xml;charset=UTF-8");
        HttpResponse response = httpClient.execute(httppost);
        return response;
    }

    public static HttpResponse sendXMLDataByHttpsPost(String url, String xmlData)
        throws ClientProtocolException, IOException
    {
        HttpPost httppost = new HttpPost(url);
        StringEntity entity = new StringEntity(xmlData);
        httppost.setEntity(entity);
        httppost.setHeader("Content-Type", "text/xml;charset=UTF-8");
        HttpResponse response = null;
        try
        {
            response = HttpClients.custom().setSSLSocketFactory(CertUtil.initCert()).build().execute(httppost);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return response;
    }

    public static JSONObject doGetJson(String url)
        throws ClientProtocolException, IOException
    {
        JSONObject jsonObject = null;
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if(entity != null)
        {
            String result = EntityUtils.toString(entity, "UTF-8");
            jsonObject = JSONObject.parseObject(result);
        }
        httpGet.releaseConnection();
        return jsonObject;
    }
}
