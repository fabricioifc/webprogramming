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
    public boolean atualizar(Usuarios usuario) throws Exception {
        String sql = "update usuarios set nome = ?, email = ?, usuario = ?, senha = ? where id = ?";
        PreparedStatement ps = null;
        try {
            int i = 1;
            ps = Conexao.getConnection().prepareStatement(sql);
            ps.setString(i++, usuario.getNome());
            ps.setString(i++, usuario.getEmail());
            ps.setString(i++, usuario.getUsuario());
            ps.setString(i++, usuario.getSenha());

            ps.setInt(i++, usuario.getId());
            return ps.executeUpdate() == 1;
        } finally {
//            Conexao.closeConnection(rs, ps);
        }
    }

}
