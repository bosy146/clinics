package com.example.clinics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Detalis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalis);
        Intent intent=getIntent();
        String result=intent.getStringExtra("name");
        Toast.makeText(Detalis.this,result,Toast.LENGTH_LONG).show();
    }
}
