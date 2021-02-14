package com.dao;
import com.ecole.Parent;

import java.sql.*;

public class ParentDAO {

    private String url;
    private String user;
    private String passwd;
    private Parent parent;

    public ParentDAO() {}

    public ParentDAO(Parent parent, String url, String user, String passwd) {
        this.parent = parent;
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }

    public ParentDAO(String url, String user, String passwd) {
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }
    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Connection OpenConnexion() {
        try{
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

    public String addParentBdd(int lastInsertedID){
        return " insert into parent (id, email, tel)"
                + " values (" + lastInsertedID + " ,'" + this.parent.getEmail()+ "','"
                + this.parent.getTel()+"')";
    }

    public void enregistrer() throws SQLException {
        String sql = "SELECT * from utilisateur order by id desc limit 1;";
        Connection conn = OpenConnexion();
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            int lastId = rs.getInt("id");
            String query = this.addParentBdd(lastId);
            Statement s2 = conn.createStatement();
            s2.executeUpdate(query);
        }
        closeConnexion(conn);
    }

    @Override
    public String toString() {
        return "ParentDAO{" +
                "parent=" + parent +
                '}';
    }

}
