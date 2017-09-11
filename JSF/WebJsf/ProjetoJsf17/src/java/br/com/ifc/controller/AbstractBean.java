/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.controller;

import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author fabricio
 */
@ApplicationScoped
@ManagedBean
public class AbstractBean implements Serializable {

    private int numeroAcessos;

    public String getURI() {
        return ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRequestURI();
    }

    public int getNumeroAcessos() {
        return ++numeroAcessos;
    }

    public void setNumeroAcessos(int numeroAcessos) {
        this.numeroAcessos = numeroAcessos;
    }

}
