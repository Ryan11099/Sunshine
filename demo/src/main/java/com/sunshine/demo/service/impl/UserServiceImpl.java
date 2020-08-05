package com.sunshine.demo.service.impl;

import com.sunshine.demo.mapper.UserDOMapper;
import com.sunshine.demo.pojo.UserDO;
import com.sunshine.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yanjh
 * @date 2020/7/28 21:33
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDOMapper userDOMapper;

    @Override
    public int insert(UserDO param) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                7,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        long beginTime = System.currentTimeMillis();
        System.out.println("开始时间为：" + System.currentTimeMillis());
        for (int i = 0; i <= 300; i++) {
            threadPoolExecutor.execute(() -> {
                param.setPassword(String.valueOf(new Random().nextInt(1000000)) + System.currentTimeMillis());
                userDOMapper.insertSelective(param);
                System.out.println("线程名为：" + Thread.currentThread().getName());
            });
        }
        System.out.println("共用时间为：" + (System.currentTimeMillis() - beginTime));
        threadPoolExecutor.shutdown();
        return 0;
    }
}
