package com.example.tp3;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MainActivityObserver implements LifecycleObserver {
    private String TAG = this.getClass().getSimpleName();
    private static Integer count =0;

    public static Integer getCount() {
        return count;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreateEvent(){
        Log.i(TAG, "observer ON_CREATE");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void nombreUtilisation(){
        count ++;
    }

}
