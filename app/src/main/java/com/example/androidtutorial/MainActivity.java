package com.example.androidtutorial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidtutorial.androidjetback.AndroidJetback;

public class MainActivity extends AppCompatActivity {

CardView card_android_jetback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home1);
        card_android_jetback=(CardView) findViewById(R.id.card_android_jetback);

        card_android_jetback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 Intent i = new Intent(getApplicationContext(),AndroidJetback.class);
                 startActivity(i);


            }
        });
    }


}