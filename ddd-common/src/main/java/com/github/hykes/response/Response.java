package com.github.hykes.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-02-25 14:32:00
 */
@Data
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -750644833749014618L;

    /**
     * 调用是否成功
     */
    private boolean success;

    /**
     * 如果success = true,则通过result可以获得调用结果
     */
    private T result;

    /**
     * 如果success = false,则通过error可以查看错误信息
     */
    private String error;

    public void setResult(T result) {
        this.success = true;
        this.result = result;
    }

    public void setError(String error) {
        this.success = false;
        this.error = error;
    }

    public static <T> Response<T> ok(T data) {
        Response<T> resp = new Response();
        resp.setResult(data);
        return resp;
    }

    public static <T> Response<T> ok() {
        return Response.ok(null);
    }

    public static <T> Response<T> fail(String error) {
        Response<T> resp = new Response();
        resp.setError(error);
        return resp;
    }
}
