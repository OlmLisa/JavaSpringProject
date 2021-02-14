package com.dao;

import com.ecole.Eleve;

import java.sql.*;

public class EleveDAO {
    private String url;
    private String user;
    private String passwd;
    private Eleve eleve;

    public EleveDAO() {}

    public EleveDAO(Eleve eleve, String url, String user, String passwd) {
        this.eleve = eleve;
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }

    public EleveDAO(String url, String user, String passwd) {
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }
    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
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

    public String addEleveBdd(int lastInsertedID){
        return " insert into eleve (id)"
                + " values (" + lastInsertedID+ ")";
    }
    public void enregistrer() throws SQLException {
        String sql = "SELECT * from utilisateur order by id desc limit 1;";
        Connection conn = OpenConnexion();
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            int lastId = rs.getInt("id");
            String query = this.addEleveBdd(lastId);
            Statement s2 = conn.createStatement();
            s2.executeUpdate(query);
        }
        closeConnexion(conn);
    }

    @Override
    public String toString() {
        return "EleveDAO{" +
                "eleve=" + eleve +
                '}';
    }
}
