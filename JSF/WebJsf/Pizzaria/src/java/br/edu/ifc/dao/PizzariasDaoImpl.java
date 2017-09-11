/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.dao;

import br.edu.ifc.dao.util.ConnectionProvider;
import br.edu.ifc.dao.util.Transacao;
import br.edu.ifc.dao.util.TransacaoJdbcImpl;
import br.edu.ifc.entidades.Pizzarias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author fabricio
 */
public class PizzariasDaoImpl implements PizzariasDao {

    @Override
    public void inserir(Pizzarias objeto) throws Exception {
        Transacao tx = TransacaoJdbcImpl.getInstance();
        Connection conn = tx.getConnection();

        try {
            tx.begin();

            String query = "insert into pizzarias (nome, preco_peq, preco_med, preco_grd, preco_borda) values (?, ?, ?, ?, ?)";
            PreparedStatement statement = TransacaoJdbcImpl.getInstance().getConnection().prepareStatement(query);
            statement.setString(1, objeto.getNome());
            statement.setDouble(2, objeto.getPrecoPeq());
            statement.setDouble(3, objeto.getPrecoMed());
            statement.setDouble(4, objeto.getPrecoGrd());
            statement.setDouble(5, objeto.getPrecoBorda());

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

            String query = "delete from pizzarias where idpizzaria = ?";
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
    public void atualizar(Pizzarias objeto) throws Exception {
        Transacao tx = TransacaoJdbcImpl.getInstance();
        Connection conn = tx.getConnection();

        try {
            tx.begin();

            String query = "update pizzarias set nome = ?, "
                    + "preco_peq = ?, preco_med = ?, preco_grd = ?, preco_borda = ?, dthralteracao = ? "
                    + "where idpizzaria = ?";
            PreparedStatement statement = TransacaoJdbcImpl.getInstance().getConnection().prepareStatement(query);
            statement.setString(1, objeto.getNome());
            statement.setDouble(2, objeto.getPrecoPeq());
            statement.setDouble(3, objeto.getPrecoMed());
            statement.setDouble(4, objeto.getPrecoGrd());
            statement.setDouble(5, objeto.getPrecoBorda());
            statement.setDate(6, new java.sql.Date(new Date().getTime()));

            statement.setLong(7, objeto.getIdpizzaria());
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
    public Pizzarias buscarPorId(Long id) throws Exception {
        Pizzarias pizzaria = new Pizzarias();
        try {
            String query = "select * from pizzarias where idpizzaria = ?";
            PreparedStatement statement = ConnectionProvider.getInstance().getConnection().prepareStatement(query);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                pizzaria = new Pizzarias();
                pizzaria.setIdpizzaria(resultSet.getLong("idpizzaria"));
                pizzaria.setNome(resultSet.getString("nome"));
                pizzaria.setPrecoPeq(resultSet.getDouble("preco_peq"));
                pizzaria.setPrecoMed(resultSet.getDouble("preco_med"));
                pizzaria.setPrecoGrd(resultSet.getDouble("preco_grd"));
                pizzaria.setPrecoBorda(resultSet.getDouble("preco_borda"));
                pizzaria.setDtcadastro(resultSet.getDate("dtcadastro"));
                pizzaria.setDthralteracao(resultSet.getDate("dthralteracao"));
            }
        } catch (SQLException sqlException) {
            throw new PersistenceException(sqlException);
        }
        return pizzaria;
    }

    @Override
    public List<Pizzarias> buscarTodos() throws Exception {
        List<Pizzarias> lista = new LinkedList<>();
        Pizzarias pizzaria = new Pizzarias();
        try {
            String query = "select * from pizzarias";
            PreparedStatement statement = ConnectionProvider.getInstance()
                    .getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                pizzaria = new Pizzarias();
                pizzaria.setIdpizzaria(resultSet.getLong("idpizzaria"));
                pizzaria.setNome(resultSet.getString("nome"));
                pizzaria.setPrecoPeq(resultSet.getDouble("preco_peq"));
                pizzaria.setPrecoMed(resultSet.getDouble("preco_med"));
                pizzaria.setPrecoGrd(resultSet.getDouble("preco_grd"));
                pizzaria.setPrecoBorda(resultSet.getDouble("preco_borda"));
                pizzaria.setDtcadastro(resultSet.getDate("dtcadastro"));
                pizzaria.setDthralteracao(resultSet.getDate("dthralteracao"));
                lista.add(pizzaria);
            }
        } catch (SQLException sqlException) {
            throw new PersistenceException(sqlException);
        }
        return lista;
    }
}
