package com.example.zeynep.bottombar.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zeynep.bottombar.Adapters.MasaAdapter;
import com.example.zeynep.bottombar.Adapters.MasaAdapterKasa;
import com.example.zeynep.bottombar.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentThree extends Fragment {


    public FragmentThree() {
        // Required empty public constructor
    }
    RecyclerView recyclerView;
    MasaAdapterKasa masaAdapterKasa;
    GridLayoutManager gridLayoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fragment_three, container, false);
        recyclerView=view.findViewById(R.id.recyleer);
        gridLayoutManager=new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        masaAdapterKasa=new MasaAdapterKasa(getContext(),30,1);
        recyclerView.setAdapter(masaAdapterKasa);

        return view;
    }


}
