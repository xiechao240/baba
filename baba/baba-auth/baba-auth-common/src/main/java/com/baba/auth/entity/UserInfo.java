package com.baba.auth.entity;

/**
 * 用户信息
 */
public class UserInfo {

    private Long id;

    private String username;

    private Integer exp;

    public UserInfo() {
    }

    public UserInfo(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public UserInfo(Long id, String username, Integer exp) {
        this.id = id;
        this.username = username;
        this.exp = exp;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }
}