
package br.com.sistemaos.dao;

import br.com.sistemaos.dal.ModuloConexao;
import br.com.sistemaos.modelo.Defeito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DefeitoDao {
    
    public List<Defeito> buscarDefeitoTabelas(){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        List<Defeito> defeitos = new ArrayList<>();
        
        try {
            pst = conexao.prepareStatement("SELECT "
                                         + "id_def, "
                                         + "nome_def "
                                         + "FROM "
                                         + "tb_defeito "
                                         + "ORDER BY "
                                         + "nome_def");
            
            rs = pst.executeQuery();
           
            while(rs.next()){
                Defeito defeito = new Defeito();
                defeito.setIdDef(rs.getLong(1));
                defeito.setNomeDef(rs.getString(2));
                
                defeitos.add(defeito);           
            }           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }        
        return defeitos;      
    }
      
    public boolean adicionarDefeito(Defeito defeito){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null; 
        boolean retorno = false;
        
        try {
            pst = conexao.prepareStatement("INSERT INTO "
                                         + "tb_defeito "
                                         + "(nome_def) "
                                         + "VALUES "
                                         + "(?)");
            
            pst.setString(1, defeito.getNomeDef().toUpperCase());
            
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
    
    public boolean editarDefeito(Defeito defeito) {

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;

        try {
            pst = conexao.prepareStatement("UPDATE "
                                         + "tb_defeito "
                                         + "SET "
                                         + "nome_def = ? "
                                         + "WHERE "
                                         + "id_def = ? ");
           
            pst.setString(1, defeito.getNomeDef().toUpperCase());
            pst.setLong(2, defeito.getIdDef());
            
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
