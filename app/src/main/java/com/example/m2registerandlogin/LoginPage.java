package com.example.m2registerandlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    EditText emaillogin;
    EditText passlogin;
    Button login;
    Button signup;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        emaillogin = findViewById(R.id.emaillogin);
        passlogin = findViewById(R.id.passlogin);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
        t = findViewById(R.id.t);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent (LoginPage.this, HomePage.class);
                startActivity(registerIntent);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }
        });
    }


    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    @SuppressLint("SetTextI18n")
    void checkDataEntered() {
        if (!isEmail(emaillogin)) {
            emaillogin.setError("Please enter your email");
        }

        if (isEmpty(passlogin)) {
            passlogin.setError("Please enter your password");
        }

        else {
            t.setText("Login Successful");
        }

    }
}

