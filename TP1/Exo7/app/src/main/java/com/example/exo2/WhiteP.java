package com.example.exo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WhiteP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_white_p);

        TextView text;
        Button button;

        Intent intent = this.getIntent();
        String tel = intent.getStringExtra("Tel");
        text = (TextView) findViewById(R.id.telephone);
        text.setText(tel);

        ActivityCompat.requestPermissions(WhiteP.this,
                new String[]{Manifest.permission.CALL_PHONE},
                1);

        button = (Button) findViewById(R.id.appel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAppel = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+text.getText()));
                startActivity(intentAppel);


            }
        });

    }
}