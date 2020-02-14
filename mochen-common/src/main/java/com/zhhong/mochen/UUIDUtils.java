package com.zhhong.mochen;

import java.util.UUID;

/**
 * @date:2020-01-14 12:15
 * @description:ID生成工具类
 */
public class UUIDUtils {
    /**
     * 32位默认长度的uuid
     * (获取32位uuid)
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * (获取指定长度uuid)
     *
     * @return
     */
    public static String getUUID(int len) {
        if (0 >= len) {
            return null;
        }

        String uuid = getUUID();
        System.out.println(uuid);
        StringBuffer str = new StringBuffer();

        for (int i = 0; i < len; i++) {
            str.append(uuid.charAt(i));
        }

        return str.toString();
    }
}
