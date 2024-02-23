package com.example.androidtutorial.androidjetback;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.example.androidtutorial.R;

public class AndroidJetback extends Activity {
    CardView card_room,card_workmanager,card_lifecycle,card_viewmodel,card_navigation,card_livedata,card_paging,card_databinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home1);
        card_room=(CardView) findViewById(R.id.card_room);
        card_workmanager=(CardView) findViewById(R.id.card_workmanager);
        card_lifecycle=(CardView) findViewById(R.id.card_lifecycle);
        card_viewmodel=(CardView) findViewById(R.id.card_viewmodel);
        card_navigation=(CardView) findViewById(R.id.card_navigation);
        card_livedata=(CardView) findViewById(R.id.card_livedata);
        card_paging=(CardView) findViewById(R.id.card_paging);
        card_databinding=(CardView) findViewById(R.id.card_databinding);



    }
}
