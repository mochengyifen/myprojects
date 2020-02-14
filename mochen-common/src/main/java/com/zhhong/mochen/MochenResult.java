package com.zhhong.mochen;

/**
 * @date:2020-01-14 12:14
 * @description:自定义类型返回结构工具类
 */
public class MochenResult {

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static MochenResult build(Integer status, String msg, Object data) {
        return new MochenResult(status, msg, data);
    }

    public static MochenResult ok(Object data) {
        return new MochenResult(data);
    }

    public static MochenResult ok() {
        return new MochenResult(null);
    }

    public MochenResult() {

    }

    public static MochenResult build(Integer status, String msg) {
        return new MochenResult(status, msg, null);
    }

    public MochenResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public MochenResult(Object data) {
        this.status = 200;
        this.msg = "操作成功";
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
