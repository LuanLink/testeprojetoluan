package com.example.projetofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnSTT, btnDT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btnSTT = findViewById(R.id.btnSTT);
        btnDT = findViewById(R.id.btnDT);

        btnSTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirSTT();

            }
        });

        btnDT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirDT();

            }
        });

    }

    private void abrirSTT(){
        Intent abrir = new Intent(this, SpeechToText.class);
        startActivity(abrir);
    }
    private void abrirDT(){
        Intent abrir = new Intent(this, DigitarText.class);
        startActivity(abrir);
    }
}