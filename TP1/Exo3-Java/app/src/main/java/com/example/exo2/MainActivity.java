package com.example.exo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TableLayout tablelayout = new TableLayout(this);
        tablelayout.addView(createRow("Nom"));
        tablelayout.addView(createRow("Prenom"));
        tablelayout.addView(createRow("Age"));
        tablelayout.addView(createRow("Mail"));
        tablelayout.addView(createRow("Telephone"));
        Button button = new Button(this);
        button.setText("Confirmer");
        tablelayout.addView(button);
        setContentView(tablelayout);
    }

    private TableRow createRow(String txt){
        TextView tv = new TextView(this);
        tv.setText(txt);


        EditText et = new EditText(this);

        et.setHint("Entrez votre "+txt+" ici");

        TableRow tr = new TableRow(this);
        tr.addView(tv);
        tr.addView(et);
        return tr;
    }






}