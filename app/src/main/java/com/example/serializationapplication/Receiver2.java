package com.example.serializationapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/12/25
 * @Describe:
 */
public class Receiver2  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String name = intent.getStringExtra("name");
        Log.e("Receiver2", name);
      Bundle bundle =  getResultExtras(true);
        Log.e("Receiver2", bundle.getString("age"));

    }
}