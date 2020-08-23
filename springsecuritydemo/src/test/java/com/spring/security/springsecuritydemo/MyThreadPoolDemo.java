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
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                7,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        try
        {
            for (int i = 1; i <=10; i++)//模拟n个客户来银行办理业务，提交请求。customer
            {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadPoolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务"+new Random().nextInt(1000));
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPoolExecutor.shutdown();
        }
    }
}
