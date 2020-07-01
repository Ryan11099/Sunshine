package com.sunshine.springboot_shiro.service.impl;

import com.sunshine.springboot_shiro.domain.User;
import com.sunshine.springboot_shiro.mapper.UserMapper;
import com.sunshine.springboot_shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author yanjh
 * @date 2020/7/1 20:52
 */
@Service
public class UserServiceImpl implements UserService {

    //注入Mapper接口
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

}