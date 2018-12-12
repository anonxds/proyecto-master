package com.example.yonathan.proyecto.Niveles;


import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yonathan.proyecto.R;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class Nivel6Fragment extends Fragment {

    public interface OnScoreListener{
        public void setName(int puntos);
        public void setMalosPuntos(int intentos);
    }

    Nivel1Fragment.OnScoreListener onScoreListener;
    public Nivel6Fragment() {
        // Required empty public constructor
    }

   private EditText resp1;
    private Button confirmar;
    int puntos, intentos;
    TextView or1;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_nivel6, container, false);
        // Inflate the layout for this fragment
        resp1=v.findViewById(R.id.editText);
        confirmar=v.findViewById(R.id.btnconfimar);
        or1=v.findViewById(R.id.or2);
        Typeface Architex = Typeface.createFromAsset(getActivity().getAssets(), "Architex.ttf");
        or1.setTypeface(Architex);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resp1.getText().toString().equals("")){
                    puntos = 20;
                    onScoreListener.setName(puntos);

                    switch (v.getId()){

                        case  R.id.btnconfimar:
                            changeFragment();
                            break;
                    }

                }
                else {
                    intentos = 1;
                    onScoreListener.setMalopuntos(intentos);
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
                getFragmentManager().beginTransaction().replace(R.id.gamecontainer,new Nivel7Fragment()).addToBackStack(null).commit();
                break;
            }
            case 1:{
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
