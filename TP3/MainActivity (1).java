package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity  {

    private final static String NOM = "nom";
    private final static String PRENOM = "prenom";
    private final static String AGE = "age";
    private final static String TEL = "tel";
    private final static String ID = "id";
    private static Integer ValueID = 0;

    private String TAG = this.getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "Owner ON_CREATE");
        getLifecycle().addObserver(new MainActivityObserver());

        if (savedInstanceState != null && savedInstanceState.containsKey(ID) ) {
            ValueID = savedInstanceState.getInt(ID);
            Toast.makeText(this, "id Restaurer : " + ValueID.toString(),
                    Toast.LENGTH_SHORT).show();
        }
        else
            genereID();

        if (savedInstanceState != null){

            if(savedInstanceState.containsKey(NOM))
            ((EditText)findViewById(R.id.saisiNom))
                    .setText(savedInstanceState.getString(NOM));
            if(savedInstanceState.containsKey(PRENOM))
                ((EditText)findViewById(R.id.saisiPrenom))
                        .setText(savedInstanceState.getString(PRENOM));
            if(savedInstanceState.containsKey(AGE))
                ((EditText)findViewById(R.id.saisiAge))
                        .setText(savedInstanceState.getString(AGE));
            if(savedInstanceState.containsKey(TEL))
                ((EditText)findViewById(R.id.saisiTel))
                        .setText(savedInstanceState.getString(TEL));

        }

        Button btn = findViewById(R.id.submit);
        btn.setOnClickListener(v -> {

            String nom = ((EditText)findViewById(R.id.saisiNom)).getText().toString();
            String prenom = ((EditText)findViewById(R.id.saisiPrenom)).getText().toString();
            String age = ((EditText)findViewById(R.id.saisiAge)).getText().toString();
            String tel = ((EditText)findViewById(R.id.saisiTel)).getText().toString();

            String msg = R.id.saisiNom2+";;;"+nom+"\n"+R.id.saisiPrenom2+";;;"+prenom+"\n"+R.id.saisiAge2+";;;"+age+"\n"+R.id.saisiTel2+";;;"+tel;

            String FILENAME = nom + ValueID;


            try {
                FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);

                fos.write(msg.getBytes());

                fos.close();
                }
            catch (IOException e) {}



            Intent myIntent = new Intent(MainActivity.this, Resultat.class);

            myIntent.putExtra("nameFile",FILENAME);
            MainActivity.this.startActivity(myIntent);
        });


        Button btn2 = findViewById(R.id.planning);
        btn2.setOnClickListener(v -> {
            Intent myIntent = new Intent(MainActivity.this, Planning.class);

            MainActivity.this.startActivity(myIntent);

        });


    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {

        Toast.makeText(this, "Etat de l'activité sauvegardé",
                Toast.LENGTH_SHORT).show();
        String nom = ((EditText)findViewById(R.id.saisiNom)).getText().toString();
        String prenom = ((EditText)findViewById(R.id.saisiPrenom)).getText().toString();
        String age = ((EditText)findViewById(R.id.saisiAge)).getText().toString();
        String tel = ((EditText)findViewById(R.id.saisiTel)).getText().toString();

        int id = ValueID;

        ((EditText)findViewById(R.id.saisimdp))
                .setText("");



        savedInstanceState.putString(NOM, nom);
        savedInstanceState.putString(PRENOM, prenom);
        savedInstanceState.putString(AGE, age);
        savedInstanceState.putString(TEL, tel);
        savedInstanceState.putInt(ID, id);



        super.onSaveInstanceState(savedInstanceState);

    }


  /*  @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
    Toast.makeText(this, "Etat de l'activité restauré",
            Toast.LENGTH_SHORT).show();
    }*/


    protected void genereID(){
        ValueID= (int)(Math.random() * ( 1000000 )+1);

    }


/*
    @Override
    protected void onResume() {
        super.onResume();
        getLifecycle().addObserver(new MainActivityObserver());


    }

    @Override
    protected void onPause() {
        super.onPause();
        getLifecycle().removeObserver(new MainActivityObserver());

    }
*/
}
