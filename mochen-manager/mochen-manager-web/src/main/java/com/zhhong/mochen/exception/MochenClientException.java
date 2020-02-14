package com.zhhong.mochen.exception;

/**
 * @author 董仁亮
 * @date 2020-01-13 11:54
 * @Description:
 */
public class MochenClientException extends RuntimeException {
    private int code;

    public MochenClientException(int code) {
        this.code = code;
    }

    public MochenClientException(String message, int code) {
        super(message);
        this.code = code;
    }

    public MochenClientException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public MochenClientException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public MochenClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
