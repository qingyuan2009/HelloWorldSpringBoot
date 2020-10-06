package com.rui.demo.service;

import java.util.Random;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class AsyncServiceImpl implements AsyncService {

    private static Random random = new Random();
    
    @Async  //异步执行
    @Override
    public Future<String> doTask1() throws Exception {
        System.out.println("任务一开始执行");
        long start=System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end=System.currentTimeMillis();
        System.out.println("任务一结束，耗时：" + (end - start) + " 毫秒");        
        return new AsyncResult<>("任务一结束");
    }

    @Async
    @Override
    public Future<String> doTask2() throws Exception {
        System.out.println("任务二开始执行");
        long start=System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end=System.currentTimeMillis();
        System.out.println("任务二结束，耗时：" + (end - start) + " 毫秒");        
        return new AsyncResult<>("任务二结束");
    }

    @Async
    @Override
    public Future<String> doTask3() throws Exception {
        System.out.println("任务三开始执行");
        long start=System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end=System.currentTimeMillis();
        System.out.println("任务三结束，耗时：" + (end - start) + " 毫秒");        
        return new AsyncResult<>("任务三结束");
    }

}
