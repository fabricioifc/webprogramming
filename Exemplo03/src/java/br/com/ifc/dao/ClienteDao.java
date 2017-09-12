package br.com.ifc.dao;

import br.com.ifc.model.Cliente;

public interface ClienteDao {
    
    public void listar() throws Exception;
    public void salvar(Cliente c) throws Exception;
    public void atualizar(Cliente c) throws Exception;
    public void excluir(Long id) throws Exception;
    
}
