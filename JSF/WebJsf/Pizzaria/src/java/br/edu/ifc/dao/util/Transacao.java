/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.dao.util;

import java.sql.Connection;
import javax.persistence.PersistenceException;

public interface Transacao {

    public Connection getConnection() throws PersistenceException;

    public void begin() throws PersistenceException;

    public void commit() throws PersistenceException;

    public void rollback() throws PersistenceException;

}
