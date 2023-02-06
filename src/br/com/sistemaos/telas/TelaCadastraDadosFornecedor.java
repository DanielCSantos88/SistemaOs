
package br.com.sistemaos.telas;

import Jm.JMascara;
import br.com.sistemaos.dao.DadosFornecedorDao;
import br.com.sistemaos.dao.PessoaDao;
import br.com.sistemaos.modelo.ControladorDeUsabilidade;
import br.com.sistemaos.modelo.DadosFornecedor;
import javax.swing.JOptionPane;


public class TelaCadastraDadosFornecedor extends javax.swing.JInternalFrame {

    protected  Long idFornecedor = TelaCadastraConsultaPessoa.idPessoaTelaConsultaPessoa;
    public static Long idDadosFornecedor;

    public TelaCadastraDadosFornecedor() {
        initComponents();
    }
    
    private void limparDadosFornecedor(){
        txtBancoFornenecdorCadastraPessoa.setText(null);
        txtAgenciaFornenecdorCadastraPessoa.setText(null);
        txtContaCFornenecdorCadastraPessoa.setText(null);
        txtPixFornenecdorCadastraPessoa.setText(null);
    }

    private boolean validarDadosFornecedor(){
        boolean retorno = true;
        if(txtBancoFornenecdorCadastraPessoa.getText().isEmpty()){
            retorno = false;
        }
        if(txtAgenciaFornenecdorCadastraPessoa.getText().isEmpty()){
            retorno = false;
        }
        if(txtContaCFornenecdorCadastraPessoa.getText().isEmpty()){
            retorno = false;
        }
        return retorno;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblBancoFornenecdorCadastraPessoa = new javax.swing.JLabel();
        txtBancoFornenecdorCadastraPessoa = new javax.swing.JTextField();
        lblAgenciaFornenecdorCadastraPessoa = new javax.swing.JLabel();
        txtAgenciaFornenecdorCadastraPessoa = new javax.swing.JTextField();
        lblContaCFornenecdorCadastraPessoa = new javax.swing.JLabel();
        txtContaCFornenecdorCadastraPessoa = new javax.swing.JTextField();
        lblPixFornenecdorCadastraPessoa = new javax.swing.JLabel();
        txtPixFornenecdorCadastraPessoa = new javax.swing.JTextField();
        btnDeletarCadastraFornecedor = new javax.swing.JButton();
        btnEditarCadastraFornecedor = new javax.swing.JButton();
        btnLimparCadastraFornecedor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAdicionarCadastraFornecedor = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Dados Fornecedor - Sistema Os");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Fornecedor"));

        lblBancoFornenecdorCadastraPessoa.setText("*Banco");

        lblAgenciaFornenecdorCadastraPessoa.setText("*Agencia");

        lblContaCFornenecdorCadastraPessoa.setText("*Conta Corrente");

        lblPixFornenecdorCadastraPessoa.setText("Pix");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPixFornenecdorCadastraPessoa)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPixFornenecdorCadastraPessoa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblBancoFornenecdorCadastraPessoa)
                                    .addComponent(txtBancoFornenecdorCadastraPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAgenciaFornenecdorCadastraPessoa)
                                    .addComponent(txtAgenciaFornenecdorCadastraPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblContaCFornenecdorCadastraPessoa)
                                .addGap(0, 238, Short.MAX_VALUE))
                            .addComponent(txtContaCFornenecdorCadastraPessoa))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBancoFornenecdorCadastraPessoa)
                    .addComponent(lblAgenciaFornenecdorCadastraPessoa)
                    .addComponent(lblContaCFornenecdorCadastraPessoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBancoFornenecdorCadastraPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAgenciaFornenecdorCadastraPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContaCFornenecdorCadastraPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPixFornenecdorCadastraPessoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPixFornenecdorCadastraPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnDeletarCadastraFornecedor.setText("Deletar");
        btnDeletarCadastraFornecedor.setEnabled(false);
        btnDeletarCadastraFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarCadastraFornecedorActionPerformed(evt);
            }
        });

        btnEditarCadastraFornecedor.setText("Editar");
        btnEditarCadastraFornecedor.setEnabled(false);
        btnEditarCadastraFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCadastraFornecedorActionPerformed(evt);
            }
        });

        btnLimparCadastraFornecedor.setText("Limpar");
        btnLimparCadastraFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCadastraFornecedorActionPerformed(evt);
            }
        });

        jLabel1.setText("*Campos Obrigatórios");

        btnAdicionarCadastraFornecedor.setText("Adicionar");
        btnAdicionarCadastraFornecedor.setEnabled(false);
        btnAdicionarCadastraFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarCadastraFornecedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLimparCadastraFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdicionarCadastraFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditarCadastraFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDeletarCadastraFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimparCadastraFornecedor)
                    .addComponent(btnEditarCadastraFornecedor)
                    .addComponent(btnDeletarCadastraFornecedor)
                    .addComponent(btnAdicionarCadastraFornecedor))
                .addContainerGap(22, Short.MAX_VALUE))
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparCadastraFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCadastraFornecedorActionPerformed
        limparDadosFornecedor();
    }//GEN-LAST:event_btnLimparCadastraFornecedorActionPerformed

    private void btnAdicionarCadastraFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarCadastraFornecedorActionPerformed
        if(validarDadosFornecedor()){
            TelaCadastraConsultaPessoa.editarPessoa();
            DadosFornecedor dadosFornecedor = new DadosFornecedor();
            DadosFornecedorDao dadosFornecedorDao = new DadosFornecedorDao();
            dadosFornecedor.setBancoDfo(txtBancoFornenecdorCadastraPessoa.getText());
            dadosFornecedor.setAgenciaDfo(txtAgenciaFornenecdorCadastraPessoa.getText());
            dadosFornecedor.setContaCorrenteDfo(txtContaCFornenecdorCadastraPessoa.getText());
            dadosFornecedor.setPixDfo(txtPixFornenecdorCadastraPessoa.getText());
            dadosFornecedor.setIdFornecedorFkDfo(idFornecedor);
            boolean retorno = dadosFornecedorDao.adicionarDadosFornecedor(dadosFornecedor);
        if(retorno){
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!", "Cadastra Dados Fornecedor", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            PessoaDao pessoaDao = new PessoaDao();
            pessoaDao.buscarPessoa(JMascara.GetJmascaraLimpar(TelaCadastraConsultaPessoa.txtCpfCnpjTelaConsultaPessoa.getText()));
            TelaCadastraConsultaPessoa.desabilitaRadioReferenciaTipoPessoa();
        }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Dados Fornecedor", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAdicionarCadastraFornecedorActionPerformed

    private void btnEditarCadastraFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCadastraFornecedorActionPerformed
        if(validarDadosFornecedor()){
            DadosFornecedor dadosFornecedor = new DadosFornecedor();
            DadosFornecedorDao dadosFornecedorDao = new DadosFornecedorDao();
            dadosFornecedor.setBancoDfo(txtBancoFornenecdorCadastraPessoa.getText());
            dadosFornecedor.setAgenciaDfo(txtAgenciaFornenecdorCadastraPessoa.getText());
            dadosFornecedor.setContaCorrenteDfo(txtContaCFornenecdorCadastraPessoa.getText());
            dadosFornecedor.setPixDfo(txtPixFornenecdorCadastraPessoa.getText());
            dadosFornecedor.setIdDfo(idDadosFornecedor);
            boolean retorno = dadosFornecedorDao.editarDadosFornecedor(dadosFornecedor);
        if(retorno){
            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Cadastra Dados Cliente", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }   
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Dados Cliente", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarCadastraFornecedorActionPerformed

    private void btnDeletarCadastraFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarCadastraFornecedorActionPerformed
        if(ControladorDeUsabilidade.telaCadastraDadosFornecedorDeletarCdu == 1){
             int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover os dados!", "Atençao", JOptionPane.YES_NO_OPTION);
             if (confirma == JOptionPane.YES_OPTION){         
                DadosFornecedorDao dadosFornecedorDao = new DadosFornecedorDao();
                boolean retorno = dadosFornecedorDao.deletarDadosFornecedor(idDadosFornecedor);
                if(retorno){
                   JOptionPane.showMessageDialog(null, "Dados apagados com sucesso!", "Cadastra Dados Fornecedor", JOptionPane.INFORMATION_MESSAGE);
                   dispose();
                   TelaCadastraConsultaPessoa.habilitaRadioReferenciaTipoPessoa();
                }                  
             }  
        }else{
             ControladorDeUsabilidade.acessoNegado();
         } 
    }//GEN-LAST:event_btnDeletarCadastraFornecedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAdicionarCadastraFornecedor;
    public static javax.swing.JButton btnDeletarCadastraFornecedor;
    public static javax.swing.JButton btnEditarCadastraFornecedor;
    private javax.swing.JButton btnLimparCadastraFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAgenciaFornenecdorCadastraPessoa;
    private javax.swing.JLabel lblBancoFornenecdorCadastraPessoa;
    private javax.swing.JLabel lblContaCFornenecdorCadastraPessoa;
    private javax.swing.JLabel lblPixFornenecdorCadastraPessoa;
    public static javax.swing.JTextField txtAgenciaFornenecdorCadastraPessoa;
    public static javax.swing.JTextField txtBancoFornenecdorCadastraPessoa;
    public static javax.swing.JTextField txtContaCFornenecdorCadastraPessoa;
    public static javax.swing.JTextField txtPixFornenecdorCadastraPessoa;
    // End of variables declaration//GEN-END:variables
}
