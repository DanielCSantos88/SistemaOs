
package br.com.sistemaos.telas;

import br.com.sistemaos.dao.MarcaDao;
import br.com.sistemaos.modelo.Marca;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TelaMarca extends javax.swing.JInternalFrame {

    public static Long idMarca;
   
    public TelaMarca() {
        initComponents();
    }

    public void buscarMarcaTbl(){
        
        DefaultTableModel mar = (DefaultTableModel) tblBuscarMarca.getModel();
        mar.setNumRows(0); 

        MarcaDao telefoneDao = new MarcaDao();

        for(Marca marca: telefoneDao.buscarMarcaTabelas()){

            mar.addRow(new Object[]{

                marca.getIdMar(),
                marca.getNomeMar(),
            });
        }  
    }
    
    private void setarCamposBuscarMarca() {
        int setar = tblBuscarMarca.getSelectedRow();
        if(jcbAdcionarEditarMarca.isSelected()){
            idMarca = Long.parseLong(tblBuscarMarca.getModel().getValueAt(setar, 0).toString());
            txtNomeMarca.setText(tblBuscarMarca.getModel().getValueAt(setar, 1).toString());
            btnAdicionarMarca.setEnabled(false);
            btnEditarMarca.setEnabled(true);
        }else{
            TelaOs.idMarcaOs = Long.parseLong(tblBuscarMarca.getModel().getValueAt(setar, 0).toString());
            TelaOs.txtNomeMarcaOs.setText(tblBuscarMarca.getModel().getValueAt(setar, 1).toString());
        }      
    }
    
    private void configurarAdicionarEditarMarca(){
        txtNomeMarca.requestFocus();
        btnLimparMarca.setEnabled(true);
        btnAdicionarMarca.setEnabled(true);
        btnEditarMarca.setEnabled(false);
    }
    
    private void desconfigurarAdicionarEditarMarca(){
        jcbAdcionarEditarMarca.setSelected(false);
        btnLimparMarca.setEnabled(false);
        btnAdicionarMarca.setEnabled(false);
        btnEditarMarca.setEnabled(false);
    }
    
    private void limparDadosMarca(){
        txtNomeMarca.setText(null);
    }
    
    private boolean validarDadosMarca(){
        boolean retorno = true;
        if(txtNomeMarca.getText().isEmpty()){
            retorno = false;
        }
        return retorno;
    }
    
    private void configuraTelaIniciarMarca(){
        idMarca = null;
        limparDadosMarca();
        buscarMarcaTbl();
        desconfigurarAdicionarEditarMarca();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuscarMarca = new javax.swing.JTable();
        txtNomeMarca = new javax.swing.JTextField();
        btnAdicionarMarca = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnEditarMarca = new javax.swing.JButton();
        btnLimparMarca = new javax.swing.JButton();
        jcbAdcionarEditarMarca = new javax.swing.JCheckBox();
        btnCancelarMarca = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Buscar Marca - Sistema Os");
        setToolTipText("");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Marcas"));

        tblBuscarMarca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "MARCA"
            }
        ));
        tblBuscarMarca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBuscarMarcaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBuscarMarca);
        if (tblBuscarMarca.getColumnModel().getColumnCount() > 0) {
            tblBuscarMarca.getColumnModel().getColumn(0).setMinWidth(50);
            tblBuscarMarca.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblBuscarMarca.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        btnAdicionarMarca.setText("Adicionar");
        btnAdicionarMarca.setEnabled(false);
        btnAdicionarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarMarcaActionPerformed(evt);
            }
        });

        jLabel2.setText("*Nome");

        btnEditarMarca.setText("Editar");
        btnEditarMarca.setEnabled(false);
        btnEditarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarMarcaActionPerformed(evt);
            }
        });

        btnLimparMarca.setText("Limpar");
        btnLimparMarca.setEnabled(false);
        btnLimparMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparMarcaActionPerformed(evt);
            }
        });

        jcbAdcionarEditarMarca.setText("Adicionar / Editar");
        jcbAdcionarEditarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAdcionarEditarMarcaActionPerformed(evt);
            }
        });

        btnCancelarMarca.setText("Cancelar");
        btnCancelarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarMarcaActionPerformed(evt);
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
                        .addComponent(txtNomeMarca, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                        .addComponent(jcbAdcionarEditarMarca, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnLimparMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdicionarMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbAdcionarEditarMarca)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimparMarca)
                    .addComponent(btnAdicionarMarca)
                    .addComponent(btnEditarMarca)
                    .addComponent(btnCancelarMarca))
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

        setBounds(0, 0, 446, 368);
    }// </editor-fold>//GEN-END:initComponents

    private void tblBuscarMarcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBuscarMarcaMouseClicked
        setarCamposBuscarMarca();
    }//GEN-LAST:event_tblBuscarMarcaMouseClicked

    private void jcbAdcionarEditarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAdcionarEditarMarcaActionPerformed
        if(jcbAdcionarEditarMarca.isSelected()){
            configurarAdicionarEditarMarca();
        }else{
            desconfigurarAdicionarEditarMarca();
        }
    }//GEN-LAST:event_jcbAdcionarEditarMarcaActionPerformed

    private void btnLimparMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparMarcaActionPerformed
        limparDadosMarca();
    }//GEN-LAST:event_btnLimparMarcaActionPerformed

    private void btnAdicionarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarMarcaActionPerformed
        if(validarDadosMarca()){
            MarcaDao marcaDao = new MarcaDao();
            Marca marca = new Marca();
            marca.setNomeMar(txtNomeMarca.getText());
            boolean retorno = marcaDao.adicionarMarca(marca);
            if(retorno){
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Cadastra Marca", JOptionPane.INFORMATION_MESSAGE);
                buscarMarcaTbl();
                limparDadosMarca();
                desconfigurarAdicionarEditarMarca();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Marca", JOptionPane.WARNING_MESSAGE); 
        }    
    }//GEN-LAST:event_btnAdicionarMarcaActionPerformed

    private void btnEditarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarMarcaActionPerformed
        if(validarDadosMarca()){
            MarcaDao marcaDao = new MarcaDao();
            Marca marca = new Marca();
            marca.setNomeMar(txtNomeMarca.getText());
            marca.setIdMar(idMarca);
            boolean retorno = marcaDao.editarMarca(marca);
            if(retorno){
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Cadastra Marca", JOptionPane.INFORMATION_MESSAGE);
                buscarMarcaTbl();
                limparDadosMarca();
                desconfigurarAdicionarEditarMarca();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Marca", JOptionPane.WARNING_MESSAGE); 
        }    
    }//GEN-LAST:event_btnEditarMarcaActionPerformed

    private void btnCancelarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarMarcaActionPerformed
        configuraTelaIniciarMarca();
    }//GEN-LAST:event_btnCancelarMarcaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarMarca;
    private javax.swing.JButton btnCancelarMarca;
    private javax.swing.JButton btnEditarMarca;
    private javax.swing.JButton btnLimparMarca;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jcbAdcionarEditarMarca;
    public static javax.swing.JTable tblBuscarMarca;
    private javax.swing.JTextField txtNomeMarca;
    // End of variables declaration//GEN-END:variables
}
