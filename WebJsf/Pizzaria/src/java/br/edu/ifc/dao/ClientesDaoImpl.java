/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.dao;

import br.edu.ifc.dao.util.ConnectionProvider;
import br.edu.ifc.dao.util.Transacao;
import br.edu.ifc.dao.util.TransacaoJdbcImpl;
import br.edu.ifc.entidades.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author fabricio
 */
public class ClientesDaoImpl implements ClientesDao {

    @Override
    public void inserir(Clientes objeto) throws Exception {
        Transacao tx = TransacaoJdbcImpl.getInstance();
        Connection conn = tx.getConnection();

        try {
            tx.begin();

            String query = "insert into clientes (nome, telefone, endereco) values ( ?, ?, ?)";
            PreparedStatement statement = TransacaoJdbcImpl.getInstance().getConnection().prepareStatement(query);
            statement.setString(1, objeto.getNome());
            statement.setString(2, objeto.getTelefone());
            statement.setString(3, objeto.getEndereco());

            statement.executeUpdate();

            tx.commit();

        } catch (SQLException sqlException) {
            throw new PersistenceException(sqlException);
        } finally {
            try {
                conn.close();
            } catch (SQLException sqlException) {
                throw new PersistenceException(sqlException);
            }
        }
    }

    @Override
    public void remover(Long objeto) throws Exception {
        Transacao tx = TransacaoJdbcImpl.getInstance();
        Connection conn = tx.getConnection();

        try {
            tx.begin();

            String query = "delete from clientes where idcliente = ?";
            PreparedStatement statement = TransacaoJdbcImpl.getInstance().getConnection().prepareStatement(query);
            statement.setLong(1, objeto);

            statement.executeUpdate();

            tx.commit();

        } catch (SQLException sqlException) {
            throw new PersistenceException(sqlException);
        } finally {
            try {
                conn.close();
            } catch (SQLException sqlException) {
                throw new PersistenceException(sqlException);
            }
        }
    }

    @Override
    public void atualizar(Clientes objeto) throws Exception {
        Transacao tx = TransacaoJdbcImpl.getInstance();
        Connection conn = tx.getConnection();

        try {
            tx.begin();

            String query = "update clientes set nome = ?, telefone = ?, endereco = ? where idcliente = ?";
            PreparedStatement statement = TransacaoJdbcImpl.getInstance().getConnection().prepareStatement(query);
            statement.setString(1, objeto.getNome());
            statement.setString(2, objeto.getTelefone());
            statement.setString(3, objeto.getEndereco());

            statement.setLong(4, objeto.getIdcliente());
            statement.executeUpdate();

            tx.commit();

        } catch (SQLException sqlException) {
            throw new PersistenceException(sqlException);
        } finally {
            try {
                conn.close();
            } catch (SQLException sqlException) {
                throw new PersistenceException(sqlException);
            }
        }
    }

    @Override
    public Clientes buscarPorId(Long id) throws Exception {
        Clientes cliente = new Clientes();
        try {
            String query = "select * from clientes where idcliente = ?";
            PreparedStatement statement = ConnectionProvider.getInstance().getConnection().prepareStatement(query);
            statement.setLong(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                cliente = new Clientes();
                cliente.setIdcliente(resultSet.getLong("idcliente"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setEndereco(resultSet.getString("endereco"));
                cliente.setTelefone(resultSet.getString("telefone"));
            }
        } catch (SQLException sqlException) {
            throw new PersistenceException(sqlException);
        }
        return cliente;
    }

    @Override
    public List<Clientes> buscarTodos() throws Exception {
        List<Clientes> lista = new LinkedList<Clientes>();
        Clientes cliente = new Clientes();
        try {
            String query = "select * from clientes";
            PreparedStatement statement = ConnectionProvider.getInstance()
                    .getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                cliente = new Clientes();
                cliente.setIdcliente(resultSet.getLong("idcliente"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setEndereco(resultSet.getString("endereco"));
                cliente.setTelefone(resultSet.getString("telefone"));
                lista.add(cliente);
            }
        } catch (SQLException sqlException) {
            throw new PersistenceException(sqlException);
        }
        return lista;
    }
}
