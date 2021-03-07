package com.example.ex5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class MainActivity extends AppCompatActivity {

    private final static String NOM = "nom";
    private final static String PRENOM = "prenom";
    private final static String AGE = "age";
    private final static String TEL = "tel";
    private final static String ID = "id";
    private static Integer ValueID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLifecycle().addObserver(new Observeur());

        if (savedInstanceState != null && savedInstanceState.containsKey(ID) ) {
            ValueID = savedInstanceState.getInt(ID);
            Toast.makeText(this, "id Sauvegardé : " + ValueID.toString(),
                    Toast.LENGTH_SHORT).show();
        }
        else
            genererID();

        if (savedInstanceState != null){

            if(savedInstanceState.containsKey(NOM))
                ((EditText)findViewById(R.id.EditNom))
                        .setText(savedInstanceState.getString(NOM));
            if(savedInstanceState.containsKey(PRENOM))
                ((EditText)findViewById(R.id.EditPrenom))
                        .setText(savedInstanceState.getString(PRENOM));
            if(savedInstanceState.containsKey(AGE))
                ((EditText)findViewById(R.id.EditAge))
                        .setText(savedInstanceState.getString(AGE));
            if(savedInstanceState.containsKey(TEL))
                ((EditText)findViewById(R.id.EditTel))
                        .setText(savedInstanceState.getString(TEL));

        }


        Button btn = findViewById(R.id.Ok);
        btn.setOnClickListener(v -> {

            String nom = ((EditText)findViewById(R.id.EditNom)).getText().toString();
            String prenom = ((EditText)findViewById(R.id.EditPrenom)).getText().toString();
            String age = ((EditText)findViewById(R.id.EditAge)).getText().toString();
            String tel = ((EditText)findViewById(R.id.EditTel)).getText().toString();

            String msg = R.id.EditNomR+":"+nom+"\n"+R.id.EditPrenomR+":"+prenom+"\n"+R.id.EditAgeR+":"+age+"\n"+R.id.EditTelR+":"+tel;

            String FILENAME = nom + ValueID;


            try {
                FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);

                fos.write(msg.getBytes());

                fos.close();
            }
            catch (IOException e) {}



            Intent myIntent = new Intent(MainActivity.this, reponse.class);

            myIntent.putExtra("nom-Fichier",FILENAME);
            MainActivity.this.startActivity(myIntent);
        });


        Button btn2 = findViewById(R.id.affPlanning);
        btn2.setOnClickListener(v -> {
            Intent myIntent = new Intent(MainActivity.this, AffPlaning.class);

            MainActivity.this.startActivity(myIntent);

        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {

        Toast.makeText(this, "Etat de l'activité sauvegardé",
                Toast.LENGTH_SHORT).show();
        String nom = ((EditText)findViewById(R.id.EditNom)).getText().toString();
        String prenom = ((EditText)findViewById(R.id.EditPrenom)).getText().toString();
        String age = ((EditText)findViewById(R.id.EditAge)).getText().toString();
        String tel = ((EditText)findViewById(R.id.EditTel)).getText().toString();

        int id = ValueID;

        ((EditText)findViewById(R.id.Editmdp)).setText("");

        savedInstanceState.putString(NOM, nom);
        savedInstanceState.putString(PRENOM, prenom);
        savedInstanceState.putString(AGE, age);
        savedInstanceState.putString(TEL, tel);

        savedInstanceState.putInt(ID, id);
        super.onSaveInstanceState(savedInstanceState);

    }

    protected void genererID(){
        ValueID = (int)(Math.random() * ( 100 )+ 1);

    }


}
