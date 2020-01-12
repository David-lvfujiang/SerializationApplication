package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.serializationapplication.R;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        final AtomicInteger atomicInteger = new AtomicInteger(100);
        final AtomicStampedReference reference =new AtomicStampedReference(100,0);
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                int result = (int) reference.getReference();
                System.out.println("线程1的预期值"+result);
                Thread.sleep(5000);
               // atomicInteger.addAndGet(-50);
                reference.compareAndSet(reference.getReference(),50,reference.getStamp(),reference.getStamp()+1);
                System.out.println("线程1的新值"+atomicInteger.get());
                return null;
            }
        });

        Future future = service.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                int result = (int) reference.getReference();
                System.out.println("线程2的预期值"+result);
                reference.compareAndSet(reference.getReference(),50,reference.getStamp(),reference.getStamp()+1);
                return null;
            }
        });

        service.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000);
                int result = (int) reference.getReference();
                System.out.println("线程3的预期值"+result);
                reference.compareAndSet(reference.getReference(),100,reference.getStamp(),reference.getStamp()+1);
                return null;
            }

        });

    }
}
