// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StringUtil.java

package com.zhhong.mochen.utils.weixin;

import java.util.Random;

public class StringUtil
{

    public StringUtil()
    {
    }

    public static boolean isEmpty(String str)
    {
        return str == null || "".equals(str.trim());
    }

    public static boolean isNotEmpty(String str)
    {
        return str != null && !"".equals(str.trim());
    }

    public static String getRandomString(int length)
    {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < length; i++)
        {
            int number = random.nextInt(2);
            long result = 0L;
            switch(number)
            {
            case 0: // '\0'
                result = Math.round(Math.random() * 25D + 65D);
                sb.append(String.valueOf((char)(int)result));
                break;

            case 1: // '\001'
                sb.append(String.valueOf((new Random()).nextInt(10)));
                break;
            }
        }

        return sb.toString();
    }
    
    public static void main(String args[])
            throws Exception
        {
            System.out.println(getRandomString(20));
        }
}
