/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.enem.bean.remote;

import br.com.ifc.enem.entidades.Usuarios;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author fabricio
 */
@Remote
public interface HomeBeanRemote {

    public String olaMundo() throws Exception;
    public List<Usuarios> getUsuarios() throws Exception;
}
