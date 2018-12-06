package com.example.yonathan.proyecto.Niveles;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
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
public class Nivel2Fragment extends Fragment {
    private Button mop1, mop2,mop3;
    int score,intentos;
    private TextView p2;



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
        p2=view.findViewById(R.id.textView);

        p2.setText(Html.fromHtml(getString(R.string.frase1)));



        mop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mantener el dato numerico en todos los fragmentos
                intentos = 1;
                onScoreListener.setMalopuntos(intentos);
                Toast.makeText(getActivity(), "mal", Toast.LENGTH_SHORT).show();


            }
        });
        mop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentos = 1;
                onScoreListener.setMalopuntos(intentos);
                Toast.makeText(getActivity(), "mal", Toast.LENGTH_SHORT).show();

            }
        });
        mop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score  = 5;
                onScoreListener.setName(score);
                switch (v.getId()){
                    case  R.id.btnop3:
                        changeFragment();
                        break;
                }



            }
        });
        return view;
    }
    private void changeFragment(){
        Random r = new Random();
        int num = r.nextInt(1);
        switch (num){
            case 0:{
                getFragmentManager().beginTransaction().replace(R.id.gamecontainer,new Nivel5Fragment()).addToBackStack(null).commit();
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




