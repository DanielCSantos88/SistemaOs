
package br.com.sistemaos.telas;

import Jm.JMascara;
import br.com.sistemaos.dao.EmailDao;
import br.com.sistemaos.modelo.ControladorDeUsabilidade;
import br.com.sistemaos.modelo.Email;
import br.com.sistemaos.util.LimitaCaracteres;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TelaCadastraEmail extends javax.swing.JInternalFrame {

    protected Long idPessoa = TelaCadastraConsultaPessoa.idPessoaTelaConsultaPessoa;;
    protected Long idTelefone;
    
    public TelaCadastraEmail() {
        initComponents();
        txtAniversarioTelaCadastraEmail.setDocument(new LimitaCaracteres(4, LimitaCaracteres.TipoEntrada.SOMENTE_NUMEROS));
    }

    public void buscarCasdastraEmail(Long idPessoa){

        DefaultTableModel modelo = (DefaultTableModel) tblTelaCadastrarEmail.getModel();
        modelo.setNumRows(0);
        
        EmailDao emailDao = new EmailDao();
        
        for(Email email: emailDao.buscarEmailTabelas(idPessoa)){

            modelo.addRow(new Object[]{

                email.getIdEma(),
                email.getEmailEma(),
                email.getResponsavelEma(),
                email.getDataAniversarioEma(),
                email.getDepartamentoEma(), 
            });         
        }  
    }
    
    private void setarCamposCadastraEmail(){
        int setar = tblTelaCadastrarEmail.getSelectedRow();
        idTelefone = Long.parseLong(tblTelaCadastrarEmail.getModel().getValueAt(setar, 0).toString());
        txtEmailTelaCadastraEmail.setText(tblTelaCadastrarEmail.getModel().getValueAt(setar, 1).toString());
        txtResponsavelTelaCadastraEmail.setText(tblTelaCadastrarEmail.getModel().getValueAt(setar, 2).toString());
        txtAniversarioTelaCadastraEmail.setText(JMascara.GetJmascaraLimpar(tblTelaCadastrarEmail.getModel().getValueAt(setar, 3).toString()));
        txtDepartamentolTelaCadastraEmail.setText(tblTelaCadastrarEmail.getModel().getValueAt(setar, 4).toString());
        bntAdicionarTelaCadastraEmail.setEnabled(false);
        bntEditarTelaCadastraEmail.setEnabled(true);
        bntDeletarTelaCadastraEmail.setEnabled(true);
    }
     
    private void limparDadosCadastraEmail(){
        txtEmailTelaCadastraEmail.setText(null);
        txtResponsavelTelaCadastraEmail.setText(null);
        txtAniversarioTelaCadastraEmail.setText(null);
        txtDepartamentolTelaCadastraEmail.setText(null);
        bntAdicionarTelaCadastraEmail.setVisible(true);
    }
        
    private void finalizarAcaoCadastraEmail(){
        dispose();
        TelaCadastraConsultaPessoa.buscarEmailTabelaConsultaPessoa(idPessoa);
    }
    
    private boolean validarDadosCadastraEmail(){
        boolean retorno = true;
        if(txtEmailTelaCadastraEmail.getText().isEmpty()){
            retorno = false;
        }
        return retorno;
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCamposObrigatoriosTelaCadastrarEmail = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTelefoneTelaCadastraEmail = new javax.swing.JLabel();
        txtEmailTelaCadastraEmail = new javax.swing.JTextField();
        lblIResponsavelTelaCadastraEmail = new javax.swing.JLabel();
        txtResponsavelTelaCadastraEmail = new javax.swing.JTextField();
        bnLimparTelaCadastraEmail = new javax.swing.JButton();
        bntAdicionarTelaCadastraEmail = new javax.swing.JButton();
        bntEditarTelaCadastraEmail = new javax.swing.JButton();
        bntDeletarTelaCadastraEmail = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTelaCadastrarEmail = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtAniversarioTelaCadastraEmail = new javax.swing.JTextField();
        txtDepartamentolTelaCadastraEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de E-mails - Sistema Os");

        lblCamposObrigatoriosTelaCadastrarEmail.setText("*Campos Obrigatórios");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Emails"));

        lblTelefoneTelaCadastraEmail.setText("*E-mail");

        lblIResponsavelTelaCadastraEmail.setText("Responsavel");

        bnLimparTelaCadastraEmail.setText("Limpar");
        bnLimparTelaCadastraEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnLimparTelaCadastraEmailActionPerformed(evt);
            }
        });

        bntAdicionarTelaCadastraEmail.setText("Adicionar");
        bntAdicionarTelaCadastraEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAdicionarTelaCadastraEmailActionPerformed(evt);
            }
        });

        bntEditarTelaCadastraEmail.setText("Editar");
        bntEditarTelaCadastraEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEditarTelaCadastraEmailActionPerformed(evt);
            }
        });

        bntDeletarTelaCadastraEmail.setText("Deletar");
        bntDeletarTelaCadastraEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDeletarTelaCadastraEmailActionPerformed(evt);
            }
        });

        tblTelaCadastrarEmail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "E-MAIL", "RESPONSAVEL", "ANIVERSÁRIO", "DEPARTAMENTO"
            }
        ));
        tblTelaCadastrarEmail.getTableHeader().setReorderingAllowed(false);
        tblTelaCadastrarEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTelaCadastrarEmailMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTelaCadastrarEmail);
        if (tblTelaCadastrarEmail.getColumnModel().getColumnCount() > 0) {
            tblTelaCadastrarEmail.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblTelaCadastrarEmail.getColumnModel().getColumn(1).setPreferredWidth(275);
            tblTelaCadastrarEmail.getColumnModel().getColumn(2).setPreferredWidth(70);
            tblTelaCadastrarEmail.getColumnModel().getColumn(3).setPreferredWidth(57);
        }

        jLabel1.setText("Aniversário");

        jLabel2.setText("Departamento");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(bnLimparTelaCadastraEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bntAdicionarTelaCadastraEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bntEditarTelaCadastraEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bntDeletarTelaCadastraEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIResponsavelTelaCadastraEmail)
                            .addComponent(txtResponsavelTelaCadastraEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAniversarioTelaCadastraEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtDepartamentolTelaCadastraEmail)))
                    .addComponent(txtEmailTelaCadastraEmail)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTelefoneTelaCadastraEmail)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTelefoneTelaCadastraEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmailTelaCadastraEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblIResponsavelTelaCadastraEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAniversarioTelaCadastraEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtResponsavelTelaCadastraEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDepartamentolTelaCadastraEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntAdicionarTelaCadastraEmail)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bntDeletarTelaCadastraEmail)
                        .addComponent(bnLimparTelaCadastraEmail)
                        .addComponent(bntEditarTelaCadastraEmail)))
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
                        .addComponent(lblCamposObrigatoriosTelaCadastrarEmail)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCamposObrigatoriosTelaCadastrarEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
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

    private void bnLimparTelaCadastraEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnLimparTelaCadastraEmailActionPerformed
        limparDadosCadastraEmail();
    }//GEN-LAST:event_bnLimparTelaCadastraEmailActionPerformed

    private void bntAdicionarTelaCadastraEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAdicionarTelaCadastraEmailActionPerformed
        if(validarDadosCadastraEmail()){
            Email email = new Email();
            EmailDao emailDao = new EmailDao();       
            email.setEmailEma(txtEmailTelaCadastraEmail.getText());
            email.setResponsavelEma(txtResponsavelTelaCadastraEmail.getText());
            email.setDataAniversarioEma(txtAniversarioTelaCadastraEmail.getText());
            email.setDepartamentoEma(txtDepartamentolTelaCadastraEmail.getText());
            email.setIdPessoaFkEma(idPessoa);
            boolean retorno = emailDao.adicionarEmail(email);
            if(retorno){
               JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!", "Cadastra Email", JOptionPane.INFORMATION_MESSAGE);
               finalizarAcaoCadastraEmail();
            }
        }else{
             JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Email", JOptionPane.WARNING_MESSAGE);
        } 
    }//GEN-LAST:event_bntAdicionarTelaCadastraEmailActionPerformed

    private void bntEditarTelaCadastraEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEditarTelaCadastraEmailActionPerformed
        if(validarDadosCadastraEmail()){
            Email email = new Email();
            EmailDao emailDao = new EmailDao();        
            email.setIdEma(idTelefone);
            email.setEmailEma(txtEmailTelaCadastraEmail.getText());
            email.setResponsavelEma(txtResponsavelTelaCadastraEmail.getText());
            email.setDataAniversarioEma(txtAniversarioTelaCadastraEmail.getText());
            email.setDepartamentoEma(txtDepartamentolTelaCadastraEmail.getText());        
            boolean retorno = emailDao.editarEmail(email);
            if(retorno){
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Cadastra Email", JOptionPane.INFORMATION_MESSAGE);
                finalizarAcaoCadastraEmail();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Email", JOptionPane.WARNING_MESSAGE);
        }  
          
    }//GEN-LAST:event_bntEditarTelaCadastraEmailActionPerformed

    private void bntDeletarTelaCadastraEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDeletarTelaCadastraEmailActionPerformed
        if(ControladorDeUsabilidade.telaCadastraEmailDeletarCdu == 1){
            if(validarDadosCadastraEmail()){
                int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este email", "Cadastra Email", JOptionPane.YES_NO_OPTION);
                if (confirma == JOptionPane.YES_OPTION) {
                    EmailDao emailDao = new EmailDao();               
                    boolean retorno = emailDao.deletarEmailPessoa(idTelefone);
                    if(retorno){
                        JOptionPane.showMessageDialog(null, "Dados apagados com sucesso!", "Cadastra Email", JOptionPane.INFORMATION_MESSAGE);
                        finalizarAcaoCadastraEmail(); 
                    }  
                }
            }else{
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Email", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            ControladorDeUsabilidade.acessoNegado();
        }      
    }//GEN-LAST:event_bntDeletarTelaCadastraEmailActionPerformed

    private void tblTelaCadastrarEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTelaCadastrarEmailMouseClicked
       setarCamposCadastraEmail();
    }//GEN-LAST:event_tblTelaCadastrarEmailMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnLimparTelaCadastraEmail;
    public static javax.swing.JButton bntAdicionarTelaCadastraEmail;
    public static javax.swing.JButton bntDeletarTelaCadastraEmail;
    public static javax.swing.JButton bntEditarTelaCadastraEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCamposObrigatoriosTelaCadastrarEmail;
    private javax.swing.JLabel lblIResponsavelTelaCadastraEmail;
    private javax.swing.JLabel lblTelefoneTelaCadastraEmail;
    public static javax.swing.JTable tblTelaCadastrarEmail;
    private javax.swing.JTextField txtAniversarioTelaCadastraEmail;
    private javax.swing.JTextField txtDepartamentolTelaCadastraEmail;
    public static javax.swing.JTextField txtEmailTelaCadastraEmail;
    private javax.swing.JTextField txtResponsavelTelaCadastraEmail;
    // End of variables declaration//GEN-END:variables
}
