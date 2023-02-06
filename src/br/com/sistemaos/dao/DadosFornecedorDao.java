
package br.com.sistemaos.dao;

import br.com.sistemaos.dal.ModuloConexao;
import br.com.sistemaos.modelo.DadosFornecedor;
import br.com.sistemaos.telas.TelaCadastraDadosFornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DadosFornecedorDao {
    
    public Long buscarIdDadosFornecedor(Long idFornecedor){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Long idDadosFornecedor = null;
        
        try {
            pst = conexao.prepareStatement("SELECT "
                                         + "id_dfo "
                                         + "FROM "
                                         + "tb_dados_fornecedor "
                                         + "WHERE "
                                         + "id_fornecedor_fk_dto = ? ");
            
            pst.setLong(1, idFornecedor);
            
            rs = pst.executeQuery();
           
            if(rs.next()){
                idDadosFornecedor = rs.getLong(1);
            }        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }
        return idDadosFornecedor;
    }
    
    public boolean buscarDadosFornecedor(Long idFornecedor){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean retorno = false;
        
        try {
            pst = conexao.prepareStatement("SELECT "
                                         + "id_dfo, "
                                         + "banco_dfo, "
                                         + "agencia_dfo, "
                                         + "contaCorrente_dfo, "
                                         + "pix_dfo "
                                         + "FROM "
                                         + "tb_dados_fornecedor "
                                         + "WHERE "
                                         + "id_fornecedor_fk_dto = ?");
            
            pst.setLong(1, idFornecedor);
            
            rs = pst.executeQuery();
           
            if(rs.next()){
                retorno = true;
                TelaCadastraDadosFornecedor.idDadosFornecedor = rs.getLong(1);
                TelaCadastraDadosFornecedor.txtBancoFornenecdorCadastraPessoa.setText(rs.getString(2));
                TelaCadastraDadosFornecedor.txtAgenciaFornenecdorCadastraPessoa.setText(rs.getString(3));
                TelaCadastraDadosFornecedor.txtContaCFornenecdorCadastraPessoa.setText(rs.getString(4));
                TelaCadastraDadosFornecedor.txtPixFornenecdorCadastraPessoa.setText(rs.getString(5));
            }        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }
        return retorno;
    }
    
    public boolean adicionarDadosFornecedor(DadosFornecedor dadosFornecedor){
      
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null; 
        boolean retorno = false;
        try {
            pst = conexao.prepareStatement("INSERT INTO "
                                         + "tb_dados_fornecedor"
                                         + "(banco_dfo, "
                                         + "agencia_dfo, "
                                         + " contaCorrente_dfo, "
                                         + "pix_dfo, "
                                         + "id_fornecedor_fk_dto) "
                                         + "VALUES "
                                         + "(?, ?, ?, ?, ?)");
           
            pst.setString(1, dadosFornecedor.getBancoDfo().toUpperCase());
            pst.setString(2, dadosFornecedor.getAgenciaDfo().toUpperCase());
            pst.setString(3, dadosFornecedor.getContaCorrenteDfo().toUpperCase());
            pst.setString(4, dadosFornecedor.getPixDfo());
            pst.setLong(5, dadosFornecedor.getIdFornecedorFkDfo());

            if(pst.executeUpdate() == 1){
                retorno = true;
            }              
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar. " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst);
        }     
        return retorno;
    }
    
    public boolean editarDadosFornecedor(DadosFornecedor dadosFornecedor) {

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;

        try {
            pst = conexao.prepareStatement("UPDATE "
                                         + "tb_dados_fornecedor "
                                         + "SET "
                                         + "banco_dfo = ?, "
                                         + "agencia_dfo = ?, "
                                         + "contaCorrente_dfo = ?, " 
                                         + "pix_dfo = ? "
                                         + "WHERE "
                                         + "id_dfo = ? ");
            
            pst.setString(1, dadosFornecedor.getBancoDfo().toUpperCase());
            pst.setString(2, dadosFornecedor.getAgenciaDfo().toUpperCase());
            pst.setString(3, dadosFornecedor.getContaCorrenteDfo().toUpperCase());
            pst.setString(4, dadosFornecedor.getPixDfo());
            pst.setLong(5, dadosFornecedor.getIdDfo());
  
            if(pst.executeUpdate() == 1){
                retorno = true;
            }
   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst);
        }
        return retorno;
    }
    
    public boolean deletarDadosFornecedor(Long idDadosFornecedor) {

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;
        try {
            pst = conexao.prepareStatement("DELETE "
                                         + "FROM "
                                         + "tb_dados_fornecedor "
                                         + "WHERE "
                                         + "id_dfo = ?");

            pst.setLong(1, idDadosFornecedor);

            if(pst.executeUpdate() == 1){
                retorno = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst);
        }
        return retorno;
    }
}
