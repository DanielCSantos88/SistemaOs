
package br.com.sistemaos.dao;

import br.com.sistemaos.dal.ModuloConexao;
import br.com.sistemaos.modelo.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ServicoDao {
    
    public List<Servico> buscarServicoTabelas(){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        List<Servico> servicos = new ArrayList<>();
        
        try {
            pst = conexao.prepareStatement("SELECT "
                                         + "id_ser, "
                                         + "nome_ser "
                                         + "FROM "
                                         + "tb_servico "
                                         + "ORDER BY "
                                         + "nome_ser");
            
            rs = pst.executeQuery();
           
            while(rs.next()){                              
                Servico servico = new Servico();
                servico.setIdSer(rs.getLong(1));
                servico.setNomeSer(rs.getString(2));
   
                servicos.add(servico);           
            }           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }        
        return servicos;      
    }
      
     public boolean adicionarServico(Servico servico){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null; 
        boolean retorno = false;
        try {
            pst = conexao.prepareStatement("INSERT INTO "
                                         + "tb_servico"
                                         + "(nome_ser) "
                                         + "VALUES "
                                         + "(?)");
       
            pst.setString(1, servico.getNomeSer().toUpperCase());
            
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
    
    public boolean editarServico(Servico servico) {

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;

        try {
            pst = conexao.prepareStatement("UPDATE "
                                         + "tb_servico "
                                         + "SET "
                                         + "nome_ser = ? "
                                         + "WHERE "
                                         + "id_ser = ?");
            
            pst.setString(1, servico.getNomeSer().toUpperCase());
            pst.setLong(2, servico.getIdSer());
            
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
}
