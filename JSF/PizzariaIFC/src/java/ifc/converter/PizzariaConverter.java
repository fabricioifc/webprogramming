/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifc.converter;

import ifc.dao.PizzariaDao;
import ifc.dao.PizzariaDaoImpl;
import ifc.model.Pizzaria;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author fabricio
 */
@FacesConverter(forClass = Pizzaria.class)
public class PizzariaConverter implements Converter {

    private final PizzariaDao pizzariaDao;

    public PizzariaConverter() {
        pizzariaDao = new PizzariaDaoImpl();
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        try {
            if (value == null) {
                return null;
            }
            return (Pizzaria) pizzariaDao.buscarPorId(Integer.parseInt(value));
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

        Pizzaria pizzaria = (Pizzaria) value;

        return pizzaria.getId() + "";
    }

}
