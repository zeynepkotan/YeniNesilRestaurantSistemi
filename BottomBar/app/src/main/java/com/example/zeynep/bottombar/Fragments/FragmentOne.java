package com.example.zeynep.bottombar.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.zeynep.bottombar.Activitys.Icerik;
import com.example.zeynep.bottombar.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment implements View.OnClickListener{


    public FragmentOne() {
        // Required empty public constructor
    }


    Button et,dnr,slt,khvlt,tatli,icecek;
    Intent inet;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_fragment_one, container, false);

        et=(Button)view.findViewById(R.id.spinner2);
        dnr=(Button)view.findViewById(R.id.döner);
        slt=(Button)view.findViewById(R.id.salata);
        khvlt=(Button)view.findViewById(R.id.kahvalti);
        tatli=(Button)view.findViewById(R.id.tatli);
        icecek=(Button)view.findViewById(R.id.icecekler);
        et.setOnClickListener(this);
        dnr.setOnClickListener(this);
        slt.setOnClickListener(this);
        khvlt.setOnClickListener(this);
        tatli.setOnClickListener(this);
        icecek.setOnClickListener(this);
        inet=new Intent(getContext(),Icerik.class);





        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.spinner2:
                inet.putExtra("deger","et");
                startActivity(inet);

                break;
            case R.id.döner:

                inet.putExtra("deger","dnr1");
                startActivity(inet);
                break;
            case R.id.salata:
                inet.putExtra("deger","salata");
                startActivity(inet);

                break;
            case R.id.kahvalti:

                inet.putExtra("deger","kahvalti");
                startActivity(inet);
                break;
            case R.id.tatli:
                inet.putExtra("deger","tatli");
                startActivity(inet);

                break;
            case R.id.icecekler:
                inet.putExtra("deger","icecek");
                startActivity(inet);

                break;

                default:


                    Toast.makeText(getContext(),"bişeyler ters gitti",Toast.LENGTH_LONG).show();
                    break;


        }


    }
}
