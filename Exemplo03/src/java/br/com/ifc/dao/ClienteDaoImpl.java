package br.com.ifc.dao;

import br.com.ifc.model.Cliente;
import br.com.ifc.utils.ConnectionProvider;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao {

    @Override
    public void listar() throws Exception {
        String sql = "select * from clientes";
        PreparedStatement ps = ConnectionProvider.getInstance().getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Cliente> lista = new ArrayList<>();
        Cliente c = null;
        while (rs.next()) {            
            c = new Cliente();
            c.setId(rs.getLong("id"));
            c.setCpf(rs.getString("cpf"));
            c.setCpf(rs.getString("nome"));
            c.setCpf(rs.getString("email"));
            c.setDtNascimento(rs.getDate("dt_nascimento"));
            c.setSexo(rs.getString("sexo"));
        }
    }

    @Override
    public void salvar(Cliente c) throws Exception {
        String sql = "insert into clientes (cpf, nome, email, sexo, dt_nascimento) values (?,?,?,?,?)";
        PreparedStatement ps = ConnectionProvider.getInstance().getConnection().prepareStatement(sql);
        int i = 1;
        ps.setString(i++, c.getCpf());
        ps.setString(i++, c.getNome());
        ps.setString(i++, c.getEmail());
        ps.setString(i++, c.getSexo());
        ps.setDate(i++, new java.sql.Date(c.getDtNascimento().getTime()));
        ps.executeUpdate();
    }

    @Override
    public void excluir(Long id) throws Exception {
        String sql = "delete from clientes where id = ?";
        PreparedStatement ps = ConnectionProvider.getInstance().getConnection().prepareStatement(sql);
        ps.setLong(1, id);
        ps.executeUpdate();
    }

    @Override
    public void atualizar(Cliente c) throws Exception {
        String sql = "update clientes set cpf = ?, nome = ?, email = ?, dt_nascimento = ?, sexo = ? where id = ?";
        PreparedStatement ps = ConnectionProvider.getInstance().getConnection().prepareStatement(sql);
        int i = 1;
        ps.setString(i++, c.getCpf());
        ps.setString(i++, c.getNome());
        ps.setString(i++, c.getEmail());
        ps.setString(i++, c.getSexo());
        ps.setDate(i++, new java.sql.Date(c.getDtNascimento().getTime()));
        ps.setLong(i++, c.getId());
        ps.executeUpdate();
    }

}
