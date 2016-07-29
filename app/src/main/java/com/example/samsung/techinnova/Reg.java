package com.example.samsung.techinnova;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.firebase.client.Firebase;

/**
 * Created by samsung on 27-Jul-16.
 */
public class Reg extends Activity implements AdapterView.OnItemSelectedListener,View.OnClickListener {
    EditText name, year, section, email, contact;
    Button register;

    private Spinner spinner;
    private Spinner spinner1;
    private static final String[] paths = {"Computer Science Engg.", "Information Technology", "Electrical Engg.", "Electrical & communication", "Civil Engg.", "Mechanical Engg."};
    private static final String[] paths1 = {"1st year", "2nd year","3rd year","4 year"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg);
        Firebase.setAndroidContext(this);
//for branch spinner
        spinner = (Spinner) findViewById(R.id.planets_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Reg.this,
                android.R.layout.simple_spinner_item, paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        spinner1 = (Spinner) findViewById(R.id.year_spinner);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Reg.this,
                android.R.layout.simple_spinner_item, paths1);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);

        name = (EditText) findViewById(R.id.name);

        section = (EditText) findViewById(R.id.section);
        email = (EditText) findViewById(R.id.email);
        contact = (EditText) findViewById(R.id.contact);
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(this);
        String text = spinner.getSelectedItem().toString();


    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                String text = spinner.getSelectedItem().toString();
                String text1=spinner1.getSelectedItem().toString();
                String Student_name=name.getText().toString();

                String Section=section.getText().toString();
                String Email_Id=email.getText().toString();
                String Contact=contact.getText().toString();
                if(Student_name.isEmpty()){name.setError("Please Enter Name");}else {name.setError(null);}

                if(Section.isEmpty()){section.setError("Please Enter Section");}else {section.setError(null);}
                if(Email_Id.isEmpty()){email.setError("Please Enter Email Id");}else {email.setError(null);}
                if(Contact.isEmpty()){contact.setError("Please Enter Contact no.");}else {contact.setError(null);}
                if(!Student_name.isEmpty()&&!Section.isEmpty()&&!Email_Id.isEmpty()&&!Contact.isEmpty()){
                    Firebase ref = new Firebase("https://techinnova-7c690.firebaseio.com/");
                   // Firebase fb_to_read = ref.child("students");
                   // Firebase fb_put_child = fb_to_read.push();//REMEMBER THIS FOR PUSH METHOD
                    //Firebase fb_put_child = fb_to_read.child(Email_Id);

                    // Creating object
                    Student student = new Student();
                    student.setName(Student_name);
                    student.setBranch(text);
                    student.setYear(text1);
                    student.setSection(Section);
                    student.setEmail(Email_Id);
                    student.setContact(Contact);

                    ref.child("students").child(Email_Id).setValue(student);
                    Toast.makeText(getBaseContext(), "Successfully Registered ! please login", Toast.LENGTH_LONG).show();

                    //progress dialog
                    final ProgressDialog progressDialog = new ProgressDialog(Reg.this);
                    progressDialog.setMessage("Please wait data is Processing");
                    progressDialog.show();

                    new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            try {
                                Thread.sleep(2000);
                                if (progressDialog.isShowing())
                                    progressDialog.dismiss();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();

                    Toast.makeText(getBaseContext(), "Successfully Registered ! please login", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(Reg.this,Login.class);
                    startActivity(intent);




                    //send data to firebase

                    //next activity
                }

              break;
        }
    }
}