
package br.com.sistemaos.telas;

import br.com.sistemaos.dao.DefeitoDao;
import br.com.sistemaos.modelo.Defeito;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaDefeito extends javax.swing.JInternalFrame {
    
    public static Long idDefeito;

    public TelaDefeito() {
        initComponents();
    }
     
    public void buscarDefeitoTbl(){
        
        DefaultTableModel def = (DefaultTableModel) tblBuscarDefeito.getModel();
        def.setNumRows(0); 

        DefeitoDao defeitoDao = new DefeitoDao();

        for(Defeito defeito: defeitoDao.buscarDefeitoTabelas()){

            def.addRow(new Object[]{
               
                defeito.getIdDef(),
                defeito.getNomeDef()
            });
        }  
    }
    
    private void setarCamposBuscarDefeito() {
        int setar = tblBuscarDefeito.getSelectedRow();
        if(jcbAdcionarEditarDefeito.isSelected()){
            idDefeito = Long.parseLong(tblBuscarDefeito.getModel().getValueAt(setar, 0).toString());
            txtNomeDefeito.setText(tblBuscarDefeito.getModel().getValueAt(setar, 1).toString());
            btnAdicionarDefeito.setEnabled(false);
            btnEditarDefeito.setEnabled(true);
        }else{
            TelaOs.idDefeitoOs = Long.parseLong(tblBuscarDefeito.getModel().getValueAt(setar, 0).toString());
            TelaOs.txtNomeDefeitoOs.setText(tblBuscarDefeito.getModel().getValueAt(setar, 1).toString());
        }      
    }
    
    private void configurarAdicionarEditarDefeito(){
        txtNomeDefeito.requestFocus();
        btnLimparDefeito.setEnabled(true);
        btnAdicionarDefeito.setEnabled(true);
        btnEditarDefeito.setEnabled(false);
    }
    
    private void desconfigurarAdicionarEditarDefeito(){
        jcbAdcionarEditarDefeito.setSelected(false);
        btnLimparDefeito.setEnabled(false);
        btnAdicionarDefeito.setEnabled(false);
        btnEditarDefeito.setEnabled(false);
    }
    
    private void limparDadosDefeito(){
        txtNomeDefeito.setText(null);
    }
    
    private boolean validarDadosDefeito(){
        boolean retorno = true;
        if(txtNomeDefeito.getText().isEmpty()){
            retorno = false;
        }
        return retorno;
    }
    
    private void configuraTelaIniciarDefeito(){
        idDefeito = null;
        limparDadosDefeito();
        buscarDefeitoTbl();
        desconfigurarAdicionarEditarDefeito();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuscarDefeito = new javax.swing.JTable();
        txtNomeDefeito = new javax.swing.JTextField();
        btnAdicionarDefeito = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnEditarDefeito = new javax.swing.JButton();
        btnLimparDefeito = new javax.swing.JButton();
        jcbAdcionarEditarDefeito = new javax.swing.JCheckBox();
        btnCancelarDefeito = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Tela Defeito - Sistema Os");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Marcas"));

        tblBuscarDefeito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "DEFEITO"
            }
        ));
        tblBuscarDefeito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBuscarDefeitoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBuscarDefeito);
        if (tblBuscarDefeito.getColumnModel().getColumnCount() > 0) {
            tblBuscarDefeito.getColumnModel().getColumn(0).setMinWidth(50);
            tblBuscarDefeito.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblBuscarDefeito.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        btnAdicionarDefeito.setText("Adicionar");
        btnAdicionarDefeito.setEnabled(false);
        btnAdicionarDefeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarDefeitoActionPerformed(evt);
            }
        });

        jLabel2.setText("*Nome");

        btnEditarDefeito.setText("Editar");
        btnEditarDefeito.setEnabled(false);
        btnEditarDefeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarDefeitoActionPerformed(evt);
            }
        });

        btnLimparDefeito.setText("Limpar");
        btnLimparDefeito.setEnabled(false);
        btnLimparDefeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparDefeitoActionPerformed(evt);
            }
        });

        jcbAdcionarEditarDefeito.setText("Adicionar / Editar");
        jcbAdcionarEditarDefeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAdcionarEditarDefeitoActionPerformed(evt);
            }
        });

        btnCancelarDefeito.setText("Cancelar");
        btnCancelarDefeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarDefeitoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNomeDefeito, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                        .addComponent(jcbAdcionarEditarDefeito, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnLimparDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdicionarDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbAdcionarEditarDefeito)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimparDefeito)
                    .addComponent(btnAdicionarDefeito)
                    .addComponent(btnEditarDefeito)
                    .addComponent(btnCancelarDefeito))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("*Campos Obrigatórios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblBuscarDefeitoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBuscarDefeitoMouseClicked
        setarCamposBuscarDefeito();
    }//GEN-LAST:event_tblBuscarDefeitoMouseClicked

    private void btnAdicionarDefeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarDefeitoActionPerformed
        if(validarDadosDefeito()){
            DefeitoDao defeitoDao = new DefeitoDao();
            Defeito defeito = new Defeito();
            defeito.setNomeDef(txtNomeDefeito.getText());
            boolean retorno = defeitoDao.adicionarDefeito(defeito);
            if(retorno){
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Cadastra Defeito", JOptionPane.INFORMATION_MESSAGE);
                buscarDefeitoTbl();
                limparDadosDefeito();
                desconfigurarAdicionarEditarDefeito();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Defeito", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAdicionarDefeitoActionPerformed

    private void btnEditarDefeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDefeitoActionPerformed
        if(validarDadosDefeito()){
            DefeitoDao defeitoDao = new DefeitoDao();
            Defeito defeito = new Defeito();
            defeito.setNomeDef(txtNomeDefeito.getText());
            defeito.setIdDef(idDefeito);
            boolean retorno = defeitoDao.editarDefeito(defeito);
            if(retorno){
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Cadastra Defeito", JOptionPane.INFORMATION_MESSAGE);
                buscarDefeitoTbl();
                limparDadosDefeito();
                desconfigurarAdicionarEditarDefeito();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Defeito", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarDefeitoActionPerformed

    private void btnLimparDefeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparDefeitoActionPerformed
        limparDadosDefeito();
    }//GEN-LAST:event_btnLimparDefeitoActionPerformed

    private void jcbAdcionarEditarDefeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAdcionarEditarDefeitoActionPerformed
        if(jcbAdcionarEditarDefeito.isSelected()){
            configurarAdicionarEditarDefeito();
        }else{
            desconfigurarAdicionarEditarDefeito();
        }
    }//GEN-LAST:event_jcbAdcionarEditarDefeitoActionPerformed

    private void btnCancelarDefeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarDefeitoActionPerformed
        configuraTelaIniciarDefeito();
    }//GEN-LAST:event_btnCancelarDefeitoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarDefeito;
    private javax.swing.JButton btnCancelarDefeito;
    private javax.swing.JButton btnEditarDefeito;
    private javax.swing.JButton btnLimparDefeito;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jcbAdcionarEditarDefeito;
    public static javax.swing.JTable tblBuscarDefeito;
    private javax.swing.JTextField txtNomeDefeito;
    // End of variables declaration//GEN-END:variables
}
