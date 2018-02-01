package com.example.anushkaweerasekarage.project;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signupSecond extends AppCompatActivity {

    Toolbar signupToolbar;
    private Button createAcc;
    private EditText name;
    private EditText username;
    private EditText email;
    private EditText password;
    private DatabaseHelper dbhelper;
    private SQLiteDatabase newSqlitedb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_second);

        signupToolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(signupToolbar);

        name = (EditText) findViewById(R.id.editText1);
        username = (EditText) findViewById(R.id.editText5);
        email = (EditText) findViewById(R.id.editText3);
        password = (EditText) findViewById(R.id.editText4);
        createAcc = (Button) findViewById(R.id.button3);

        dbhelper = new DatabaseHelper(signupSecond.this, "PIZZADB", null, 1);
        newSqlitedb = dbhelper.getWritableDatabase();

        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Toast.makeText(signupSecond.this, String.valueOf(id), Toast.LENGTH_LONG).show();
                if((email.getText().toString().matches("")) || (password.getText().toString().matches(""))){
                    Toast.makeText(signupSecond.this, "Enter Required Feilds!", Toast.LENGTH_SHORT).show();


                }
                else {
                    ContentValues cv = new ContentValues();
                    cv.put("name", name.getText().toString());
                    cv.put("username", username.getText().toString());
                    cv.put("email", email.getText().toString());
                    cv.put("password", password.getText().toString());
                    long id = newSqlitedb.insert("Customer", null, cv);
                    launchHomePage();
                }
            }
        });

    }

    private void launchHomePage() {

        Intent homepage = new Intent(this, homwWithNav.class);
        startActivity(homepage);
    }
}
