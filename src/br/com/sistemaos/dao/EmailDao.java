
package br.com.sistemaos.dao;

import Jm.JMascara;
import br.com.sistemaos.dal.ModuloConexao;
import br.com.sistemaos.modelo.Email;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class EmailDao {
    
    public List<Email> buscarEmailTabelas(Long idPessoa){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        List<Email> emails = new ArrayList<>();
        
        try {
            pst = conexao.prepareStatement("SELECT "
                                         + "id_ema, "
                                         + "email_ema, "
                                         + "responsavel_ema, "
                                         + "concat(substring(dataAniversario_ema,1,2),'/',substring(dataAniversario_ema,3,2)) as dataAniversario_ema , "
                                         + "departamento_ema "
                                         + "FROM "
                                         + "tb_email "
                                         + "WHERE "
                                        + "id_pessoa_fk_ema = ? ");
           
            pst.setLong(1, idPessoa);
            
            rs = pst.executeQuery();
           
            while(rs.next()){              
                Email email = new Email();
                email.setIdEma(rs.getLong(1));
                email.setEmailEma(rs.getString(2));
                email.setResponsavelEma(rs.getString(3));
                if(!rs.getString(4).equals("/")){
                     email.setDataAniversarioEma(rs.getString(4));
                }
                email.setDepartamentoEma(rs.getString(5));
               
                emails.add(email);  
            }   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }
        return emails;
    }
    
     public boolean adicionarEmail(Email email){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null; 
        boolean retorno = false;

        try {
            pst = conexao.prepareStatement("INSERT INTO "
                                         + "tb_email"
                                         + "(email_ema, "
                                         + "responsavel_ema, "
                                         + "dataAniversario_ema, "
                                         + "departamento_ema, "
                                         + "id_pessoa_fk_ema) "
                                         + "VALUES "
                                         + "(?, ?, ?, ?, ?)");
            
            pst.setString(1, email.getEmailEma().toLowerCase());
            pst.setString(2, email.getResponsavelEma().toUpperCase());
            pst.setString(3, email.getDataAniversarioEma());
            pst.setString(4, email.getDepartamentoEma().toUpperCase());
            pst.setLong(5, email.getIdPessoaFkEma());
   
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
    
    public boolean editarEmail(Email email) {

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;

        try {
            pst = conexao.prepareStatement("UPDATE "
                                         + "tb_email "
                                         + "SET email_ema = ?, "
                                         + "responsavel_ema = ?, "
                                         + "dataAniversario_ema = ?, "
                                         + "departamento_ema = ?"
                                         + " WHERE "
                                         + "id_ema = ?");
           
            pst.setString(1, email.getEmailEma().toLowerCase());
            pst.setString(2, email.getResponsavelEma().toUpperCase());
            pst.setString(3, email.getDataAniversarioEma());
            pst.setString(4, email.getDepartamentoEma().toUpperCase());
            pst.setLong(5, email.getIdEma());
  
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
     
    public boolean deletarEmailPessoa(Long idEmail) {

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;
        try {
            pst = conexao.prepareStatement("DELETE FROM "
                                         + "tb_email "
                                         + "WHERE "
                                         + "id_ema = ? ");
          
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
}
