
package br.com.sistemaos.modelo;

import javax.swing.JOptionPane;

public class ControladorDeUsabilidade {
    
    public static Long idCdu;
    public static int telaPrincipalCadastraOsCdu;
    public static int telaPrincipalCadastraConsultaPessoaCdu;
    public static int telaPrincipalCadastraAcessoCdu;
    public static int telaPrincipalCadastraUsabilidadeCdu;
    public static int telaPrincipalCadastraSetorCdu;
    public static int telaPrincipalRelatorioOsCdu;
    public static int telaPrincipalRelatorioPessoaCdu;
    public static int telaOsDeletarCdu;
    public static int telaCadastraConsultaPessoaDadosClienteCdu;
    public static int telaCadastraConsultaPessoaDadosFornecedorCdu;
    public static int telaCadastraConsultaPessoaDadosFuncionarioCdu;
    public static int telaCadastraConsultaPessoaDeletarCdu;
    public static int telaCadastraConsultaPessoaCadastraTelefoneCdu;
    public static int telaCadastraConsultaPessoaCadastraEmailCdu;
    public static int telaCadastraConsultaPessoaCadastraEnderecoCdu;
    public static int telaCadastraConsultaPessoaReferenciaClienteCdu;
    public static int telaCadastraConsultaPessoaReferenciaFornecedorCdu;
    public static int telaCadastraConsultaPessoaReferenciaFuncionarioCdu;
    public static int telaCadastraDadosClienteDeletarCdu;
    public static int telaCadastraDadosFornecedorDeletarCdu;
    public static int telaCadastraDadosFuncionarioDeletarCdu;
    public static int telaCadastraTelefoneDeletarCdu;
    public static int telaCadastraEmailDeletarCdu;
    public static int telaCadastraEnderecoDeletarCdu;
    public static int telaCadastraAcessoDeletarCdu;
    public static int telaCadastraUsabilidadeDeletarCdu;
    public static String cpfCnpjUsuarioCdu;
    public static String senhaUsuarioCdu;


    public static void acessoNegado(){
        JOptionPane.showMessageDialog(null, "Usuário sem permissão de acesso", "Sistema Os", JOptionPane.WARNING_MESSAGE);
    }
    
}
