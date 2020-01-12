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
public class Receiver1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String name = intent.getStringExtra("name");
        Log.e("Receiver1", name);
        //终止广播
      //  abortBroadcast();
        Bundle b  = new Bundle();
        b.putString("age","23");
        setResultExtras(b);
    }
}
