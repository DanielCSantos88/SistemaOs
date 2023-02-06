
package br.com.sistemaos.telas;

import Jm.JMascara;
import br.com.sistemaos.dao.ControladorDeAcessoDao;
import br.com.sistemaos.dao.PessoaDao;
import br.com.sistemaos.modelo.ControladorDeAcesso;
import br.com.sistemaos.modelo.ControladorDeUsabilidade;
import br.com.sistemaos.modelo.Pessoa;
import br.com.sistemaos.util.LimitaCaracteres;
import br.com.sistemaos.util.PosicaoFormulario;
import br.com.sistemaos.util.TipoPessoa;
import javax.swing.JOptionPane;

public class TelaCadastraAcesso extends javax.swing.JInternalFrame {

    public static Long idCadastraAcesso;
    
    public TelaCadastraAcesso() {
        initComponents();
        txtCpfTelaCadastraAcesso.setDocument(new LimitaCaracteres(14, LimitaCaracteres.TipoEntrada.CARACTERES_LETRAS));
    }
    
    private boolean validarDadosCadastraAcesso(){
        boolean retorno = true;
        if(txtLoginTelaCadastraAcesso.getText().isEmpty()){
            retorno = false;
        }
        String captura = new String(txtSenhaTelaCadastraAcesso.getPassword());
        if(captura.isEmpty()){
            retorno = false;
        }
        return retorno; 
    }
    
    private void limparDadosCadastraAcesso(){
        txtLoginTelaCadastraAcesso.setText(null);
        txtSenhaTelaCadastraAcesso.setText(null);
    }
    
    private void configuraTelaIniciarCadastraAcesso(){
        idCadastraAcesso = null;
        limparDadosCadastraAcesso();
        txtCpfTelaCadastraAcesso.setEditable(true);
        txtCpfTelaCadastraAcesso.setText(null);
        txtCpfTelaCadastraAcesso.requestFocus();
        txtIdPessoaCadastraAcesso.setText(null);
        txtNomeTelaCadastraAcesso.setText(null);
        btnLimparTelaCadastraAcesso.setEnabled(false);
        btnAdicionarTelaCadastraAcesso.setEnabled(false);
        btnEditarTelaCadastraAcesso.setEnabled(false);
        btnDeletarTelaCadastraAcesso.setEnabled(false);
        btnCancelarTelaCadastraAcesso.setEnabled(false);   
    }
    
