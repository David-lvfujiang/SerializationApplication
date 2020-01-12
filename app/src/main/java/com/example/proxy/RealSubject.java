package com.example.proxy;

import android.util.Log;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/12/26
 * @Describe:
 */
public class RealSubject implements Subject {
    @Override
    public void sayHello(String str) {
        Log.e("TAG",str);
    }
}
