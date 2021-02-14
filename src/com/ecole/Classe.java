package com.ecole;

import java.util.ArrayList;

public class Classe {

    private String libelle;
    private ArrayList<Eleve> eleve; // collection
    private ArrayList<Enseignant> enseignant; // collection

    public Classe(String libelle) {
        this.libelle = libelle;
        this.eleve = new ArrayList<Eleve>();
        this.enseignant = new ArrayList<Enseignant>();
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Classe{" +
                "libelle='" + libelle + '\'' +
                ", eleve=" + eleve +
                ", enseignant=" + enseignant +
                '}';
    }
}
