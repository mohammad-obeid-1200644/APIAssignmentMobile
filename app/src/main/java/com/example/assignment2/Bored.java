package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Bored extends AppCompatActivity {
    private TextView edtbar;
    private RequestQueue queue;
    private Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bored);
        setUpViews();  // Call the method to initialize views
    }

    public void setUpViews() {
        edtbar = findViewById(R.id.newacttxt);
        queue = Volley.newRequestQueue(this);
        spn=findViewById(R.id.spn);
    }

    public void searchclk(View view) {
        String url = "https://www.boredapi.com/api/activity/?participants="+spn.getSelectedItem().toString();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("m012m", "Response: " + response.toString());

                try {
                    // Use the correct key to get the value
                    String newActivity = response.getString("activity");

                    String newact ="";
                    newact+=newActivity;
                    System.out.println("ssss:::::::::::::::::ssssss");

                    edtbar.setText(newact);
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
        });

        // Add the request to the request queue
        queue.add(request);
    }

    public void clkback(View view) {
        Intent intent=new Intent(Bored.this,Options.class);
        startActivity(intent);
    }
}
