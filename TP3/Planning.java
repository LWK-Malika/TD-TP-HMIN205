package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;

public class Planning extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        PlanningService model = ViewModelProviders.of(this).get(PlanningService.class);


        TextView view = ((TextView) findViewById(R.id.matin));
        view.setText(model.getMatin());
        TextView view2 = ((TextView) findViewById(R.id.midi));
        view2.setText(model.getMidi());
        TextView view3 = ((TextView) findViewById(R.id.aprem));
        view3.setText(model.getAprem());
        TextView view4 = ((TextView) findViewById(R.id.soir));
        view4.setText(model.getSoir());

    }
}