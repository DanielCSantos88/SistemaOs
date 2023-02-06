
package br.com.sistemaos.dao;

import br.com.sistemaos.dal.ModuloConexao;
import br.com.sistemaos.modelo.Pessoa;
import br.com.sistemaos.telas.TelaCadastraConsultaPessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class PessoaDao {
 
    public boolean buscarPessoa(String cpfCnpj){

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean retorno = false;
  
        try {
            pst = conexao.prepareStatement("SELECT "
                                         + "id_pes, "
                                         + "nome_pes, "
                                         + "referencia_pes "
                                         + "FROM "
                                         + "tb_pessoa "
                                         + "WHERE "
                                         + "cpfcnpj_pes= ? ");
            
            pst.setString(1, cpfCnpj);
            
            rs = pst.executeQuery();
           
            if(rs.next()){
                retorno = true;
                TelaCadastraConsultaPessoa.idPessoaTelaConsultaPessoa = rs.getLong(1);
                TelaCadastraConsultaPessoa.txtNomeTelaConsultaPessoa.setText(rs.getString(2));   
                TelaCadastraConsultaPessoa.tipoPessoaTelaConsultaPessoa = rs.getInt(3);
            }        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }
        return retorno; 
    }
    
    public List<Pessoa> buscarDadosPessoa(String cpfCnpj){
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        List<Pessoa> dados = new ArrayList<>();
        
        try {
            pst = conexao.prepareStatement("SELECT "
                                         + "id_pes, "
                                         + "nome_pes, "
                                         + "referencia_pes "
                                         + "FROM "
                                         + "tb_pessoa "
                                         + "WHERE "
                                         + "cpfcnpj_pes = ? ");
            
            pst.setString(1, cpfCnpj);
            
            rs = pst.executeQuery();
           
            if(rs.next()){
                Pessoa pessoa = new Pessoa();
                pessoa.setIdPes(rs.getLong(1));
                pessoa.setNomePes(rs.getString(2));
                pessoa.setReferenciaTipoPessoaPes(rs.getInt(3));
                dados.add(pessoa);
            }        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }   
        return dados;
    }
    
    public boolean adicionarPessoa(Pessoa pessoa){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null; 
        boolean retorno = false;
        
        try {
            pst = conexao.prepareStatement("INSERT INTO "
                                         + "tb_pessoa"
                                         + "(nome_pes, "
                                         + "cpfcnpj_pes, "
                                         + "referencia_pes) "
                                         + "VALUES "
                                         + "(?, ?, ?)");
            
            pst.setString(1, pessoa.getNomePes().toUpperCase());
            pst.setString(2, pessoa.getCpfCnpjPes());
            pst.setInt(3, pessoa.getReferenciaTipoPessoaPes());
            
            if(pst.executeUpdate() ==1){
               retorno = true;
            }  
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar. " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst);
        }       
        return retorno;
    }
    
    public boolean editarPessoa(Pessoa pessoa) {
    
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;

        try {
            pst = conexao.prepareStatement("UPDATE "
                                         + "tb_pessoa "
                                         + "SET "
                                         + "nome_pes = ?, "
                                         + "referencia_pes = ? "
                                         + "WHERE "
                                         + "id_pes = ? ");
           
           pst.setString(1, pessoa.getNomePes().toUpperCase());
           pst.setInt(2, pessoa.getReferenciaTipoPessoaPes());
           pst.setLong(3, pessoa.getIdPes());
           
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
    
    public boolean deletarPessoa(Long idPessoa) {
      
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;
        try {
            pst = conexao.prepareStatement("DELETE FROM "
                                         + "tb_pessoa "
                                         + "WHERE "
                                         + "id_pes = ? ");
            
            pst.setLong(1, idPessoa);
            
            if(pst.executeUpdate()== 1){
                retorno = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst);
        }
        return retorno;
    }
    
    public boolean deletarTodosTelefonesPessoa(Long idTelefone) {
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;
        try {
            pst = conexao.prepareStatement("DELETE FROM "
                                         + "tb_telefone "
                                         + "WHERE "
                                         + "id_pessoa_fk_tel = ? ");
            
            pst.setLong(1, idTelefone);
    
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
    
    public boolean deletarTodosEmailsPessoa(Long idEmail) {
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;
        try {
            pst = conexao.prepareStatement("DELETE FROM "
                                         + "tb_email "
                                         + "WHERE "
                                         + "id_pessoa_fk_ema = ? ");
            
            pst.setLong(1, idEmail);
   
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
    
    public boolean deletarTodosEnderecosPessoa(Long idPessoa) {
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;
        
        try {
            pst = conexao.prepareStatement("DELETE FROM "
                                         + "tb_endereco "
                                         + " WHERE "
                                         + "id_pessoa_fk_end = ? ");
           
            pst.setLong(1, idPessoa);
            
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
    
    public boolean deletarTodasOs(Long idPessoa) {

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;
        try {
            pst = conexao.prepareStatement("DELETE "
                                         + "FROM "
                                         + "tb_os "
                                         + "WHERE "
                                         + "id_cliente_fk_os = ? ");
            
            pst.setLong(1, idPessoa);

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


