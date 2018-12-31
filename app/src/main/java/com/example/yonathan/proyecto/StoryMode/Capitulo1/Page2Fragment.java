package com.example.yonathan.proyecto.StoryMode.Capitulo1;


import android.os.Bundle;
import android.app.Fragment;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    TextView parrafo;
    int index =0;
    ConstraintLayout siguiente;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_page2, container, false);
       parrafo=v.findViewById(R.id.txtparrafo);
       siguiente=v.findViewById(R.id.next);
        final ModelSt[] mParrados = new ModelSt[]{
                new ModelSt(getString(R.string.Ruta2),1),
                new ModelSt(getString(R.string.Ruta2Parrafo6),2),
                new ModelSt(getString(R.string.Ruta2Dialogo1),3)
        };
        update();
siguiente.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        index =(index+1)%(mParrados.length);
        update();
    }
});
        return v;
    }
    private void update(){
        ModelSt[] mParrados = new ModelSt[]{
                new ModelSt(getString(R.string.Ruta2),1),
                new ModelSt(getString(R.string.Ruta2Parrafo6),2),
                new ModelSt(getString(R.string.Ruta2Dialogo1),3)
        };
        parrafo.setText(mParrados[index].getParrafo());
        if(parrafo.getText() == getString(R.string.Ruta2Dialogo1)){
            siguiente.setVisibility(View.GONE);
        }
    }

}
