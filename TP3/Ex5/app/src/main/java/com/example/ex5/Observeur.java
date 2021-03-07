package com.example.ex5;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class Observeur implements LifecycleObserver {
    private static Integer somme =0;

    public static Integer Compte() {
        return somme;
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void nbUtilisation(){
        somme ++;
    }





}

