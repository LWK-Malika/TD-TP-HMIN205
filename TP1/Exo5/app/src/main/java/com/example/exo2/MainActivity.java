package com.example.exo2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
    final Context context = this;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    button = (Button) findViewById(R.id.Submit);
    //add button listener
    button.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder( MainActivity.this);

            //set title
            alertDialogBuilder.setTitle("ATTENTION !");
            //set dialog message
            alertDialogBuilder
                    .setMessage(R.string.nouvelle_activite)
                    .setPositiveButton(R.string.oui, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(getApplicationContext(), "Envoie des réponses", Toast.LENGTH_LONG).show();
                            dialog.cancel();
                        }
                    })

                    .setNegativeButton(R.string.retour, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(getApplicationContext(), "Action annulée ", Toast.LENGTH_LONG).show();
                            dialog.cancel();
                        }
                    });
            //create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            //show it
            alertDialog.show();
        }
    });


    }


    /*
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
*/





}