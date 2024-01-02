package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Options extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }

    public void barcodeclk(View view) {
        Intent intent=new Intent(Options.this, Bored.class);
        startActivity(intent);
    }

    public void memesclk(View view) {
        Intent intent=new Intent(Options.this, Jokes.class);
        startActivity(intent);
    }

    public void adviceclk(View view) {
        Intent intent=new Intent(Options.this, Advice.class);
        startActivity(intent);
    }
}