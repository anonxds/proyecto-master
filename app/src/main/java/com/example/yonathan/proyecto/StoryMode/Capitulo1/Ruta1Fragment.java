package com.example.yonathan.proyecto.StoryMode.Capitulo1;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.app.Fragment;
import android.support.constraint.ConstraintLayout;
import android.text.SpannableStringBuilder;
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
Button op1,op2,op3,op4,op5;
LinearLayout botones,siguiente,botones2;
    TextView parrafo,nombreruta;
    ConstraintLayout next2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ruta1, container, false);
        next2 = v.findViewById(R.id.next2);
        next2.setVisibility(View.GONE);
botones2=v.findViewById(R.id.opciones2);
botones2.setVisibility(View.GONE);
        op1=v.findViewById(R.id.btnruta1op1);
        op2=v.findViewById(R.id.btnruta1Op2);
        op3=v.findViewById(R.id.btnruta1op3);
        op4=v.findViewById(R.id.btnruta1op4);
        op5=v.findViewById(R.id.btnruta1op5);
        botones=v.findViewById(R.id.opciones);
        botones.setVisibility(View.GONE);
        parrafo=v.findViewById(R.id.txtparrafo);
siguiente=v.findViewById(R.id.next);
siguiente.setVisibility(View.GONE);
nombreruta=v.findViewById(R.id.txtruta);
        final Animation anim = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);

nombreruta.setVisibility(View.INVISIBLE);

        final ModelSt[] mparrafo = new ModelSt[]{
                new ModelSt(getString(R.string.ruta1resp2),1),
                new ModelSt(getString(R.string.ruta1parrafo6),2)
        };
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                parrafo.setText(R.string.Ruta1);
                 mod.gettext(getString(R.string.Ruta1));
                parrafo.startAnimation(anim);
            }
        },1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                botones.setVisibility(View.VISIBLE);
            }
        },1000);
        //acciiones
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FIN();
            }
        });
        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrocede();
            }
        });

        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        parrafo.setText("");
                //update();
                botones.setVisibility(View.INVISIBLE);
                siguiente.setVisibility(View.VISIBLE);
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
               index =(index+1)%(mparrafo.length);
            }
        });

        op4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parrafo.setText("");
                nombreruta.setText("pregunta");
                botones2.setVisibility(View.GONE);
                next2.setVisibility(View.VISIBLE);
            }
        });
        op5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next2.setVisibility(View.VISIBLE);
                nombreruta.setText("ira");
parrafo.setText("");
botones2.setVisibility(View.GONE);
//ruta1_1();
            }
        });

     next2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
if(nombreruta.getText().equals("pregunta")) {

    update2();
}
else if(nombreruta.getText().equals("ira")){
    ruta1_1();
}


    }
    });
        return v;
    }

    private void FIN(){
        final Animation anim = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);

        botones.setVisibility(View.GONE);
        mod.gettext(getString(R.string.ruta1pregunta3));
        parrafo.setText(getString(R.string.ruta1pregunta3));
    parrafo.startAnimation(anim);
    }
    private void Retrocede(){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Page2Fragment ruta2 = new Page2Fragment();
        transaction.replace(R.id.texto, ruta2);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private int index = 0;
    private int indice=0;

private void update(){
        ModelSt[] mparrafo = new ModelSt[]{
        new ModelSt(getString(R.string.ruta1resp2),1),
          new ModelSt(getString(R.string.ruta1parrafo6),2),
        };
    final Animation anim = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);

    mod.gettext(mparrafo[index].getParrafo());
        parrafo.setText(mparrafo[index].getParrafo());
        parrafo.startAnimation(anim);
        if(parrafo.getText() == getString(R.string.ruta1parrafo6)){
            siguiente.setVisibility(View.GONE);
botones2.setVisibility(View.VISIBLE);
        }
}

private void update2(){
    ModelSt[] mparrafo = new ModelSt[]{
            new ModelSt(getString(R.string.ruta1parrafo7),1),
        new ModelSt(getString(R.string.ruta1parrafo7_1),2),
      new ModelSt(getString(R.string.ruta1parrafo7_2),3),
      new ModelSt(getString(R.string.ruta1parrafo7_3),4),
      new ModelSt(getString(R.string.ruta1parrafo7_4),5),
            new ModelSt(getString(R.string.rutal1parrafo7_5),6),
            new ModelSt("4",7),
            new ModelSt(getString(R.string.ruta1parrafo8),8),
            new ModelSt(getString(R.string.ruta1parrafoEND),9),


    };
    final Animation anim = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);

    // parrafo.setText(mparrafo[index].getParrafo());
    parrafo.append(mparrafo[index].getParrafo() +"\n"+"\n");
    index =(index+1)%(mparrafo.length);
    mod.gettext(mparrafo[index].getParrafo());
    parrafo.startAnimation(anim);
    if(mparrafo[index].getId() >= 8){

        parrafo.setText(mparrafo[index].getParrafo());
mod.gettext(mparrafo[index].getParrafo());
        parrafo.startAnimation(anim);
    }
    if(mparrafo[index].getId() == 9){
        next2.setVisibility(View.GONE);  //final
    }



}
private void ruta1_1(){
    ModelSt[] mparrafo = new ModelSt[]{
            new ModelSt(getString(R.string.rutal1respuesta2),1),
            new ModelSt(getString(R.string.rutal1respuesta2_1),2),
            new ModelSt("@",3),
            new ModelSt(getString(R.string.ruta1parrafo8),4),
            new ModelSt(getString(R.string.ruta1parrafoEND),5)
    };
    final Animation anim = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);

    parrafo.append(mparrafo[index].getParrafo()+"\n"+"\n");
    index =(index+1)%(mparrafo.length);
    mod.gettext(mparrafo[index].getParrafo());
    parrafo.startAnimation(anim);
    if(mparrafo[index].getId()>=4){
        SpannableStringBuilder span = new SpannableStringBuilder( mparrafo[index].getParrafo());
        span.replace(0,1,"p");
        parrafo.setText("Ya veo y vienes a este lugar para alejarte de esos problemas, en este pueblo, "+span);
         mod.gettext(parrafo.getText().toString());
         parrafo.startAnimation(anim);
    }
    if(mparrafo[index].getId() == 5){
        parrafo.setText(getString(R.string.ruta1parrafoEND));
        next2.setVisibility(View.GONE);  //final
        mod.gettext(parrafo.getText().toString());
        parrafo.startAnimation(anim);
    }
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
