package com.sample.base;

/**
 * @Author: 张
 * @Email: 1271396448@qq.com
 * @Date: 2020/11/13
 * @DESC: 封装的返回
 */
public class BaseResult {

    public static BaseResponse success(Object data) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(10000);
        baseResponse.setMsg("请求成功");
        baseResponse.setData(data);
        return baseResponse;
    }

    public static BaseResponse error() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(10001);
        baseResponse.setMsg("错误码");
        baseResponse.setData(null);
        return baseResponse;
    }

    public static BaseResponse error(String msg) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(10001);
        baseResponse.setMsg(msg);
        baseResponse.setData(null);
        return baseResponse;
    }


}
