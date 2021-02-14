package com.ecole;

import java.util.ArrayList;
import java.util.Arrays;

public class Devoir {

    private String texte;
    private String date;
    private ArrayList<Fichier> fichier;

    public Devoir(String texte, String date) {
        this.texte = texte;
        this.date = date;
        this.fichier = new ArrayList<Fichier>();
    }
    
    public Devoir() {
        
    }

    public void addFichier(Fichier f) {
        this.fichier.add(f);
    }

    public void afficher(){
        Arrays.toString(fichier.toArray());
        System.out.println("Devoir{" + "fichier=" + Arrays.toString(fichier.toArray()) + '}');
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Fichier> getFichier() {
        return fichier;
    }

    public void setFichier(ArrayList<Fichier> fichier) {
        this.fichier = fichier;
    }

    @Override
    public String toString() {
        return "Devoir{" +
                "texte='" + texte + '\'' +
                ", date='" + date + '\'' +
                ", fichier=" + fichier +
                '}';
    }
}
