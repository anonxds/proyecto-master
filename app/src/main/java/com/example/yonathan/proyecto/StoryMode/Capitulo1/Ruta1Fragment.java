package com.example.yonathan.proyecto.StoryMode.Capitulo1;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yonathan.proyecto.R;
import com.example.yonathan.proyecto.StoryMode.ModelSt;

/**
 * A simple {@link Fragment} subclass.
 */
public class Ruta1Fragment extends Fragment {


    public Ruta1Fragment() {
        // Required empty public constructor
    }
   Page1Fragment.Mod mod;
Button op1,op2,op3;
LinearLayout botones;
    TextView parrafo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ruta1, container, false);
        op1=v.findViewById(R.id.btnruta1op1);
        op2=v.findViewById(R.id.btnruta1Op2);
        op3=v.findViewById(R.id.btnruta1op3);
        botones=v.findViewById(R.id.opciones);
        botones.setVisibility(View.GONE);
        parrafo=v.findViewById(R.id.txtparrafo);

        final Animation anim = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                parrafo.startAnimation(anim);
                parrafo.setText(R.string.Ruta1);
                 mod.gettext(getString(R.string.Ruta1));
            }
        },4000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                botones.setVisibility(View.VISIBLE);
            }
        },6000);
        //acciiones
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FIN();
            }
        });

        return v;
    }
    private void FIN(){
        botones.setVisibility(View.GONE);
        parrafo.setText(getString(R.string.ruta1pregunta3));
    }
    private void Retrocede(){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Page2Fragment ruta2 = new Page2Fragment();
        transaction.replace(R.id.texto, ruta2);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mod= (Page1Fragment.Mod) activity;
        }
        catch (Exception e){}
    }
}
