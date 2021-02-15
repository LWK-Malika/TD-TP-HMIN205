package com.example.exo4;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {

    SensorManager Smanager;
    ImageView img;
    Sensor mySensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.image);
        Smanager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

    }
    @Override
    protected void onPause() {
        super.onPause();
        Smanager.unregisterListener((SensorEventListener) this, Smanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
    }
    @Override
    protected void onResume() {
        super.onResume();

        mySensor = Smanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (mySensor == null) {
            Toast.makeText(this, "\nPas de détecteur!\n", Toast.LENGTH_LONG).show();
        } else {
            Smanager.registerListener(proximitySensorEventListener,mySensor,SensorManager.SENSOR_DELAY_NORMAL);
            Toast.makeText(this,"\nDétecteur, OK!\n", Toast.LENGTH_LONG).show();

        }

    }

    SensorEventListener proximitySensorEventListener = new SensorEventListener() {
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
        @SuppressLint("ResourceAsColor")
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x, y, z;
            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                x = event.values[0];
                y = event.values[1];
                z = event.values[2];
                TextView tv = findViewById(R.id.Texte);
                if (pow(x, 2) > pow(y, 2)) {
                    if (x > 0){
                        tv.setText("Droite !");
                        img.setImageDrawable(getDrawable(R.drawable.droite));}

                    else{
                        tv.setText("Gauche !");
                        img.setImageDrawable(getDrawable(R.drawable.gauche));}

                } else {
                    if (y > 0){
                        tv.setText("Haut !");
                        img.setImageDrawable(getDrawable(R.drawable.haut));}

                    else{
                        tv.setText("Bas !");
                        img.setImageDrawable(getDrawable(R.drawable.bas));}

                }
            }
            }

    };


}