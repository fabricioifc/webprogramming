/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifc.converter;

import ifc.dao.IngredienteDao;
import ifc.dao.IngredienteDaoImpl;
import ifc.dao.PizzariaDao;
import ifc.dao.PizzariaDaoImpl;
import ifc.model.Ingrediente;
import ifc.model.Pizzaria;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author fabricio
 */
@FacesConverter(forClass = Ingrediente.class, value = "IngredienteConverter")
public class IngredienteConverter implements Converter {

    private final IngredienteDao ingredienteDao;

    public IngredienteConverter() {
        ingredienteDao = new IngredienteDaoImpl();
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        try {
            if (value == null) {
                return null;
            }
            return (Ingrediente) ingredienteDao.buscarPorId(Integer.parseInt(value));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value == null) {
            return null;
        }

        Ingrediente obj = (Ingrediente) value;

        return obj.getId() + "";
    }

}
