package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String DATA = "DATA";
    public static final String SAVED = "SAVED";
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    ArrayList<String> arr = new ArrayList<String>();
    private EditText edtname,edtpass;
    private CheckBox chkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupSharedPrefs();
        setUpViews();

    }
    public void setupSharedPrefs() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }
    public void setUpViews(){
        edtname=findViewById(R.id.edtname);
        edtpass=findViewById(R.id.edtpass);
        chkbox=findViewById(R.id.chkbox);
        Gson gson = new Gson();
        String str = prefs.getString(SAVED, "");
        if (!str.equals("")) {
            User Reg = gson.fromJson(str, User.class);
            edtname.setText(Reg.getName());
            edtpass.setText(Reg.getPass());
        }

    }


    public boolean getRegistiredUsers(User x) {
        Gson gson = new Gson();
        String str = prefs.getString(DATA, "");
        if (!str.equals("")) {
            User[] Reg = gson.fromJson(str, User[].class);

            for (int i = 0; i < Reg.length; i++) {
                if(x.getName().toString().equals(Reg[i].getName().toString())&&
                        x.getPass().toString().equals(Reg[i].getPass().toString())){
                    return true;
                }
            }

        }
        return false;
    }
    public void gotosignupclk(View view) {
        Intent intent=new Intent(MainActivity.this,Signup.class);
        startActivity(intent);
    }

    public void Loginclk(View view) {

        String name=edtname.getText().toString();
        String pass=edtpass.getText().toString();
        if(name.equals("")){
            edtname.setHint("Please Enter Name");
            edtname.setHintTextColor(Color.parseColor("#F00000"));
        }
        if(pass.equals("")){
            edtpass.setHint("Please Enter Password");
            edtpass.setHintTextColor(Color.parseColor("#F00000"));
        }
        if(!name.equals("") && !pass.equals("")){
            User newuser=new User(name,pass);
            if(getRegistiredUsers(newuser)){
                if(chkbox.isChecked()){
                    Gson gson=new Gson();
                    String userString =gson.toJson(newuser);
                    editor.putString(SAVED,userString);
                    editor.commit();
                }
                Toast.makeText(this,"Registered User",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this,Options.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(this,"UnRegistered User",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this,Signup.class);
                startActivity(intent);
            }
        }
    }
}