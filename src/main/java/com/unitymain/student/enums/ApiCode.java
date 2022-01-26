package com.unitymain.student.enums;

/**
 * @author unitymain
 */

public enum ApiCode {
    /**
     * 失败
     */
    FAILED(-1, "操作失败"),
    /**
     * 成功
     */
    SUCCESS(0, "执行成功");
    
    /**
     * 错误码
     */
    private final long code;
    /**
     * 错误信息
     */
    private final String msg;


    ApiCode(long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public long getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
