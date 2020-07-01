package com.sunshine.springboot_shiro.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yanjh
 * @date 2020/7/1 20:48
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private String perms;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }
}
