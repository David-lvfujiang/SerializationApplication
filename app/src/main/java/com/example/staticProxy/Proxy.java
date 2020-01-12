package com.example.staticProxy;

import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/12/26
 * @Describe:
 */
public class Proxy implements Subject {
    Subject subject;
    public Proxy(Subject subject) {
        this.subject = subject;
    }
    @Override
    public void handleData1() {
        System.out.println("打印日志上传");
        subject.handleData1();
    }
    @Override
    public void handleData2() {
        System.out.println("打印日志上传");
        subject.handleData1();
    }
    @Override
    public void handleData3() {
        System.out.println("打印日志上传");
        subject.handleData1();
    }
}
