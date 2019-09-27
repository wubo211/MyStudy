package com.study.zookeeper.configCenter;

import java.io.Serializable;

/**
 * @Author: wubo
 * @Description:
 * @Date Created in 下午10:23 19/8/8
 **/

public class CommonConfig implements Serializable {
    private String username;
    private String password;

    public CommonConfig() {
    }

    public CommonConfig(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CommonConfig{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
