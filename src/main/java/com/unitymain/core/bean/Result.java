package com.unitymain.core.bean;

import com.unitymain.core.enums.ApiCode;
import lombok.Data;
import java.io.Serializable;

/**
 * @author unitymain
 */
@Data
public class Result<T> implements Serializable {
    /**
     * 错误码
     */
    private long status;

    /**
     * 描述信息
     */
    private String error;

    /**
     * 结果
     */
    private T data;

    public Result(){
        // 什么都不做
    }


    public Result(long status, String error, T data) {
        this.status = status;
        this.error = error;
        this.data = data;
    }

    public static <T> Result<T> ok(){
        return status(ApiCode.SUCCESS);
    }

    public static <T> Result<T> ok(String msg){
        return status(ApiCode.SUCCESS.getCode(),msg);
    }

    public static <T> Result<T> failed(){
        return status(ApiCode.FAILED);
    }

    public static <T> Result<T> failed(String msg){
        return status(ApiCode.FAILED.getCode(),msg);
    }

    public <T> Result<T> body(T data){
        return new Result(this.status,this.error,data);
    }

    private static <T> Result<T> status(ApiCode apiCode) {
        Result<T> apiResult = new Result<>();
        apiResult.setStatus(apiCode.getCode());
        apiResult.setError(apiCode.getMsg());
        return apiResult;
    }

    private static <T> Result<T> status(long code, String msg) {
        Result<T> apiResult = new Result<>();
        apiResult.setStatus(code);
        apiResult.setError(msg);
        return apiResult;
    }

    private static <T> Result<T> status(T data, long code, String msg) {
        Result<T> apiResult = new Result<>();
        apiResult.setStatus(code);
        apiResult.setData(data);
        apiResult.setError(msg);
        return apiResult;
    }
}
