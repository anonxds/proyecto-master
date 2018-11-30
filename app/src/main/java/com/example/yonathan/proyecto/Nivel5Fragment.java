package com.example.yonathan.proyecto;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class Nivel5Fragment extends Fragment {


    public Nivel5Fragment() {
        // Required empty public constructor
    }
    public interface OnScoreListener{
        public void setName(int puntos);
        public void setMalosPuntos(int intentos);
    }

    private Button mop1,mop2,mop3;
    Nivel1Fragment.OnScoreListener onScoreListener;
    int puntos, intentos;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_nivel5, container, false);
        // Inflate the layout for this fragment
        mop1=v.findViewById(R.id.op1);
        mop2=v.findViewById(R.id.op2);
        mop3=v.findViewById(R.id.op3);

        mop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentos = 1;
                onScoreListener.setMalopuntos(intentos);
                Toast.makeText(getActivity(), "mal", Toast.LENGTH_SHORT).show();


            }
        });

        mop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()){

                    case  R.id.op2:
                        changeFragment();
                        break;
                }
            }
        });

        mop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentos = 1;
                onScoreListener.setMalopuntos(intentos);
            }
        });

        return v;
    }
    private void changeFragment(){
        Random r = new Random();
        int num = r.nextInt(2);
        switch (num){
            case 0:{
                getFragmentManager().beginTransaction().replace(R.id.gamecontainer,new Nivel2Fragment()).addToBackStack(null).commit();
                break;
            }
            case 1:{
                getFragmentManager().beginTransaction().replace(R.id.gamecontainer,new Nivel1Fragment()).addToBackStack(null).commit();
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

