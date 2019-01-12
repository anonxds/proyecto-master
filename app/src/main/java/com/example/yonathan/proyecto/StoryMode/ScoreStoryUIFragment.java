package com.example.yonathan.proyecto.StoryMode;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.yonathan.proyecto.MenuActivity;
import com.example.yonathan.proyecto.R;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreStoryUIFragment extends Fragment {

int heart;
int hp=10;
String valor;
ProgressBar hpbar;
    public ScoreStoryUIFragment() {
        // Required empty public constructor
    }


    TextView score,info;

    Button review,salir;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_score_story_ui, container, false);
        score=v.findViewById(R.id.textView3);

        info=v.findViewById(R.id.txthp);
        hpbar=v.findViewById(R.id.Hpbar);
score.setVisibility(View.INVISIBLE);
review=v.findViewById(R.id.btnreview);
        salir=v.findViewById(R.id.btnsalir);
review.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent is = new Intent(getActivity().getBaseContext(),ReviewActivity.class);
        is.putExtra("p1",score.getText().toString());
        startActivity(is);
    }
});
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),MenuActivity.class);
                startActivity(i);
            }
        });

        losehp(heart);
        return v;
    }
    public void gettext(String i){
        score.append(String.valueOf(i)+"\n"+"\n");
    }

    public void loseheart(int i){
        heart = heart + i;

        score.setText(String.valueOf(heart));


    }
    public void losehp(int i){

        hp = i + hp;
        hpbar.setProgress(hp);
        info.setText("Hp:"+String.valueOf(hp));
      //  info.setText(String.valueOf(hp));
//ArrayList<String> arr = new ArrayList<>();
//        for(int is =0;is<=hp;is++){
//           arr.add("▐");
//        }
//        info.setText(String.valueOf(arr));
    }

}
