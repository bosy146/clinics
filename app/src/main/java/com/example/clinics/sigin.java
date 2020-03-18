package com.example.clinics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class sigin extends AppCompatActivity {
    EditText nameText, phText, emText, pwText;
    TextView signinedit;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin);
        mFirebaseAuth = FirebaseAuth.getInstance();
        nameText = findViewById(R.id.nameText);
        phText = findViewById(R.id.phText);
        emText = findViewById(R.id.emtext2);
        pwText = findViewById(R.id.pwText);
        signinedit = findViewById(R.id.signinedit);
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();

                if (mFirebaseUser != null) {
                    Toast.makeText(sigin.this, "You are logged in", Toast.LENGTH_LONG).show();
                    Intent in = new Intent(sigin.this, Main2Activity.class);
                    startActivity(in);

                } else {
                    Toast.makeText(sigin.this, "Please Login", Toast.LENGTH_LONG).show();
                }

            }
        };
        signinedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emText.getText().toString();
                String pwd = pwText.getText().toString();
                if (email.isEmpty()) {
                    emText.setError("please enter your email");
                    emText.requestFocus();
                } else if (pwd.isEmpty()) {
                    pwText.setError("please enter your password");
                    pwText.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(sigin.this, "Fieldes Are Empty!", Toast.LENGTH_LONG).show();
                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(sigin.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(sigin.this, "Login Error, Please Login Again", Toast.LENGTH_LONG).show();
                            } else {
                                Intent inToHome = new Intent(sigin.this, login.class);
                                startActivity(inToHome);
                            }
                        }
                    });

                } else {
                    Toast.makeText(sigin.this, "Error Ocurred!", Toast.LENGTH_LONG).show();

                }

            }
        });
        signinedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(sigin.this, Main2Activity.class);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}
