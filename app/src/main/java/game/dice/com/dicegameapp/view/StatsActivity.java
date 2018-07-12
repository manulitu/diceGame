package game.dice.com.dicegameapp.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.GameController;
import game.dice.com.dicegameapp.application.GameDTO;
import game.dice.com.dicegameapp.domain.Game;

public class StatsActivity extends AppCompatActivity {

    LinearLayout scrollableView;
    GameController controller;
    List<String> games;
    ListView text;
    Button backButton;
    Intent intent;
    ArrayAdapter<String> adapter;

    

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = getIntent();
        setContentView(R.layout.stats);
        controller = new GameController();
        scrollableView = (LinearLayout)findViewById(R.id.statsLayout);
        text = (ListView)findViewById(R.id.games_list_view);
        backButton = (Button)findViewById(R.id.button_back_to_games);



        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToGame = new Intent(getBaseContext(), PlaygameActivity.class);
                startActivity(intentToGame);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        games = controller.getPlayerGamesToString();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, games);
        text.setAdapter(adapter);

    }
}
