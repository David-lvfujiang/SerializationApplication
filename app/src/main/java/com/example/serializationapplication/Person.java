package com.example.serializationapplication;

import java.io.Serializable;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/12/25
 * @Describe:
 */
public class Person implements Serializable {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
