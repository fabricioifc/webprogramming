/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.PersistenceException;

/**
 *
 * @author fabricio
 */
public class ConnectionProvider {

    private static ConnectionProvider instance;
    private static Connection connection = null;

    private String url = "jdbc:mysql://localhost:3306/pizzaria";

    private ConnectionProvider() throws PersistenceException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(this.url, "root", "root");
        } catch (Exception classNotFoundException) {
            throw new PersistenceException(classNotFoundException);
        }
    }

    public static ConnectionProvider getInstance() throws PersistenceException {
        if (instance == null) {
            instance = new ConnectionProvider();
        }
        return instance;
    }

    public Connection getConnection() throws PersistenceException {

        try {
            this.closeConnection();
            connection = DriverManager.getConnection(this.url, "root", "root");
            connection.setAutoCommit(false);
        } catch (Exception exception) {
            throw new PersistenceException(exception);
        }
        return connection;
    }

    public void closeConnection() throws PersistenceException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException sqlException) {
                throw new PersistenceException(sqlException);
            }
        }
    }

    public void rollback() throws PersistenceException {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException sqlException) {
                throw new PersistenceException(sqlException);
            }
        }
    }
}
