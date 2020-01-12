package com.example.proxy;

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
        Log.e("TAG",method.getName());
        method.invoke(realSubject, objects);
        return null;
    }
}
