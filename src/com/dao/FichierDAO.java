package com.dao;
import com.ecole.Fichier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FichierDAO {

    private String url;
    private String user;
    private String passwd;
    private Fichier fichier;

    public FichierDAO(Fichier fichier, String url, String user, String passwd) {
        this.fichier = fichier;
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }

    public FichierDAO(String url, String user, String passwd) {
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }
    public Fichier getFichier() {
        return fichier;
    }

    public void setFichier(Fichier fichier) {
        this.fichier = fichier;
    }

    public Connection OpenConnexion() {
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

    public String addFichierBdd(){
        return " insert into fichier (libelle)"
                + " values ('" + this.fichier.getLibelle()+  "')";
    }

    public void enregistrer() throws SQLException {
        String query = this.addFichierBdd();
        Connection conn = OpenConnexion();
        Statement s = conn.createStatement();
        s.executeUpdate(query);
        closeConnexion(conn);
    }

    @Override
    public String toString() {
        return "FichierDAO{" +
                "fichier=" + fichier +
                '}';
    }
}