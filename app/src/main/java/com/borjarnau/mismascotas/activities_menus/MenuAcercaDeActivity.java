package com.borjarnau.mismascotas.activities_menus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.borjarnau.mismascotas.R;

/**
 * Created by ArnAu on 27/05/2016.
 */
public class MenuAcercaDeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_acerca_de);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
