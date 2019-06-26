package com.example.zeynep.bottombar.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LoginFragmentKasa.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LoginFragmentKasa#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragmentKasa extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public LoginFragmentKasa() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragmentKasa.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragmentKasa newInstance(String param1, String param2) {
        LoginFragmentKasa fragment = new LoginFragmentKasa();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    EditText klc,sifre;
    Button btn;
    String url="http://10.84.14.111:8088/android/kayit.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login_fragment_kasa, container, false);
        btn=(Button)view.findViewById(R.id.girisbtn);
        klc=(EditText)view.findViewById(R.id.kullaniciadi);
        sifre=(EditText)view.findViewById(R.id.sifre);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONArray jsonArray=new JSONArray(response);
                                    JSONObject jsonObject;
                                    Log.i( "---------",response);
                                    jsonObject  =jsonArray.getJSONObject(0);

                                    if(jsonObject.getString("code").toString().equals("dogru")){
                                        // Toast.makeText(getContext(),jsonObject.getString("message").toString(),Toast.LENGTH_LONG).show();
                                        FragmentThree fragment3 = new FragmentThree();
                                        FragmentTransaction fragmentTransaction3 = getFragmentManager().beginTransaction();
                                        fragmentTransaction3.replace(R.id.fram, fragment3, "FragmentName");
                                        fragmentTransaction3.commit();
                                    }else{

                                        Toast.makeText(getContext(),jsonObject.getString("message").toString(),Toast.LENGTH_LONG).show();
                                    }







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
                        params.put("mail",klc.getText().toString());
                        params.put("sifre",sifre.getText().toString());

                        return params;
                    }
                };
                MyVolley.getInstance(getContext()).addToRequestque(stringRequest);

            }
        });



        return view ;



    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
           // throw new RuntimeException(context.toString()
           //         + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
