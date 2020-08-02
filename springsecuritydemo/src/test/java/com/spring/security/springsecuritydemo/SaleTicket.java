package com.spring.security.springsecuritydemo;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket//资源类
{
    private int number = 30;
    Lock lock = new ReentrantLock();
    public void sale()
    {
        lock.lock();
        try
        {
            if(number > 0)
            {
                System.out.println(Thread.currentThread().getName()+"\t卖出第："+(number--)+"\t 还剩下："+number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

/**
 * 题目：三个售票员     卖出      30张票
 * 目的：如何写出企业级的多线程程序
 *
 *  ** 高内聚，低耦合
 *
 *  1 高内低耦的前提下，线程       操作          资源类
 *
 */
public class SaleTicket
{
    public static void main(String[] args) throws Exception     //main一切程序入口
    {
        Ticket ticket = new Ticket();

//        new Thread(() -> {for (int i = 1; i <=40; i++) ticket.sale();},"A").start();
//        new Thread(() -> {for (int i = 1; i <=40; i++) ticket.sale();},"B").start();
//        new Thread(() -> {for (int i = 1; i <=40; i++) ticket.sale();},"C").start();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 1; i <=30; i++) {
            executorService.submit(() -> {
                ticket.sale();
            });
        }
        executorService.shutdown();


    }
}
