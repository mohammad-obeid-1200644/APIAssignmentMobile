package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Signup extends AppCompatActivity {
    private EditText edtname,edtpass;
    public static final String DATA = "DATA";
    public static final String SAVEDONST = "SAVEDONST";
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    ArrayList<String> arr = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setUpViews();
        setupSharedPrefs();
        checkonstop();
    }

    public void checkonstop(){
        String str=prefs.getString(SAVEDONST,"");
        Gson gson=new Gson();
        User b=gson.fromJson(str,User.class);
        if (!str.equals("")) {
            String []x=str.split(",");
                if(!x[0].toString().equals(""))
                     edtname.setText(b.getName().toString());
                if(!x[1].toString().equals(""))
                     edtpass.setText(b.getPass().toString());
            }
        editor.putString(SAVEDONST,"");
        editor.commit();
    }
    public void setupSharedPrefs() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }
    public void setUpViews(){
        edtname=findViewById(R.id.edtname);
        edtpass=findViewById(R.id.edtpass);
    }

    public void clktxt(View view) {
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
        if(!name.equals("") && !pass.equals("")) {



            Gson gson=new Gson();
            String str=prefs.getString(DATA,"");
            User[] Reg=gson.fromJson(str,User[].class);
            if (Reg == null) {
                Reg = new User[1];
                Reg[0] = new User(name, pass);
            } else {
                User[] newUser = new User[Reg.length + 1];

                for(int i=0;i<Reg.length;i++){
                    newUser[i]=new User(Reg[i].getName(),Reg[i].getPass());
                }
                newUser[Reg.length] = new User(name, pass);
                Reg = newUser;
            }


            String taskSttring =gson.toJson(Reg);
            editor.putString(DATA,taskSttring);
            editor.commit();
            edtname.setText("");
            edtpass.setText("");
            Intent intent=new Intent(Signup.this,Options.class);
            startActivity(intent);
        }

        }

    public void clkback(View view) {
        Intent intent=new Intent(Signup.this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        String name=edtname.getText().toString();
        String pass=edtpass.getText().toString();
        User newuser=new User(name,pass);
        Gson gson=new Gson();
        String x=gson.toJson(newuser);
        Log.d("ommmmm",x);
        editor.putString(SAVEDONST,x);
        editor.commit();
        super.onStop();
    }


}