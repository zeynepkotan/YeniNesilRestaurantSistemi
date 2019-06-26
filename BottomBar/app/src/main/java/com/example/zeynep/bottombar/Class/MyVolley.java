package com.example.zeynep.bottombar.Class;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by zeynep on 14.03.2018.
 */

public class MyVolley {

    //bu class volley kĆ¼tĆ¼phanesinin kontrollĆ¼ bir Åekilde Ć§alÄ±ÅmasÄ±nÄ± saÄlÄ±yor
    private static MyVolley mInstance;
    private RequestQueue requestQueue;
    private Context context;
    private MyVolley(Context context){
        this.context=context;
        requestQueue=getRequestQueue();

    }
    public RequestQueue getRequestQueue(){
        if(requestQueue==null)
            requestQueue= Volley.newRequestQueue(context);

        return requestQueue;
    }
    public  static synchronized MyVolley getInstance(Context context){
        if(mInstance==null)
            mInstance=new MyVolley(context);

        return mInstance;
    }
    public  <T> void addToRequestque(Request<T> request){
        requestQueue.add(request);
    }

}
