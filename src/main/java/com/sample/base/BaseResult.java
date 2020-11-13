package com.sample.base;

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
