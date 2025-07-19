package com.example.mywebproject.Pojo;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class myResult {
    private int code;
    private String message;
    private Object data;

    public myResult() {}

    public myResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static myResult success(Object data) {
        return new myResult(200, "success", data);
    }

    public static myResult success() {
        return new myResult(200, "success", null);
    }

    public static myResult error(String message) {
        return new myResult(500, message, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "myResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
