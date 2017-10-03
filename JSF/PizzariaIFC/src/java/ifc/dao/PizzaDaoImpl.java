/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifc.dao;

import ifc.model.Pizza;
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
public class PizzaDaoImpl implements PizzaDao {

    private final PizzariaDao pizzariaDao;
    private final PizzaIngredienteDao pizzaIngredienteDao;

    public PizzaDaoImpl() {
        pizzariaDao = new PizzariaDaoImpl();
        pizzaIngredienteDao = new PizzaIngredienteDaoImpl();
    }

    @Override
    public void inserir(Pizza objeto) throws Exception {
        Transacao tx = TransacaoJdbcImpl.getInstance();
        Connection conn = tx.getConnection();
        String generatedColumns[] = {"id"};
        Integer idPizza = null;

        try {
            tx.begin();

            String query = "insert into Pizza (nome, Pizzaria_id) values (?, ?)";
            PreparedStatement statement = TransacaoJdbcImpl.getInstance().getConnection().prepareStatement(query, generatedColumns);
            statement.setString(1, objeto.getNome());
            statement.setInt(2, objeto.getPizzaria().getId());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                idPizza = rs.getInt(1);
                pizzaIngredienteDao.inserirIngredientePizza(idPizza, objeto.getIngredientes());
            }
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

        pizzaIngredienteDao.removerIngredientesPizza(objeto);

        try {
            tx.begin();

            String query = "delete from Pizza where id = ?";
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
    public void atualizar(Pizza objeto) throws Exception {
        Transacao tx = TransacaoJdbcImpl.getInstance();
        Connection conn = tx.getConnection();

        try {
            tx.begin();

            String query = "update Pizza set nome = ?, Pizzaria_id = ? "
                    + "where id = ?";
            PreparedStatement statement = TransacaoJdbcImpl.getInstance().getConnection().prepareStatement(query);
            statement.setString(1, objeto.getNome());
            statement.setInt(2, objeto.getPizzaria().getId());

            statement.setLong(3, objeto.getId());
            statement.executeUpdate();

            pizzaIngredienteDao.inserirIngredientePizza(objeto.getId(), objeto.getIngredientes());
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
    public Pizza buscarPorId(Integer id) throws Exception {
        Pizza pizza = null;
        try {
            String query = "select * from Pizza where id = ?";
            PreparedStatement statement = ConnectionProvider.getInstance().getConnection().prepareStatement(query);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                pizza = new Pizza();
                pizza.setId(resultSet.getInt("id"));
                pizza.setNome(resultSet.getString("nome"));
                pizza.setPizzaria(pizzariaDao.buscarPorId(resultSet.getInt("Pizzaria_id")));
                pizza.setIngredientes(pizzaIngredienteDao.getIngredientesPizza(id));
            }
        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        }
        return pizza;
    }

    @Override
    public List<Pizza> buscarTodos() throws Exception {
        List<Pizza> lista = new LinkedList<>();
        Pizza pizza = new Pizza();
        try {
            String query = "select * from Pizza";
            PreparedStatement ps = ConnectionProvider.getInstance()
                    .getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pizza = new Pizza();
                pizza.setId(rs.getInt("id"));
                pizza.setNome(rs.getString("nome"));
                pizza.setPizzaria(pizzariaDao.buscarPorId(rs.getInt("Pizzaria_id")));
                pizza.setIngredientes(pizzaIngredienteDao.getIngredientesPizza(rs.getInt("id")));
                lista.add(pizza);
            }
        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        }
        return lista;
    }

}
