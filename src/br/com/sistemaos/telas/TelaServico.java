
package br.com.sistemaos.telas;

import br.com.sistemaos.dao.ServicoDao;
import br.com.sistemaos.modelo.Servico;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TelaServico extends javax.swing.JInternalFrame {

    public static Long idServico;
    protected String servico;
    protected String categoriaServico;
    protected String descricaoServico;
    
    public TelaServico() {
        initComponents();
    }

    public void buscarServicoTbl(){
        
        DefaultTableModel ser = (DefaultTableModel) tblBuscarServico.getModel();
        ser.setNumRows(0); 

        ServicoDao servicoDao = new ServicoDao();

        for(Servico servico: servicoDao.buscarServicoTabelas()){

            ser.addRow(new Object[]{

                servico.getIdSer(),
                servico.getNomeSer()
            });
        }  
    }
    
    private void setarCamposBuscarServico() {
        int setar = tblBuscarServico.getSelectedRow();
        if(jcbAdicionarEditarServico.isSelected()){
            idServico = Long.parseLong(tblBuscarServico.getModel().getValueAt(setar, 0).toString());
            servico = tblBuscarServico.getModel().getValueAt(setar, 1).toString();
            txtCategoriaServico.setText(servico.substring(0, (servico.indexOf('-') - 1)));
            txtDescricaoServico.setText(servico.substring(servico.indexOf('-') + 2));  
            btnAdicionarServico.setEnabled(false);
            btnEditarServico.setEnabled(true);
        }else{
            TelaOs.idServicoOs = Long.parseLong(tblBuscarServico.getModel().getValueAt(setar, 0).toString());
            TelaOs.txtNomeServicoOs.setText(tblBuscarServico.getModel().getValueAt(setar, 1).toString());
        }      
    }
    
    private void configurarAdicionarEditarServico(){
        txtCategoriaServico.requestFocus();
        btnLimparServico.setEnabled(true);
        btnAdicionarServico.setEnabled(true);
        btnEditarServico.setEnabled(false);
    }
    
    private void desconfigurarAdicionarEditaServico(){
        jcbAdicionarEditarServico.setSelected(false);
        btnLimparServico.setEnabled(false);
        btnAdicionarServico.setEnabled(false);
        btnEditarServico.setEnabled(false);
    }
    
    private void limparDadosServico(){
        txtCategoriaServico.setText(null);
        txtDescricaoServico.setText(null);
    }
    
    private boolean validarDadosServico(){
        boolean retorno = true;
        if(txtCategoriaServico.getText().isEmpty()){
            retorno = false;
        }
        if(txtDescricaoServico.getText().isEmpty()){
            retorno = false;
        }
        return retorno;
    }
    
    private void configuraTelaIniciarServico(){
        idServico = null;
        limparDadosServico();
        buscarServicoTbl();
        desconfigurarAdicionarEditaServico();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuscarServico = new javax.swing.JTable();
        txtCategoriaServico = new javax.swing.JTextField();
        btnAdicionarServico = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnEditarServico = new javax.swing.JButton();
        btnLimparServico = new javax.swing.JButton();
        jcbAdicionarEditarServico = new javax.swing.JCheckBox();
        btnCancelarServico = new javax.swing.JButton();
        txtDescricaoServico = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Tela Servico - Sistema Os");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Marcas"));

        tblBuscarServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "SERVICO"
            }
        ));
        tblBuscarServico.getTableHeader().setReorderingAllowed(false);
        tblBuscarServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBuscarServicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBuscarServico);
        if (tblBuscarServico.getColumnModel().getColumnCount() > 0) {
            tblBuscarServico.getColumnModel().getColumn(0).setMinWidth(50);
            tblBuscarServico.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblBuscarServico.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        btnAdicionarServico.setText("Adicionar");
        btnAdicionarServico.setEnabled(false);
        btnAdicionarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarServicoActionPerformed(evt);
            }
        });

        jLabel2.setText("*Categoria");

        btnEditarServico.setText("Editar");
        btnEditarServico.setEnabled(false);
        btnEditarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarServicoActionPerformed(evt);
            }
        });

        btnLimparServico.setText("Limpar");
        btnLimparServico.setEnabled(false);
        btnLimparServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparServicoActionPerformed(evt);
            }
        });

        jcbAdicionarEditarServico.setText("Adicionar / Editar");
        jcbAdicionarEditarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAdicionarEditarServicoActionPerformed(evt);
            }
        });

        btnCancelarServico.setText("Cancelar");
        btnCancelarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarServicoActionPerformed(evt);
            }
        });

        jLabel1.setText("*Descrção");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCategoriaServico, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescricaoServico))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(88, 88, 88)
                                .addComponent(jLabel1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbAdicionarEditarServico)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnLimparServico, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdicionarServico, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditarServico, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelarServico, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbAdicionarEditarServico)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCategoriaServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescricaoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimparServico)
                    .addComponent(btnAdicionarServico)
                    .addComponent(btnEditarServico)
                    .addComponent(btnCancelarServico))
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

    private void tblBuscarServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBuscarServicoMouseClicked
        setarCamposBuscarServico();
    }//GEN-LAST:event_tblBuscarServicoMouseClicked

    private void btnAdicionarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarServicoActionPerformed
        if(validarDadosServico()){
            ServicoDao servicoDao = new ServicoDao();
            Servico servico = new Servico();
            categoriaServico = txtCategoriaServico.getText();
            descricaoServico = txtDescricaoServico.getText();
            servico.setNomeSer(categoriaServico + " - " + descricaoServico);
            boolean retorno = servicoDao.adicionarServico(servico);
            if(retorno){
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Cadastra Servico", JOptionPane.INFORMATION_MESSAGE);
                buscarServicoTbl();
                limparDadosServico();
                desconfigurarAdicionarEditaServico();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Servico", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAdicionarServicoActionPerformed

    private void btnEditarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarServicoActionPerformed
        if(validarDadosServico()){
            ServicoDao servicoDao = new ServicoDao();
            Servico servico = new Servico();
            categoriaServico = txtCategoriaServico.getText();
            descricaoServico = txtDescricaoServico.getText();
            servico.setNomeSer(categoriaServico + " - " + descricaoServico);
            servico.setIdSer(idServico);
            boolean retorno = servicoDao.editarServico(servico);
            if(retorno){
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Cadastra Servico", JOptionPane.INFORMATION_MESSAGE);
                buscarServicoTbl();
                limparDadosServico();
                desconfigurarAdicionarEditaServico();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Servico", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarServicoActionPerformed

    private void btnLimparServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparServicoActionPerformed
        limparDadosServico();
    }//GEN-LAST:event_btnLimparServicoActionPerformed

    private void jcbAdicionarEditarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAdicionarEditarServicoActionPerformed
        if(jcbAdicionarEditarServico.isSelected()){
            configurarAdicionarEditarServico();
        }else{
            desconfigurarAdicionarEditaServico();
        }
    }//GEN-LAST:event_jcbAdicionarEditarServicoActionPerformed

    private void btnCancelarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarServicoActionPerformed
        configuraTelaIniciarServico();
    }//GEN-LAST:event_btnCancelarServicoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarServico;
    private javax.swing.JButton btnCancelarServico;
    private javax.swing.JButton btnEditarServico;
    private javax.swing.JButton btnLimparServico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jcbAdicionarEditarServico;
    public static javax.swing.JTable tblBuscarServico;
    private javax.swing.JTextField txtCategoriaServico;
    private javax.swing.JTextField txtDescricaoServico;
    // End of variables declaration//GEN-END:variables
}
