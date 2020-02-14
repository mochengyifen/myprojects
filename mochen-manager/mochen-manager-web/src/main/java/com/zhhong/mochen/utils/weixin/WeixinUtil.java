// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WeixinUtil.java

package com.zhhong.mochen.utils.weixin;

import com.google.zxing.common.BitMatrix;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.*;

// Referenced classes of package com.zhhong.mapping.util.http:
//            Md5Util

public class WeixinUtil {

    public WeixinUtil() {
    }

    public static String getRemortIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null)
            return request.getRemoteAddr();
        else
            return request.getHeader("x-forwarded-for");
    }

    public static String getSign(Map map) {
        StringBuffer sb = new StringBuffer();
        String keyArr[] = (String[]) map.keySet().toArray(new String[map.keySet().size()]);
        Arrays.sort(keyArr);
        int i = 0;
        for (int size = keyArr.length; i < size; i++)
            if (!"sign".equals(keyArr[i]))
                sb.append((new StringBuilder(String.valueOf(keyArr[i]))).append("=").append(map.get(keyArr[i])).append("&").toString());

        sb.append("key=" + WeixinPayConfig.key);
        String sign = Md5Util.string2MD5(sb.toString());
        return sign;
    }

    public static String getElementValue(InputStream in, String key) {
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(in);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        List childElements = root.elements();
        for (Iterator iterator = childElements.iterator(); iterator.hasNext(); ) {
            Element child = (Element) iterator.next();
            System.out.println((new StringBuilder(String.valueOf(child.getName()))).append(":").append(child.getStringValue()).toString());
            if (key.equals(child.getName()))
                return child.getStringValue();
        }

        return null;
    }

    public static Map<String, String> getElementValue(InputStream in) {
        Map<String, String> resultMap = new HashMap<String, String>();
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(in);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        List childElements = root.elements();
        Element child;
        for (Iterator iterator = childElements.iterator(); iterator.hasNext();
             resultMap.put(child.getName(), child.getStringValue())

        )
            child = (Element) iterator.next();

        return resultMap;
    }

    public static java.awt.image.BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        java.awt.image.BufferedImage image = new java.awt.image.BufferedImage(width, height, 2);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++)
                image.setRGB(x, y, matrix.get(x, y) ? 0xff000000 : -1);

        }

        return image;
    }

    public static boolean isTenpaySign(String characterEncoding, SortedMap packageParams, String API_KEY) {
        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        for (Iterator it = es.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (!"sign".equals(k) && v != null && !"".equals(v))
                sb.append((new StringBuilder(String.valueOf(k))).append("=").append(v).append("&").toString());
        }

        sb.append((new StringBuilder("key=")).append(API_KEY).toString());
        String mysign = Md5Util.MD5Encode(sb.toString(), characterEncoding).toLowerCase();
        String tenpaySign = ((String) packageParams.get("sign")).toLowerCase();
        return tenpaySign.equals(mysign);
    }
}
