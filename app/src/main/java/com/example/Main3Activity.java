package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.serializationapplication.R;
import com.example.staticProxy.MySubject;
import com.example.staticProxy.Subject;
import com.example.staticProxy.SubjectInvocationHandler;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.Collections.synchronizedMap;


public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //被代理类
        Subject realSubject = new MySubject();
        //我们要代理哪个类，就将该对象传进去，最后是通过该被代理对象来调用其方法的
        SubjectInvocationHandler handler = new SubjectInvocationHandler();
        handler.setRealSubject(realSubject);
        //生成代理类
        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(), handler);
        subject.handleData1();
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        //获取迭代器
        Iterator iterator = list.iterator();
        //历遍集合
        while (iterator.hasNext()) {
            //   Log.e("iterator", iterator.next().toString());
            //移除第一个元素
            // iterator.remove();
        }
        HashMap hashMap = new HashMap<String, String>();
        hashMap.put("one", "1");
        hashMap.put("two", "2");
        Map<String, String> map = Collections.synchronizedMap(hashMap);
        Log.e("iterator", map.get("one"));



    }
}
