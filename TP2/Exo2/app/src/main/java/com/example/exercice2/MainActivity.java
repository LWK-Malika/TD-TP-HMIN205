package com.example.exercice2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SensorManager mSensorManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        TextView text = (TextView) findViewById(R.id.TextV);
        String mess = "";
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) !=null){
            mess = "GG ! Il y a une lumière.";
        } else {
            mess = "Pas de lumière.";
        }
        text.setText(mess);



    }


}