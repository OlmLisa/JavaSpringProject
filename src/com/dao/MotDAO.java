package com.dao;

import com.ecole.Mot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MotDAO {
    private String url;
    private String user;
    private String passwd;
    private Mot mot;

    public MotDAO(Mot mot, String url, String user, String passwd) {
        this.mot = mot;
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }

    public MotDAO(String url, String user, String passwd) {
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }
    public Mot getMot() {
        return mot;
    }

    public void setMot(Mot mot) {
        this.mot = mot;
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

    public String addMotBdd(){
        return " insert into mot (libelle)"
                + " values ('" + this.mot.getLibelle()+  "')";
    }

    public void enregistrer() throws SQLException {
        String query = this.addMotBdd();
        Connection conn = OpenConnexion();
        Statement s = conn.createStatement();
        s.executeUpdate(query);
        closeConnexion(conn);
    }

    @Override
    public String toString() {
        return "MotDAO{" +
                "mot=" + mot +
                '}';
    }
}
