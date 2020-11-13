package com.sample.entity;

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