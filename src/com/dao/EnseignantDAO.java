package com.dao;

import com.ecole.Enseignant;

import java.sql.*;

public class EnseignantDAO {
    private String url;
    private String user;
    private String passwd;
    private Enseignant enseignant;

    public EnseignantDAO() {}

    public EnseignantDAO(Enseignant enseignant, String url, String user, String passwd) {
        this.enseignant = enseignant;
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }

    public EnseignantDAO(String url, String user, String passwd) {
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }
    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant utilisateur) {
        this.enseignant = enseignant;
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

    public String addEnseignantBdd(int lastInsertedID){
        return " insert into enseignant (id)"
                + " values (" + lastInsertedID + ")";
    }

    public void enregistrer() throws SQLException {
        String sql = "SELECT * from utilisateur order by id desc limit 1;";
        Connection conn = OpenConnexion();
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            int lastId = rs.getInt("id");
            String query = this.addEnseignantBdd(lastId);
            Statement s2 = conn.createStatement();
            s2.executeUpdate(query);
        }
        closeConnexion(conn);
    }

    @Override
    public String toString() {
        return "EnseignantDAO{" +
                "enseignant=" + enseignant +
                '}';
    }
}
