package com.example.m2registerandlogin;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    EditText fName;
    EditText lName;
    EditText pass;
    EditText email;
    EditText Birthdate;
    Button sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        fName = findViewById(R.id.fName);
        lName = findViewById(R.id.lName);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        Birthdate = findViewById(R.id.Birthdate);
        sign = findViewById(R.id.sign);

        sign.setOnClickListener(new View.OnClickListener() {
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

    void checkDataEntered() {
        if (isEmpty(fName)) {
            fName.setError("First name required");
        }

        if (isEmpty(lName)) {
            lName.setError("Last name required");
        }

        if (!isEmail(email)) {
            email.setError("Email Required");
        }

        if (isEmpty(pass)) {
            pass.setError("Password Required");
        }

        if (isEmpty(Birthdate)) {
            Birthdate.setError("Date of Birth Required");
        }
        else {
            Intent LoginIntent = new Intent (HomePage.this, LoginPage.class);
            startActivity(LoginIntent);
            finish();
        }

    }

}
