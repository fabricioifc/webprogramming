/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.converter;

import br.edu.ifc.entidades.Pizzarias;
import br.edu.ifc.negocio.PizzariaBO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author fabricio
 */
@FacesConverter(forClass = Pizzarias.class)
public class PizzariaConverter implements Converter {

    @Override
    public Pizzarias getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            if (value == null) {
                return null;
            }
            PizzariaBO negocio = new PizzariaBO();
            return negocio.buscarPorId(Long.parseLong(value));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Pizzarias tipo = (Pizzarias) value;
            return Long.toString(tipo.getIdpizzaria());
        } else {
            return "";
        }
    }
}
