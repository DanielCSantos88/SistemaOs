
package br.com.sistemaos.dao;

import br.com.sistemaos.dal.ModuloConexao;
import br.com.sistemaos.modelo.ControladorDeAcesso;
import br.com.sistemaos.telas.TelaCadastraAcesso;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorDeAcessoDao {
    
    public List<ControladorDeAcesso> logar(String login, String senha){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        List<ControladorDeAcesso> controladorDeAcessos = new ArrayList<>();
        
        try {
            
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));
    
            StringBuilder sb = new StringBuilder();
            
            for(byte b: messageDigest){
                sb.append(String.format("%02X", 0xFF & b));  
            }
            
            String senhaHex = sb.toString();
            
            pst = conexao.prepareStatement("SELECT "
                                         + "id_pessoa_fk_cda, "
                                         + "nome_pes "
                                         + "FROM "
                                         + "tb_controlador_de_acesso "
                                         + "INNER JOIN "
                                         + "tb_pessoa "
                                         + "ON id_pessoa_fk_cda = id_pes "
                                         + "WHERE "
                                         + "login_cda = ? AND senha_cda = ? ");

            pst.setString(1, login);
            pst.setString(2, senhaHex);
            
            rs = pst.executeQuery();
            if (rs.next()) {
                ControladorDeAcesso controladorDeAcesso = new ControladorDeAcesso();
                controladorDeAcesso.setIdPessoaFkCda(rs.getLong(1));
                controladorDeAcesso.setNomePessoaFkCda(rs.getString(2));
                controladorDeAcessos.add(controladorDeAcesso);
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar!" + ex);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            JOptionPane.showMessageDialog(null,  ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst);
        }
        return controladorDeAcessos;
    }
    
    public boolean buscarCadastroAcesso(String cpfCnpj){
  
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean retorno = false;
  
        try {
            pst = conexao.prepareStatement("SELECT "
                                         + "id_cda, "
                                         + "login_cda "
                                         + "FROM "
                                         + "tb_controlador_de_acesso "
                                         + "INNER JOIN "
                                         + "tb_pessoa "
                                         + "ON id_pessoa_fk_cda = id_pes "
                                         + "WHERE cpfcnpj_pes = ? ");
            
            pst.setString(1, cpfCnpj);
            
            rs = pst.executeQuery();
           
            if(rs.next()){
                retorno = true;
                TelaCadastraAcesso.idCadastraAcesso = rs.getLong(1);
                TelaCadastraAcesso.txtLoginTelaCadastraAcesso.setText(rs.getString(2));
            }        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }
        return retorno; 
    }
    
    public boolean verificarCadastroAcesso(Long idPessoa){
  
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean retorno = false;
  
        try {
            pst = conexao.prepareStatement("SELECT "
                                         + "id_cda "
                                         + "FROM "
                                         + "tb_controlador_de_acesso "
                                         + "WHERE "
                                         + "id_pessoa_fk_cda = ? ");
            
            pst.setLong(1, idPessoa);
            
            rs = pst.executeQuery();
           
            if(rs.next()){
                retorno = true;
            }        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }
        return retorno; 
    }
    
     public boolean adicionarCadastroAcesso(ControladorDeAcesso controladorDeAcesso){
      
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null; 
        boolean retorno = false;
        
        String senha = controladorDeAcesso.getSenhaCda();
        try {
            
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));
    
            StringBuilder sb = new StringBuilder();
            
            for(byte b: messageDigest){
                sb.append(String.format("%02X", 0xFF & b));  
            }
            
            String senhaHex = sb.toString();
            
            pst = conexao.prepareStatement("INSERT INTO "
                                         + "tb_controlador_de_acesso"
                                         + "(login_cda, "
                                         + "senha_cda, "
                                         + "id_pessoa_fk_cda) "
                                         + "VALUES "
                                        + "(?, ?, ?)");
            
            pst.setString(1, controladorDeAcesso.getLoginCda());
            pst.setString(2, senhaHex);
            pst.setLong(3, controladorDeAcesso.getIdPessoaFkCda());
           
           if(pst.executeUpdate() == 1){
                retorno = true;
            }
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel ao salvar. Já existe um login cadastrado!");
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            JOptionPane.showMessageDialog(null,  ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst);
        }    
        return retorno;
    }
     
    public boolean editarCadastroAcesso(ControladorDeAcesso controladorDeAcesso) {

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;

        String senha = controladorDeAcesso.getSenhaCda();
        
        try {
            
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));
    
            StringBuilder sb = new StringBuilder();
            
            for(byte b: messageDigest){
                sb.append(String.format("%02X", 0xFF & b));  
            }
            
            String senhaHex = sb.toString();
            
            pst = conexao.prepareStatement("UPDATE "
                                         + "tb_controlador_de_acesso "
                                         + "SET "
                                         + "login_cda = ?, "
                                         + "senha_cda = ?  "
                                         + "WHERE "
                                         + "id_cda = ? ");
            
            pst.setString(1, controladorDeAcesso.getLoginCda());
            pst.setString(2, senhaHex);
            pst.setLong(3, controladorDeAcesso.getIdCda());
  
           if(pst.executeUpdate() == 1){
                retorno = true;
            }
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel ao editar. Já existe um login cadastrado!");
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            JOptionPane.showMessageDialog(null,  ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst);
        } 
        return retorno;
    }
    
    public boolean deletarCadastroAcesso(Long idPessoa) {

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;
        
        try {
            pst = conexao.prepareStatement("DELETE "
                                         + "FROM "
                                         + "tb_controlador_de_acesso "
                                         + "WHERE "
                                         + "id_pessoa_fk_cda = ? ");
            
            pst.setLong(1, idPessoa);

            if(pst.executeUpdate() == 1){
                retorno = true;
            };

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst);
        }
        return retorno;
    }
}

