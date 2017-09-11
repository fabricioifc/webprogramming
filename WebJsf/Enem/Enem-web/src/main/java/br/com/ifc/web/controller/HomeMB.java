/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.web.controller;

import br.com.ifc.enem.bean.remote.HomeBeanRemote;
import br.com.ifc.enem.entidades.Usuarios;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author fabricio
 */
@ManagedBean
@RequestScoped
public class HomeMB {

    @EJB
    private HomeBeanRemote homeBeanRemote;

    public List<Usuarios> getUsuarios() throws Exception {
        return homeBeanRemote.getUsuarios();
    }

    public String hello() throws Exception {
        try {
            return homeBeanRemote.olaMundo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
