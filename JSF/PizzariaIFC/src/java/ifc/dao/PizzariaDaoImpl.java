/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifc.dao;

import ifc.model.Pizzaria;
import ifc.utils.ConnectionProvider;
import ifc.utils.Transacao;
import ifc.utils.TransacaoJdbcImpl;
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
public class PizzariaDaoImpl implements PizzariaDao {

    @Override
    public void inserir(Pizzaria objeto) throws Exception {
        Transacao tx = TransacaoJdbcImpl.getInstance();
        Connection conn = tx.getConnection();

        try {
            tx.begin();

            String query = "insert into Pizzaria (nome, preco_peq, preco_med, preco_grd, preco_borda) values (?, ?, ?, ?, ?)";
            PreparedStatement statement = TransacaoJdbcImpl.getInstance().getConnection().prepareStatement(query);
            statement.setString(1, objeto.getNome());
            statement.setDouble(2, objeto.getPrecoPeq());
            statement.setDouble(3, objeto.getPrecoMed());
            statement.setDouble(4, objeto.getPrecoGrd());
            statement.setDouble(5, objeto.getPrecoBorda());

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

            String query = "delete from Pizzaria where id = ?";
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
    public void atualizar(Pizzaria objeto) throws Exception {
        Transacao tx = TransacaoJdbcImpl.getInstance();
        Connection conn = tx.getConnection();

        try {
            tx.begin();

            String query = "update Pizzaria set nome = ?, "
                    + "preco_peq = ?, preco_med = ?, preco_grd = ?, preco_borda = ?"
                    + "where id = ?";
            PreparedStatement statement = TransacaoJdbcImpl.getInstance().getConnection().prepareStatement(query);
            statement.setString(1, objeto.getNome());
            statement.setDouble(2, objeto.getPrecoPeq());
            statement.setDouble(3, objeto.getPrecoMed());
            statement.setDouble(4, objeto.getPrecoGrd());
            statement.setDouble(5, objeto.getPrecoBorda());

            statement.setLong(6, objeto.getId());
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
    public Pizzaria buscarPorId(Integer id) throws Exception {
        Pizzaria pizzaria = new Pizzaria();
        try {
            String query = "select * from Pizzaria where id = ?";
            PreparedStatement statement = ConnectionProvider.getInstance().getConnection().prepareStatement(query);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                pizzaria = new Pizzaria();
                pizzaria.setId(resultSet.getInt("id"));
                pizzaria.setNome(resultSet.getString("nome"));
                pizzaria.setPrecoPeq(resultSet.getDouble("preco_peq"));
                pizzaria.setPrecoMed(resultSet.getDouble("preco_med"));
                pizzaria.setPrecoGrd(resultSet.getDouble("preco_grd"));
                pizzaria.setPrecoBorda(resultSet.getDouble("preco_borda"));
            }
        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        }
        return pizzaria;
    }

    @Override
    public List<Pizzaria> buscarTodos() throws Exception {
        List<Pizzaria> lista = new LinkedList<>();
        Pizzaria pizzaria = new Pizzaria();
        try {
            String query = "select * from Pizzaria";
            PreparedStatement statement = ConnectionProvider.getInstance()
                    .getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                pizzaria = new Pizzaria();
                pizzaria.setId(resultSet.getInt("id"));
                pizzaria.setNome(resultSet.getString("nome"));
                pizzaria.setPrecoPeq(resultSet.getDouble("preco_peq"));
                pizzaria.setPrecoMed(resultSet.getDouble("preco_med"));
                pizzaria.setPrecoGrd(resultSet.getDouble("preco_grd"));
                pizzaria.setPrecoBorda(resultSet.getDouble("preco_borda"));
                lista.add(pizzaria);
            }
        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        }
        return lista;
    }
}
