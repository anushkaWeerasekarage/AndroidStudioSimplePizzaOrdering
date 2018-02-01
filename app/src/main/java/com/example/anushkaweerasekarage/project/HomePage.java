package com.example.anushkaweerasekarage.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

public class HomePage extends AppCompatActivity {

    private Toolbar homeToolbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cartoption, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        homeToolbar = (Toolbar) findViewById(R.id.htoolbar2);
        setSupportActionBar(homeToolbar);



    }
}
