package com.example.samsung.techinnova;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by samsung on 28-Jul-16.
 */
public class TechInnova extends Activity implements View.OnClickListener {

    Button message, webdesign, software, algorithm, meet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tec);


        message = (Button) findViewById(R.id.message);
        webdesign = (Button) findViewById(R.id.webdesign);
        software = (Button) findViewById(R.id.software);
        algorithm = (Button) findViewById(R.id.algorithm);
        meet = (Button) findViewById(R.id.meet);

        message.setOnClickListener(this);
        webdesign.setOnClickListener(this);
        software.setOnClickListener(this);
        algorithm.setOnClickListener(this);
        meet.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.message:
                startActivity(new Intent( TechInnova.this,LiveNotification.class ));
                break;

            case R.id.webdesign:
                startActivity(new Intent( TechInnova.this,LiveNotification.class ));
                break;


            case R.id.software:
                startActivity(new Intent( TechInnova.this,LiveNotification.class ));
                break;


            case R.id.algorithm:
                startActivity(new Intent( TechInnova.this,LiveNotification.class ));
                break;


            case R.id.meet:
                startActivity(new Intent( TechInnova.this,LiveNotification.class ));
                break;


        }
    }




}