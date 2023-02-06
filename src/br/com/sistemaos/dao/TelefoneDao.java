
package br.com.sistemaos.dao;

import Jm.JMascara;
import br.com.sistemaos.dal.ModuloConexao;
import br.com.sistemaos.modelo.Telefone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class TelefoneDao {
    
    public List<Telefone> buscarTelefoneTabelas(Long idPessoa){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        List<Telefone> telefones = new ArrayList<>();
        
        try {
            pst = conexao.prepareStatement("SELECT "
                                         + "id_tel, "
                                         + "telefone_tel, "
                                         + "responsavel_tel, "
                                         + "concat(substring(dataAniversario_tel,1,2),'/',substring(dataAniversario_tel,3,2)) as dataAniversario_tel, "
                                         + "departamento_tel "
                                         + "FROM "
                                         + "tb_telefone "
                                         + "WHERE "
                                         + "id_pessoa_fk_tel = ? ");
            
            pst.setLong(1, idPessoa);
            
            rs = pst.executeQuery();
           
            while(rs.next()){                              
                Telefone telefone = new Telefone();
                telefone.setIdTel(rs.getLong(1));
                telefone.setTelefoneTel(JMascara.GetJmascaraFone(JMascara.GetJmascaraFone(rs.getString(2))));
                telefone.setResponsavelTel(rs.getString(3));
                if(!rs.getString(4).equals("/")){
                    telefone.setDataAniversarioTel(rs.getString(4));
                }
                telefone.setDepartamentoTel(rs.getString(5));
                
                telefones.add(telefone);           
            }           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }        
        return telefones;      
    }
    
    public boolean adicionarTelefone(Telefone telefone){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;

        try {
            pst = conexao.prepareStatement("INSERT INTO "
                                         + "tb_telefone"
                                         + "(telefone_tel, "
                                         + "responsavel_tel, "
                                         + "dataAniversario_tel, "
                                         + "departamento_tel, "
                                         + "id_pessoa_fk_tel) " 
                                         + "VALUES "
                                         + "(?, ?, ?, ?, ?)");
          
            pst.setString(1, telefone.getTelefoneTel());
            pst.setString(2, telefone.getResponsavelTel().toUpperCase());
            pst.setString(3, telefone.getDataAniversarioTel());
            pst.setString(4, telefone.getDepartamentoTel().toUpperCase());
            pst.setLong(5, telefone.getIdPessoaFkTel());
   
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
    
    public boolean editarTelefone(Telefone telefone) {

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;

        try {
            pst = conexao.prepareStatement("UPDATE "
                                         + "tb_telefone "
                                         + "SET "
                                         + "telefone_tel = ?, "
                                         + "responsavel_tel = ?, "
                                         + "dataAniversario_tel = ?, "
                                         + "departamento_tel = ? "
                                         + "WHERE "
                                         + "id_tel = ?");
          
            pst.setString(1, telefone.getTelefoneTel());
            pst.setString(2, telefone.getResponsavelTel().toUpperCase());
            pst.setString(3, telefone.getDataAniversarioTel());
            pst.setString(4, telefone.getDepartamentoTel().toUpperCase());
            pst.setLong(5, telefone.getIdTel());

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
    
    public boolean deletarTelefone(Long idTelefone) {

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;
        try {
            pst = conexao.prepareStatement("DELETE "
                                         + "FROM "
                                         + "tb_telefone"
                                         + " WHERE "
                                         + "id_tel = ? ");
           
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
   
}
