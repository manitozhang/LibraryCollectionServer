package com.sample.controller;

import com.sample.base.BaseResponse;
import com.sample.util.FileUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class SampleController {

    @Resource
    HttpServletRequest request;

    @GetMapping("/get")
    public BaseResponse testGet(String username, String password) {
        return success(new ExampleBean(username, password));
    }

    @PostMapping("/post")
    public BaseResponse testPost(String username, String password) {
        return success(null);
    }

    @PutMapping("/put")
    public BaseResponse testPut(String username, String password) {
        return error();
    }

    @DeleteMapping("/delete")
    public BaseResponse testDelete(String username, String password) {
        return success(success(new ExampleBean(username, password)));
    }

    @PostMapping("/postJson")
    public BaseResponse testPostJson(@RequestBody ExampleBean exampleBean) {
        return success(exampleBean);
    }

    @PostMapping("/uploadFile")
    @ResponseBody
    public BaseResponse testUploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String[] split = fileName.split("\\.");
        fileName = "filename." + split[split.length - 1];
        //设置文件上传路径
        String filePath = request.getSession().getServletContext().getRealPath("upload/");
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            return success("http://localhost:8080"+"/upload/"+fileName);
        } catch (Exception e) {
            return error("上传失败");
        }
    }


    private BaseResponse success(Object data) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(10000);
        baseResponse.setMsg("请求成功");
        baseResponse.setData(data);
        return baseResponse;
    }

    private BaseResponse error() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(10001);
        baseResponse.setMsg("错误码");
        baseResponse.setData(null);
        return baseResponse;
    }

    private BaseResponse error(String msg) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(10001);
        baseResponse.setMsg(msg);
        baseResponse.setData(null);
        return baseResponse;
    }

    static class ExampleBean {
        private String username;
        private String password;

        public ExampleBean(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

}
