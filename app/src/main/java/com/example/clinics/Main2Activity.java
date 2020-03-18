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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {
    EditText emtaxt, password;
    TextView signup, singinedit;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mFirebaseAuth = FirebaseAuth.getInstance();
        emtaxt = findViewById(R.id.emText);
        password = findViewById(R.id.password2);
        signup = findViewById(R.id.signup);
        singinedit=findViewById(R.id.singinedit);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emtaxt.getText().toString();
                String pwd = password.getText().toString();
                if (email.isEmpty()) {
                    emtaxt.setError("please enter your email");
                    emtaxt.requestFocus();
                } else if (pwd.isEmpty()) {
                    password.setError("please enter your password");
                    password.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(Main2Activity.this, "Fieldes Are Empty!", Toast.LENGTH_LONG).show();
                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(Main2Activity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Main2Activity.this, "SignUp Unsuccessful ", Toast.LENGTH_LONG).show();
                            } else {
                                startActivity(new Intent(Main2Activity.this, login.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(Main2Activity.this, "Error Ocurred!", Toast.LENGTH_LONG);

                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in =new Intent(Main2Activity.this,login.class);
                startActivity(in);
            }
        });
    }
}


