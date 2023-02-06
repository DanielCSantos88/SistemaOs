
package br.com.sistemaos.dao;

import br.com.sistemaos.dal.ModuloConexao;
import br.com.sistemaos.modelo.DadosCliente;
import br.com.sistemaos.telas.TelaCadastraDadosCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DadosClienteDao {
    
    public Long buscarIdDadosCliente(Long idCliente){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Long idDadosCliente = null;
        
        try {
            pst = conexao.prepareStatement("SELECT "
                                         + "id_dcl "
                                         + "FROM "
                                         + "tb_dados_cliente "
                                         + "WHERE "
                                         + "id_cliente_fk_dcl = ? ");
            
            pst.setLong(1, idCliente);
            
            rs = pst.executeQuery();
           
            if(rs.next()){
                idDadosCliente = rs.getLong(1);
            }        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }
        return idDadosCliente;
    }
    
    public boolean buscarDadosCliente(Long idCliente){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean retorno = false;
        
        try {
            pst = conexao.prepareStatement("SELECT "
                                         + "id_dcl, "
                                         + "observacoes_dcl "
                                         + "FROM "
                                         + "tb_dados_cliente "
                                         + "WHERE "
                                         + "id_cliente_fk_dcl = ? ");
            
            pst.setLong(1, idCliente);
            
            rs = pst.executeQuery();
           
            if(rs.next()){
                retorno = true;
                TelaCadastraDadosCliente.idDadosCliente = rs.getLong(1);
                TelaCadastraDadosCliente.txaObservacoesCadastraCliente.setText(rs.getString(2));
            }        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }
        return retorno;
    }
    
    public boolean adicionarDadosCliente(DadosCliente dadosCliente){
      
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null; 
        boolean retorno = false;
        try {
            pst = conexao.prepareStatement("INSERT INTO "
                                         + "tb_dados_cliente "
                                         + "(observacoes_dcl, "
                                         + "id_cliente_fk_dcl) "
                                         + "VALUES "
                                         + "( ?, ?)");
            
            pst.setString(1, dadosCliente.getObservacoesDcl().toUpperCase());
            pst.setLong(2, dadosCliente.getIdClienteFkDcl());

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
    
    public boolean editarDadosCliente(DadosCliente dadosCliente) {

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;

        try {
            pst = conexao.prepareStatement("UPDATE "
                                         + "tb_dados_cliente "
                                         + "SET "
                                         + "observacoes_dcl = ?"
                                         + " WHERE "
                                         + "id_dcl = ? ");
            
           pst.setString(1, dadosCliente.getObservacoesDcl().toUpperCase());
           pst.setLong(2, dadosCliente.getIdDcl());
  
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
    
    public boolean deletarDadosCliente(Long idDadosCliente) {

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;
        try {
            pst = conexao.prepareStatement("DELETE "
                                         + "FROM "
                                         + "tb_dados_cliente "
                                         + "WHERE "
                                         + "id_dcl = ? ");

            pst.setLong(1, idDadosCliente);

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
