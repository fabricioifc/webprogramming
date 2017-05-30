/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.services;

import br.com.ifc.entidades.Usuarios;
import java.util.List;

/**
 *
 * @author fabricio
 */
public interface UsuarioService {

    public List<Usuarios> listar() throws Exception;
    public boolean salvar(Usuarios usuario) throws Exception;
    public Usuarios getByUsuario(String usuario) throws Exception;
}
