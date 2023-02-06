
package br.com.sistemaos.dao;

import br.com.sistemaos.dal.ModuloConexao;
import br.com.sistemaos.modelo.ConfiguradorDeUsabilidade;
import br.com.sistemaos.telas.TelaCadastraUsabilidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConfiguradorDeUsabilidadeDao {
      
    public boolean buscarConfiguracao(Long idPessoa){
     
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean retorno = false;
        
        try {           
            pst = conexao.prepareStatement("SELECT "
                                         + "id_cdu, "
                                         + "telaPrincipal_cadastraOs_cdu, "
                                         + "telaPrincipal_cadastraConsultaPessoa_cdu, "
                                         + "telaPrincipal_cadastraAcesso_cdu, "
                                         + "telaPrincipal_cadastraUsabilidade_cdu, "
                                         + "telaPrincipal_cadastraSetor_cdu, "
                                         + "telaPrincipal_relatorioOs_cdu,"
                                         + "telaPrincipal_relatorioPessoa_cdu, "
                                         + "telaOs_deletar_cdu, "
                                         + "telaCadastraConsultaPessoa_dadosCliente_cdu ,"
                                         + "telaCadastraConsultaPessoa_dadosFornecedor_cdu, "
                                         + "telaCadastraConsultaPessoa_dadosFuncionario_cdu, "
                                         + "telaCadastraConsultaPessoa_deletar_cdu, "
                                         + "telaCadastraConsultaPessoa_cadastraTelefone_cdu, "
                                         + "telaCadastraConsultaPessoa_cadastraEmail_cdu, "
                                         + "telaCadastraConsultaPessoa_cadastraEndereco_cdu, "
                                         + "telaCadastraConsultaPessoa_referenciaCliente_cdu, "
                                         + "telaCadastraConsultaPessoa_referenciaFornecedor_cdu, "
                                         + "telaCadastraConsultaPessoa_referenciaFuncionario_cdu, " 
                                         + "telaCadastraDadosCliente_deletar_cdu, "
                                         + "telaCadastraDadosFornecedor_deletar_cdu, "
                                         + "telaCadastraDadosFuncionario_deletar_cdu, "
                                         + "telaCadastraTelefone_deletar_cdu," 
                                         + "telaCadastraEmail_deletar_cdu, "
                                         + "telaCadastraEndereco_deletar_cdu, "
                                         + "telaCadastraAcesso_deletar_cdu " 
                                         + "FROM "
                                         + "tb_controlador_de_usabilidade "
                                         + "WHERE "
                                         + "id_pessoa_fk_cdu = ?");

            pst.setLong(1, idPessoa);
            
            rs = pst.executeQuery();
           
            if (rs.next()) {
                
                TelaCadastraUsabilidade.idCadastraUsabilidade = rs.getLong(1);               
                if(rs.getInt(2) == 1){
                    TelaCadastraUsabilidade.jcbTelaCadastraOs.setSelected(true);
                }               
                if(rs.getInt(3) == 1){
                    TelaCadastraUsabilidade.jcbTelaCadastraPessoa.setSelected(true);
                }               
                if(rs.getInt(4) == 1){
                    TelaCadastraUsabilidade.jcbTelaCadastraAcesso.setSelected(true);
                }               
                if(rs.getInt(5) == 1){
                    TelaCadastraUsabilidade.jcbTelaCadastraUsabilidade.setSelected(true);
                }                
                if(rs.getInt(6) == 1){
                    TelaCadastraUsabilidade.jcbTelaCadastraSetor.setSelected(true);
                }               
                if(rs.getInt(7) == 1){
                    TelaCadastraUsabilidade.jcbTelaRelatorioOs.setSelected(true);
                }                
                if(rs.getInt(8) == 1){
                    TelaCadastraUsabilidade.jcbTelaRelatorioPessoa.setSelected(true);
                }               
                if(rs.getInt(9) == 1){
                    TelaCadastraUsabilidade.jcbDeletarOs.setSelected(true);
                }                
                if(rs.getInt(10) == 1){
                    TelaCadastraUsabilidade.jcbTelaDadosCliente.setSelected(true);
                }                
                if(rs.getInt(11) == 1){
                    TelaCadastraUsabilidade.jcbTelaDadosFornecedor.setSelected(true);
                }               
                if(rs.getInt(12) == 1){
                    TelaCadastraUsabilidade.jcbTelaDadosFuncionario.setSelected(true);
                }              
                if(rs.getInt(13) == 1){
                    TelaCadastraUsabilidade.jcbDeletarPessoa.setSelected(true);
                }                
                if(rs.getInt(14) == 1){
                    TelaCadastraUsabilidade.jcbTelaCadastraTelefone.setSelected(true);
                }              
                if(rs.getInt(15) == 1){
                    TelaCadastraUsabilidade.jcbTelaCadastraEmail.setSelected(true);
                }              
                if(rs.getInt(16) == 1){
                    TelaCadastraUsabilidade.jcbTelaCadastraEndereco.setSelected(true);
                }                            
                if(rs.getInt(17) == 1){
                    TelaCadastraUsabilidade.jcbReferenciaCliente.setSelected(true);
                } 
                if(rs.getInt(18) == 1){
                    TelaCadastraUsabilidade.jcbReferenciaFornecedor.setSelected(true);
                }               
                if(rs.getInt(19) == 1){
                    TelaCadastraUsabilidade.jcbReferenciaFuncionario.setSelected(true);
                }               
                if(rs.getInt(20) == 1){
                    TelaCadastraUsabilidade.jcbDeletarDadosCliente.setSelected(true);
                }              
                if(rs.getInt(21) == 1){
                    TelaCadastraUsabilidade.jcbDeletarDadosFornecedor.setSelected(true);
                }               
                if(rs.getInt(22) == 1){
                    TelaCadastraUsabilidade.jcbDeletarDadosFuncionario.setSelected(true);
                }               
                if(rs.getInt(23) == 1){
                    TelaCadastraUsabilidade.jcbDeletarTelefone.setSelected(true);
                }                
                if(rs.getInt(24) == 1){
                    TelaCadastraUsabilidade.jcbDeletarEmail.setSelected(true);
                }              
                if(rs.getInt(25) == 1){
                    TelaCadastraUsabilidade.jcbDeletarEndereco.setSelected(true);
                }               
                if(rs.getInt(26) == 1){
                    TelaCadastraUsabilidade.jcbDeletarAcesso.setSelected(true);
                }

                retorno = true;
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar!" + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }
        return retorno;
    }
    
    public boolean adicionarUsabilidade(ConfiguradorDeUsabilidade configuradorDeUsabilidade){
       
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null; 
        boolean retorno = false;
        
        try {
            pst = conexao.prepareStatement("INSERT INTO "
                                         + "tb_controlador_de_usabilidade "
                                         + "(telaPrincipal_cadastraOs_cdu, "
                                         + "telaPrincipal_cadastraConsultaPessoa_cdu, "
                                         + "telaPrincipal_cadastraAcesso_cdu, "
                                         + "telaPrincipal_cadastraUsabilidade_cdu, "
                                         + "telaPrincipal_cadastraSetor_cdu, "
                                         + "telaPrincipal_relatorioOs_cdu,"
                                         + "telaPrincipal_relatorioPessoa_cdu, "
                                         + "telaOs_deletar_cdu, "
                                         + "telaCadastraConsultaPessoa_dadosCliente_cdu,"
                                         + "telaCadastraConsultaPessoa_dadosFornecedor_cdu, "
                                         + "telaCadastraConsultaPessoa_dadosFuncionario_cdu, "
                                         + "telaCadastraConsultaPessoa_deletar_cdu, "
                                         + "telaCadastraConsultaPessoa_cadastraTelefone_cdu, "
                                         + "telaCadastraConsultaPessoa_cadastraEmail_cdu, "
                                         + "telaCadastraConsultaPessoa_cadastraEndereco_cdu, "
                                         + "telaCadastraConsultaPessoa_referenciaCliente_cdu, "
                                         + "telaCadastraConsultaPessoa_referenciaFornecedor_cdu, "
                                         + "telaCadastraConsultaPessoa_referenciaFuncionario_cdu, "
                                         + "telaCadastraDadosCliente_deletar_cdu, "
                                         + "telaCadastraDadosFornecedor_deletar_cdu,"
                                         + " telaCadastraDadosFuncionario_deletar_cdu, "
                                         + "telaCadastraTelefone_deletar_cdu, "
                                         + "telaCadastraEmail_deletar_cdu, t"
                                         + "elaCadastraEndereco_deletar_cdu, "
                                         + "telaCadastraAcesso_deletar_cdu, "
                                         + "id_pessoa_fk_cdu) "
                                         + "VALUES "
                                        + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
           
            pst.setInt(1, configuradorDeUsabilidade.getTelaPrincipalCadastraOsCdu());
            pst.setInt(2, configuradorDeUsabilidade.getTelaPrincipalCadastraConsultaPessoaCdu());
            pst.setInt(3, configuradorDeUsabilidade.getTelaPrincipalCadastraAcessoCdu());
            pst.setInt(4, configuradorDeUsabilidade.getTelaPrincipalCadastraUsabilidadeCdu());
            pst.setInt(5, configuradorDeUsabilidade.getTelaPrincipalCadastraSetorCdu());
            pst.setInt(6, configuradorDeUsabilidade.getTelaPrincipalRelatorioOsCdu());
            pst.setInt(7, configuradorDeUsabilidade.getTelaPrincipalRelatorioPessoaCdu());
            pst.setInt(8, configuradorDeUsabilidade.getTelaOsDeletarCdu());
            pst.setInt(9, configuradorDeUsabilidade.getTelaCadastraConsultaPessoaDadosClienteCdu());
            pst.setInt(10, configuradorDeUsabilidade.getTelaCadastraConsultaPessoaDadosFornecedorCdu());
            pst.setInt(11, configuradorDeUsabilidade.getTelaCadastraConsultaPessoaDadosFuncionarioCdu());
            pst.setInt(12, configuradorDeUsabilidade.getTelaCadastraConsultaPessoaDeletarCdu());
            pst.setInt(13, configuradorDeUsabilidade.getTelaCadastraConsultaPessoaCadastraTelefoneCdu());
            pst.setInt(14, configuradorDeUsabilidade.getTelaCadastraConsultaPessoaCadastraEmailCdu());
            pst.setInt(15, configuradorDeUsabilidade.getTelaCadastraConsultaPessoaCadastraEnderecoCdu());
            pst.setInt(16, configuradorDeUsabilidade.getTelaCadastraConsultaPessoaReferenciaClienteCdu());
            pst.setInt(17, configuradorDeUsabilidade.getTelaCadastraConsultaPessoaReferenciaFornecedorCdu());
            pst.setInt(18, configuradorDeUsabilidade.getTelaCadastraConsultaPessoaReferenciaFuncionarioCdu());
            pst.setInt(19, configuradorDeUsabilidade.getTelaCadastraDadosClienteDeletarCdu());
            pst.setInt(20, configuradorDeUsabilidade.getTelaCadastraDadosFornecedorDeletarCdu());
            pst.setInt(21, configuradorDeUsabilidade.getTelaCadastraDadosFuncionarioDeletarCdu());
            pst.setInt(22, configuradorDeUsabilidade.getTelaCadastraTelefoneDeletarCdu());
            pst.setInt(23, configuradorDeUsabilidade.getTelaCadastraEmailDeletarCdu());
            pst.setInt(24, configuradorDeUsabilidade.getTelaCadastraEnderecoDeletarCdu());
            pst.setInt(25, configuradorDeUsabilidade.getTelaCadastraAcessoDeletarCdu());
            pst.setLong(26, configuradorDeUsabilidade.getIdPessoaFkCdu());
                    
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
    
    public boolean editarUsabilidade(ConfiguradorDeUsabilidade configuradorDeUsabilidade){
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null; 
        boolean retorno = false;
        
        try {
            pst = conexao.prepareStatement("UPDATE "
                                         + "tb_controlador_de_usabilidade "
                                         + "SET "
                                         + "telaPrincipal_cadastraOs_cdu = ?, "
                                         + "telaPrincipal_cadastraConsultaPessoa_cdu = ?, "
                                         + "telaPrincipal_cadastraAcesso_cdu = ?, "
                                         + "telaPrincipal_cadastraUsabilidade_cdu = ?, "
                                         + "telaPrincipal_cadastraSetor_cdu = ?, "
                                         + "telaPrincipal_relatorioOs_cdu = ?, "
                                         + "telaPrincipal_relatorioPessoa_cdu = ?, "
                                         + "telaOs_deletar_cdu = ?, "
                                         + "telaCadastraConsultaPessoa_dadosCliente_cdu = ?, "
                                         + "telaCadastraConsultaPessoa_dadosFornecedor_cdu = ?, "
                                         + "telaCadastraConsultaPessoa_dadosFuncionario_cdu = ?, "
                                         + "telaCadastraConsultaPessoa_deletar_cdu = ?, "
                                         + "telaCadastraConsultaPessoa_cadastraTelefone_cdu = ?, "
                                         + "telaCadastraConsultaPessoa_cadastraEmail_cdu = ?, "
                                         + "telaCadastraConsultaPessoa_cadastraEndereco_cdu = ?, "
                                         + "telaCadastraConsultaPessoa_referenciaCliente_cdu = ?, "
                                         + "telaCadastraConsultaPessoa_referenciaFornecedor_cdu = ?, "
                                         + "telaCadastraConsultaPessoa_referenciaFuncionario_cdu = ?, "
                                         + "telaCadastraDadosCliente_deletar_cdu = ?, "
                                         + "telaCadastraDadosFornecedor_deletar_cdu = ?, "
                                         + "telaCadastraDadosFuncionario_deletar_cdu = ?, "
                                         + "telaCadastraTelefone_deletar_cdu = ?, "
                                         + "telaCadastraEmail_deletar_cdu = ?, "
                                         + "telaCadastraEndereco_deletar_cdu = ?, "
                                         + "telaCadastraAcesso_deletar_cdu = ? "
                                         + "WHERE "
                                         + "id_cdu = ? ");
           
            pst.setInt(1, configuradorDeUsabilidade.getTelaPrincipalCadastraOsCdu());
            pst.setInt(2, configuradorDeUsabilidade.getTelaPrincipalCadastraConsultaPessoaCdu());
            pst.setInt(3, configuradorDeUsabilidade.getTelaPrincipalCadastraAcessoCdu());
            pst.setInt(4, configuradorDeUsabilidade.getTelaPrincipalCadastraUsabilidadeCdu());
            pst.setInt(5, configuradorDeUsabilidade.getTelaPrincipalCadastraSetorCdu());
            pst.setInt(6, configuradorDeUsabilidade.getTelaPrincipalRelatorioOsCdu());
            pst.setInt(7, configuradorDeUsabilidade.getTelaPrincipalRelatorioPessoaCdu());
            pst.setInt(8, configuradorDeUsabilidade.getTelaOsDeletarCdu());
            pst.setInt(9, configuradorDeUsabilidade.getTelaCadastraConsultaPessoaDadosClienteCdu());
            pst.setInt(10, configuradorDeUsabilidade.getTelaCadastraConsultaPessoaDadosFornecedorCdu());
            pst.setInt(11, configuradorDeUsabilidade.getTelaCadastraConsultaPessoaDadosFuncionarioCdu());
            pst.setInt(12, configuradorDeUsabilidade.getTelaCadastraConsultaPessoaDeletarCdu());
            pst.setInt(13, configuradorDeUsabilidade.getTelaCadastraConsultaPessoaCadastraTelefoneCdu());
            pst.setInt(14, configuradorDeUsabilidade.getTelaCadastraConsultaPessoaCadastraEmailCdu());
            pst.setInt(15, configuradorDeUsabilidade.getTelaCadastraConsultaPessoaCadastraEnderecoCdu());
            pst.setInt(16, configuradorDeUsabilidade.getTelaCadastraConsultaPessoaReferenciaClienteCdu());
            pst.setInt(17, configuradorDeUsabilidade.getTelaCadastraConsultaPessoaReferenciaFornecedorCdu());
            pst.setInt(18, configuradorDeUsabilidade.getTelaCadastraConsultaPessoaReferenciaFuncionarioCdu());
            pst.setInt(19, configuradorDeUsabilidade.getTelaCadastraDadosClienteDeletarCdu());
            pst.setInt(20, configuradorDeUsabilidade.getTelaCadastraDadosFornecedorDeletarCdu());
            pst.setInt(21, configuradorDeUsabilidade.getTelaCadastraDadosFuncionarioDeletarCdu());
            pst.setInt(22, configuradorDeUsabilidade.getTelaCadastraTelefoneDeletarCdu());
            pst.setInt(23, configuradorDeUsabilidade.getTelaCadastraEmailDeletarCdu());
            pst.setInt(24, configuradorDeUsabilidade.getTelaCadastraEnderecoDeletarCdu());
            pst.setInt(25, configuradorDeUsabilidade.getTelaCadastraAcessoDeletarCdu());
            pst.setLong(26, configuradorDeUsabilidade.getIdCdu());
                   
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
    
    public boolean deletarUsabilidade(Long idPessoa) {
        
        Connection conexao = ModuloConexao.conector();
        PreparedStatement pst = null;
        boolean retorno = false;
        try {
            pst = conexao.prepareStatement("DELETE "
                                         + "FROM "
                                         + "tb_controlador_de_usabilidade "
                                         + "WHERE "
                                         + "id_pessoa_fk_cdu = ? ");
            
            pst.setLong(1, idPessoa);
      
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
