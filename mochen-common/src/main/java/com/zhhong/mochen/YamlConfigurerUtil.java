package com.zhhong.mochen;

import java.util.Properties;

/**
 * @author 董仁亮
 * @date 2020-01-14 11:54
 * @Description:获取yml配置项工具类
 */
public class YamlConfigurerUtil {
    private static Properties ymlProperties = new Properties();

    public YamlConfigurerUtil(Properties properties) {
        ymlProperties = properties;
    }

    public static String getStrYmlVal(String key) {
        return ymlProperties.getProperty(key);
    }

    public static Integer getIntegerYmlVal(String key) {
        return Integer.valueOf(ymlProperties.getProperty(key));
    }
}
