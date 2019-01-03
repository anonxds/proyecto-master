package com.example.yonathan.proyecto.StoryMode.Capitulo1;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.constraint.ConstraintLayout;
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
public class Page2Fragment extends Fragment {


    public Page2Fragment() {
        // Required empty public constructor
    }
    Page1Fragment.Mod mod;
    TextView parrafo,ruta;
    int index =0;
    LinearLayout botones,btn2;
    ConstraintLayout siguiente,sig2,background;
    Button op1,op2,op3,op4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_page2, container, false);
       parrafo=v.findViewById(R.id.txtparrafo);
       op1=v.findViewById(R.id.btnruta2op1);
       op2=v.findViewById(R.id.btnruta2op2);
       op3=v.findViewById(R.id.btnop1);
       op4=v.findViewById(R.id.btnop2);

       siguiente=v.findViewById(R.id.next);
      // siguiente.setVisibility(View.GONE);
       ruta=v.findViewById(R.id.txtruta);
        ruta.setVisibility(View.GONE);
       sig2=v.findViewById(R.id.next2);
       sig2.setVisibility(View.GONE);
       botones=v.findViewById(R.id.opciones);
btn2=v.findViewById(R.id.opciones2);
btn2.setVisibility(View.GONE);
       botones.setVisibility(View.GONE);
        background = v.findViewById(R.id.parrafo);
      background.setBackgroundResource(R.drawable.puebo);
        final Animation anim = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);

        final ModelSt[] mParrados = new ModelSt[]{
                new ModelSt(getString(R.string.Ruta2),1),
                new ModelSt(getString(R.string.Ruta2Parrafo6),2),
                new ModelSt(getString(R.string.Ruta2Dialogo1),3)
        };
     //   update();
siguiente.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        update();
    }
});
sig2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
if(ruta.getText().equals("pregunta")){
pregunta();
}
else if(ruta.getText().equals("gema")){
gema();
}
else if(ruta.getText().equals("partir")){
partir();
}
else if(ruta.getText().equals("descanzar")){
descanzar();
}


    }
});
op1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        ruta.setText("pregunta");
      parrafo.setText("");
        botones.setVisibility(View.GONE);
        siguiente.setVisibility(View.GONE);
        sig2.setVisibility(View.VISIBLE);
    }
});
op2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        botones.setVisibility(View.GONE);
        ruta.setText("gema");
        parrafo.setText("");

        siguiente.setVisibility(View.GONE);
        sig2.setVisibility(View.VISIBLE);
    }
});
op3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        parrafo.setText(getString(R.string.ruta2parrafoEND));
        btn2.setVisibility(View.GONE);
        ruta.setText("partir");
sig2.setVisibility(View.VISIBLE);
        mod.gettext(parrafo.getText().toString());
parrafo.startAnimation(anim);
    }
});
op4.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        parrafo.setText(getString(R.string.ruta2parrafo11));
        btn2.setVisibility(View.GONE);
        ruta.setText("descanzar");
sig2.setVisibility(View.INVISIBLE);
        mod.gettext(parrafo.getText().toString());
        parrafo.startAnimation(anim);
    }
});
        return v;
    }
    private void partir(){
        parrafo.setText(getString(R.string.ruta2parrafoEND));
        mod.gettext(parrafo.getText().toString());
        btn2.setVisibility(View.GONE);
    }
    private void descanzar(){
        parrafo.setText(getString(R.string.ruta2parrafo11));
        mod.gettext(parrafo.getText().toString());
        btn2.setVisibility(View.GONE);
    }
    private void update(){
        ModelSt[] mParrados = new ModelSt[]{
                new ModelSt(getString(R.string.Ruta2),1),
                new ModelSt(getString(R.string.Ruta2Parrafo6),2),
                new ModelSt(getString(R.string.Ruta2Dialogo1),3)
        };
        final Animation anim = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
        parrafo.startAnimation(anim);
        mod.gettext(mParrados[index].getParrafo());
        parrafo.setText(mParrados[index].getParrafo());
        index =(index+1)%(mParrados.length);

        if(parrafo.getText() == getString(R.string.Ruta2Dialogo1)){
           botones.setVisibility(View.VISIBLE);
            siguiente.setVisibility(View.GONE);
        }

        switch (mParrados[index].getId()){
            case 2:
               background.setBackgroundResource(R.drawable.niebla2);
                    break;
            case 3:
                background.setBackgroundResource(R.drawable.niebla);
                break;

        }
    }
private int indice = 0;
    private void pregunta(){
        ModelSt[] mparrafo = new ModelSt[]{
          new ModelSt(getString(R.string.ruta2parrafo7),1),
          new ModelSt(getString(R.string.ruta2parrafo7_1),2),
          new ModelSt(getString(R.string.ruta2parrafo7_2),3),
          new ModelSt(getString(R.string.ruta2parrafo8),4),
                new ModelSt(" ",5),
          new ModelSt(getString(R.string.ruta2parrafo9),6),
          new ModelSt(getString(R.string.ruta2parrafo10),7),
          new ModelSt(getString(R.string.ruta2parrafo10_1),8),
          new ModelSt(getString(R.string.ruta2parrafo10_2),9)
        };
        final Animation anim = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
parrafo.startAnimation(anim);
        mod.gettext(mparrafo[indice].getParrafo());
parrafo.append(mparrafo[indice].getParrafo()+"\n"+"\n");
        indice=(indice+1)%(mparrafo.length);

        if(mparrafo[indice].getId() >= 6){
            parrafo.startAnimation(anim);
            parrafo.setText(mparrafo[indice].getParrafo());

          //  mod.gettext(mparrafo[indice].getParrafo());
        }
        if(mparrafo[indice].getId() == 9){
            sig2.setVisibility(View.GONE);
            btn2.setVisibility(View.VISIBLE);
        }

    }
    private void gema(){
        ModelSt[] mparrafo = new ModelSt[]{
                new ModelSt(getString(R.string.ruta2parrafo7_1),2),
                new ModelSt(getString(R.string.ruta2parrafo7_2),3),
                new ModelSt(getString(R.string.ruta2parrafo8),4),
                new ModelSt(" ",5),
                new ModelSt(getString(R.string.ruta2parrafo9),6),
                new ModelSt(getString(R.string.ruta2parrafo10),7),
                new ModelSt(getString(R.string.ruta2parrafo10_1),8),
                new ModelSt(getString(R.string.ruta2parrafo10_2),9)
        };
        final Animation anim = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
parrafo.startAnimation(anim);
        mod.gettext(mparrafo[indice].getParrafo());
        parrafo.append(mparrafo[indice].getParrafo()+"\n"+"\n");
        indice=(indice+1)%(mparrafo.length);

        if(mparrafo[indice].getId() >= 6){
            parrafo.setText(mparrafo[indice].getParrafo());
        //    mod.gettext(mparrafo[indice].getParrafo());
        }
         if(mparrafo[indice].getId() == 9){
          sig2.setVisibility(View.GONE);
          btn2.setVisibility(View.VISIBLE);
        }
    }
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mod= (Page1Fragment.Mod) activity;
        }
        catch (Exception e){}
    }

}
