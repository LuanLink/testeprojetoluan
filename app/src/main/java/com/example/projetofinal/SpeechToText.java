package com.example.projetofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Locale;

public class SpeechToText extends AppCompatActivity {
    Button btnSalvar, btnSairSTT;
    ImageButton btnGravar;
    EditText edtSTT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_to_text);
        getSupportActionBar().hide();

        btnSalvar = findViewById(R.id.btnSalvar);
        btnSairSTT = findViewById(R.id.btnSairSTT);
        btnGravar = findViewById(R.id.btnGravar);
        edtSTT = findViewById(R.id.edtSTT);

        edtSTT.setMovementMethod(new ScrollingMovementMethod());

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gravar();

            }
        });

        btnSairSTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void gravar(){
        Intent iSTT = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        iSTT.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        iSTT.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        iSTT.putExtra(RecognizerIntent.EXTRA_PROMPT, "Fale Agora");
        startActivityForResult(iSTT, 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 10){
            ArrayList<String> detectado = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String texto = detectado.get(0);

            edtSTT.setText(texto);

        }


    }
}