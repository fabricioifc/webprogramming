/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifc.dao;

import ifc.model.Ingrediente;
import ifc.model.PizzaIngrediente;
import ifc.model.Pizzaria;
import ifc.utils.ConnectionProvider;
import ifc.utils.Transacao;
import ifc.utils.TransacaoJdbcImpl;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author fabricio
 */
public class IngredienteDaoImpl implements IngredienteDao, Serializable {

    @Override
    public void inserir(Ingrediente objeto) throws Exception {
        Transacao tx = TransacaoJdbcImpl.getInstance();
        Connection conn = tx.getConnection();

        try {
            tx.begin();

            String query = "insert into Ingrediente (descricao) values (?)";
            PreparedStatement statement = TransacaoJdbcImpl.getInstance().getConnection().prepareStatement(query);
            statement.setString(1, objeto.getDescricao());

            statement.executeUpdate();

            tx.commit();

        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        } finally {
            try {
                conn.close();
            } catch (SQLException sqlException) {
                throw new Exception(sqlException);
            }
        }
    }

    @Override
    public void remover(Integer objeto) throws Exception {
        Transacao tx = TransacaoJdbcImpl.getInstance();
        Connection conn = tx.getConnection();

        try {
            tx.begin();

            String query = "delete from Ingrediente where id = ?";
            PreparedStatement statement = TransacaoJdbcImpl.getInstance().getConnection().prepareStatement(query);
            statement.setLong(1, objeto);

            statement.executeUpdate();

            tx.commit();

        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        } finally {
            try {
                conn.close();
            } catch (SQLException sqlException) {
                throw new Exception(sqlException);
            }
        }
    }

    @Override
    public void atualizar(Ingrediente objeto) throws Exception {
        Transacao tx = TransacaoJdbcImpl.getInstance();
        Connection conn = tx.getConnection();

        try {
            tx.begin();

            String query = "update Ingrediente set descricao = ? "
                    + "where id = ?";
            PreparedStatement statement = TransacaoJdbcImpl.getInstance().getConnection().prepareStatement(query);
            statement.setString(1, objeto.getDescricao());

            statement.setInt(2, objeto.getId());
            statement.executeUpdate();

            tx.commit();

        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        } finally {
            try {
                conn.close();
            } catch (SQLException sqlException) {
                throw new Exception(sqlException);
            }
        }
    }

    @Override
    public Ingrediente buscarPorId(Integer id) throws Exception {
        Ingrediente ingrediente = new Ingrediente();
        try {
            String query = "select * from Ingrediente where id = ?";
            PreparedStatement statement = ConnectionProvider.getInstance().getConnection().prepareStatement(query);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ingrediente = new Ingrediente();
                ingrediente.setId(resultSet.getInt("id"));
                ingrediente.setDescricao(resultSet.getString("descricao"));
            }
        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        }
        return ingrediente;
    }

    @Override
    public List<Ingrediente> buscarTodos() throws Exception {
        List<Ingrediente> lista = new LinkedList<>();
        Ingrediente ingrediente = new Ingrediente();
        try {
            String query = "select * from Ingrediente";
            PreparedStatement statement = ConnectionProvider.getInstance()
                    .getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ingrediente = new Ingrediente();
                ingrediente.setId(resultSet.getInt("id"));
                ingrediente.setDescricao(resultSet.getString("descricao"));
                lista.add(ingrediente);
            }
        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        }
        return lista;
    }
}
