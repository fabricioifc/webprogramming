/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifc.services;

import br.com.ifc.entidades.Usuarios;
import br.com.ifc.utils.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabricio
 */
public class UsuarioServiceImpl implements UsuarioService {

    @Override
    public List<Usuarios> listar() throws Exception {
        //Implementar
        return null;
    }

    @Override
    public boolean salvar(Usuarios usuario) throws Exception {
        String sql = "insert into usuarios (nome, email, usuario, senha) values (?,?,?,?)";
        PreparedStatement ps = null;
        try {
            int i = 1;
            ps = Conexao.getConnection().prepareStatement(sql);
            ps.setString(i++, usuario.getNome());
            ps.setString(i++, usuario.getEmail());
            ps.setString(i++, usuario.getUsuario());
            ps.setString(i++, usuario.getSenha());
            return ps.executeUpdate() == 1;
        } finally {
//            Conexao.closeConnection(rs, ps);
        }
    }


    @Override
    public Usuarios getByUsuario(String usuario) throws Exception {
        Usuarios user = new Usuarios();
        try {
            PreparedStatement preparedStatement = Conexao.getConnection().
                    prepareStatement("select * from usuarios where usuario=?");
            preparedStatement.setString(1, usuario);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setUsuario(rs.getString("usuario"));
                user.setSenha(rs.getString("senha"));
                return user;
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }

}
