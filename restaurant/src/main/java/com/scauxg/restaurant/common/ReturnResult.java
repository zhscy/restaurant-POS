/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/19 23:36
 * History:
 */
package com.scauxg.restaurant.common;

import java.util.HashMap;

/**
 * 操作消息提醒
 *
 * @author Yue
 * @create 2019/3/19
 * @since 1.0.0
 */
public class ReturnResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    /**
     * 初始化一个新创建的 Message 对象
     */
    public ReturnResult() {
    }

    /**
     * 返回错误消息
     *
     * @return 错误消息
     */
    public static ReturnResult error() {
        return error(1, "操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 内容
     * @return 错误消息
     */
    public static ReturnResult error(String msg) {
        return error(1, msg);
    }

    /**
     * 返回错误消息
     *
     * @param code 错误码
     * @param msg  内容
     * @return 错误消息
     */
    public static ReturnResult error(int code, String msg) {
        ReturnResult json = new ReturnResult();
        json.put("code", code);
        json.put("msg", msg);
        return json;
    }

    /**
     * 返回成功消息
     *
     * @param msg 内容
     * @return 成功消息
     */
    public static ReturnResult success(String msg) {
        ReturnResult json = new ReturnResult();
        json.put("msg", msg);
        json.put("code", 0);
        return json;
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static ReturnResult success() {
        return ReturnResult.success("操作成功");
    }

    /**
     * 返回成功消息
     *
     * @param key   键值
     * @param value 内容
     * @return 成功消息
     */
    @Override
    public ReturnResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
