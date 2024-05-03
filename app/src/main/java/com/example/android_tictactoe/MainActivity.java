package com.example.android_tictactoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnQuit, btnStart;
    EditText userName1, userName2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        userName1 = (EditText) findViewById(R.id.editTextFirstName);
        userName2 = (EditText) findViewById(R.id.editTextSecondName);

        btnQuit = findViewById(R.id.btnQuit);
        btnQuit.setOnClickListener(v -> finish());




        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(v ->{
            String name1, name2;
            name1 = userName1.getText().toString();
            name2 = userName2.getText().toString();


            if (name1.matches("") || name2.matches("")) {
                Toast.makeText(this, "You did not enter a name First oe Second player.", Toast.LENGTH_SHORT).show();
                return;
            }
            else
            {

                Intent intent = new Intent(this, GameSide.class);
                intent.putExtra("PLAYER_NAMES", new String[] {name1, name2});
                startActivity(intent);
            }
        });

    }
}