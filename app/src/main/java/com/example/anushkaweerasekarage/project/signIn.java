package com.example.anushkaweerasekarage.project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signIn extends AppCompatActivity {

    private Toolbar signinToolbar;
    private Button secondSignup;
    private Button signinbutton;
    private EditText userEmail;
    private EditText userPassword;
    private DatabaseHelper dbhelper;
    private SQLiteDatabase Sqlitedb;
    String uEmail;
    String passwrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signinToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(signinToolbar);

        secondSignup = (Button) findViewById(R.id.button2);
        signinbutton = (Button) findViewById(R.id.button);
        userEmail = (EditText) findViewById(R.id.editText);
        userPassword = (EditText) findViewById(R.id.editText2);

        dbhelper = new DatabaseHelper(signIn.this, "PIZZADB", null, 1);
        Sqlitedb = dbhelper.getReadableDatabase();

        signinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                uEmail = userEmail.getText().toString();
                passwrd = userPassword.getText().toString();

                    if(uEmail.toString().matches("") || (passwrd.toString().matches(""))) {
                        Toast.makeText(signIn.this, "Enter Email & Password", Toast.LENGTH_SHORT).show();
                    }

                    else if (getLoginInfo(uEmail).equals(passwrd) ) {

                        launchHome();
                        //Toast.makeText(signIn.this, "Welcome", Toast.LENGTH_LONG).show();
                    }

                    else {
                        Toast.makeText(signIn.this, "Invalid Login", Toast.LENGTH_LONG).show();
                    }

                }

        });

        secondSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchSecondSignup();
            }
        });
    }

    private void launchSecondSignup() {

        Intent signupIntent2 = new Intent(this, signupSecond.class);
        startActivity(signupIntent2);
    }

    private String getLoginInfo(String username) {



        Cursor c = Sqlitedb.query("Customer", null, "email=?", new String[]{uEmail}, null, null, null, null);
        if(c.getCount()<1) // UserName Not Exist
        {
            return "NOT EXIST";
        }

            c.moveToFirst();
            String password = c.getString(c.getColumnIndex("password"));

        return password;
    }

    private void launchHome() {

        Intent hpage = new Intent(this, homwWithNav.class);
        startActivity(hpage);
    }
}
