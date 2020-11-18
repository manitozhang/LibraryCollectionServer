package com.sample.entity;

/**
 * @Author: 张
 * @Email: 1271396448@qq.com
 * @Date: 2020/11/18
 * @DESC:
 */
public class ExampleListBean {

    private Integer id;
    private String title;
    private String content;
    private String time;

    public ExampleListBean(Integer id, String title, String content, String time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public ExampleListBean setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ExampleListBean setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public ExampleListBean setContent(String content) {
        this.content = content;
        return this;
    }

    public String getTime() {
        return time;
    }

    public ExampleListBean setTime(String time) {
        this.time = time;
        return this;
    }
}
