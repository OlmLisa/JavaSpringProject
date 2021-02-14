package com.dao;

import com.ecole.Classe;
import com.ecole.Utilisateur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ClasseDAO {

    private String url;
    private String user;
    private String passwd;
    private Classe classe;

    public ClasseDAO() {}

    public ClasseDAO(Classe classe, String url, String user, String passwd) {
        this.classe = classe;
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }

    public ClasseDAO(String url, String user, String passwd) {
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }
    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
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

    public String addClasseBdd(){
        return " insert into classe (libelle)"
                + " values ('" + this.classe.getLibelle()+  "')";
    }
    public void enregistrer() throws SQLException {
        String query = this.addClasseBdd();
        Connection conn = OpenConnexion();
        Statement s = conn.createStatement();
        s.executeUpdate(query);
        closeConnexion(conn);
    }

    @Override
    public String toString() {
        return "ClasseDAO{" +
                "classe=" + classe +
                '}';
    }
}
