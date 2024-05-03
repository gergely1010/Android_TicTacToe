package com.example.android_tictactoe;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.android_tictactoe.Data.TicTacToeBoard;

public class GameSide extends AppCompatActivity {

    //Button btnHome, btnAgain;

    private TicTacToeBoard ticTacToeBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game_side);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        Button playAgainBTN = findViewById(R.id.btnPlayAgain);
        Button homeBTN = findViewById(R.id.btnHome);
        TextView txtTitleBTN = findViewById(R.id.textTitle);

        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);

        String[]  playerNames = getIntent().getStringArrayExtra("PLAYER_NAMES");

        ticTacToeBoard = findViewById(R.id.ticTacToe);


        ticTacToeBoard.setUpGame(playAgainBTN, homeBTN, txtTitleBTN, playerNames);

        homeBTN.setOnClickListener(v ->{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });


        playAgainBTN.setOnClickListener(v ->{
            ticTacToeBoard.resetGame();
            ticTacToeBoard.invalidate();
        });
    }
}