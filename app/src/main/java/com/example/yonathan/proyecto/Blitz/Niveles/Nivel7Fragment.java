package com.example.yonathan.proyecto.Blitz.Niveles;


import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.yonathan.proyecto.R;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class Nivel7Fragment extends Fragment {
    public interface OnScoreListener{
        public void setName(int puntos);
        public void setMalosPuntos(int intentos);
    }

    Nivel1Fragment.OnScoreListener onScoreListener;


    public Nivel7Fragment() {
        // Required empty public constructor
    }

private Button resp1, resp2;
   private TextView oracion1;
   int puntos,intentos;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_nivel7, container, false);
        oracion1=v.findViewById(R.id.txtn3);
        Typeface Architex = Typeface.createFromAsset(getActivity().getAssets(), "Architex.ttf");

        oracion1.setTypeface(Architex);
        resp1=v.findViewById(R.id.btncor1);
       resp2=v.findViewById(R.id.btncor2);

       resp1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               puntos = 2;
               onScoreListener.setName(puntos);
               switch (v.getId()){

                   case  R.id.btncor1:
                       changeFragment();
                       break;
               }
           }
       });
       resp2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               intentos = 1;
               onScoreListener.setMalopuntos(intentos);
           }
       });

        // Inflate the layout for this fragment
        return v;
    }

    private void changeFragment(){
        Random r = new Random();
        int num = r.nextInt(1);
        switch (num){
            case 0:{
                getFragmentManager().beginTransaction().replace(R.id.gamecontainer,new Nivel8Fragment()).addToBackStack(null).commit();
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
