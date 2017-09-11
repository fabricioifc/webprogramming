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
import br.edu.ifc.entidades.Pizzas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author fabricio
 */
public class PizzasDaoImpl implements PizzasDao {

    private IngredientesDao ingredienteDao;
    private PizzariasDao pizzariaDao;

    public PizzasDaoImpl() {
        ingredienteDao = new IngredientesDaoImpl();
        pizzariaDao = new PizzariasDaoImpl();
    }

    @Override
    public void inserir(Pizzas objeto) throws Exception {
        Transacao tx = TransacaoJdbcImpl.getInstance();
        Connection conn = tx.getConnection();

        try {
            tx.begin();

            String query = "insert into pizzas (nome, idpizzaria) values (?, ?)";
            PreparedStatement statement = TransacaoJdbcImpl.getInstance().getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, objeto.getNome());
            statement.setLong(2, objeto.getPizzaria().getIdpizzaria());
            
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            Long idpizza = rs.getLong(1);
            objeto.setIdpizza(idpizza);

            //Inserir os ingredientes por pizza
            inserirIngredientesPizza(objeto, conn);

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

            String query = "delete from pizzas where idpizza = ?";
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
    public void atualizar(Pizzas objeto) throws Exception {
        Transacao tx = TransacaoJdbcImpl.getInstance();
        Connection conn = tx.getConnection();

        try {
            tx.begin();

            String query = "update pizzas set nome = ?, idpizzaria = ? where idpizza = ?";
            PreparedStatement statement = TransacaoJdbcImpl.getInstance().getConnection().prepareStatement(query);
            statement.setString(1, objeto.getNome());
            statement.setLong(2, objeto.getPizzaria().getIdpizzaria());

            statement.setLong(3, objeto.getIdpizza());
            statement.executeUpdate();

            //Inserir os ingredientes por pizza
            inserirIngredientesPizza(objeto, conn);

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
    public Pizzas buscarPorId(Long id) throws Exception {
        Pizzas pizza = new Pizzas();
        try {
            String query = "select * from pizzas where idpizza = ?";
            PreparedStatement statement = ConnectionProvider.getInstance().getConnection().prepareStatement(query);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                pizza = new Pizzas();
                pizza.setIdpizza(resultSet.getLong("idpizza"));
                pizza.setNome(resultSet.getString("nome"));
                pizza.setPizzaria(pizzariaDao.buscarPorId(resultSet.getLong("idpizzaria")));
                pizza.setDtcadastro(resultSet.getDate("dtcadastro"));
                pizza.setIngredientes(buscarIngredientesPorPizza(resultSet.getLong("idpizza")));
            }
        } catch (SQLException sqlException) {
            throw new PersistenceException(sqlException);
        }
        return pizza;
    }

    @Override
    public List<Pizzas> buscarTodos() throws Exception {
        List<Pizzas> lista = new LinkedList<Pizzas>();
        Pizzas pizza = null;
        try {
            String query = "select * from pizzas";
            PreparedStatement statement = ConnectionProvider.getInstance()
                    .getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                pizza = new Pizzas();
                pizza.setIdpizza(resultSet.getLong("idpizza"));
                pizza.setNome(resultSet.getString("nome"));
                pizza.setDtcadastro(resultSet.getDate("dtcadastro"));
                pizza.setPizzaria(pizzariaDao.buscarPorId(resultSet.getLong("idpizzaria")));
                pizza.setIngredientes(buscarIngredientesPorPizza(resultSet.getLong("idpizza")));
                lista.add(pizza);
            }
        } catch (SQLException sqlException) {
            throw new PersistenceException(sqlException);
        }
        return lista;
    }

    private void inserirIngredientesPizza(Pizzas objeto, Connection conn) throws Exception {
        String query = "delete from pizza_ingredientes where idpizza = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setLong(1, objeto.getIdpizza());

        statement.executeUpdate();

        for (Ingredientes ingrediente : objeto.getIngredientes()) {

            statement = conn.prepareStatement(
                    "insert into pizza_ingredientes (idpizza, idingrediente) values (?, ?)"
            );
            statement.setLong(1, objeto.getIdpizza());
            statement.setLong(2, ingrediente.getIdingrediente());

            statement.executeUpdate();
        }
    }

    private List<Ingredientes> buscarIngredientesPorPizza(Long idpizza) throws Exception {
        List<Ingredientes> lista = new LinkedList<>();
        try {
            String query = "select * from pizza_ingredientes where idpizza = ?";
            PreparedStatement statement = ConnectionProvider.getInstance().getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lista.add(ingredienteDao.buscarPorId(resultSet.getLong("idingrediente")));
            }
        } catch (SQLException sqlException) {
            throw new PersistenceException(sqlException);
        }
        return lista;
    }
}
