
package br.com.sistemaos.dao;

import br.com.sistemaos.dal.ModuloConexao;
import br.com.sistemaos.modelo.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MarcaDao {
    public List<Marca> buscarMarcaTabelas(){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        List<Marca> marcas = new ArrayList<>();
        
        try {
            pst = conexao.prepareStatement("SELECT "
                                         + "id_mar, "
                                         + "nome_mar "
                                         + "FROM "
                                         + "tb_marca "
                                         + "ORDER BY "
                                         + "nome_mar");
            
            rs = pst.executeQuery();
           
            while(rs.next()){                              
                Marca marca = new Marca();
                marca.setIdMar(rs.getLong(1));
                marca.setNomeMar(rs.getString(2));
                
                marcas.add(marca);           
            }           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }        
        return marcas;      
    }
      
     public boolean adicionarMarca(Marca marca){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null; 
        boolean retorno = false;
        try {
            pst = conexao.prepareStatement("INSERT INTO "
                                         + "tb_marca"
                                         + "(nome_mar) "
                                         + "VALUES "
                                         + "(?)");
            
            pst.setString(1, marca.getNomeMar().toUpperCase());
            
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
    
    public boolean editarMarca(Marca marca) {

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;

        try {
            pst = conexao.prepareStatement("UPDATE "
                                         + "tb_marca "
                                         + "SET "
                                         + "nome_mar = ? "
                                         + "WHERE "
                                         + "id_mar = ? ");
            
            pst.setString(1, marca.getNomeMar().toUpperCase());
            pst.setLong(2, marca.getIdMar());
            
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
