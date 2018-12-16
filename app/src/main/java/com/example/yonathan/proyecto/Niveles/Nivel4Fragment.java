package com.example.yonathan.proyecto.Niveles;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yonathan.proyecto.R;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class Nivel4Fragment extends Fragment {

    Nivel1Fragment.OnScoreListener onScoreListener;
    public Nivel4Fragment() {
        // Required empty public constructor
    }
    public interface OnScoreListener {
        public void setName(int puntos);
        public  void setMalopuntos(int intentos);
        public void changefragment();
    }

    private int puntos, intentos;
    private Button nop1,nop2,nop3;
EditText res;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_nivel4, container, false);
        nop1=v.findViewById(R.id.op1);

        res = v.findViewById(R.id.txtres4);



               /*


        nop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentos = 1;
                onScoreListener.setMalopuntos(intentos);
                Toast.makeText(getActivity(), "mal", Toast.LENGTH_SHORT).show();

            }
        });
*/
nop1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        if(res.getText().toString().equals("aguila") || res.getText().toString().equals("águila") || res.getText().toString().equals("Águila")) {

                    puntos = 3;
                    onScoreListener.setName(puntos);

                    switch (v.getId()) {
                        case R.id.op1:
                          onScoreListener.changefragment();
                            break;
                    }


        }
        else{
            intentos = 1;
            onScoreListener.setMalopuntos(intentos);
            Toast.makeText(getActivity(), "mal", Toast.LENGTH_SHORT).show();

        }
    }
});



        return v;
    }
    private void changeFragment(){

        switch (1){
            case 0 :{
                getFragmentManager().beginTransaction().replace(R.id.gamecontainer,new Nivel3Fragment()).addToBackStack(null).commit();
                break;
            }
            case 1:{
                getFragmentManager().beginTransaction().replace(R.id.gamecontainer,new Nivel2Fragment()).addToBackStack(null).commit();
                break;
            }
            case 2:{
                getFragmentManager().beginTransaction().replace(R.id.gamecontainer,new Nivel4Fragment()).addToBackStack(null).commit();
                break;
            }
            case 3:{
                getFragmentManager().beginTransaction().replace(R.id.gamecontainer,new Nivel5Fragment()).addToBackStack(null).commit();
                break;
            }
            case 4:{
                getFragmentManager().beginTransaction().replace(R.id.gamecontainer,new Nivel6Fragment()).addToBackStack(null).commit();
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




