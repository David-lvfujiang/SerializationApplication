package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.serializationapplication.R;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        final TestReadWriteLock rwd = new TestReadWriteLock();

        //写线程
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rwd.set(finalI);
                }
            }, "Write"+finalI).start();
        }
        //启动10个读线程
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rwd.get();
                }
            },"Read"+i).start();
        }
    }
}
