package com.ecole;

public class Enseignant extends Utilisateur{

    public Enseignant(String nom, String prenom, String login, String mdp) {
        super(nom, prenom, login, mdp);
    }

    @Override
    public String toString() {
        return "Enseignant{}";
    }
}
