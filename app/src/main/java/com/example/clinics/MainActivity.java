package com.example.clinics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

////
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );


        // دا تايمر بينفذ الى جواه  بعد وقت معين بالملي ثانية
        new Handler ().postDelayed ( new Runnable () {
            @Override
            public void run() {
                Intent in = new Intent ( MainActivity.this, Main2Activity.class );
                startActivity ( in );
            }
        }, 3000 );
    }
}
