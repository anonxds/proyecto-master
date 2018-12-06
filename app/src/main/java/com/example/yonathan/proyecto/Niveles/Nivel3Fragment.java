package com.example.yonathan.proyecto.Niveles;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yonathan.proyecto.R;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class Nivel3Fragment extends Fragment {

    Nivel1Fragment.OnScoreListener onScoreListener;
    public Nivel3Fragment() {
        // Required empty public constructor
    }
    public interface OnScoreListener{
        public void setName(int score);
        public void setMalopuntos(int score);
    }


    private Button mNextl,mNext2;
    private int intentos, puntos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_nivel3, container, false);

        // Inflate the layout for this fragment
        mNextl=v.findViewById(R.id.btncor1);
        mNext2=v.findViewById(R.id.btncor2);
        TextView p2 =v.findViewById(R.id.txtn3);
        p2.setText(Html.fromHtml(getString(R.string.Primeracolm)));


        mNextl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentos = 1;
                onScoreListener.setMalopuntos(intentos);

                Toast.makeText(getActivity(), "mal", Toast.LENGTH_SHORT).show();

            }
        });
        mNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 2;
                onScoreListener.setName(puntos);
                switch (v.getId()){
                    case  R.id.btncor2:
                        changeFragment();
                        break;
                }


            }
        });

        return v;
    }
    private void changeFragment(){
        Random r = new Random();
        int num = r.nextInt(1);
        switch (num){
            case 0:{
                getFragmentManager().beginTransaction().replace(R.id.gamecontainer,new Nivel4Fragment()).addToBackStack(null).commit();
                break;
            }


        }

    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onScoreListener= (Nivel1Fragment.OnScoreListener) activity;
        }
        catch (Exception e){}
    }
}


