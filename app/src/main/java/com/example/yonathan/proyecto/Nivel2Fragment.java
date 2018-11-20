package com.example.yonathan.proyecto;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Nivel2Fragment extends Fragment {
     private Button mop1, mop2,mop3;
    int score,intentos;


    Nivel1Fragment.OnScoreListener onScoreListener;
    public Nivel2Fragment() {
        // Required empty public constructor
    }

    public interface OnScoreListener{
        public void setName(int score);
        public void setMalopuntos(int score);
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_nivel2, container, false);
        // Inflate the layout for this fragment
        mop1=view.findViewById(R.id.btnop1);
        mop2=view.findViewById(R.id.btnop2);
        mop3=view.findViewById(R.id.btnop3);

        mop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mantener el dato numerico en todos los fragmentos
                int intentos = 1;
                onScoreListener.setMalopuntos(intentos);

            }
        });
        mop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
       return view;
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



