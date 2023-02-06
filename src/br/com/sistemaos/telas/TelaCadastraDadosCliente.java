
package br.com.sistemaos.telas;

import Jm.JMascara;
import br.com.sistemaos.dao.DadosClienteDao;
import br.com.sistemaos.dao.PessoaDao;
import br.com.sistemaos.modelo.ControladorDeUsabilidade;
import br.com.sistemaos.modelo.DadosCliente;
import javax.swing.JOptionPane;


public class TelaCadastraDadosCliente extends javax.swing.JInternalFrame {

    protected  Long idCliente = TelaCadastraConsultaPessoa.idPessoaTelaConsultaPessoa;
    public static Long idDadosCliente;
    
    public TelaCadastraDadosCliente() {
        initComponents();
    }

    private void limparDadosCliente(){
        txaObservacoesCadastraCliente.setText(null);
    }
    
    private boolean validarDadosCliente(){
        boolean retorno = true;
        if(txaObservacoesCadastraCliente.getText().isEmpty()){
            retorno = false;
        }
        return retorno;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jplDadosCadastraCliente = new javax.swing.JPanel();
        lblObservacoesCadastraCliente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaObservacoesCadastraCliente = new javax.swing.JTextArea();
        btnDeletarCadastraCliente = new javax.swing.JButton();
        btnEditarCadastraCliente = new javax.swing.JButton();
        btnLimparCadastraCliente = new javax.swing.JButton();
        lblCamposObrigatotios = new javax.swing.JLabel();
        btnAdicionarCadastraCliente = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Dados Cliente - Sistema Os");

        jplDadosCadastraCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Cliente"));

        lblObservacoesCadastraCliente.setText("Observações");

        txaObservacoesCadastraCliente.setColumns(20);
        txaObservacoesCadastraCliente.setRows(5);
        jScrollPane1.setViewportView(txaObservacoesCadastraCliente);

        javax.swing.GroupLayout jplDadosCadastraClienteLayout = new javax.swing.GroupLayout(jplDadosCadastraCliente);
        jplDadosCadastraCliente.setLayout(jplDadosCadastraClienteLayout);
        jplDadosCadastraClienteLayout.setHorizontalGroup(
            jplDadosCadastraClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplDadosCadastraClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jplDadosCadastraClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplDadosCadastraClienteLayout.createSequentialGroup()
                        .addComponent(lblObservacoesCadastraCliente)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE))
                .addContainerGap())
        );
        jplDadosCadastraClienteLayout.setVerticalGroup(
            jplDadosCadastraClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplDadosCadastraClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblObservacoesCadastraCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnDeletarCadastraCliente.setText("Deletar");
        btnDeletarCadastraCliente.setEnabled(false);
        btnDeletarCadastraCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarCadastraClienteActionPerformed(evt);
            }
        });

        btnEditarCadastraCliente.setText("Editar");
        btnEditarCadastraCliente.setEnabled(false);
        btnEditarCadastraCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCadastraClienteActionPerformed(evt);
            }
        });

        btnLimparCadastraCliente.setText("Limpar");
        btnLimparCadastraCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCadastraClienteActionPerformed(evt);
            }
        });

        lblCamposObrigatotios.setText("*Campos Obrigatórios");

        btnAdicionarCadastraCliente.setText("Adicionar");
        btnAdicionarCadastraCliente.setEnabled(false);
        btnAdicionarCadastraCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarCadastraClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jplDadosCadastraCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLimparCadastraCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCamposObrigatotios)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdicionarCadastraCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditarCadastraCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDeletarCadastraCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCamposObrigatotios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jplDadosCadastraCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimparCadastraCliente)
                    .addComponent(btnEditarCadastraCliente)
                    .addComponent(btnDeletarCadastraCliente)
                    .addComponent(btnAdicionarCadastraCliente))
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

    private void btnLimparCadastraClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCadastraClienteActionPerformed
        limparDadosCliente();
    }//GEN-LAST:event_btnLimparCadastraClienteActionPerformed

    private void btnAdicionarCadastraClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarCadastraClienteActionPerformed
        if(validarDadosCliente()){
            TelaCadastraConsultaPessoa.editarPessoa();
            DadosCliente dadosCliente = new DadosCliente();
            DadosClienteDao dadosClienteDao = new DadosClienteDao();
            dadosCliente.setObservacoesDcl(txaObservacoesCadastraCliente.getText());
            dadosCliente.setIdClienteFkDcl(idCliente);
            boolean retorno = dadosClienteDao.adicionarDadosCliente(dadosCliente);
        if(retorno){
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!", "Cadastra Dados Cliente", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            PessoaDao pessoaDao = new PessoaDao();
            pessoaDao.buscarPessoa(JMascara.GetJmascaraLimpar(TelaCadastraConsultaPessoa.txtCpfCnpjTelaConsultaPessoa.getText()));
            TelaCadastraConsultaPessoa.desabilitaRadioReferenciaTipoPessoa();
        }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Dados Cliente", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAdicionarCadastraClienteActionPerformed

    private void btnEditarCadastraClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCadastraClienteActionPerformed
        if(validarDadosCliente()){
            DadosCliente dadosCliente = new DadosCliente();
            DadosClienteDao dadosClienteDao = new DadosClienteDao();
            dadosCliente.setObservacoesDcl(txaObservacoesCadastraCliente.getText());
            dadosCliente.setIdDcl(idDadosCliente);
            boolean retorno = dadosClienteDao.editarDadosCliente(dadosCliente);
            if(retorno){
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Cadastra Dados Cliente", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }   
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Dados Cliente", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarCadastraClienteActionPerformed

    private void btnDeletarCadastraClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarCadastraClienteActionPerformed
        if(ControladorDeUsabilidade.telaCadastraDadosClienteDeletarCdu == 1){
            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover os dados!", "Cadastra Dados Cliente", JOptionPane.YES_NO_OPTION);
            if (confirma == JOptionPane.YES_OPTION){      
                DadosClienteDao dadosClienteDao = new DadosClienteDao();
                boolean retorno = dadosClienteDao.deletarDadosCliente(idDadosCliente);
                if(retorno){
                    JOptionPane.showMessageDialog(null, "Dados apagados com sucesso!", "Cadastra Dados Cliente", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    TelaCadastraConsultaPessoa.habilitaRadioReferenciaTipoPessoa();
                }                 
            }  
       }else{
            ControladorDeUsabilidade.acessoNegado();
        }   
    }//GEN-LAST:event_btnDeletarCadastraClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAdicionarCadastraCliente;
    public static javax.swing.JButton btnDeletarCadastraCliente;
    public static javax.swing.JButton btnEditarCadastraCliente;
    private javax.swing.JButton btnLimparCadastraCliente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jplDadosCadastraCliente;
    private javax.swing.JLabel lblCamposObrigatotios;
    private javax.swing.JLabel lblObservacoesCadastraCliente;
    public static javax.swing.JTextArea txaObservacoesCadastraCliente;
    // End of variables declaration//GEN-END:variables
}
