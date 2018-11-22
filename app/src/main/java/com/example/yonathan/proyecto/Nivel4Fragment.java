package com.example.yonathan.proyecto;


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
public class Nivel4Fragment extends Fragment {


    public Nivel4Fragment() {
        // Required empty public constructor
    }

    private Button nop1,nop2,nop3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_nivel4, container, false);
        nop1=v.findViewById(R.id.op1);
        nop2=v.findViewById(R.id.op2);
        nop3=v.findViewById(R.id.Op3);

        nop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "mal", Toast.LENGTH_SHORT).show();

            }
        });

        nop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "mal", Toast.LENGTH_SHORT).show();

            }
        });

        nop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case  R.id.Op3:
                        changeFragment();
                        break;
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
                getFragmentManager().beginTransaction().replace(R.id.gamecontainer,new Nivel5Fragment()).addToBackStack(null).commit();
                break;
            }

        }

    }

}
