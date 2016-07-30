package com.example.samsung.techinnova;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by samsung on 30-Jul-16.
 */
public class SupportedBy extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supportby);



        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);



                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    //pDialog.dismiss();
                    Intent intent = new Intent(SupportedBy.this,Login.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }
}
