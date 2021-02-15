package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

        SensorManager sensorManager;
   // TextView text ;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
            listSensor();
        }
        private void listSensor() {
            List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
            StringBuffer sensorDesc = new StringBuffer();
            for (Sensor sensor : sensors) {
                sensorDesc.append("New sensor detected : \r\n");
                sensorDesc.append("\tName: " + sensor.getName() + "\r\n");
                sensorDesc.append("\tType: " + Character.getType(sensor.getType()) + "\r\n");
                sensorDesc.append("Version: " + sensor.getVersion() + "\r\n");
                sensorDesc.append("Resolution (in the sensor unit): " +
                        sensor.getResolution() + "\r\n");
                sensorDesc.append("Power in mA used by this sensor while in use" +
                        sensor.getPower() +"\r\n");
                sensorDesc.append("Vendor: " + sensor.getVendor() + "\r\n");
                sensorDesc.append("Maximum range of the sensor in the sensor's unit." +
                        sensor.getMaximumRange() + "\r\n");
                sensorDesc.append("Minimum delay allowed between two events in microsecond " +
                                " or zero if this sensor only returns a value when the data it's measuring changes " +
                sensor.getMinDelay() + "\r\n");
            }
            //text.setText(sensorDesc.toString());
            //text = findViewById(R.id.TextV);

            //text.setText(sensorDesc);
            Toast.makeText(this, sensorDesc.toString(), Toast.LENGTH_LONG).show();
        }

    }