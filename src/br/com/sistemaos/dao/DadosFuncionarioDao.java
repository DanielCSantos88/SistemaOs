
package br.com.sistemaos.dao;

import br.com.sistemaos.dal.ModuloConexao;
import br.com.sistemaos.modelo.DadosFuncionario;
import br.com.sistemaos.telas.TelaCadastraDadosFuncionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DadosFuncionarioDao {
    
     public Long buscarIdDadosFuncionario(Long idFuncionario){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Long idDadosFuncionario = null;
        
        try {
            pst = conexao.prepareStatement("SELECT "
                                         + "id_dfu "
                                         + "FROM "
                                         + "tb_dados_funcionario "
                                         + "WHERE "
                                         + "id_funcionario_fk_dfu = ?");
            
            pst.setLong(1, idFuncionario);
            
            rs = pst.executeQuery();
           
            if(rs.next()){                
                idDadosFuncionario = rs.getLong(1);
            }        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }  
        return idDadosFuncionario;
    }
    
    public boolean buscarDadosFuncionario(Long idFuncionario){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean retorno = false;
        
        try {
            pst = conexao.prepareStatement("SELECT "
                                         + "id_dfu, "
                                         + "id_set, " 
                                         + "nome_set, "
                                         + "salario_dfu "
                                         + "FROM "
                                         + "tb_dados_funcionario "
                                         + "INNER JOIN "
                                         + "tb_setor "
                                         + "ON "
                                         + "id_set = id_setor_fk_dtu "
                                         + "WHERE "
                                         + "id_funcionario_fk_dfu = ? ");
            
            pst.setLong(1, idFuncionario);
            
            rs = pst.executeQuery();
           
            if(rs.next()){                
                retorno = true;
                TelaCadastraDadosFuncionario.idDadosFuncionario = rs.getLong(1);
                TelaCadastraDadosFuncionario.idSetor = rs.getLong(2);
                TelaCadastraDadosFuncionario.txrSetorCadastraDadosFuncionario.setText(rs.getString(3));
                TelaCadastraDadosFuncionario.txtSalarioFuncionario.setText(rs.getString(4));
            }        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }  
        return retorno;
    }
    
    public boolean adicionarDadosFuncionario(DadosFuncionario funcionario){
    
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null; 
        boolean retorno = false;
        try {
            pst = conexao.prepareStatement("INSERT INTO "
                                         + "tb_dados_funcionario"
                                         + "(salario_dfu, "
                                         + "id_setor_fk_dtu, "
                                         + "id_funcionario_fk_dfu)"
                                         + "VALUES "
                                         + "(?, ?, ?)");
           
            pst.setString(1, funcionario.getSalarioDfu());
            pst.setLong(2, funcionario.getIdSetorFkDfu());
            pst.setLong(3, funcionario.getIdFuncionarioFkDfu());
           
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
    
    public boolean editarDadosFuncionario(DadosFuncionario funcionario) {

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;

        try {
            pst = conexao.prepareStatement("UPDATE "
                                         + "tb_dados_funcionario "
                                         + "SET "
                                         + "salario_dfu = ? , "
                                         + "id_setor_fk_dtu = ? "
                                         + "WHERE "
                                         + "id_dfu = ?");
           
            pst.setString(1, funcionario.getSalarioDfu());
            pst.setLong(2, funcionario.getIdSetorFkDfu());
            pst.setLong(3, funcionario.getIdDfu());

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
    
    public boolean deletarDadosFuncionario(Long idDadosFuncionario) {

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;
        try {
            pst = conexao.prepareStatement("DELETE "
                                         + "FROM "
                                         + "tb_dados_funcionario "
                                         + "WHERE "
                                         + "id_dfu = ? ");
            
            pst.setLong(1, idDadosFuncionario);
        
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
