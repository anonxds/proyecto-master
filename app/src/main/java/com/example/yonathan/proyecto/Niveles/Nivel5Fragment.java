package com.example.yonathan.proyecto.Niveles;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yonathan.proyecto.R;
import com.example.yonathan.proyecto.Trivia.trivia1Activity;
import com.example.yonathan.proyecto.Trivia.trvia2Activity;

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
TextView oracion,adv;

    Nivel1Fragment.OnScoreListener onScoreListener;
    int puntos, intentos;
    Button conf;
    TextView res;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_nivel5, container, false);

        // Inflate the layout for this fragment
       oracion=v.findViewById(R.id.or2);
       adv=v.findViewById(R.id.adivinanzaultma);
       res=v.findViewById(R.id.editText);
       conf=v.findViewById(R.id.btnconfimar);
        Typeface Architex = Typeface.createFromAsset(getActivity().getAssets(), "Architex.ttf");
        oracion.setTypeface(Architex);
        adv.setTypeface(Architex);


             conf.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
     if(res.getText().toString().equals("corazon")|| res.getText().toString().equals("Corazon")){
         puntos = 20;
         onScoreListener.setName(puntos);
         Intent i = new Intent(getActivity(), trvia2Activity.class);
         startActivity(i);
     }
     else {
         Toast.makeText(getActivity(), "mal", Toast.LENGTH_SHORT).show();

     }
                 }
             });

/*
                switch (v.getId()){

                    case  R.id.op2:
                        changeFragment();
                        break;
                }
                */




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

