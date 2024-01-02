package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class Jokes extends AppCompatActivity {
    private TextView txt;
    private RequestQueue queue;
    private static final String API_KEY = "TKKtG9YAHXHVQMxewUs+tA==PppZojtqDx5fexu9";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        setUpViews();
    }
    public void setUpViews(){
        txt=findViewById(R.id.newacttxt);
        queue = Volley.newRequestQueue(this);
    }

    public void clkback(View view) {
        Intent intent=new Intent(Jokes.this,Options.class);
        startActivity(intent);
    }

    public void searchclk(View view) {
        String url = "https://api.api-ninjas.com/v1/jokes?limit=1";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("m012m", "Response: " + response.toString());

                try {
                    int i=0;
                    JSONObject obj=response.getJSONObject(0);
                    String newActivity = obj.getString("joke");

                    String newact ="";
                    newact+=newActivity;
                    System.out.println("ssss:::::::::::::::::ssssss");

                    txt.setText(newact);
                } catch (JSONException e) {
                    Log.d("Volley_error", e.toString());
                    System.out.println("aaaaa:::::::::::::::::aaaaaa");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Volley_error", error.toString());
                System.out.println("eeee:::::::::::::::::eeeeee");
            }
        }){
            // Override the getHeaders method to add custom headers
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<>();
                headers.put("X-Api-Key", API_KEY);
                return headers;
            }
        };

        // Add the request to the request queue
        queue.add(request);
    }
}