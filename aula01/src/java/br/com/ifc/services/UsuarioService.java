package br.com.ifc.services;

import br.com.ifc.entidades.Usuarios;
import java.util.List;

public interface UsuarioService {

    public List<Usuarios> listar() throws Exception;
    public boolean salvar(Usuarios usuario) throws Exception;
    public boolean atualizar(Usuarios usuario) throws Exception;
    public boolean deletar(Integer usuario) throws Exception;
    public Usuarios getById(Integer id) throws Exception;
    public Usuarios autenticar(String usuario, String senha) throws Exception;
}

