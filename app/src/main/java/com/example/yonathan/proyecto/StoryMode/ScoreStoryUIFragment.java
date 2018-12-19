package com.example.yonathan.proyecto.StoryMode;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yonathan.proyecto.Board.GoodActivity;
import com.example.yonathan.proyecto.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreStoryUIFragment extends Fragment {

int heart;
    public ScoreStoryUIFragment() {
        // Required empty public constructor
    }

    ImageView heart1,heart2,heart3;
    TextView score;
    int total;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_score_story_ui, container, false);
        score=v.findViewById(R.id.textView3);
        heart1=v.findViewById(R.id.hp1);
        heart2=v.findViewById(R.id.hp2);
        heart3=v.findViewById(R.id.hp3);




        return v;
    }

    public void loseheart(int i){
        heart = heart + i;

        score.setText(String.valueOf(heart));
        if(score.getText().toString().equals("1")){

            heart1.setVisibility(View.GONE);
        }
        if(score.getText().toString().equals("2")){

            heart2.setVisibility(View.GONE);
        }
        if(score.getText().toString().equals("3")){

            heart3.setVisibility(View.GONE);
            
        }

    }

}
