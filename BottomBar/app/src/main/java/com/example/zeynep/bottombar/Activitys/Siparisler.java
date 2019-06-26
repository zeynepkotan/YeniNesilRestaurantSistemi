package com.example.zeynep.bottombar.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.zeynep.bottombar.Class.MyVolley;
import com.example.zeynep.bottombar.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Siparisler extends AppCompatActivity {


    TextView txt;
    Button siparisbitti;
    String masa;


    String url="http://10.84.14.111:8088/android/siparis_cek.php";
    String url1="http://10.84.14.111:8088/android/siparis_sil.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siparisler);
        txt=findViewById(R.id.textView3);
        siparisbitti=findViewById(R.id.button);
        Intent inet=getIntent();
        //txt.setText(inet.getStringExtra("masa"));
        siparisler(inet.getStringExtra("masa"));
        masa=inet.getStringExtra("masa");


        siparisbitti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringRequest stringRequest=new StringRequest(Request.Method.POST, url1,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONArray jsonArray=new JSONArray(response);
                                    JSONObject jsonObject;



                                    jsonObject  =jsonArray.getJSONObject(0);
                                    txt.setText("silindi");



                                } catch (JSONException e) {

                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                    }
                }){

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params=new HashMap<String, String>();
                        params.put("masano",masa);
                        // params.put("siparisdetay",sepetler);
                        // params.put("toplamtutar",String.valueOf(toplamtutar));


                        return params;
                    }
                };
                MyVolley.getInstance(getApplicationContext()).addToRequestque(stringRequest);




            }
        });






    }



    public void siparisler(final String masano){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            JSONObject jsonObject;

                            jsonObject  =jsonArray.getJSONObject(0);
                            txt.setText(jsonObject.getString("siparisdetay"));

                        } catch (JSONException e) {

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        }){


            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<String, String>();
                params.put("masano",masano);



                return params;
            }
        };
        MyVolley.getInstance(getApplicationContext()).addToRequestque(stringRequest);

    }
}
