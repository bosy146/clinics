package com.example.clinics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class sigin extends AppCompatActivity {
    TextView nameText,phText,emText,pwText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin);
        nameText=findViewById(R.id.nameText);
        phText=findViewById(R.id.phText);
        emText=findViewById(R.id.emtext);
        pwText=findViewById(R.id.pwText);

    }

    public void next(View view) {
        Intent in=new Intent(this,login.class);
        startActivity(in);

    }
}
