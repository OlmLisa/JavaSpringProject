package com.dao;

import com.ecole.Utilisateur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UtilisateurDAO {

    private String url;
    private String user;
    private String passwd;
    private Utilisateur utilisateur;

    public UtilisateurDAO() {}

    public UtilisateurDAO(Utilisateur utilisateur, String url, String user, String passwd) {
        this.utilisateur = utilisateur;
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }

    public UtilisateurDAO(String url, String user, String passwd) {
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }
    public Utilisateur getCoach() {
        return utilisateur;
    }

    public void setUser(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Connection OpenConnexion() { ;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(this.url, this.user, this.passwd);
            System.out.println("Connecter");
            return conn;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnexion(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String addUtilisateurBdd(){
        return " insert into utilisateur (nom, prenom, login, mdp)"
                + " values ('" + this.utilisateur.getNom()+ "','"
                + this.utilisateur.getPrenom()+"','"+ this.utilisateur.getLogin()+ "','"+ this.utilisateur.getMdp()+ "')";
    }
    public void enregistrer() throws SQLException {
        String query = this.addUtilisateurBdd();
        Connection conn = OpenConnexion();
        Statement s = conn.createStatement();
        s.executeUpdate(query);
        closeConnexion(conn);
    }

    @Override
    public String toString() {
        return "UtilisateurDAO{" +
                "utilisateur=" + utilisateur +
                '}';
    }

}
