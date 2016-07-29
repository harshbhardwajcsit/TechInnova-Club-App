package com.example.samsung.techinnova;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(5000);



                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    //pDialog.dismiss();
                    Intent intent = new Intent(MainActivity.this,TechInnova.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }
    }

