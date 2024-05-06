package com.example.android_tictactoe;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_tictactoe.Data.Gamer;
import com.example.android_tictactoe.adapter.UserHighScoreAdapter;

import java.util.ArrayList;
import java.util.List;

public class HighScorePanel extends AppCompatActivity {

    private RecyclerView recyclerView;

    // 2- Data Source
    private List<Gamer> gamerList;

    // 3- Adapter
    private UserHighScoreAdapter gameAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_high_score_panel);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        recyclerView = findViewById(R.id.recyclerView);
        gamerList = new ArrayList<>();

        //Teszt Adatok
        Gamer s1 = new Gamer("Nagy Imre", "Tic-Tac-Toe", 3 , 1);
        Gamer s2 = new Gamer("Szabó Kálmán", "Tic-Tac-Toe", 2, 2);
        Gamer s3 = new Gamer("Magyar Endre", "Tic-Tac-Toe", 2, 2);
        Gamer s4 = new Gamer("Hajnal Evelin", "Tic-Tac-Toe",1,3 );
        Gamer s5 = new Gamer("Moszt Ferenc","Other");

        gamerList.add(s1);
        gamerList.add(s2);
        gamerList.add(s3);
        gamerList.add(s4);
        gamerList.add(s5);


        gameAdapter = new UserHighScoreAdapter(gamerList, "Tic-Tac-Toe");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(gameAdapter);

    }
}