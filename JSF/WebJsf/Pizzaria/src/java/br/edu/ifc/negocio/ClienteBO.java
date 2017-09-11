/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.negocio;

import br.edu.ifc.dao.ClientesDao;
import br.edu.ifc.dao.ClientesDaoImpl;
import br.edu.ifc.entidades.Clientes;
import java.util.List;

/**
 *
 * @author fabricio
 */
public class ClienteBO {

    private final ClientesDao dao;

    public ClienteBO() {
        dao = new ClientesDaoImpl();
    }

    public List<Clientes> buscarTodos() throws Exception {
        return dao.buscarTodos();
    }

    public void inserir(Clientes objeto) throws Exception {
        dao.inserir(objeto);
    }

    public void atualizar(Clientes objeto) throws Exception {
        dao.atualizar(objeto);
    }

    public void remover(Long objeto) throws Exception {
        dao.remover(objeto);
    }

    public Clientes buscarPorId(Long id) throws Exception {
        return dao.buscarPorId(id);
    }

}
