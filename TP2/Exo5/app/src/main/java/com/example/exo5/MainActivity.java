package com.example.exo5;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {

    SensorManager Smanager;
    Sensor mySensor;
    boolean isEnabled, hasCameraFlash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Smanager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        hasCameraFlash = getPackageManager().
                hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);


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
    Boolean flashLightStatus = false;

    SensorEventListener proximitySensorEventListener = new SensorEventListener() {
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
        @SuppressLint({"ResourceAsColor", "NewApi"})
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override

        public void onSensorChanged(SensorEvent event) {
            float x, y, z;

            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                x = event.values[0];
                y = event.values[1];
                z = event.values[2];
                float dist = (float) sqrt(pow(x, 2) + pow(y, 2) + pow(z, 2));

                if (dist > 15) {
                    if (hasCameraFlash)
                        if (flashLightStatus) {  //flash off
                            CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                            try {
                                String cameraId = cameraManager.getCameraIdList()[0];
                                cameraManager.setTorchMode(cameraId, false);
                                flashLightStatus = false;
                                }
                            catch (CameraAccessException e) {
                                }
                        }
                        else{//flash on
                             CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                             try {
                                    String cameraId = cameraManager.getCameraIdList()[0];
                                    cameraManager.setTorchMode(cameraId, true);
                                    flashLightStatus = true;
                                }
                             catch (CameraAccessException e) {
                                }
                         }
                    else
                        Toast.makeText(MainActivity.this, "No flash available on your device",
                                Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

}