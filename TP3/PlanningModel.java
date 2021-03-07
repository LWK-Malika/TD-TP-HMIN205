package com.example.tp3;

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

public class PlanningModel extends ViewModel  {
    private MutableLiveData<String> matin;//= "Rencontre client Dupont";
    private MutableLiveData<String> midi;//="Travailler le dossier recrutement";
    private MutableLiveData<String> aprem;//="Réunion équipe";
    private MutableLiveData<String> soir;//="Préparation dossier vente.";

    private static Activity context =null;

    private MutableLiveData<String> currentName;
    public MutableLiveData<String> getCurrentName() {
        if (currentName== null) {
            currentName= new MutableLiveData<String>();
        }
        return currentName;
    }

    public MutableLiveData<String> getMatin() {
        if (matin == null){
            matin = new MutableLiveData<String>();
            matin.setValue("Rencontre client Dupont");}
        return matin;

    }

    public MutableLiveData<String> getMidi() {
        if (midi == null){
            midi = new MutableLiveData<String>();
        midi.setValue("Travailler le dossier recrutement");}
        return midi;
    }

    public MutableLiveData<String> getAprem() {
        if (aprem == null){
            aprem = new MutableLiveData<String>();
        aprem.setValue("Réunion équipe");}
        return aprem;
    }

    public MutableLiveData<String> getSoir() {
        if (soir == null){
            soir = new MutableLiveData<String>();
        soir.setValue("Préparation dossier vente.");}
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
                String msg = "ne pas oublier de dejeuner \n Bien manger a midi \n Travailler le cours de mobile \n Se reposer après tout cet effort";
                fos.write(msg.getBytes());

                fos.close();
            } catch (IOException e) {
            }


    }



}
