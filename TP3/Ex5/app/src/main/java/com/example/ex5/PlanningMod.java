package com.example.ex5;

import android.annotation.SuppressLint;
import android.app.Activity;
        import android.content.Context;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.lifecycle.MutableLiveData;
        import androidx.lifecycle.ViewModel;

        import java.io.BufferedReader;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.InputStreamReader;

@SuppressLint("StaticFieldLeak")
public class PlanningMod extends ViewModel  {
    private MutableLiveData<String> matin;//= "Réunion du matin";
    private MutableLiveData<String> midi;//="Travailler";
    private MutableLiveData<String> aprem;//="RDV zoom";
    private MutableLiveData<String> soir;//="Préparation du dossier vente.";

    private static Activity context =null;
/*
    private MutableLiveData<String> currentName;
    public MutableLiveData<String> getCurrentName() {
        if (currentName== null) {
            currentName= new MutableLiveData<String>();
        }
        return currentName;
    }
*/
    public MutableLiveData<String> getMatin() {
        if (matin == null){
            matin = new MutableLiveData<String>();
            matin.setValue("Réunion du matin");}
        return matin;

    }

    public MutableLiveData<String> getMidi() {
        if (midi == null){
            midi = new MutableLiveData<String>();
            midi.setValue("Travailler");}
        return midi;
    }

    public MutableLiveData<String> getAprem() {
        if (aprem == null){
            aprem = new MutableLiveData<String>();
            aprem.setValue("RDV zoom");}
        return aprem;
    }

    public MutableLiveData<String> getSoir() {
        if (soir == null){
            soir = new MutableLiveData<String>();
            soir.setValue("Préparation du dossier vente.");}
        return soir;
    }

    public void setContext(Activity Context){
        context = Context;
    }

    public  void accesFichierPlanning() {
        if (context != null) {
            try {
                FileInputStream fis = context.openFileInput("Planning");

                if (fis == null) {
                    creerFichier();

                } else {
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader buffreader = new BufferedReader(isr);
                    String readString = buffreader.readLine();
                    while(readString !=null){
                        if (matin == null)
                            matin = new MutableLiveData<String>();
                        matin.setValue(readString);
                        readString = buffreader.readLine();
                        if (midi == null)
                            midi = new MutableLiveData<String>();
                        midi.setValue(readString);
                        readString = buffreader.readLine();
                        if (aprem == null)
                            aprem = new MutableLiveData<String>();
                        aprem.setValue(readString);
                        readString = buffreader.readLine();
                        if (soir == null)
                            soir = new MutableLiveData<String>();
                        soir.setValue(readString);

                        readString = buffreader.readLine();
                    }
                    isr.close();
                }
                fis.close();
            }
            catch (FileNotFoundException e) {
                creerFichier();
            }
            catch (IOException e) {}
        }
    }



    public void creerFichier() {

        try {
            FileOutputStream fos = context.openFileOutput("Planning", Context.MODE_PRIVATE);
            String msg = "L'heure de déjeuner arrive bientot \n Réunion après manger \n Au boulot! \n Il est l'heure du thé";
            fos.write(msg.getBytes());

            fos.close();
        } catch (IOException e) {
        }


    }



}
