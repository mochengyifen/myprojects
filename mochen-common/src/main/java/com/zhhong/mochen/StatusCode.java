package com.zhhong.mochen;

/**
 * @date:2020-01-14 12:15
 * @description:状态码工具类
 */
public class StatusCode {
    public static int CODE_SUCCESS = 0;         //成功返回
    public static int CODE_ERROR = 1000;        //失败返回

    public static int CODE_ERROR_FILE = 510;    //文件格式不支持
    public static int CODE_ERROR_PARAM = 511;   //请求参数存在空值
    public static int CODE_ERROR_AUTH = 512;    //暂无权限
}
