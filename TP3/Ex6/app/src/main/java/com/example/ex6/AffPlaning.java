package com.example.ex6;


import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class AffPlaning extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aff_planing);
        PlanningMod plaM = ViewModelProviders.of(this).get(PlanningMod.class);

        plaM.setContext(this);
       // plaM.creerFichier();
       // plaM.accesFichierPlanning();
        plaM.initDatabase();
        plaM.ActualizeDB(0);


        final Observer<String> matinObserver= new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {

                TextView view = ((TextView) findViewById(R.id.matin));

                view.setText(newName);
            }
        };
        plaM.getMatin().observe(this, matinObserver);

        final Observer<String> midiObserver= new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {
                TextView view2 = ((TextView) findViewById(R.id.midi));

                view2.setText(newName);
            }
        };
        plaM.getMidi().observe(this, midiObserver);
        final Observer<String> apremObserver= new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {

                TextView view3 = ((TextView) findViewById(R.id.aprem));

                view3.setText(newName);
            }
        };
        plaM.getAprem().observe(this, apremObserver);
        final Observer<String> soirObserver= new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {

                TextView view4 = ((TextView) findViewById(R.id.soir));

                view4.setText(newName);
            }
        };
        plaM.getSoir().observe(this, soirObserver);



    }
}