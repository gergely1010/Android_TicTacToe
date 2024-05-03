package com.example.android_tictactoe;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.android_tictactoe.Data.TicTacToeBoard;

public class GameSide extends AppCompatActivity {

    Button btnHome, btnAgain;

    TicTacToeBoard ticTacToeBoard;

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

        ticTacToeBoard = findViewById(R.id.ticTacToe);

        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(v ->{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        btnAgain = findViewById(R.id.btnPlayAgain);
        btnAgain.setOnClickListener(v ->{
            ticTacToeBoard.resetGame();
            ticTacToeBoard.invalidate();
        });
    }
}