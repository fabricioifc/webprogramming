package ifc.dao;

import ifc.model.Ingrediente;
import ifc.utils.Transacao;
import java.util.List;

public interface PizzaIngredienteDao {
    
    public void inserirIngredientePizza(Integer idPizza, List<Ingrediente> ingredientes) throws Exception;
    public void removerIngredientesPizza(Integer idPizza) throws Exception;
    public List<Ingrediente> getIngredientesPizza(Integer idPizza) throws Exception;
    
}
