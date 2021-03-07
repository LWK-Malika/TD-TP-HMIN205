package com.example.tp3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;

public class Planning extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);
        PlanningModel model = ViewModelProviders.of(this).get(PlanningModel.class);
        model.setContext(this);
        model.creerFichier();
        model.accesFichierPlanning();

        final Observer<String> matinObserver= new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {// Update the UI, in thiscase, a TextView.name

                TextView view = ((TextView) findViewById(R.id.matin));
               // view.setText(model.getMatin().getValue());
                view.setText(newName);
            }
        };
        model.getMatin().observe(this, matinObserver);

        final Observer<String> midiObserver= new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {// Update the UI, in thiscase, a TextView.name

                TextView view2 = ((TextView) findViewById(R.id.midi));
                //view2.setText(model.getMidi().getValue());
                view2.setText(newName);
            }
        };
        model.getMidi().observe(this, midiObserver);
        final Observer<String> apremObserver= new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {// Update the UI, in thiscase, a TextView.name

                TextView view3 = ((TextView) findViewById(R.id.aprem));
               // view3.setText(model.getAprem().getValue());
                view3.setText(newName);
            }
        };
        model.getAprem().observe(this, apremObserver);
        final Observer<String> soirObserver= new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {// Update the UI, in thiscase, a TextView.name

                TextView view4 = ((TextView) findViewById(R.id.soir));
                //view4.setText(model.getSoir().getValue());
                view4.setText(newName);
            }
        };
        model.getSoir().observe(this, soirObserver);



    }
}