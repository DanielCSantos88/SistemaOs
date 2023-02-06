
package br.com.sistemaos.dao;

import br.com.sistemaos.dal.ModuloConexao;
import br.com.sistemaos.modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutoDao {
    
    public List<Produto> buscarProdutoTabelas(Long idMarca){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            pst = conexao.prepareStatement("SELECT "
                                         + "id_pro, "
                                         + "nome_pro "
                                         + "FROM "
                                         + "tb_produto "
                                         + "WHERE "
                                         + "id_marca_fk_pro = ? "
                                         + "ORDER BY "
                                         + "nome_pro");
            
            pst.setLong(1, idMarca);
            
            rs = pst.executeQuery();
           
            while(rs.next()){                              
                Produto produto = new Produto();
                produto.setIdPro(rs.getLong(1));
                produto.setNomePro(rs.getString(2));
   
                produtos.add(produto);           
            }           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }        
        return produtos;      
    }
      
     public boolean adicionarProduto(Produto produto){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null; 
        boolean retorno = false;
        
        try {
            pst = conexao.prepareStatement("INSERT INTO "
                                         + "tb_produto"
                                         + "(nome_pro, "
                                         + "id_marca_fk_pro) "
                                         + "VALUES "
                                         + "(?, ?)");
          
            pst.setString(1, produto.getNomePro().toUpperCase());
            pst.setLong(2, produto.getIdMarcaFkPro());
            
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
    
    public boolean editarProduto(Produto produto) {

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;

        try {
            pst = conexao.prepareStatement("UPDATE "
                                         + "tb_produto "
                                         + "SET "
                                         + "nome_pro = ? "
                                         + "WHERE "
                                         + "id_pro = ? ");
           
            pst.setString(1, produto.getNomePro().toUpperCase());
            pst.setLong(2, produto.getIdPro());
            
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
