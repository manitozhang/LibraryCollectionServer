package com.sample.entity;

/**
 * @Author: 张
 * @Email: 1271396448@qq.com
 * @Date: 2020/11/13
 * @DESC: 例子的返回类
 */
public class ExampleBean {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public ExampleBean setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ExampleBean setPassword(String password) {
        this.password = password;
        return this;
    }
}