package com.example.clinics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main2 );
    }

    public void login(View view) {
        Intent in = new Intent ( this, login.class );
        startActivity ( in );

    }

    public void singin(View view) {
        Intent in = new Intent ( this, sigin.class );
        startActivity ( in );
    }
}
