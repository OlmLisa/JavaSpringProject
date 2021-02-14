package com.dao;

import com.ecole.Devoir;
import com.ecole.Mot;

import java.sql.*;

public class DevoirDAO {
    private String url;
    private String user;
    private String passwd;
    private Devoir devoir;

    public DevoirDAO(Devoir devoir, String url, String user, String passwd) {
        this.devoir = devoir;
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }

    public DevoirDAO(String url, String user, String passwd) {
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }
    public Devoir getDevoir() {
        return devoir;
    }

    public void setDevoir(Devoir devoir) {
        this.devoir = devoir;
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

    public String addDevoirBdd(int lastInsertedID){
        return " insert into devoir (texte, date, enseignant_id)"
                + " values ('" + this.devoir.getTexte()+ "','" + this.devoir.getDate()+  "',"+lastInsertedID+")";    }

    public void enregistrer() throws SQLException {
        String sql = "SELECT * from enseignant order by id desc limit 1;";
        Connection conn = OpenConnexion();
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            int lastId = rs.getInt("id");
            String query = this.addDevoirBdd(lastId);
            Statement s2 = conn.createStatement();
            s2.executeUpdate(query);
        }
        closeConnexion(conn);
    }

    @Override
    public String toString() {
        return "DevoirDAO{" +
                "devoir=" + devoir +
                '}';
    }
}
