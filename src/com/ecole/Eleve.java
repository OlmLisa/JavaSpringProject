package com.ecole;

import java.util.ArrayList;
import java.util.Arrays;

public class Eleve extends Utilisateur {

    private int id;
    private ArrayList<Parent> parent; // collection

    public Eleve(String nom, String prenom, String login, String mdp) {
        super(nom, prenom, login, mdp);
        this.parent = new ArrayList<Parent>();
    }

    public Eleve(int id, String nom, String prenom, String login, String mdp) {
        super(nom, prenom, login, mdp);
        this.id = id;
    }

    public ArrayList<Parent> getParent() {
        return parent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addParent(Parent p) {
        this.parent.add(p);
    }

    public void afficher(){
        Arrays.toString(parent.toArray());
        System.out.println("Eleve{" + "parent=" + Arrays.toString(parent.toArray()) + '}');
    }

    public void setParent(ArrayList<Parent> parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Eleve{" +
                "parent=" + parent +
                '}';
    }
}
