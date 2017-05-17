package br.com.ifc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

    private static java.sql.Connection connection = null;
    private static final String ENDERECO = "jdbc:mysql://localhost";
    private static final String DATABASE = "servlet_login_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String PORTA = "3306";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    public static Connection getConnection() {
        try {
            if (connection == null) {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(
                        ENDERECO
                        + ":"
                        + PORTA
                        + "/"
                        + DATABASE,
                        USER, PASSWORD);
            }
            return connection;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void closeConnection() {
        closeConnection(null, null);
    }

    public static void closeConnection(ResultSet rs,
            PreparedStatement ps) {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (ps != null) {
                ps.close();
                ps = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
