package com.ecole;

import java.util.ArrayList;
import java.util.Arrays;

public class Mot {

    private String libelle;
    private ArrayList<Eleve> eleve;
    private ArrayList<Enseignant> enseignant;
    private ArrayList<Parent> parent;

    public Mot(String libelle) {
        this.libelle = libelle;
        this.eleve = new ArrayList<Eleve>();
        this.enseignant = new ArrayList<Enseignant>();
        this.parent = new ArrayList<Parent>();
    }

    public void addEnseignant(Enseignant e) {
        this.enseignant.add(e);
    }


    public void addParent(Parent p) {
        this.parent.add(p);
    }


    public void addEleve(Eleve e) {
        this.eleve.add(e);
    }

    public void afficher(){
        Arrays.toString(eleve.toArray());
        System.out.println("Mot{" + "eleve=" + Arrays.toString(eleve.toArray()) + '\n' +
                "parent=" + Arrays.toString(parent.toArray())  + '\n' +
                "enseignant=" + Arrays.toString(enseignant.toArray())  + '}');
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public ArrayList<Parent> getParent() {
        return parent;
    }

    public void setParent(ArrayList<Parent> parent) {
        this.parent = parent;
    }

    public ArrayList<Eleve> getEleve() {
        return eleve;
    }

    public void setEleve(ArrayList<Eleve> eleve) {
        this.eleve = eleve;
    }

    public ArrayList<Enseignant> getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(ArrayList<Enseignant> enseignant) {
        this.enseignant = enseignant;
    }

    @Override
    public String toString() {
        return "Mot{" +
                "libelle='" + libelle + '\'' +
                ", eleve=" + eleve +
                ", enseignant=" + enseignant +
                ", parent=" + parent +
                '}';
    }
}
