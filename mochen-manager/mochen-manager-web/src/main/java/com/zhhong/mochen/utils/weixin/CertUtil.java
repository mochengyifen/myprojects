// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CertUtil.java

package com.zhhong.mochen.utils.weixin;


import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.ssl.SSLContexts;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

public class CertUtil {

    public CertUtil() {
    }

    public static SSLConnectionSocketFactory initCert()
            throws Exception {
        FileInputStream instream = null;
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        instream = new FileInputStream(new File(WeixinPayConfig.certp));
        /*    keyStore.load(instream, "1526195511".toCharArray());*/
        keyStore.load(instream, WeixinPayConfig.mch_id.toCharArray());
        if (instream != null)
            instream.close();
        javax.net.ssl.SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, WeixinPayConfig.mch_id.toCharArray()).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext, new String[]{"TLSv1"}, null,
                new DefaultHostnameVerifier());
        return sslsf;
    }

}
