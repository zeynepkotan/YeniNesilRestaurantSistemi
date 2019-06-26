package com.example.zeynep.bottombar.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zeynep.bottombar.R;
import com.example.zeynep.bottombar.Model.SepetModel;
import com.example.zeynep.bottombar.Class.Sepetim;
import com.example.zeynep.bottombar.Model.icerikmodel;

import java.util.ArrayList;

/**
 * Created by zeynep on 14.03.2018.
 */

public class IcerikAdapter extends RecyclerView.Adapter<IcerikAdapter.MyViewHolder> {

Context context;
ArrayList<icerikmodel> data;

Sepetim spt=new Sepetim();
LayoutInflater inflater;
    public IcerikAdapter(Context context, ArrayList<icerikmodel> data) {
        this.context = context;
        this.data = data;

        notifyItemRangeChanged(0,data.size());
        inflater=LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.urun_item,parent,false);
        MyViewHolder holder=new MyViewHolder(view,viewType);


        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        icerikmodel model=data.get(position);
        holder.urun_adi.setText(model.getUrun_adi());
        holder.fiyat.setText(model.getFiyat()+" Tl");

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView urun_adi,fiyat;
        Spinner spinner;
        Button ekle;
        ArrayAdapter<CharSequence> adapter;

        public MyViewHolder(View itemView,int positions)

        {
            super(itemView);
            urun_adi=(TextView)itemView.findViewById(R.id.urun_adi);
            fiyat=(TextView)itemView.findViewById(R.id.fiyat);
            ekle=(Button)itemView.findViewById(R.id.ekle);
            spinner=(Spinner) itemView.findViewById(R.id.spinner);
            adapter=ArrayAdapter.createFromResource(context,R.array.prs,android.R.layout.simple_spinner_item);
            spinner.setAdapter(adapter);
            ekle.setOnClickListener(this);



        }

        @Override
        public void onClick(View v) {
            int positions=getAdapterPosition();
            icerikmodel icerikmodel=data.get(positions);
            int id=v.getId();
            switch (id){
                case R.id.ekle:

                    spt.addFavorite(context,new SepetModel(Integer.parseInt(spinner.getSelectedItem().toString()),urun_adi.getText().toString(),Integer.parseInt(icerikmodel.getFiyat().toString()),Integer.parseInt(icerikmodel.getUrun_id())));
                    Toast.makeText(context,urun_adi.getText().toString()+" fiyat "+Double.parseDouble(icerikmodel.getFiyat().toString())*Double.parseDouble(spinner.getSelectedItem().toString()),Toast.LENGTH_LONG).show();
                    break;

            }

        }
    }
}
