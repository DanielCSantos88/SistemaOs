
package br.com.sistemaos.telas;

import Jm.JMascara;
import br.com.sistemaos.dao.DadosFuncionarioDao;
import br.com.sistemaos.dao.PessoaDao;
import br.com.sistemaos.dao.SetorDao;
import br.com.sistemaos.modelo.ControladorDeUsabilidade;
import br.com.sistemaos.modelo.DadosFuncionario;
import br.com.sistemaos.modelo.Setor;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaCadastraDadosFuncionario extends javax.swing.JInternalFrame {

    protected  Long idFuncionario = TelaCadastraConsultaPessoa.idPessoaTelaConsultaPessoa;
    public static Long idDadosFuncionario;
    public static Long idSetor;

    public TelaCadastraDadosFuncionario() {
        initComponents();
    }
    
    public void buscarTblDadosFuncionario(){

        DefaultTableModel modelo = (DefaultTableModel) tblSetorDadosFuncionario.getModel();
        modelo.setNumRows(0);
       
        SetorDao setorDao = new SetorDao();
        
        for(Setor setor: setorDao.buscarSetorTabelas()){
            modelo.addRow(new Object[]{
             
                setor.getIdSet(),
                setor.getNomeSet(),
                
            });
        }
    }
    
    private void setarCamposSetorDadosFuncionario() {
        int setar = tblSetorDadosFuncionario.getSelectedRow();
        idSetor = Long.parseLong(tblSetorDadosFuncionario.getModel().getValueAt(setar, 0).toString());
        txrSetorCadastraDadosFuncionario.setText(tblSetorDadosFuncionario.getModel().getValueAt(setar, 1).toString());
    }
    
    private boolean validarDadosFuncionario(){
        boolean retorno = true;
        if(txtSalarioFuncionario.getText().equals("0,00")){
            retorno = false;
        }
        return retorno;
    }
    
 
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblCargoFuncionario = new javax.swing.JLabel();
        lblSalarioFuncionario = new javax.swing.JLabel();
        txtSalarioFuncionario = new br.com.sistemaos.util.JMoneyField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSetorDadosFuncionario = new javax.swing.JTable();
        txrSetorCadastraDadosFuncionario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bntEditarDadosFuncionario = new javax.swing.JButton();
        btnDeletarDadosFuncionario = new javax.swing.JButton();
        btnAdicionarCadastraFuncionario = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Dados Funcionário - Sistema Os");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Funcionário"));

        lblCargoFuncionario.setText("Setor");

        lblSalarioFuncionario.setText("*Salario");

        txtSalarioFuncionario.setEditable(true);

        tblSetorDadosFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
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
        tblSetorDadosFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSetorDadosFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSetorDadosFuncionario);
        if (tblSetorDadosFuncionario.getColumnModel().getColumnCount() > 0) {
            tblSetorDadosFuncionario.getColumnModel().getColumn(0).setMinWidth(50);
            tblSetorDadosFuncionario.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblSetorDadosFuncionario.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCargoFuncionario)
                    .addComponent(txrSetorCadastraDadosFuncionario)
                    .addComponent(lblSalarioFuncionario)
                    .addComponent(txtSalarioFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblCargoFuncionario)
                        .addGap(8, 8, 8)
                        .addComponent(txrSetorCadastraDadosFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSalarioFuncionario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSalarioFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 98, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel1.setText("*Campos Obrigatórios");

        bntEditarDadosFuncionario.setText("Editar");
        bntEditarDadosFuncionario.setEnabled(false);
        bntEditarDadosFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEditarDadosFuncionarioActionPerformed(evt);
            }
        });

        btnDeletarDadosFuncionario.setText("Deletar");
        btnDeletarDadosFuncionario.setEnabled(false);
        btnDeletarDadosFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarDadosFuncionarioActionPerformed(evt);
            }
        });

        btnAdicionarCadastraFuncionario.setText("Adicionar");
        btnAdicionarCadastraFuncionario.setEnabled(false);
        btnAdicionarCadastraFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarCadastraFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdicionarCadastraFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bntEditarDadosFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeletarDadosFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
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
                    .addComponent(bntEditarDadosFuncionario)
                    .addComponent(btnDeletarDadosFuncionario)
                    .addComponent(btnAdicionarCadastraFuncionario))
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

    private void btnAdicionarCadastraFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarCadastraFuncionarioActionPerformed
        if(validarDadosFuncionario()){
            TelaCadastraConsultaPessoa.editarPessoa();
            DadosFuncionario dadosFuncionario = new DadosFuncionario();
            DadosFuncionarioDao dadosFuncionarioDao = new DadosFuncionarioDao();
            dadosFuncionario.setSalarioDfu(txtSalarioFuncionario.getText());
            dadosFuncionario.setIdSetorFkDfu(idSetor);
            dadosFuncionario.setIdFuncionarioFkDfu(idFuncionario);
            boolean retorno = dadosFuncionarioDao.adicionarDadosFuncionario(dadosFuncionario);
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
    }//GEN-LAST:event_btnAdicionarCadastraFuncionarioActionPerformed

    private void bntEditarDadosFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEditarDadosFuncionarioActionPerformed
        if(validarDadosFuncionario()){
            DadosFuncionario dadosFuncionario = new DadosFuncionario();
            DadosFuncionarioDao dadosFuncionarioDao = new DadosFuncionarioDao();
            dadosFuncionario.setSalarioDfu(txtSalarioFuncionario.getText());
            dadosFuncionario.setIdSetorFkDfu(idSetor);
            dadosFuncionario.setIdDfu(idDadosFuncionario);
            boolean retorno = dadosFuncionarioDao.editarDadosFuncionario(dadosFuncionario);
            if(retorno){
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Cadastra Dados Cliente", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }   
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Dados Cliente", JOptionPane.WARNING_MESSAGE);
        } 
    }//GEN-LAST:event_bntEditarDadosFuncionarioActionPerformed

    private void btnDeletarDadosFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarDadosFuncionarioActionPerformed
        if(ControladorDeUsabilidade.telaCadastraDadosFuncionarioDeletarCdu == 1){
             int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover os dados!", "Atençao", JOptionPane.YES_NO_OPTION);
             if (confirma == JOptionPane.YES_OPTION){               
                DadosFuncionarioDao dadosFuncionarioDao = new DadosFuncionarioDao();
                boolean retorno = dadosFuncionarioDao.deletarDadosFuncionario(idDadosFuncionario);
                if(retorno){
                    JOptionPane.showMessageDialog(null, "Dados apagados com sucesso!", "Cadastra Dados Cliente", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    TelaCadastraConsultaPessoa.habilitaRadioReferenciaTipoPessoa();
                }         
             }  
        }else{
            ControladorDeUsabilidade.acessoNegado();
        }
    }//GEN-LAST:event_btnDeletarDadosFuncionarioActionPerformed

    private void tblSetorDadosFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSetorDadosFuncionarioMouseClicked
       setarCamposSetorDadosFuncionario();
    }//GEN-LAST:event_tblSetorDadosFuncionarioMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bntEditarDadosFuncionario;
    public static javax.swing.JButton btnAdicionarCadastraFuncionario;
    public static javax.swing.JButton btnDeletarDadosFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCargoFuncionario;
    private javax.swing.JLabel lblSalarioFuncionario;
    private javax.swing.JTable tblSetorDadosFuncionario;
    public static javax.swing.JTextField txrSetorCadastraDadosFuncionario;
    public static br.com.sistemaos.util.JMoneyField txtSalarioFuncionario;
    // End of variables declaration//GEN-END:variables
}
