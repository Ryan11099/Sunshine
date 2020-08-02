package com.sunshine.demo.service.impl;

import com.sunshine.demo.mapper.UserDOMapper;
import com.sunshine.demo.pojo.UserDO;
import com.sunshine.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.ExecutorService;

/**
 * @author yanjh
 * @date 2020/7/28 21:33
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDOMapper userDOMapper;
    @Autowired
    private ExecutorService executorService;

    @Override
    public int insert(UserDO param) {
        for (int i =10; i>=0; i--){
            param.setId(i+1);
            executorService.execute(()->userDOMapper.insertSelective(param));
            System.out.println(Thread.currentThread().getName());
        }
        executorService.shutdown();
        return 0;
    }
}
