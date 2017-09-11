/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.dao.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.persistence.PersistenceException;

public class TransacaoJdbcImpl implements Transacao {

    private static TransacaoJdbcImpl instance = null;

    private Connection connection = null;

    private TransacaoJdbcImpl() {

    }

    public static TransacaoJdbcImpl getInstance() {
        if (TransacaoJdbcImpl.instance == null) {
            TransacaoJdbcImpl.instance = new TransacaoJdbcImpl();
        }
        return TransacaoJdbcImpl.instance;
    }

    @Override
    public Connection getConnection() throws PersistenceException {
        try {
            if (this.connection == null || this.connection.isClosed()) {
                this.connection = ConnectionProvider.getInstance().getConnection();
            }
        } catch (SQLException sqlException) {
            throw new PersistenceException(sqlException);
        }
        return this.connection;
    }

    @Override
    public void begin() throws PersistenceException {
        try {
            this.getConnection().setAutoCommit(false);
        } catch (SQLException sqlException) {
            throw new PersistenceException(sqlException);
        }
    }

    @Override
    public void commit() throws PersistenceException {
        try {
            this.connection.commit();
        } catch (SQLException sqlCommitException) {
            throw new PersistenceException(sqlCommitException);
        } finally {
            this.close();
        }
    }

    @Override
    public void rollback() throws PersistenceException {
        try {
            this.connection.rollback();
        } catch (SQLException sqlRollbackException) {
            throw new PersistenceException(sqlRollbackException);
        } finally {
            this.close();
        }
    }

    private void close() throws PersistenceException {
        try {
            if (this.connection != null
                    && !this.connection.isClosed()) {
                ConnectionProvider.getInstance().closeConnection();
                this.connection = null;
            }
        } catch (SQLException sqlException) {
            throw new PersistenceException(sqlException);
        }
    }

}
