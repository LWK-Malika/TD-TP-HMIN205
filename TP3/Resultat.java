package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Resultat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);

        Bundle extras = getIntent().getExtras();
        String FileName = extras.getString("nameFile");

        MainActivityObserver obs = new MainActivityObserver();
        Integer nb = obs.getCount();

        TextView view = ((TextView) findViewById(R.id.valueNb));
        view.setText(nb.toString());

        try {
            FileInputStream fis = openFileInput(FileName);

            InputStreamReader isr = new InputStreamReader ( fis ) ;
            BufferedReader buffreader = new BufferedReader ( isr ) ;

            String readString = buffreader.readLine( ) ;
            while ( readString != null ) {
                String[] values = readString.split(";;;");

                if (values.length==2) {
                    TextView tv = ((TextView) findViewById(Integer.parseInt(values[0])));
                    tv.setText(values[1]);
                }

                readString = buffreader.readLine( ) ;
            }
            isr.close ( ) ;
            }
         catch (IOException e) {
            e.printStackTrace();
        }

    }
}