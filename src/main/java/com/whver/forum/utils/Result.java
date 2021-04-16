package com.whver.forum.utils;

import lombok.Data;

/**
 * this is for REST API
 * */

@Data
public class Result {

    public static int SUCCESS_CODE = 0;
    public static int FAIL_CODE = 1;

    int code; // stand for success or failure
    String message; // if failed, need send message to the console or print it out
    Object data; // if succeed, where the retrieved data kept

    private Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result success() {
        return new Result(SUCCESS_CODE,null,null);
    }
    public static Result success(Object data) {
        return new Result(SUCCESS_CODE,"",data);
    }
    public static Result fail(String message) {
        return new Result(FAIL_CODE,message,null);
    }

}
