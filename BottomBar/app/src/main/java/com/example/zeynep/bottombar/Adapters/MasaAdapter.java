package com.example.zeynep.bottombar.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.zeynep.bottombar.Activitys.KasaHesap;
import com.example.zeynep.bottombar.R;
import com.example.zeynep.bottombar.Activitys.Siparisler;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.GREEN;


/**
 * Created by zeynep on 27.04.2018.
 */

public class MasaAdapter extends RecyclerView.Adapter<MasaAdapter.MyHolder> {

    Context context;
    int sayi;


    public MasaAdapter(Context context, int sayi,int deger) {
        this.context = context;
        this.sayi = sayi;

    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.masa_item,null);
        MyHolder myHolder=new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        position=position+1;
        holder.btn.setText(""+position);


    }



    @Override
    public int getItemCount() {
        return sayi;
    }


    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Button btn;
        public MyHolder(View itemView) {
            super(itemView);
            btn=itemView.findViewById(R.id.masa);
            btn.setOnClickListener(this);
            //btn.findViewById(R.id.masa);


        }

        @Override
        public void onClick(View v) {
            int id=v.getId();

            switch (id){
                case R.id.masa:

                        Intent inet = new Intent(context, Siparisler.class);
                        inet.putExtra("masa", btn.getText().toString());
                        context.startActivity(inet);



                    break;



            }
        }
    }
}
