package com.sample.controller;

import com.sample.base.BaseResponse;
import com.sample.base.BaseResult;
import com.sample.entity.ExampleBean;
import com.sample.entity.ExampleFileBean;
import com.sample.entity.ExampleListBean;
import com.sample.util.DateUtil;
import com.sample.util.FileUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @Author: 张
 * @Email: 1271396448@qq.com
 * @Date: 2020/11/13
 * @DESC: 控制器
 */
@RestController
@RequestMapping("/api")
public class SampleController {

    @Resource
    HttpServletRequest request;

    @GetMapping("/get")
    public BaseResponse testGet(String username, String password) {
        return BaseResult.success(new ExampleBean().setUsername(username).setPassword(password));
    }

    @PostMapping("/post")
    public BaseResponse testPost(String username, String password) {
        return BaseResult.success(null);
    }

    @PutMapping("/put")
    public BaseResponse testPut(String username, String password) {
        return BaseResult.error();
    }

    @DeleteMapping("/delete")
    public BaseResponse testDelete(String username, String password) {
        return BaseResult.success(new ExampleBean().setUsername(username).setPassword(password));
    }

    @PostMapping("/postJson")
    public BaseResponse testPostJson(@RequestBody ExampleBean exampleBean) {
        return BaseResult.success(exampleBean);
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
            return BaseResult.success(new ExampleFileBean().setFileUrl("http://119.45.229.87:1271" + "/upload/" + fileName));
        } catch (Exception e) {
            return BaseResult.error("上传失败");
        }
    }

    /**
     * 获取集合数据
     * @param page
     * @param pageNum
     * @return
     */
    @GetMapping("/getList")
    public BaseResponse getList(Integer page, Integer pageNum) {
        ArrayList<ExampleListBean> dataList = new ArrayList<>();
        int startPos = page == 1 ? 0 : (page - 1) * 10;
        for (int i = startPos; i < pageNum + startPos; i++) {
            dataList.add(new ExampleListBean(i + 1
                    , "我是第" + (i + 1) + "标题"
                    , "我是第" + (i + 1) + "内容"
                    , DateUtil.getCurrentDateTime()));
        }
        return BaseResult.success(dataList);
    }

}
