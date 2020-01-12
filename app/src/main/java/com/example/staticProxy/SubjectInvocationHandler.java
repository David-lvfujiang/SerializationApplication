package com.example.staticProxy;

import android.util.Log;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/12/26
 * @Describe:
 */
public class SubjectInvocationHandler implements InvocationHandler {

    Subject realSubject;
    public void setRealSubject(Subject realSubject) {
        this.realSubject = realSubject;
    }
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
       System.out.println("打印日志上传");
        method.invoke(realSubject, objects);
        return null;
    }
}
