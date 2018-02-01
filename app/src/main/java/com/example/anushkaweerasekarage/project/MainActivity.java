package com.example.anushkaweerasekarage.project;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button signIn;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signIn = (Button) findViewById(R.id.button_signin);
        signUp = (Button) findViewById(R.id.button_signup);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchSigninActivity();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchSignupActivity();
            }
        });
    }

    private void launchSigninActivity() {

        Intent signinIntent = new Intent(this, signIn.class);
        startActivity(signinIntent);
    }

    private void launchSignupActivity() {

        Intent signupIntent = new Intent(this, signupSecond.class);
        startActivity(signupIntent);
    }



}
