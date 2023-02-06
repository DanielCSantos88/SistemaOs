
package br.com.sistemaos.telas;

import br.com.sistemaos.dao.SetorDao;
import br.com.sistemaos.modelo.Setor;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TelaCadastraSetor extends javax.swing.JInternalFrame {

    public static Long idSetor;
    
    public TelaCadastraSetor() {
        initComponents();
    }
 
    public void buscarSetorTbl(){
        
        DefaultTableModel set = (DefaultTableModel) tblBuscarSetor.getModel();
        set.setNumRows(0); 

        SetorDao setorDao = new SetorDao();

        for(Setor setor: setorDao.buscarSetorTabelas()){

            set.addRow(new Object[]{

                setor.getIdSet(),
                setor.getNomeSet()
            });
        }  
    }
    
    private void setarCamposBuscarSetor() {
        int setar = tblBuscarSetor.getSelectedRow();
         idSetor = Long.parseLong(tblBuscarSetor.getModel().getValueAt(setar, 0).toString());
         txtNomeSetor.setText(tblBuscarSetor.getModel().getValueAt(setar, 1).toString());
         btnAdicionarSetor.setEnabled(false);
         btnEditarSetor.setEnabled(true);
    }
    
    private void limparDadosSetor(){
        txtNomeSetor.setText(null);
    }
    
    private boolean validarDadosSetor(){
        boolean retorno = true;
        if(txtNomeSetor.getText().isEmpty()){
            retorno = false;
        }
        return retorno;
    }
    
    private void configuraTelaIniciarSetor(){
        idSetor = null;   
        txtNomeSetor.requestFocus();
        configuraBotoesIniciar();
        limparDadosSetor();
        buscarSetorTbl();
    }
    
    private void configuraBotoesIniciar(){
        btnAdicionarSetor.setEnabled(true);
        btnEditarSetor.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuscarSetor = new javax.swing.JTable();
        txtNomeSetor = new javax.swing.JTextField();
        btnAdicionarSetor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnEditarSetor = new javax.swing.JButton();
        btnLimparSetor = new javax.swing.JButton();
        btnCancelarSetor = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastra Setor - Sistema Os");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Setores"));

        tblBuscarSetor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "SETOR"
            }
        ));
        tblBuscarSetor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBuscarSetorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBuscarSetor);
        if (tblBuscarSetor.getColumnModel().getColumnCount() > 0) {
            tblBuscarSetor.getColumnModel().getColumn(0).setMinWidth(50);
            tblBuscarSetor.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblBuscarSetor.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        btnAdicionarSetor.setText("Adicionar");
        btnAdicionarSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarSetorActionPerformed(evt);
            }
        });

        jLabel2.setText("*Nome");

        btnEditarSetor.setText("Editar");
        btnEditarSetor.setEnabled(false);
        btnEditarSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarSetorActionPerformed(evt);
            }
        });

        btnLimparSetor.setText("Limpar");
        btnLimparSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparSetorActionPerformed(evt);
            }
        });

        btnCancelarSetor.setText("Cancelar");
        btnCancelarSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarSetorActionPerformed(evt);
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
                        .addComponent(txtNomeSetor, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnLimparSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdicionarSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimparSetor)
                    .addComponent(btnAdicionarSetor)
                    .addComponent(btnEditarSetor)
                    .addComponent(btnCancelarSetor))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblBuscarSetorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBuscarSetorMouseClicked
        setarCamposBuscarSetor();
    }//GEN-LAST:event_tblBuscarSetorMouseClicked

    private void btnAdicionarSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarSetorActionPerformed
        if(validarDadosSetor()){
            SetorDao setorDao = new SetorDao();
            Setor setor = new Setor();
            setor.setNomeSet(txtNomeSetor.getText());
            boolean retorno = setorDao.adicionarSetor(setor);
            if(retorno){
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Cadastra Setor", JOptionPane.INFORMATION_MESSAGE);
                buscarSetorTbl();
                limparDadosSetor();
                configuraBotoesIniciar();
                txtNomeSetor.requestFocus();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Setor", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAdicionarSetorActionPerformed

    private void btnEditarSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarSetorActionPerformed
        if(validarDadosSetor()){
            SetorDao setorDao = new SetorDao();
            Setor setor = new Setor();
            setor.setNomeSet(txtNomeSetor.getText());
            setor.setIdSet(idSetor);
            boolean retorno = setorDao.editarSetor(setor);
            if(retorno){
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Cadastra Setor", JOptionPane.INFORMATION_MESSAGE);
                buscarSetorTbl();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Setor", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarSetorActionPerformed

    private void btnLimparSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparSetorActionPerformed
       limparDadosSetor();
    }//GEN-LAST:event_btnLimparSetorActionPerformed

    private void btnCancelarSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarSetorActionPerformed
        configuraTelaIniciarSetor();
    }//GEN-LAST:event_btnCancelarSetorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarSetor;
    private javax.swing.JButton btnCancelarSetor;
    private javax.swing.JButton btnEditarSetor;
    private javax.swing.JButton btnLimparSetor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblBuscarSetor;
    private javax.swing.JTextField txtNomeSetor;
    // End of variables declaration//GEN-END:variables
}
