package com.example.yonathan.proyecto;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class Nivel1Fragment extends Fragment {

    private Button mabian, mavian, mhabian;
    private EditText mpal1;
    OnScoreListener onScoreListener;
    int score,intentos;



    private CountDownTimer count;
    private long millosencond = 10000;
    private Boolean timerunning;
    private Nivel1Fragment listend;


    public Nivel1Fragment() {
        // Required empty public constructor
    }

    public interface OnScoreListener{
        public void setName(int score);
        public void setMalopuntos(int score);
    }







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_nivel1, container, false);
        // Inflate the layout for this fragment

        mabian=v.findViewById(R.id.btnabian);
        mavian=v.findViewById(R.id.btnavian);
        mhabian=v.findViewById(R.id.btnhabian);




        mabian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // mpal1.setText("abian");
                if(mpal1.getText().toString().equals("abian")){
                      //   mal.show();

              //      intentos = 1 + intentos;
                       intentos =1;
                    onScoreListener.setMalopuntos(intentos);


                    Toast.makeText(getActivity(), "mal", Toast.LENGTH_SHORT).show();

                }
            }
        });

        mavian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mpal1.setText("avian");
                if(mpal1.getText().toString().equals("avian")){

                    intentos = 1;

                    onScoreListener.setMalopuntos(intentos);


                }
            }
        });
        mhabian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mpal1.setText("habian");
                if(mpal1.getText().toString().equals("habian")){
                    //        correct.show();

                    score = 5;

                    onScoreListener.setName(score);
                    switch (v.getId()){
                        case  R.id.btnhabian:
                        changeFragment();
                        break;
                    }


                }
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
                getFragmentManager().beginTransaction().replace(R.id.gamecontainer,new Nivel4Fragment()).addToBackStack(null).commit();
                break;
            }

        }

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onScoreListener= (OnScoreListener) activity;
        }
    catch (Exception e){}
    }
}
