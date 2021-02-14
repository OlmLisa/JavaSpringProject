package com.ecole;

import java.util.ArrayList;
import java.util.Arrays;

public class Fichier {

    private int eleve_id;
    private String libelle;
    private ArrayList<Eleve> eleve;

    public Fichier(String libelle ,int eleve_id) {
        this.libelle = libelle;
        this.eleve_id = eleve_id;
        this.eleve = new ArrayList<Eleve>();
    }
    public void addEleve(Eleve p) {
        this.eleve.add(p);
    }

    public int getEleve_id() {
        return eleve_id;
    }

    public void setEleve_id(int eleve_id) {
        this.eleve_id = eleve_id;
    }

    public void afficher(){
        Arrays.toString(eleve.toArray());
        System.out.println("Classe Fichier{" + "eleve=" + Arrays.toString(eleve.toArray()) + '}');
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public ArrayList<Eleve> getEleve() {
        return eleve;
    }

    public void setEleve(ArrayList<Eleve> eleve) {
        this.eleve = eleve;
    }

    @Override
    public String toString() {
        return "Fichier{" +
                "eleve_id=" + eleve_id +
                ", libelle='" + libelle + '\'' +
                ", eleve=" + eleve +
                '}';
    }
}
