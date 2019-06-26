package com.example.zeynep.bottombar.Activitys;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.zeynep.bottombar.Adapters.OzetAdapter;
import com.example.zeynep.bottombar.Class.MyVolley;
import com.example.zeynep.bottombar.Class.Sepetim;
import com.example.zeynep.bottombar.Model.SepetModel;
import com.example.zeynep.bottombar.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OzetHesap extends AppCompatActivity {

    RecyclerView recyclerView;
    OzetAdapter adapter;
    Sepetim spt=new Sepetim();
    ArrayList<SepetModel> sepetler=new ArrayList<>();
    Context context;
    TextView hesp;
    int fiyat=0;
    Button tamamla;
    Spinner spn;
    String url="http://10.84.14.111:8088/android/siparis_ekle.php";
    ArrayAdapter<CharSequence> adapter1;
    String k="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ozet_hesap);
        recyclerView=(RecyclerView)findViewById(R.id.rccyl) ;
        hesp=findViewById(R.id.ozethesap);
        tamamla=findViewById(R.id.oksiparis);
        spn=findViewById(R.id.spinner2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        context=getApplicationContext();
        adapter1=ArrayAdapter.createFromResource(context,R.array.no,android.R.layout.simple_spinner_item);
        spn.setAdapter(adapter1);



        sepetler=spt.getFavorites(context);
        adapter=new OzetAdapter(context,sepetler);
        recyclerView.setAdapter(adapter);

        for (int i=0;i<sepetler.size();i++){
            fiyat=fiyat+sepetler.get(i).getFiyat()*sepetler.get(i).getPorsiyon();

        }
        hesp.setText(fiyat+"");

        tamamla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i = 0; i<sepetler.size(); i++){

                    k=k+" "+sepetler.get(i).getIsim()+"   "+sepetler.get(i).getPorsiyon()+"---";


                }
                    siparis(spn.getSelectedItem().toString(),k,fiyat);


            }
        });

    }
    public  void siparis(final String masano, final String siparis, final int toplamfiyat){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            JSONObject jsonObject;


                                jsonObject  =jsonArray.getJSONObject(0);

                            Toast.makeText(getApplicationContext(),jsonObject.getString("message"),Toast.LENGTH_LONG).show();

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
                params.put("siparisdetay",siparis);
                params.put("toplamtutar",String.valueOf(toplamfiyat));

                return params;
            }
        };
        MyVolley.getInstance(getApplicationContext()).addToRequestque(stringRequest);


    }
}
