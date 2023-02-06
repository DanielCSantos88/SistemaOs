
package br.com.sistemaos.dao;

import br.com.sistemaos.dal.ModuloConexao;
import br.com.sistemaos.modelo.Setor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SetorDao {
      
    public List<Setor> buscarSetorTabelas(){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        List<Setor> setores = new ArrayList<>();
        
        try {
            pst = conexao.prepareStatement("SELECT "
                                         + "id_set, "
                                         + "nome_set "
                                         + "FROM "
                                         + "tb_setor "
                                         + "ORDER BY "
                                         + "nome_set");
            
            rs = pst.executeQuery();
           
            while(rs.next()){              
                Setor setor = new Setor();
                setor.setIdSet(rs.getLong(1));
                setor.setNomeSet(rs.getString(2));
                setores.add(setor);
            }   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }
        return setores;
    }
    
    public boolean adicionarSetor(Setor setor){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null; 
        boolean retorno = false;
        try {
            pst = conexao.prepareStatement("INSERT INTO "
                                         + "tb_setor "
                                         + "(nome_set) "
                                         + "VALUES "
                                         + "(?)");
           
            pst.setString(1, setor.getNomeSet().toUpperCase());
            
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
    
    public boolean editarSetor(Setor setor) {

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;

        try {
            pst = conexao.prepareStatement("UPDATE "
                                         + "tb_setor "
                                         + "SET "
                                         + "nome_set = ? "
                                         + "WHERE "
                                         + "id_set = ? ");
          
            pst.setString(1, setor.getNomeSet().toUpperCase());
            pst.setLong(2, setor.getIdSet());
            
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
