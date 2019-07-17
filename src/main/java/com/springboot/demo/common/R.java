package com.springboot.demo.common;

import java.util.HashMap;


public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 0);
    }

    public static R error() {
        return error(500, "服务器内部错误！！");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Object data) {
        R r = new R();
        r.put("msg", "Success");
        if (data != null) {
            r.put("data",data);
        }
        return r;
    }

    public static R ok() {
        R r = new R();
        r.put("msg", "Success");
        return r;
    }

    public R put(Object value) {
        super.put("data", value);
        return this;
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
