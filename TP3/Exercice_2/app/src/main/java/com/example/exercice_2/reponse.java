package com.example.exercice_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
public class reponse extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reponse);

        Bundle extras = getIntent().getExtras();
        String FileName = extras.getString("nom-Fichier");


        try {
            FileInputStream fis = openFileInput(FileName);

            InputStreamReader isr = new InputStreamReader ( fis ) ;
            BufferedReader buffreader = new BufferedReader ( isr ) ;

            String readString = buffreader.readLine( ) ;
            while ( readString != null ) {
                String[] values = readString.split(":");


                TextView tv = findViewById(Integer.parseInt(values[0]));
                tv.setText(values[1]);

                readString = buffreader.readLine( ) ;
            }
            isr.close ( ) ;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}