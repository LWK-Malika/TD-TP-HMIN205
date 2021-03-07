package com.example.tp3;

import androidx.lifecycle.ViewModel;

public class PlanningService extends ViewModel {
    private String matin= "Rencontre client Dupont";
    private String midi="Travailler le dossier recrutement";
    private String aprem="Réunion équipe";
    private String soir="Préparation dossier vente.";

    public String getMatin() {
        return matin;
    }

    public String getMidi() {
        return midi;
    }

    public String getAprem() {
        return aprem;
    }

    public String getSoir() {
        return soir;
    }
}