    private void configuraTelaEditarDeletarCadastraAcesso(){
        txtCpfTelaCadastraAcesso.setEditable(false);
        btnAdicionarTelaCadastraAcesso.setEnabled(false);
        btnEditarTelaCadastraAcesso.setEnabled(true);
        btnDeletarTelaCadastraAcesso.setEnabled(true);
        btnLimparTelaCadastraAcesso.setEnabled(true);
        btnCancelarTelaCadastraAcesso.setEnabled(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtIdPessoaCadastraAcesso = new javax.swing.JTextField();
        btnBuscarTelaCadastraAcesso = new javax.swing.JButton();
        txtNomeTelaCadastraAcesso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtLoginTelaCadastraAcesso = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSenhaTelaCadastraAcesso = new javax.swing.JPasswordField();
        txtCpfTelaCadastraAcesso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnLimparTelaCadastraAcesso = new javax.swing.JButton();
        btnAdicionarTelaCadastraAcesso = new javax.swing.JButton();
        btnEditarTelaCadastraAcesso = new javax.swing.JButton();
        btnDeletarTelaCadastraAcesso = new javax.swing.JButton();
        btnCancelarTelaCadastraAcesso = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Acesso - Sistema Os");

        jLabel1.setText("*Campos Obrigatórios");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Controlador de Acesso"));

        jLabel2.setText("Id");

        txtIdPessoaCadastraAcesso.setEditable(false);

        btnBuscarTelaCadastraAcesso.setText("Buscar");
        btnBuscarTelaCadastraAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTelaCadastraAcessoActionPerformed(evt);
            }
        });

        txtNomeTelaCadastraAcesso.setEditable(false);

        jLabel3.setText("Nome");

        jLabel4.setText("*Login");

        jLabel5.setText("*Senha");

        txtCpfTelaCadastraAcesso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCpfTelaCadastraAcessoKeyPressed(evt);
            }
        });

        jLabel6.setText("CPF");

        btnLimparTelaCadastraAcesso.setText("Limpar");
        btnLimparTelaCadastraAcesso.setEnabled(false);
        btnLimparTelaCadastraAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparTelaCadastraAcessoActionPerformed(evt);
            }
        });

        btnAdicionarTelaCadastraAcesso.setText("Adcionar");
        btnAdicionarTelaCadastraAcesso.setEnabled(false);
        btnAdicionarTelaCadastraAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarTelaCadastraAcessoActionPerformed(evt);
            }
        });

        btnEditarTelaCadastraAcesso.setText("Editar");
        btnEditarTelaCadastraAcesso.setEnabled(false);
        btnEditarTelaCadastraAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTelaCadastraAcessoActionPerformed(evt);
            }
        });

        btnDeletarTelaCadastraAcesso.setText("Deletar");
        btnDeletarTelaCadastraAcesso.setEnabled(false);
        btnDeletarTelaCadastraAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarTelaCadastraAcessoActionPerformed(evt);
            }
        });

        btnCancelarTelaCadastraAcesso.setText("Cancelar");
        btnCancelarTelaCadastraAcesso.setEnabled(false);
        btnCancelarTelaCadastraAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarTelaCadastraAcessoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnLimparTelaCadastraAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdicionarTelaCadastraAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditarTelaCadastraAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeletarTelaCadastraAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelarTelaCadastraAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtCpfTelaCadastraAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscarTelaCadastraAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtLoginTelaCadastraAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSenhaTelaCadastraAcesso)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(0, 226, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdPessoaCadastraAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtNomeTelaCadastraAcesso))))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpfTelaCadastraAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarTelaCadastraAcesso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdPessoaCadastraAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeTelaCadastraAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLoginTelaCadastraAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenhaTelaCadastraAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimparTelaCadastraAcesso)
                    .addComponent(btnAdicionarTelaCadastraAcesso)
                    .addComponent(btnEditarTelaCadastraAcesso)
                    .addComponent(btnDeletarTelaCadastraAcesso)
                    .addComponent(btnCancelarTelaCadastraAcesso))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 558, 335);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCpfTelaCadastraAcessoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpfTelaCadastraAcessoKeyPressed
       txtCpfTelaCadastraAcesso.setText(JMascara.GetJmascaraCpfCnpj(txtCpfTelaCadastraAcesso.getText()));
    }//GEN-LAST:event_txtCpfTelaCadastraAcessoKeyPressed

    private void btnBuscarTelaCadastraAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTelaCadastraAcessoActionPerformed
        String cpfCnpj = JMascara.GetJmascaraLimpar(txtCpfTelaCadastraAcesso.getText());
        if(cpfCnpj.length() != 11 && cpfCnpj.length() != 14){
            JOptionPane.showMessageDialog(null, "Favor inserir CPF/CNPJ valido!","Cadasro de Acesso", JOptionPane.WARNING_MESSAGE);
        }else{
            PessoaDao pessoaDao = new PessoaDao();
            Long idPessoa = null;
            String nome = null;
            for (Pessoa pessoa : pessoaDao.buscarDadosPessoa(cpfCnpj)) {
                idPessoa = pessoa.getIdPes();
                nome = pessoa.getNomePes();
            }
            if(idPessoa != null){
                txtIdPessoaCadastraAcesso.setText(idPessoa.toString());
                txtNomeTelaCadastraAcesso.setText(nome);
                ControladorDeAcessoDao controladorDeAcessoDao = new ControladorDeAcessoDao();
                boolean retorno = controladorDeAcessoDao.buscarCadastroAcesso(cpfCnpj);
                if(!retorno){
                    int confirma = JOptionPane.showConfirmDialog(null, "Cadastro de Acesso não encontrado, Deseja Cadastrar!", "Cadasro de Acesso", JOptionPane.YES_NO_OPTION);
                    if (confirma == JOptionPane.YES_OPTION){
                        txtLoginTelaCadastraAcesso.requestFocus();
                        btnAdicionarTelaCadastraAcesso.setEnabled(true);
                    }else{
                         configuraTelaIniciarCadastraAcesso();
                    }
                }else{
                    configuraTelaEditarDeletarCadastraAcesso();
                }
            }else{
                int confirma = JOptionPane.showConfirmDialog(null, "Pessoa não encontrada, Deseja Cadastrar!", "Cadasro de Acesso", JOptionPane.YES_NO_OPTION);
                if (confirma == JOptionPane.YES_OPTION){
                    TelaCadastraConsultaPessoa telaConsultaPessoa = new TelaCadastraConsultaPessoa();
                    PosicaoFormulario form = new PosicaoFormulario();  
                    form.abrirFormulario(telaConsultaPessoa, TelaPrincipal.desktop);
                    TelaCadastraConsultaPessoa.rbtFuncionarioConsultaPessoa.setSelected(true);
                    TelaCadastraConsultaPessoa.tipoPessoaTelaConsultaPessoa = TipoPessoa.FUNCIONARIO.getValor();
                    TelaCadastraConsultaPessoa.txtCpfCnpjTelaConsultaPessoa.setText(JMascara.GetJmascaraCpfCnpj(cpfCnpj));
                    TelaCadastraConsultaPessoa.configuraAdicionar();
                    TelaCadastraConsultaPessoa.desabilitaRadioReferenciaTipoPessoa();
                    dispose();
                } 
            } 
        }
    }//GEN-LAST:event_btnBuscarTelaCadastraAcessoActionPerformed

    private void btnLimparTelaCadastraAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparTelaCadastraAcessoActionPerformed
        limparDadosCadastraAcesso();
    }//GEN-LAST:event_btnLimparTelaCadastraAcessoActionPerformed

    private void btnAdicionarTelaCadastraAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarTelaCadastraAcessoActionPerformed
        if(validarDadosCadastraAcesso()){
            ControladorDeAcessoDao controladorDeAcessoDao = new ControladorDeAcessoDao();
            ControladorDeAcesso controladorDeAcesso = new ControladorDeAcesso();
            controladorDeAcesso.setLoginCda(txtLoginTelaCadastraAcesso.getText());
            String captura = new String(txtSenhaTelaCadastraAcesso.getPassword());
            controladorDeAcesso.setSenhaCda(captura);
            controladorDeAcesso.setIdPessoaFkCda(Long.parseLong(txtIdPessoaCadastraAcesso.getText()));
            boolean retorno = controladorDeAcessoDao.adicionarCadastroAcesso(controladorDeAcesso);
            if(retorno){
               JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!", "Cadastra Acesso", JOptionPane.INFORMATION_MESSAGE);
               controladorDeAcessoDao.buscarCadastroAcesso(JMascara.GetJmascaraLimpar(txtCpfTelaCadastraAcesso.getText()));
               configuraTelaEditarDeletarCadastraAcesso();
            }else{
                txtLoginTelaCadastraAcesso.setText(null);
                txtLoginTelaCadastraAcesso.requestFocus();
            }
        }else{
             JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Acesso", JOptionPane.WARNING_MESSAGE); 
        }
    }//GEN-LAST:event_btnAdicionarTelaCadastraAcessoActionPerformed

    private void btnEditarTelaCadastraAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTelaCadastraAcessoActionPerformed
        if(validarDadosCadastraAcesso()){
            ControladorDeAcessoDao controladorDeAcessoDao = new ControladorDeAcessoDao();
            ControladorDeAcesso controladorDeAcesso = new ControladorDeAcesso();
            controladorDeAcesso.setLoginCda(txtLoginTelaCadastraAcesso.getText());
            String captura = new String(txtSenhaTelaCadastraAcesso.getPassword());
            controladorDeAcesso.setSenhaCda(captura);
            controladorDeAcesso.setIdCda(idCadastraAcesso);
            boolean retorno = controladorDeAcessoDao.editarCadastroAcesso(controladorDeAcesso);
            if(retorno){
               JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Cadastra Acesso", JOptionPane.INFORMATION_MESSAGE);
            }else{
                txtLoginTelaCadastraAcesso.setText(null);
                txtLoginTelaCadastraAcesso.requestFocus();
            }
        }else{
             JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Acesso", JOptionPane.WARNING_MESSAGE); 
        }
    }//GEN-LAST:event_btnEditarTelaCadastraAcessoActionPerformed

    private void btnDeletarTelaCadastraAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarTelaCadastraAcessoActionPerformed
         if(ControladorDeUsabilidade.telaCadastraAcessoDeletarCdu == 1){   
            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este acesso!", "Cadastra Acesso", JOptionPane.YES_NO_OPTION);
            if (confirma == JOptionPane.YES_OPTION) {
                ControladorDeAcessoDao controladorDeAcessoDao = new ControladorDeAcessoDao();
                boolean retorno = controladorDeAcessoDao.deletarCadastroAcesso(Long.parseLong(txtIdPessoaCadastraAcesso.getText()));
                if(retorno){
                    int confirmaPessoa = JOptionPane.showConfirmDialog(null, "Dados apagados com sucesso. Deseja realizar outra operação!", "Cadastra Acesso", JOptionPane.YES_NO_OPTION);
                    if (confirmaPessoa == JOptionPane.YES_OPTION) {        
                        configuraTelaIniciarCadastraAcesso();
                    }else{
                        dispose();
                    } 
                }                
            }           
        }else{
           ControladorDeUsabilidade.acessoNegado();
        }
    }//GEN-LAST:event_btnDeletarTelaCadastraAcessoActionPerformed

    private void btnCancelarTelaCadastraAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarTelaCadastraAcessoActionPerformed
        configuraTelaIniciarCadastraAcesso();
    }//GEN-LAST:event_btnCancelarTelaCadastraAcessoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAdicionarTelaCadastraAcesso;
    private javax.swing.JButton btnBuscarTelaCadastraAcesso;
    private javax.swing.JButton btnCancelarTelaCadastraAcesso;
    private javax.swing.JButton btnDeletarTelaCadastraAcesso;
    private javax.swing.JButton btnEditarTelaCadastraAcesso;
    private javax.swing.JButton btnLimparTelaCadastraAcesso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JTextField txtCpfTelaCadastraAcesso;
    public static javax.swing.JTextField txtIdPessoaCadastraAcesso;
    public static javax.swing.JTextField txtLoginTelaCadastraAcesso;
    public static javax.swing.JTextField txtNomeTelaCadastraAcesso;
    public static javax.swing.JPasswordField txtSenhaTelaCadastraAcesso;
    // End of variables declaration//GEN-END:variables
}
