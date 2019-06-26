package com.example.zeynep.bottombar.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.zeynep.bottombar.Adapters.IcerikAdapter;
import com.example.zeynep.bottombar.Class.MyVolley;
import com.example.zeynep.bottombar.Model.SepetModel;
import com.example.zeynep.bottombar.Model.icerikmodel;
import com.example.zeynep.bottombar.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Icerik extends AppCompatActivity {


    ArrayList<SepetModel> sepet=new ArrayList<>();
    RecyclerView recyclerView;
    ArrayList<icerikmodel> data=new ArrayList<>();
    String url="http://10.84.14.111:8088/android/urun_cek.php";
    IcerikAdapter adapter;
    Button tamamla,devam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icerik);
     recyclerView=(RecyclerView)findViewById(R.id.rcy) ;
     tamamla=findViewById(R.id.tamamla);
     devam=findViewById(R.id.devam);

     tamamla.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
         startActivity(new Intent(getApplicationContext(),OzetHesap.class));
         }
     });

     devam.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            onBackPressed();

         }
     });

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Intent inet=getIntent();
        final String deger=inet.getStringExtra("deger");

        StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            JSONObject jsonObject;
                            Log.i( "---------",response);
                            for (int i=0;i<jsonArray.length();i++){

                              jsonObject  =jsonArray.getJSONObject(i);
                              data.add(new icerikmodel(jsonObject.getString("urun_id"),jsonObject.getString("urun_adi"),jsonObject.getString("kategori_adi"),jsonObject.getString("fiyat")));

                            }
                            adapter=new IcerikAdapter(getApplicationContext(),data);
                            recyclerView.setAdapter(adapter);




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
                params.put("ktgr_adi",deger);

                return params;
            }
        };
        MyVolley.getInstance(getApplicationContext()).addToRequestque(stringRequest);



    }
}
