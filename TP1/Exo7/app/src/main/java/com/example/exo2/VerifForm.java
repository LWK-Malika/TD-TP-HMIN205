package com.example.exo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VerifForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verif_form);

        TextView text;
        Button pageB;
        Button ret;

        Intent intent = this.getIntent();

        String nom = intent.getStringExtra("Nom");
        String prenom = intent.getStringExtra("Prenom");
        String age = intent.getStringExtra("Age");
        String mail = intent.getStringExtra("Email");
        String tel = intent.getStringExtra("Tel");

        text = (TextView) findViewById(R.id.View1);
        text.setText("nom: "+nom);

        text = (TextView) findViewById(R.id.View2);
        text.setText("Prenom: "+prenom);

        text = (TextView) findViewById(R.id.View3);
        text.setText("Age: "+age);

        text = (TextView) findViewById(R.id.View4);
        text.setText("Email: "+mail);

        text = (TextView) findViewById(R.id.View5);
        text.setText("Tel: "+tel);

        pageB = (Button) findViewById(R.id.act3);
        pageB.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intention1 = new Intent(VerifForm.this, WhiteP.class);
                                        intention1.putExtra("Tel",tel);
                                        VerifForm.this.startActivity(intention1);


                                    }
                                }

        );

        ret = (Button) findViewById(R.id.ret);
        ret.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intention1 = new Intent(VerifForm.this, MainActivity.class);

                                        VerifForm.this.startActivity(intention1);
                                    }
                                }

        );
    }
}