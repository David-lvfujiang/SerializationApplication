package com.example.serializationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class Main2Activity extends AppCompatActivity {

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        Person person = (Person) intent.getSerializableExtra("name");
        Student student =  intent.getParcelableExtra("name1");
        Log.e("TAG",person.getName());
        Log.e("TAG",student.getName());
    }
}
