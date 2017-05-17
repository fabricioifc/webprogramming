package br.com.ifc.testes;

import br.com.ifc.utils.Conexao;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConexaoTeste {

    public ConexaoTeste() {
    }

    /**
     * Verificar se a conexão funciona
     */
    @org.junit.Test
    public void testarConexao() {
        try {
            Connection conn = Conexao.getConnection();
            assertTrue(conn.isValid(0));
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.closeConnection();
        }
    }

    /**
     * Verificar se a tabela usuarios foi criada
     */
    @Test
    public void testarTabelaExiste() {
        try {
            Connection conn = Conexao.getConnection();
            if (conn != null) {
                DatabaseMetaData dbm = conn.getMetaData();
                ResultSet tables = dbm.getTables(null, null, "usuarios", null);
                //Verificar se a tabela existe mesmo
                assertTrue(tables.next());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.closeConnection();
        }
    }

}
