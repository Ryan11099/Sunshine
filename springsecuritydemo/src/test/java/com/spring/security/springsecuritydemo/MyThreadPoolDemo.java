package com.atguigu.sh.juc0615;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @auther zzyy
 * @create 2019-10-14 15:02
 */
public class MyThreadPoolDemo
{
    public static void main(String[] args)
    {
        // 创建线程池
        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        try
        {
            for (int i = 1; i <=10; i++)//模拟n个客户来银行办理业务，提交请求。customer
            {
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务"+new Random().nextInt(10));
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }
}
