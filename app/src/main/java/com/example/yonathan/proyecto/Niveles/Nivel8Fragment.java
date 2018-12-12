package com.example.yonathan.proyecto.Niveles;


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

/**
 * A simple {@link Fragment} subclass.
 */
public class Nivel8Fragment extends Fragment {
    public interface OnScoreListener{
        public void setName(int puntos);
        public void setMalosPuntos(int intentos);
    }

    Nivel1Fragment.OnScoreListener onScoreListener;


    public Nivel8Fragment() {
        // Required empty public constructor
    }

private Button resp1, resp2;
   private TextView oracion1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_nivel8, container, false);
        oracion1=v.findViewById(R.id.txtn3);
        Typeface Architex = Typeface.createFromAsset(getActivity().getAssets(), "Architex.ttf");

        oracion1.setTypeface(Architex);
        // Inflate the layout for this fragment
     //   resp1=v.findViewById(R.id.);
       // resp2=v.findViewById(R.id.);
        return v;
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
