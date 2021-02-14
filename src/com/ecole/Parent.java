package com.ecole;

public class Parent extends Utilisateur {

    private String email;
    private String tel;

    public Parent(String nom, String prenom, String login, String mdp, String email, String tel) {
        super(nom, prenom, login, mdp);
        this.email = email;
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
