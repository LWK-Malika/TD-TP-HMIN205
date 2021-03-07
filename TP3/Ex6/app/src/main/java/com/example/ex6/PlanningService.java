package com.example.ex6;

import androidx.lifecycle.ViewModel;

public class PlanningService extends ViewModel {
    private String matin= "Réunion du matin";
    private String midi="Travailler";
    private String aprem="RDV zoom";
    private String soir="Préparation du dossier vente.";

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