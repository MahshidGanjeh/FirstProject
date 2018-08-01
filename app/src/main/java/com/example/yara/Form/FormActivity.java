package com.example.yara.Form;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.yara.R;

public class FormActivity extends AppCompatActivity
        implements Handler {
    String mName,mLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        FirstNameFragment firstName = new FirstNameFragment();
        LastNameFragment lastName = new LastNameFragment();
        SubmitFragment submit = new SubmitFragment();

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.first_fragment, firstName).commit();
        fragmentManager.beginTransaction().add(R.id.second_fragment, lastName).commit();
        fragmentManager.beginTransaction().add(R.id.third_fragment, submit).commit();


    }

    @Override
    public void onSubmit() {
        Toast.makeText(getApplicationContext(),mName + mLastName ,Toast.LENGTH_LONG).show();
    }
    @Override
    public void setTextListener(String type , String name){
        switch (type){
            case ("name"):
                mName = name;
                break;
            case ("last"):
                mLastName = name;
                break;
        }
    }
}

interface Handler {
    public void onSubmit();

    public void setTextListener(String type , String lastName);
}

