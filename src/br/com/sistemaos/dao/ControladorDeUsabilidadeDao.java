
package br.com.sistemaos.dao;

import br.com.sistemaos.dal.ModuloConexao;
import br.com.sistemaos.modelo.ControladorDeUsabilidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControladorDeUsabilidadeDao {
    
    public boolean setarConfiguracao(Long idPessoa){
        
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
                                         + "telaCadastraAcesso_deletar_cdu, "
                                         + "cpfcnpj_pes, "
                                         + "senha_cda "
                                         + "FROM "
                                         + "tb_controlador_de_usabilidade "
                                         + "INNER JOIN "
                                         + "tb_pessoa "
                                         + "ON "
                                         + "id_pes = id_pessoa_fk_cdu "
                                         + "INNER JOIN "
                                         + "tb_controlador_de_acesso "
                                         + "ON "
                                         + "id_pes = id_pessoa_fk_cda "
                                         + "WHERE "
                                         + "id_pessoa_fk_cdu = ? ");

            pst.setLong(1, idPessoa);
            
            rs = pst.executeQuery();
            
            if (rs.next()) {
                ControladorDeUsabilidade.idCdu = rs.getLong(1);
                ControladorDeUsabilidade.telaPrincipalCadastraOsCdu = rs.getInt(2);
                ControladorDeUsabilidade.telaPrincipalCadastraConsultaPessoaCdu = rs.getInt(3);
                ControladorDeUsabilidade.telaPrincipalCadastraAcessoCdu = rs.getInt(4);
                ControladorDeUsabilidade.telaPrincipalCadastraUsabilidadeCdu = rs.getInt(5);
                ControladorDeUsabilidade.telaPrincipalCadastraSetorCdu = rs.getInt(6);
                ControladorDeUsabilidade.telaPrincipalRelatorioOsCdu = rs.getInt(7);
                ControladorDeUsabilidade.telaPrincipalRelatorioPessoaCdu = rs.getInt(8);
                ControladorDeUsabilidade.telaOsDeletarCdu = rs.getInt(9);
                ControladorDeUsabilidade.telaCadastraConsultaPessoaDadosClienteCdu = rs.getInt(10);
                ControladorDeUsabilidade.telaCadastraConsultaPessoaDadosFornecedorCdu = rs.getInt(11);
                ControladorDeUsabilidade.telaCadastraConsultaPessoaDadosFuncionarioCdu = rs.getInt(12);
                ControladorDeUsabilidade.telaCadastraConsultaPessoaDeletarCdu = rs.getInt(13);
                ControladorDeUsabilidade.telaCadastraConsultaPessoaCadastraTelefoneCdu = rs.getInt(14);
                ControladorDeUsabilidade.telaCadastraConsultaPessoaCadastraEmailCdu = rs.getInt(15);
                ControladorDeUsabilidade.telaCadastraConsultaPessoaCadastraEnderecoCdu = rs.getInt(16);
                ControladorDeUsabilidade.telaCadastraConsultaPessoaReferenciaClienteCdu = rs.getInt(17);
                ControladorDeUsabilidade.telaCadastraConsultaPessoaReferenciaFornecedorCdu = rs.getInt(18);
                ControladorDeUsabilidade.telaCadastraConsultaPessoaReferenciaFuncionarioCdu = rs.getInt(19);
                ControladorDeUsabilidade.telaCadastraDadosClienteDeletarCdu = rs.getInt(20);
                ControladorDeUsabilidade.telaCadastraDadosFornecedorDeletarCdu = rs.getInt(21);
                ControladorDeUsabilidade.telaCadastraDadosFuncionarioDeletarCdu = rs.getInt(22);
                ControladorDeUsabilidade.telaCadastraTelefoneDeletarCdu = rs.getInt(23);
                ControladorDeUsabilidade.telaCadastraEmailDeletarCdu = rs.getInt(24);
                ControladorDeUsabilidade.telaCadastraEnderecoDeletarCdu = rs.getInt(25);
                ControladorDeUsabilidade.telaCadastraAcessoDeletarCdu = rs.getInt(26);
                ControladorDeUsabilidade.cpfCnpjUsuarioCdu = rs.getString(27);
                ControladorDeUsabilidade.senhaUsuarioCdu = rs.getString(28);
                
                retorno = true;
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar!" + ex);
        }finally{
            ModuloConexao.closeConexao(conexao, pst, rs);
        }
        return retorno;
    }
   
}
