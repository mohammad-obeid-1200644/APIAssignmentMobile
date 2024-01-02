package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Advice extends AppCompatActivity {
    private TextView edtbar;
    private RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice);

    }

    public void clkback(View view) {
        Intent intent=new Intent(Advice.this, Options.class);
        startActivity(intent);
        setUpViews();
    }
    public void setUpViews() {
        edtbar = findViewById(R.id.newacttxt);
        queue = Volley.newRequestQueue(this);
    }

    public void searchclk(View view) {
        Toast.makeText(this,"API is not responding :(",Toast.LENGTH_LONG).show();
        /*
        int x = (int) (Math.random() * (10 - 1 + 1)) + 1;

        String url = "https://api.adviceslip.com/advice/"+x;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("m012mk", "Response: " + response.toString());
                try {
                    if (response.has("slip")) {
                        JSONObject slipObject = response.getJSONObject("slip");
                        if (slipObject.has("advice")) {
                            final String newActivity = slipObject.getString("advice");

                            // Ensure UI operations are on the main thread
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    edtbar.setText(newActivity);
                                }
                            });
                        } else {
                            Log.d("m012mk", "Key 'advice' not found under 'slip' in JSON response");
                        }
                    } else {
                        Log.d("m012mk", "Key 'slip' not found in JSON response");
                    }
                } catch (JSONException e) {
                    Log.d("m012mk", "Error parsing JSON: " + e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("m012mk", error.toString());
                System.out.println("eeee:::::::::::::::::eeeeee");
            }
        });
        queue.add(request);
   */
    }



}