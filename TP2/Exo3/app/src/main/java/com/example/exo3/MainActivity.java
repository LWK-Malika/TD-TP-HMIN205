package com.example.exo3;

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
    Sensor mySensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                float dist = (float) sqrt(pow(x, 2) + pow(y, 2) + pow(z, 2));
                LinearLayout ll = findViewById(R.id.Layout);
                if (dist < 4)
                    ll.setBackgroundColor(R.color.green);
                else {
                    if (dist < 7)
                        ll.setBackgroundColor(R.color.black);
                    else {
                        ll.setBackgroundColor(R.color.red);
                    }
                }
            }
        }
    };


}