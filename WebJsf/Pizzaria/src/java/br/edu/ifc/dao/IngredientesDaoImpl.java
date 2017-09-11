/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.dao;

import br.edu.ifc.dao.util.ConnectionProvider;
import br.edu.ifc.dao.util.Transacao;
import br.edu.ifc.dao.util.TransacaoJdbcImpl;
import br.edu.ifc.entidades.Ingredientes;
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
public class IngredientesDaoImpl implements IngredientesDao {

    @Override
    public void inserir(Ingredientes objeto) throws Exception {
        Transacao tx = TransacaoJdbcImpl.getInstance();
        Connection conn = tx.getConnection();

        try {
            tx.begin();

            String query = "insert into ingredientes (nome, idativo) values (?, ?)";
            PreparedStatement statement = TransacaoJdbcImpl.getInstance().getConnection().prepareStatement(query);
            statement.setString(1, objeto.getNome());
            statement.setBoolean(2, objeto.getIdativo());

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

            String query = "delete from ingredientes where idingrediente = ?";
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
    public void atualizar(Ingredientes objeto) throws Exception {
        Transacao tx = TransacaoJdbcImpl.getInstance();
        Connection conn = tx.getConnection();

        try {
            tx.begin();

            String query = "update ingredientes set nome = ?, idativo = ? where idingrediente = ?";
            PreparedStatement statement = TransacaoJdbcImpl.getInstance().getConnection().prepareStatement(query);
            statement.setString(1, objeto.getNome());
            statement.setBoolean(2, objeto.getIdativo());

            statement.setLong(3, objeto.getIdingrediente());
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
    public Ingredientes buscarPorId(Long id) throws Exception {
        Ingredientes ingrediente = new Ingredientes();
        try {
            String query = "select * from ingredientes where idingrediente = ?";
            PreparedStatement statement = ConnectionProvider.getInstance().getConnection().prepareStatement(query);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ingrediente = new Ingredientes();
                ingrediente.setIdingrediente(resultSet.getLong("idingrediente"));
                ingrediente.setNome(resultSet.getString("nome"));
                ingrediente.setIdativo(resultSet.getBoolean("idativo"));
            }
        } catch (SQLException sqlException) {
            throw new PersistenceException(sqlException);
        }
        return ingrediente;
    }

    @Override
    public List<Ingredientes> buscarTodos() throws Exception {
        List<Ingredientes> lista = new LinkedList<>();
        Ingredientes ingrediente = new Ingredientes();
        try {
            String query = "select * from ingredientes";
            PreparedStatement statement = ConnectionProvider.getInstance()
                    .getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ingrediente = new Ingredientes();
                ingrediente.setIdingrediente(resultSet.getLong("idingrediente"));
                ingrediente.setNome(resultSet.getString("nome"));
                ingrediente.setIdativo(resultSet.getBoolean("idativo"));
                lista.add(ingrediente);
            }
        } catch (SQLException sqlException) {
            throw new PersistenceException(sqlException);
        }
        return lista;
    }
}
