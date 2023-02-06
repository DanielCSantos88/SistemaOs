
package br.com.sistemaos.telas;

import Jm.JMascara;
import br.com.sistemaos.dao.TelefoneDao;
import br.com.sistemaos.modelo.ControladorDeUsabilidade;
import br.com.sistemaos.modelo.Telefone;
import br.com.sistemaos.util.LimitaCaracteres;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TelaCadastraTelefone extends javax.swing.JInternalFrame {
    
    protected Long idPessoa = TelaCadastraConsultaPessoa.idPessoaTelaConsultaPessoa;
    protected Long idTelefone;
    
    public TelaCadastraTelefone() {
        initComponents();
        txtAniversarioTelaCadastraTelefone.setDocument(new LimitaCaracteres(4, LimitaCaracteres.TipoEntrada.SOMENTE_NUMEROS));
    }
    
    public void buscarCadastraTelefone(Long idPessoa){

        DefaultTableModel modelo = (DefaultTableModel) tblTelaCadastrarTelefone.getModel();
        modelo.setNumRows(0);
        
        TelefoneDao telefoneDao = new TelefoneDao();
        
        for(Telefone telefone: telefoneDao.buscarTelefoneTabelas(idPessoa)){

            modelo.addRow(new Object[]{

                telefone.getIdTel(),
                telefone.getTelefoneTel(),
                telefone.getResponsavelTel(),
                telefone.getDataAniversarioTel(),
                telefone.getDepartamentoTel(),
            });
        }  
    }
    
    private void setarCamposCadastraTelefone() {
        int setar = tblTelaCadastrarTelefone.getSelectedRow();
        idTelefone = Long.parseLong(tblTelaCadastrarTelefone.getModel().getValueAt(setar, 0).toString());
        txtTelefoneTelaCadastraTelefone.setText(tblTelaCadastrarTelefone.getModel().getValueAt(setar, 1).toString());
        txtResponsavelTelaCadastraTelefone.setText(tblTelaCadastrarTelefone.getModel().getValueAt(setar, 2).toString());
        txtAniversarioTelaCadastraTelefone.setText(JMascara.GetJmascaraLimpar(tblTelaCadastrarTelefone.getModel().getValueAt(setar, 3).toString()));
        txtDepartamentoTelaCadastraTelefone.setText(tblTelaCadastrarTelefone.getModel().getValueAt(setar, 4).toString());
        bntAdicionarTelaCadastraTelefone.setEnabled(false);
        bntEditarTelaCadastraTelefone.setEnabled(true);
        bntDeletarTelaCadastraTelefone.setEnabled(true);
    }
         
    private void limparDadosCadastraTelefone(){
        txtTelefoneTelaCadastraTelefone.setText(null);
        txtResponsavelTelaCadastraTelefone.setText(null);
        txtAniversarioTelaCadastraTelefone.setText(null);
        txtDepartamentoTelaCadastraTelefone.setText(null);
        bntAdicionarTelaCadastraTelefone.setEnabled(true);
        bntEditarTelaCadastraTelefone.setEnabled(false);
        bntDeletarTelaCadastraTelefone.setEnabled(false);
    }
    
    private void finalizarAcoesCadastraTelefone(){
        dispose();
        TelaCadastraConsultaPessoa.buscarTelefoneTabelaConsultaPessoa(idPessoa);
    }
    
    private boolean validarDadosCadastraTelefone(){
        boolean retorno = true;
        if(txtTelefoneTelaCadastraTelefone.getText().isEmpty()){
            retorno = false;
        }
        return retorno;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        lblCamposObrigatoriosTelaCadastrarTelefone = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTelaCadastrarTelefone = new javax.swing.JTable();
        lblTelefoneTelaCadastraTelefone = new javax.swing.JLabel();
        txtTelefoneTelaCadastraTelefone = new javax.swing.JTextField();
        lblIResponsavelTelaCadastraTelefone = new javax.swing.JLabel();
        txtResponsavelTelaCadastraTelefone = new javax.swing.JTextField();
        bnLimparTelaCadastraTelefone = new javax.swing.JButton();
        bntAdicionarTelaCadastraTelefone = new javax.swing.JButton();
        bntEditarTelaCadastraTelefone = new javax.swing.JButton();
        bntDeletarTelaCadastraTelefone = new javax.swing.JButton();
        txtAniversarioTelaCadastraTelefone = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDepartamentoTelaCadastraTelefone = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Telefones - Sistema Os");

        lblCamposObrigatoriosTelaCadastrarTelefone.setText("*Campos Obrigatórios");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefones"));

        tblTelaCadastrarTelefone.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "TELEFONE", "RESPONSAVEL", "ANIVERSÁRIO", "DEPARTAMENTO"
            }
        ));
        tblTelaCadastrarTelefone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTelaCadastrarTelefoneMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTelaCadastrarTelefone);
        if (tblTelaCadastrarTelefone.getColumnModel().getColumnCount() > 0) {
            tblTelaCadastrarTelefone.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblTelaCadastrarTelefone.getColumnModel().getColumn(1).setPreferredWidth(70);
            tblTelaCadastrarTelefone.getColumnModel().getColumn(2).setPreferredWidth(70);
            tblTelaCadastrarTelefone.getColumnModel().getColumn(3).setPreferredWidth(57);
        }

        lblTelefoneTelaCadastraTelefone.setText("*Telefone");

        txtTelefoneTelaCadastraTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefoneTelaCadastraTelefoneKeyPressed(evt);
            }
        });

        lblIResponsavelTelaCadastraTelefone.setText("Responsavel");

        bnLimparTelaCadastraTelefone.setText("Limpar");
        bnLimparTelaCadastraTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnLimparTelaCadastraTelefoneActionPerformed(evt);
            }
        });

        bntAdicionarTelaCadastraTelefone.setText("Adicionar");
        bntAdicionarTelaCadastraTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAdicionarTelaCadastraTelefoneActionPerformed(evt);
            }
        });

        bntEditarTelaCadastraTelefone.setText("Editar");
        bntEditarTelaCadastraTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEditarTelaCadastraTelefoneActionPerformed(evt);
            }
        });

        bntDeletarTelaCadastraTelefone.setText("Deletar");
        bntDeletarTelaCadastraTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDeletarTelaCadastraTelefoneActionPerformed(evt);
            }
        });

        jLabel2.setText("Anivesário");

        jLabel3.setText("Departamento");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefoneTelaCadastraTelefone)
                            .addComponent(txtTelefoneTelaCadastraTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblIResponsavelTelaCadastraTelefone)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtResponsavelTelaCadastraTelefone)
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(bnLimparTelaCadastraTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bntAdicionarTelaCadastraTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bntEditarTelaCadastraTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bntDeletarTelaCadastraTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtAniversarioTelaCadastraTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtDepartamentoTelaCadastraTelefone))))
                        .addGap(11, 11, 11))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTelefoneTelaCadastraTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTelefoneTelaCadastraTelefone)
                                    .addComponent(lblIResponsavelTelaCadastraTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtResponsavelTelaCadastraTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAniversarioTelaCadastraTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDepartamentoTelaCadastraTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntDeletarTelaCadastraTelefone)
                    .addComponent(bntEditarTelaCadastraTelefone)
                    .addComponent(bntAdicionarTelaCadastraTelefone)
                    .addComponent(bnLimparTelaCadastraTelefone))
                .addContainerGap())
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
                        .addComponent(lblCamposObrigatoriosTelaCadastrarTelefone)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCamposObrigatoriosTelaCadastrarTelefone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblTelaCadastrarTelefoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTelaCadastrarTelefoneMouseClicked
        setarCamposCadastraTelefone();
    }//GEN-LAST:event_tblTelaCadastrarTelefoneMouseClicked

    private void bnLimparTelaCadastraTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnLimparTelaCadastraTelefoneActionPerformed
        limparDadosCadastraTelefone();
    }//GEN-LAST:event_bnLimparTelaCadastraTelefoneActionPerformed

    private void bntAdicionarTelaCadastraTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAdicionarTelaCadastraTelefoneActionPerformed
        if(validarDadosCadastraTelefone()){
            TelefoneDao telefoneDao = new TelefoneDao();
            Telefone telefone = new Telefone();    
            telefone.setTelefoneTel(JMascara.GetJmascaraLimpar(txtTelefoneTelaCadastraTelefone.getText()));
            telefone.setResponsavelTel(txtResponsavelTelaCadastraTelefone.getText());
            telefone.setDataAniversarioTel(txtAniversarioTelaCadastraTelefone.getText());
            telefone.setDepartamentoTel(txtDepartamentoTelaCadastraTelefone.getText());
            telefone.setIdPessoaFkTel(idPessoa);
            boolean retorno = telefoneDao.adicionarTelefone(telefone);
            if(retorno){
                JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!", "Cadastra Telefone", JOptionPane.INFORMATION_MESSAGE);
                finalizarAcoesCadastraTelefone();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Telefone", JOptionPane.WARNING_MESSAGE); 
        }
        
    }//GEN-LAST:event_bntAdicionarTelaCadastraTelefoneActionPerformed

    private void bntEditarTelaCadastraTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEditarTelaCadastraTelefoneActionPerformed
        if(validarDadosCadastraTelefone()){
            TelefoneDao telefoneDao = new TelefoneDao();
            Telefone telefone = new Telefone();    
            telefone.setTelefoneTel(JMascara.GetJmascaraLimpar(txtTelefoneTelaCadastraTelefone.getText()));
            telefone.setResponsavelTel(txtResponsavelTelaCadastraTelefone.getText());
            telefone.setDataAniversarioTel(txtAniversarioTelaCadastraTelefone.getText());
            telefone.setDepartamentoTel(txtDepartamentoTelaCadastraTelefone.getText());
            telefone.setIdTel(idTelefone);
            boolean retorno = telefoneDao.editarTelefone(telefone);
            if(retorno){
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Cadastra Telefone", JOptionPane.INFORMATION_MESSAGE);
                finalizarAcoesCadastraTelefone();
            }           
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Telefone", JOptionPane.WARNING_MESSAGE);
        } 
             
    }//GEN-LAST:event_bntEditarTelaCadastraTelefoneActionPerformed

    private void bntDeletarTelaCadastraTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDeletarTelaCadastraTelefoneActionPerformed
        if(ControladorDeUsabilidade.telaCadastraTelefoneDeletarCdu == 1){   
            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este telefone", "Cadastra Endereço", JOptionPane.YES_NO_OPTION);
            if (confirma == JOptionPane.YES_OPTION) {
                TelefoneDao telefoneDao = new TelefoneDao();
                boolean retorno = telefoneDao.deletarTelefone(idTelefone);
                if(retorno){
                    JOptionPane.showMessageDialog(null, "Dados apagados com sucesso!", "Cadastra Endereço", JOptionPane.INFORMATION_MESSAGE);
                    finalizarAcoesCadastraTelefone();
                }                
            }           
        }else{
           ControladorDeUsabilidade.acessoNegado();
        }
    }//GEN-LAST:event_bntDeletarTelaCadastraTelefoneActionPerformed

    private void txtTelefoneTelaCadastraTelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefoneTelaCadastraTelefoneKeyPressed
        txtTelefoneTelaCadastraTelefone.setText(JMascara.GetJmascaraFone(txtTelefoneTelaCadastraTelefone.getText()));
    }//GEN-LAST:event_txtTelefoneTelaCadastraTelefoneKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnLimparTelaCadastraTelefone;
    public static javax.swing.JButton bntAdicionarTelaCadastraTelefone;
    public static javax.swing.JButton bntDeletarTelaCadastraTelefone;
    public static javax.swing.JButton bntEditarTelaCadastraTelefone;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCamposObrigatoriosTelaCadastrarTelefone;
    private javax.swing.JLabel lblIResponsavelTelaCadastraTelefone;
    private javax.swing.JLabel lblTelefoneTelaCadastraTelefone;
    public static javax.swing.JTable tblTelaCadastrarTelefone;
    private javax.swing.JTextField txtAniversarioTelaCadastraTelefone;
    private javax.swing.JTextField txtDepartamentoTelaCadastraTelefone;
    private javax.swing.JTextField txtResponsavelTelaCadastraTelefone;
    public static javax.swing.JTextField txtTelefoneTelaCadastraTelefone;
    // End of variables declaration//GEN-END:variables
}
