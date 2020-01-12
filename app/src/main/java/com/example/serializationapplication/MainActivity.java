package com.example.serializationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Receiver1 receiver1;
    Receiver2 receiver2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter1 = new IntentFilter("com.example.leidong.action.OrderedBroadcast");
        receiver1 = new Receiver1();
        intentFilter1.setPriority(1);
        registerReceiver(receiver1, intentFilter1);

        IntentFilter intentFilter2 = new IntentFilter("com.example.leidong.action.OrderedBroadcast");
        receiver2 = new Receiver2();
        intentFilter1.setPriority(0);
        registerReceiver(receiver2, intentFilter2);

        final Intent intent = new Intent("com.example.leidong.action.OrderedBroadcast");
        intent.putExtra("name", "张三");
        sendOrderedBroadcast(intent, null);

        Intent serviceIntent = new Intent();
        intent.setClass(this, MyService.class);
        Connection connection1 =  new Connection();
        Connection connection2 =  new Connection();
        bindService(intent, connection1, BIND_AUTO_CREATE);
        bindService(intent, connection2, BIND_AUTO_CREATE);
    }
public static class Connection implements ServiceConnection{
    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.e("tag", "onServiceConnected");
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        Log.e("tag", "onServiceDisconnected");

    }
}

}
