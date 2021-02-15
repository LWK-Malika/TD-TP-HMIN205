package com.example.exo8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button rechercher;
    EditText TextD, TextA ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rechercher = (Button) findViewById(R.id.submit);
        rechercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextD = (EditText) findViewById(R.id.saisieDepart);
                TextA = (EditText) findViewById(R.id.saisieArrivee);

                Intent intention = new Intent(MainActivity.this, Resultat.class);

                String r = TextD.getText().toString();
                intention.putExtra("Depart",r);

                r = TextA.getText().toString();
                intention.putExtra("Arrivee",r);

                MainActivity.this.startActivity(intention);


            }
        });





    }
}