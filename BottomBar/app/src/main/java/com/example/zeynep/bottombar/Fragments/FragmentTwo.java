package com.example.zeynep.bottombar.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zeynep.bottombar.Adapters.MasaAdapter;
import com.example.zeynep.bottombar.R;


/**
 * A simple {@link Fragment} subclass.
 */

public class FragmentTwo extends Fragment {



    public FragmentTwo() {
        // Required empty public constructor
        //buttons();

    }


    RecyclerView recyclerView;
    MasaAdapter masaAdapter;
    GridLayoutManager gridLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fragment_two, container, false);
        recyclerView=view.findViewById(R.id.recyleer);
        gridLayoutManager=new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        masaAdapter=new MasaAdapter(getContext(),30,0);
        recyclerView.setAdapter(masaAdapter);



        return view;


    }



}
