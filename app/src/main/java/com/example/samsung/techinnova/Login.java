package com.example.samsung.techinnova;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class Login extends Activity implements View.OnClickListener {
    Button login, newuser;
    EditText loginemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Firebase.setAndroidContext(this);

        loginemail = (EditText) findViewById(R.id.loginemail);
        login = (Button) findViewById(R.id.login);
        newuser = (Button) findViewById(R.id.newuser);
        login.setOnClickListener(this);
        newuser.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                String E=loginemail.getText().toString();
                Firebase ref1=new Firebase("https://techinnova-7c690.firebaseio.com/students");

                if(E.isEmpty()){ loginemail.setError("Enter Registered Email Id");  }

            else{

                    loginemail.setError(null);
                ref1.child(E).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        if (snapshot.getValue() != null) {



                            Toast.makeText(getBaseContext(), "Welcome to Tech Innova", Toast.LENGTH_LONG).show();
                            Intent in=new Intent(Login.this,TechInnova.class);
                            startActivity(in);
                        } else {
                            //user does not exist, do something else
                            Toast.makeText(getBaseContext(), "You are not registered", Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onCancelled(FirebaseError arg) {
                    }
                });}



                break;
            case R.id.newuser:
                Intent i=new Intent(Login.this,Reg.class);
                startActivity(i);
                break;


        }
    }
//on back button press
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("No", null).show();
    }

}