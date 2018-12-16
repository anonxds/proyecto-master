package com.example.yonathan.proyecto.Niveles;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.os.CountDownTimer;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yonathan.proyecto.BlitzActivity;
import com.example.yonathan.proyecto.R;
import com.example.yonathan.proyecto.Trivia.trivia1Activity;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class Nivel1Fragment extends Fragment {

    private Button mabian, mavian, mhabian;
    private EditText mpal1;
    OnScoreListener onScoreListener;
    int score,intentos;
    private TextView p1;



    private CountDownTimer count;

    private Boolean timerunning;
    private Nivel1Fragment listend;


    public Nivel1Fragment() {
        // Required empty public constructor
    }

    public interface OnScoreListener{
        public void setName(int score);
        public void setMalopuntos(int score);
        public void changefragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_nivel1, container, false);
        // Inflate the layout for this fragment

        mabian=v.findViewById(R.id.btnabian);
        mavian=v.findViewById(R.id.btnavian);
        mhabian=v.findViewById(R.id.btnhabian);
        p1=v.findViewById(R.id.textView5);
        Typeface BLUNT = Typeface.createFromAsset(getActivity().getAssets(), "BLUNT.TTF");
mabian.setTypeface(BLUNT);
mavian.setTypeface(BLUNT);
mhabian.setTypeface(BLUNT);
        Typeface Architex = Typeface.createFromAsset(getActivity().getAssets(), "Architex.ttf");
        p1.setTypeface(Architex);

        p1.setText(Html.fromHtml(getString(R.string.frase1)));


        mabian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentos =1;
                onScoreListener.setMalopuntos(intentos);


                Toast.makeText(getActivity(), "mal", Toast.LENGTH_SHORT).show();


            }
        });

        mavian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentos = 1;

                onScoreListener.setMalopuntos(intentos);
                Intent i = new Intent(getActivity(),trivia1Activity.class);
                startActivity(i);



            }
        });
        mhabian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                score = 5;


                onScoreListener.setName(score);
                switch (v.getId()){
                    case  R.id.btnhabian:
                        onScoreListener.changefragment();
                        break;
                }


            }

        });

        return v;
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

