package com.example.staticProxy;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/12/26
 * @Describe:
 */
public class MySubject implements Subject {
    @Override
    public void handleData1() {
        System.out.println("业务1");
    }

    @Override
    public void handleData2() {
        System.out.println("业务3");
    }

    @Override
    public void handleData3() {
        System.out.println("业务3");
    }
}
