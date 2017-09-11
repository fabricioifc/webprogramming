/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.converters;

import br.com.ifc.controller.ClienteBean;
import br.com.ifc.model.TipoPessoa;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author fabricio
 */
@FacesConverter(forClass = TipoPessoa.class)
public class TipoPessoaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        System.out.println("getAsObject: " + value);

        ClienteBean clienteBean = (ClienteBean) FacesContext.getCurrentInstance().getELContext().getELResolver().getValue(context.getELContext(), null, "clienteBean");
        if (value == null || clienteBean == null) {
            return null;
        }

        Long idTipo = Long.parseLong(value);

        for (TipoPessoa t : clienteBean.getTipos()) {
            if (t.getId().equals(idTipo)) {
                return t;
            }
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("getAsString: " + value);
        return value.toString();
    }

}
