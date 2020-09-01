package com.example.projetofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class DigitarText extends AppCompatActivity {
    Button btnOuvir, btnSalvarDT, btnSair;
    EditText edtDT;
    TextToSpeech tts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digitar_text);
        getSupportActionBar().hide();

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if ( i != TextToSpeech.ERROR){
                    tts.setLanguage(Locale.getDefault());
                }

            }
        });

        btnOuvir = findViewById(R.id.btnOuvir);
        btnSalvarDT = findViewById(R.id.btnSalvarDT);
        btnSair = findViewById(R.id.btnSair);
        edtDT = findViewById(R.id.edtDT);

        edtDT.setMovementMethod(new ScrollingMovementMethod());


        btnOuvir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                narrar(edtDT.getText().toString());

            }
        });

        btnSalvarDT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

    }

    private void narrar(String texto){
        tts.speak(texto, TextToSpeech.QUEUE_FLUSH, null);

    }
}