
package br.com.sistemaos.telas;

import br.com.sistemaos.dao.ProdutoDao;
import br.com.sistemaos.modelo.Produto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TelaProduto extends javax.swing.JInternalFrame {

   public static Long idProduto;
   public static Long idMarcaFk;
   protected String produto;
   protected String categoriaProduto;
   protected String codigoProduto;
   
    public TelaProduto() {
        initComponents();
    }

    public void buscarProdutoTbl(Long idMarca){
        
        DefaultTableModel pro = (DefaultTableModel) tblBuscarProduto.getModel();
        pro.setNumRows(0); 

        ProdutoDao produtoDao = new ProdutoDao();

        for(Produto produto: produtoDao.buscarProdutoTabelas(idMarca)){

            pro.addRow(new Object[]{

                produto.getIdPro(),
                produto.getNomePro()
            });
        }  
    }
    
    private void setarCamposBuscarProduto() {
        int setar = tblBuscarProduto.getSelectedRow();
        if(jcbAdicionarEditarProduto.isSelected()){
            idProduto = Long.parseLong(tblBuscarProduto.getModel().getValueAt(setar, 0).toString());
            produto = tblBuscarProduto.getModel().getValueAt(setar, 1).toString();
            txtCategoriaProduto.setText(produto.substring(0, (produto.indexOf('-') - 1)));
            txtCodigoProduto.setText(produto.substring(produto.indexOf('-') + 2));  
            btnAdicionarProduto.setEnabled(false);
            btnEditarProduto.setEnabled(true);
        }else{
            TelaOs.idProdutoOs = Long.parseLong(tblBuscarProduto.getModel().getValueAt(setar, 0).toString());
            TelaOs.txtNomeProdutoOs.setText(tblBuscarProduto.getModel().getValueAt(setar, 1).toString());
        }      
    }
    
    private void configurarAdicionarEditarProduto(){
        txtCategoriaProduto.requestFocus();
        btnLimparProduto.setEnabled(true);
        btnAdicionarProduto.setEnabled(true);
        btnEditarProduto.setEnabled(false);
    }
    
    private void desconfigurarAdicionarEditaProduto(){
        jcbAdicionarEditarProduto.setSelected(false);
        btnLimparProduto.setEnabled(false);
        btnAdicionarProduto.setEnabled(false);
        btnEditarProduto.setEnabled(false);
    }
    
    private void limparDadosProduto(){
        txtCategoriaProduto.setText(null);
        txtCodigoProduto.setText(null);
    }
    
    private boolean validarDadosProduto(){
        boolean retorno = true;
        if(txtCategoriaProduto.getText().isEmpty()){
            retorno = false;
        }
        if(txtCodigoProduto.getText().isEmpty()){
            retorno = false;
        }
        return retorno;
    }
    
    private void configuraTelaIniciarProduto(){
        idProduto = null;
        limparDadosProduto();
        buscarProdutoTbl(idMarcaFk);
        desconfigurarAdicionarEditaProduto();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuscarProduto = new javax.swing.JTable();
        txtCategoriaProduto = new javax.swing.JTextField();
        btnAdicionarProduto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnEditarProduto = new javax.swing.JButton();
        btnLimparProduto = new javax.swing.JButton();
        jcbAdicionarEditarProduto = new javax.swing.JCheckBox();
        btnCancelarProduto = new javax.swing.JButton();
        txtCodigoProduto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Tela Produto  - Sistema Os");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Marcas"));

        tblBuscarProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "PRODUTO"
            }
        ));
        tblBuscarProduto.getTableHeader().setReorderingAllowed(false);
        tblBuscarProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBuscarProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBuscarProduto);
        if (tblBuscarProduto.getColumnModel().getColumnCount() > 0) {
            tblBuscarProduto.getColumnModel().getColumn(0).setMinWidth(50);
            tblBuscarProduto.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblBuscarProduto.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        btnAdicionarProduto.setText("Adicionar");
        btnAdicionarProduto.setEnabled(false);
        btnAdicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarProdutoActionPerformed(evt);
            }
        });

        jLabel2.setText("*Categoria");

        btnEditarProduto.setText("Editar");
        btnEditarProduto.setEnabled(false);
        btnEditarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProdutoActionPerformed(evt);
            }
        });

        btnLimparProduto.setText("Limpar");
        btnLimparProduto.setEnabled(false);
        btnLimparProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparProdutoActionPerformed(evt);
            }
        });

        jcbAdicionarEditarProduto.setText("Adicionar / Editar");
        jcbAdicionarEditarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAdicionarEditarProdutoActionPerformed(evt);
            }
        });

        btnCancelarProduto.setText("Cancelar");
        btnCancelarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarProdutoActionPerformed(evt);
            }
        });

        jLabel1.setText("*Código");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCategoriaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigoProduto))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(88, 88, 88)
                                .addComponent(jLabel1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbAdicionarEditarProduto)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnLimparProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbAdicionarEditarProduto)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCategoriaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimparProduto)
                    .addComponent(btnAdicionarProduto)
                    .addComponent(btnEditarProduto)
                    .addComponent(btnCancelarProduto))
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

    private void tblBuscarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBuscarProdutoMouseClicked
        setarCamposBuscarProduto();
    }//GEN-LAST:event_tblBuscarProdutoMouseClicked

    private void btnAdicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarProdutoActionPerformed
        if(validarDadosProduto()){
            ProdutoDao produtoDao = new ProdutoDao();
            Produto produto = new Produto();
            categoriaProduto = txtCategoriaProduto.getText();
            codigoProduto = txtCodigoProduto.getText();
            produto.setNomePro(categoriaProduto + " - " + codigoProduto);
            produto.setIdMarcaFkPro(idMarcaFk);
            boolean retorno = produtoDao.adicionarProduto(produto);
            if(retorno){
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Cadastra Marca", JOptionPane.INFORMATION_MESSAGE);
                buscarProdutoTbl(idMarcaFk);
                limparDadosProduto();
                desconfigurarAdicionarEditaProduto();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Marca", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAdicionarProdutoActionPerformed

    private void btnEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProdutoActionPerformed
        if(validarDadosProduto()){
            ProdutoDao produtoDao = new ProdutoDao();
            Produto produto = new Produto();
            categoriaProduto = txtCategoriaProduto.getText();
            codigoProduto = txtCodigoProduto.getText();
            produto.setNomePro(categoriaProduto + " - " + codigoProduto);
            produto.setIdPro(idProduto);
            boolean retorno = produtoDao.editarProduto(produto);
            if(retorno){
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Cadastra Marca", JOptionPane.INFORMATION_MESSAGE);
                buscarProdutoTbl(idMarcaFk);
                limparDadosProduto();
                desconfigurarAdicionarEditaProduto();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Marca", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarProdutoActionPerformed

    private void btnLimparProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparProdutoActionPerformed
        limparDadosProduto();
    }//GEN-LAST:event_btnLimparProdutoActionPerformed

    private void jcbAdicionarEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAdicionarEditarProdutoActionPerformed
        if(jcbAdicionarEditarProduto.isSelected()){
            configurarAdicionarEditarProduto();
        }else{
            desconfigurarAdicionarEditaProduto();
        }
    }//GEN-LAST:event_jcbAdicionarEditarProdutoActionPerformed

    private void btnCancelarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarProdutoActionPerformed
        configuraTelaIniciarProduto();
    }//GEN-LAST:event_btnCancelarProdutoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarProduto;
    private javax.swing.JButton btnCancelarProduto;
    private javax.swing.JButton btnEditarProduto;
    private javax.swing.JButton btnLimparProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jcbAdicionarEditarProduto;
    public static javax.swing.JTable tblBuscarProduto;
    private javax.swing.JTextField txtCategoriaProduto;
    private javax.swing.JTextField txtCodigoProduto;
    // End of variables declaration//GEN-END:variables
}
