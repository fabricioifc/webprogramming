package ifc.dao;

import ifc.model.Ingrediente;
import ifc.utils.ConnectionProvider;
import ifc.utils.Transacao;
import ifc.utils.TransacaoJdbcImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PizzaIngredienteDaoImpl implements PizzaIngredienteDao {

    private final IngredienteDao ingredienteDao;

    public PizzaIngredienteDaoImpl() {
        ingredienteDao = new IngredienteDaoImpl();
    }

    @Override
    public void inserirIngredientePizza(Integer idPizza, List<Ingrediente> ingredientes) throws Exception {
//        Remove os ingredientes da pizza (caso exista) antes de salvar
        removerIngredientesPizza(idPizza);

        try {
            String query = "insert into PizzaIngrediente (Pizza_id, Ingrediente_id) values (?, ?)";
            for (Ingrediente ingrediente : ingredientes) {
                PreparedStatement statement = TransacaoJdbcImpl.getInstance().getConnection().prepareStatement(query);
                statement.setInt(1, idPizza);
                statement.setInt(2, ingrediente.getId());

                statement.executeUpdate();
            }

        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        } finally {

        }
    }

    @Override
    public void removerIngredientesPizza(Integer idPizza) throws Exception {
        try {
            String query = "delete from PizzaIngrediente where Pizza_id = ?";
            PreparedStatement statement = TransacaoJdbcImpl.getInstance().getConnection().prepareStatement(query);
            statement.setInt(1, idPizza);

            statement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        } finally {
        }
    }

    @Override
    public List<Ingrediente> getIngredientesPizza(Integer idPizza) throws Exception {
        List<Ingrediente> lista = new LinkedList<>();
        try {
            String query = "select * from PizzaIngrediente where Pizza_id = ?";
            PreparedStatement ps = ConnectionProvider.getInstance()
                    .getConnection().prepareStatement(query);
            ps.setInt(1, idPizza);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(ingredienteDao.buscarPorId(rs.getInt("Ingrediente_id")));
            }
        } catch (SQLException sqlException) {
            throw new Exception(sqlException);
        }
        return lista;
    }
}
