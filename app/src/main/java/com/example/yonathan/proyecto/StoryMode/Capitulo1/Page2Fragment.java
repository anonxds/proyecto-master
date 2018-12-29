package com.example.yonathan.proyecto.StoryMode.Capitulo1;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.yonathan.proyecto.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Page2Fragment extends Fragment {


    public Page2Fragment() {
        // Required empty public constructor
    }

LinearLayout opciones;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_page2, container, false);

        opciones= v.findViewById(R.id.botones);
        opciones.setVisibility(View.GONE);


        return v;
    }

}
