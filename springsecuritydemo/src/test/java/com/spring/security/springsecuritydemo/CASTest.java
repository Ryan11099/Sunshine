package com.spring.security.springsecuritydemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author yanjh
 * @date 2020/8/6 20:35
 * 并发原子类
 */
@Slf4j
public class CASTest {
    public static void main(String[] args) {


      /*  AtomicReference<String> ar = new AtomicReference<String>();
        ar.set("hello2");
        //CAS操作更新,如果更新成功返回true，否则返回false
        boolean compareAndSet = ar.compareAndSet("hello2", "hello111");
        boolean compareAndSet1 = ar.compareAndSet(new String("hello2"), "hello111");
        log.info("是否更新成功：{}" + compareAndSet);// True
        log.info("是否更新成功：{}" + compareAndSet1);// False
        System.out.println(ar);*/
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        AtomicStampedReference<Object> atomicStampedReference = new AtomicStampedReference(a, 0);
        /*
         * 第一个参数expectedReference：表示预期值
         * 第二个参数newReference：表示要更新的值
         * 第三个参数expectedStamp：表示预期的时间戳
         * 第四个参数newStamp：表示要更新的时间戳
         * */
        boolean b1 = atomicStampedReference.compareAndSet(a, b, 0, 1);
        log.info("{}", b1);
        log.info("第一次修改过后的数据为{}" + atomicStampedReference);
        System.out.println(a);
         /*
          * 21:35:43.607 [main] INFO  c.s.s.springsecuritydemo.CASTest - true
          * */
        boolean b2 = atomicStampedReference.compareAndSet(c, a, 1, 2);
        log.info("{}", b2);
        log.info("第二次修改过后的数据为{}" + atomicStampedReference);
        System.out.println(b);
        /*
        * 21:36:34.830 [main] INFO  c.s.s.springsecuritydemo.CASTest - true
        * */

        boolean b3 = atomicStampedReference.compareAndSet(a, c, 0, 1);
        log.info("{}", b3);
        log.info("第三次修改过后的数据为{}" + atomicStampedReference);
        System.out.println(c);
        /*
        * 21:36:49.486 [main] INFO  c.s.s.springsecuritydemo.CASTest - false
        * */

    }

    public void useABAStampReference() {


    }
}
