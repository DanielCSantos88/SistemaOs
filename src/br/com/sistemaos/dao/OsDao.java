
package br.com.sistemaos.dao;

import Jm.JMascara;
import br.com.sistemaos.dal.ModuloConexao;
import br.com.sistemaos.modelo.Os;
import br.com.sistemaos.telas.TelaOs;
import br.com.sistemaos.util.TipoServico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class OsDao {
   

   public List<Os> buscarHistoricoPessoaOs(Long id){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        List<Os> ordemDeServicos = new ArrayList<>();
        
        try {
            pst = conexao.prepareStatement("SELECT id_os, data_os, "
                                         + "CASE WHEN "
                                         + "	tipo_os = 1 "
                                         + "    THEN 'ORÇAMENTO' "
                                         + "	ELSE 'ORDEM DE SERVIÇO' "
                                         + "END AS tipo_os, "
                                         + "situacao_os, nome_mar, nome_pro, nome_def, nome_ser, nome_pes as funcionario, valor_os FROM tb_os "
                                         + "INNER JOIN tb_marca ON id_marca_fk_os = id_mar "
                                         + "INNER JOIN tb_produto ON id_produto_fk_os = id_pro "
                                         + "INNER JOIN tb_defeito ON id_defeito_fk_os = id_def "
                                         + "INNER JOIN tb_servico ON id_servico_fk_os = id_ser "
                                         + "INNER JOIN tb_pessoa ON id_funcionario_fk_os = id_pes "
                                         + "WHERE id_cliente_fk_os = ? ORDER BY id_os DESC");
            
            pst.setLong(1, id);
            
            rs = pst.executeQuery();
           
            while(rs.next()){                              
                Os os = new Os();
                os.setIdOs(rs.getLong(1));
                os.setDataOs(rs.getString(2));
                os.setNomeTipoOs(rs.getString(3));
                os.setSituacaoOs(rs.getString(4));
                os.setNomeMarcaOs(rs.getString(5));
                os.setNomeProdutoOs(rs.getString(6));
                os.setNomeDefeitoOs(rs.getString(7));
                os.setNomeServicoOs(rs.getString(8));
                os.setNomeFuncionarioOs(rs.getString(9));
                os.setValorOs(rs.getString(10));
                ordemDeServicos.add(os);
            }           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }        
        return ordemDeServicos;      
    }
   
    public String buscarNomeFuncionario(Long idFuncionario){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String nomeFuncionario = null;
        
        try {
            pst = conexao.prepareStatement("SELECT "
                    + "nome_pes "
                    + "FROM "
                    + "tb_pessoa "
                    + "WHERE "
                    + "referencia_pes = 3 "
                    + "AND id_pes = ? ");
            
            pst.setLong(1, idFuncionario);
            
            rs = pst.executeQuery();
           
            if(rs.next()){                
                nomeFuncionario = rs.getString(1);
            }        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }  
        return nomeFuncionario;
    }
    
    public boolean buscarOs(Long idOs){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean retorno = false;
   
        try {
            pst = conexao.prepareStatement("SELECT DATE_FORMAT(data_os, '%d/%m/%Y - %H:%i') as data_os, tipo_os, situacao_os, "
                                         + "id_marca_fk_os, nome_mar, id_produto_fk_os, nome_pro, id_defeito_fk_os, nome_def, "
                                         + "id_servico_fk_os, nome_ser, "
                                         + "id_funcionario_fk_os, "
                                         + "(select nome_pes from tb_pessoa where id_pes = id_funcionario_fk_os) as funcionario, "
                                         + "id_cliente_fk_os, "
                                         + "(select nome_pes from tb_pessoa where id_pes = id_cliente_fk_os) as cliente, "
                                         + "(select cpfcnpj_pes from tb_pessoa where id_pes = id_cliente_fk_os) as cpfCnpjCliente, "
                                         + "valor_os "
                                         + "FROM tb_os "
                                         + "INNER JOIN tb_pessoa ON id_funcionario_fk_os = id_pes "
                                         + "INNER JOIN tb_marca ON id_marca_fk_os = id_mar "
                                         + "INNER JOIN tb_produto ON id_produto_fk_os = id_pro "
                                         + "INNER JOIN tb_defeito ON id_defeito_fk_os = id_def "
                                         + "INNER JOIN tb_servico ON id_servico_fk_os = id_ser "
                                         + "WHERE id_os = ?");

            pst.setLong(1, idOs);
   
            rs = pst.executeQuery();
           
            if(rs.next()){
                retorno = true;
                TelaOs.txtDataOs.setText(rs.getString(1));
                TelaOs.tipoServicoOs = rs.getInt(2);
                if(TelaOs.tipoServicoOs == TipoServico.ORCAMENTO.getValor()){
                    TelaOs.rbtOrcamentoOs.setSelected(true);
                }else{
                    TelaOs.rbtOrdemDeServicoOs.setSelected(true);
                }
                TelaOs.cboSituacaoOs.setSelectedItem(rs.getString(3));
                TelaOs.idMarcaOs = rs.getLong(4);
                TelaOs.txtNomeMarcaOs.setText(rs.getString(5));
                TelaOs.idProdutoOs = rs.getLong(6);
                TelaOs.txtNomeProdutoOs.setText(rs.getString(7));
                TelaOs.idDefeitoOs = rs.getLong(8);
                TelaOs.txtNomeDefeitoOs.setText(rs.getString(9));
                TelaOs.idServicoOs = rs.getLong(10);
                TelaOs.txtNomeServicoOs.setText(rs.getString(11));
                TelaOs.idFuncionarioOs = rs.getLong(12);
                TelaOs.txtNomeFuncionarioOs.setText(rs.getString(13));
                TelaOs.idClienteOs = rs.getLong(14);
                TelaOs.txtNomeClienteOs.setText(rs.getString(15));
                TelaOs.txtcpfCnpjClienteOs.setText(JMascara.GetJmascaraCpfCnpj(rs.getString(16)));  
                TelaOs.txtValorOs.setText(rs.getString(17));
            }        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }
        return retorno;
    }
    
    public Long buscarIdOs(Long idPessoa){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Long idOs = null;
   
        try {
            pst = conexao.prepareStatement("SELECT "
                                         + "id_os "
                                         + "FROM "
                                         + "tb_os "
                                         + "WHERE "
                                         + "id_cliente_fk_os = ? ");

            pst.setLong(1, idPessoa);
   
            rs = pst.executeQuery();
           
            if(rs.next()){
                idOs = rs.getLong(1);
            }        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! " + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }
        return idOs;
    }
      
    public boolean adicionarOs(Os os){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;
        try {
            pst = conexao.prepareStatement("INSERT INTO "
                                         + "tb_os"
                                         + "(tipo_os, "
                                         + "situacao_os, "
                                         + "id_marca_fk_os, "
                                         + "id_produto_fk_os, "
                                         + "id_defeito_fk_os, "
                                         + "id_servico_fk_os, "
                                         + "id_funcionario_fk_os, "
                                         + "id_cliente_fk_os, "
                                         + "valor_os) "
                                         + "VALUES "
                                         + "(?, ?, ?, ?, ?, ?, ?, ?, ?)");
           
            pst.setInt(1, os.getTipoOs());
            pst.setString(2, os.getSituacaoOs().toUpperCase());
            pst.setLong(3, os.getIdMarcaFkOs());
            pst.setLong(4, os.getIdProdutoFkOs());
            pst.setLong(5, os.getIdDefeitoFkOs());
            pst.setLong(6, os.getIdServicoFkOs());
            pst.setLong(7, os.getIdFuncionarioFkOs());
            pst.setLong(8, os.getIdClienteFkOs());
            pst.setString(9, os.getValorOs());
            
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
    
    public boolean editarOs(Os os) {

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;

        try {
            pst = conexao.prepareStatement("UPDATE "
                                         + "tb_os "
                                          + "SET "
                                         + "tipo_os = ?, "
                                         + "situacao_os = ?, "
                                         + "id_marca_fk_os = ?, "
                                         + "id_produto_fk_os = ?, "
                                         + "id_defeito_fk_os = ?, "
                                         + "id_servico_fk_os = ?, "
                                         + "id_funcionario_fk_os = ?, "
                                         + "valor_os = ? "
                                         + "WHERE id_os = ? ");
           
            pst.setInt(1, os.getTipoOs());
            pst.setString(2, os.getSituacaoOs().toUpperCase());
            pst.setLong(3, os.getIdMarcaFkOs());
            pst.setLong(4, os.getIdProdutoFkOs());
            pst.setLong(5, os.getIdDefeitoFkOs());
            pst.setLong(6, os.getIdServicoFkOs());
            pst.setLong(7, os.getIdFuncionarioFkOs());
            pst.setString(8, os.getValorOs());
            pst.setLong(9, os.getIdOs());
            
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
     
    public boolean deletarOs(Long idOs) {

        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;
        try {
            pst = conexao.prepareStatement("DELETE "
                                         + "FROM "
                                         + "tb_os "
                                         + "WHERE "
                                         + "id_os = ? ");
            
            pst.setLong(1, idOs);

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
