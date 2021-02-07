package com.example.exo8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Resultat extends AppCompatActivity {

    ArrayList<Train> Trains = new ArrayList<Train>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);

        Train train1 = new Train("Toulouse","Montpellier",9,"9h05");
        Train train2 = new Train("Montpellier","Toulouse",13,"10h20");

        Train train3 = new Train("Paris","Montpellier",15,"8h15");

        Train train4 = new Train("Montpellier","Paris",7,"6h30");
        Train train5 = new Train("Montpellier","Paris",5,"13h45");


        Trains.add(train1);
        Trains.add(train2);
        Trains.add(train3);
        Trains.add(train4);
        Trains.add(train5);


        Intent intent = this.getIntent();
        String depart = intent.getStringExtra("Depart");
        String arrivee = intent.getStringExtra("Arrivee");

        boolean test = false;
        for (int i=0; i<Trains.size(); i++){

            if(Trains.get(i).Depart.equals(depart) && Trains.get(i).Arrivee.equals(arrivee) ){
                LinearLayout li = (LinearLayout) findViewById(R.id.MonLay);
                TextView t = new TextView(this);

                t.setText(" Horraire : "+ Trains.get(i).Heure + "\n Numero Train: "+Trains.get(i).Num+" Depart: "+Trains.get(i).Depart+" Arrivée: "+Trains.get(i).Arrivee
                        +"\n");

                li.addView(t);
                test=true;
            }
        }

        if (test == false){
            LinearLayout li = (LinearLayout) findViewById(R.id.MonLay);
            TextView t = new TextView(this);
            t.setText("Aucun Résultat ! Essayer avec Toulouse, Montpellier ou Paris");
            li.addView(t);
        }


    }
}