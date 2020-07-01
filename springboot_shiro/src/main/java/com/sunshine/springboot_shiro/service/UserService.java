package com.sunshine.springboot_shiro.service;

import com.sunshine.springboot_shiro.domain.User;

/**
 * @author yanjh
 * @date 2020/7/1 20:51
 */
public interface UserService {

    public User findByName(String name);

    public User findById(Integer id);
}