
package br.com.sistemaos.dao;

import Jm.JMascara;
import br.com.sistemaos.dal.ModuloConexao;
import br.com.sistemaos.modelo.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class EnderecoDao {
    
    public List<Endereco> buscarEndereco(Long idPessoa){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        List<Endereco> enderecos = new ArrayList<>();
        
        try {
            pst = conexao.prepareStatement("SELECT "
                                         + "id_end, "
                                         + "rua_end, "
                                         + "numero_end, "
                                         + "complemento_end, "
                                         + "bairro_end, "
                                         + "cep_end, "
                                         + "cidade_end, "
                                         + "uf_end " 
                                         + "FROM "
                                         + "tb_endereco "
                                         + "WHERE "
                                         + "id_pessoa_fk_end = ? ");
       
            pst.setLong(1, idPessoa);
            
            rs = pst.executeQuery();
           
            while(rs.next()){              
                Endereco endereco = new Endereco();
                endereco.setIdEnd(rs.getLong(1));
                endereco.setRuaEnd(rs.getString(2));
                endereco.setNumEnd(rs.getString(3));
                endereco.setComplementoEnd(rs.getString(4));
                endereco.setBairroEnd(rs.getString(5));
                endereco.setCepEnd(JMascara.GetJmascaraCep(rs.getString(6)));
                endereco.setCidadeEnd(rs.getString(7));
                endereco.setUfEnd(rs.getString(8));
                enderecos.add(endereco);  
            }   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }
        return enderecos;
    }
    
    public boolean adicionarEndereco(Endereco endereco){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null; 
        boolean retorno = false;

        try {
            pst = conexao.prepareStatement("INSERT INTO "
                                         + "tb_endereco "
                                         + "(rua_end, "
                                         + "numero_end, "
                                         + "complemento_end, "
                                         + "bairro_end, "
                                         + "cep_end, "
                                         + "cidade_end, "
                                         + "uf_end, "
                                         + "id_pessoa_fk_end) "
                                         + "VALUES "
                                         + "(?, ?, ?, ?, ?, ?, ?, ?)");
            
            pst.setString(1, endereco.getRuaEnd().toUpperCase());
            pst.setString(2, endereco.getNumEnd().toUpperCase());
            pst.setString(3, endereco.getComplementoEnd().toUpperCase());
            pst.setString(4, endereco.getBairroEnd().toUpperCase());
            pst.setString(5, endereco.getCepEnd());
            pst.setString(6, endereco.getCidadeEnd().toUpperCase());
            pst.setString(7, endereco.getUfEnd());
            pst.setLong(8, endereco.getIdPessoaFkEnd());
            
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
    
    public boolean editarEndereco(Endereco endereco) {

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;

        try {
            pst = conexao.prepareStatement("UPDATE "
                                         + "tb_endereco "
                                         + "SET "
                                         + "rua_end = ?, "
                                         + "numero_end = ?, "
                                         + "complemento_end = ?, "
                                         + "bairro_end = ?, "
                                         + "cep_end = ?, "
                                         + "cidade_end = ?, "
                                         + "uf_end = ? "
                                         + "WHERE "
                                         + "id_end = ?");
            
            pst.setString(1, endereco.getRuaEnd().toUpperCase());
            pst.setString(2, endereco.getNumEnd().toUpperCase());
            pst.setString(3, endereco.getComplementoEnd().toUpperCase());
            pst.setString(4, endereco.getBairroEnd().toUpperCase());
            pst.setString(5, endereco.getCepEnd());
            pst.setString(6, endereco.getCidadeEnd().toUpperCase());
            pst.setString(7, endereco.getUfEnd());
            pst.setLong(8, endereco.getIdEnd());
            
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
     
    public boolean deletarEndereco(Long idEndereco) {

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;
        
        try {
            pst = conexao.prepareStatement("DELETE "
                                         + "FROM "
                                         + "tb_endereco "
                                         + "WHERE "
                                         + "id_end = ? ");
         
            pst.setLong(1, idEndereco);

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
