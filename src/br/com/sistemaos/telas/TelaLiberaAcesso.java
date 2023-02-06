
package br.com.sistemaos.telas;

import br.com.sistemaos.modelo.ControladorDeUsabilidade;
import br.com.sistemaos.util.PosicaoFormulario;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;


public class TelaLiberaAcesso extends javax.swing.JInternalFrame {

    public int valorTela;
    
    public TelaLiberaAcesso() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSenhaLiberaAcesso = new javax.swing.JPasswordField();
        btnSenhaLiberaAcesso = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Libera Acesso - Sistema Os");

        jLabel1.setText("Senha");

        btnSenhaLiberaAcesso.setText("Acessar");
        btnSenhaLiberaAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSenhaLiberaAcessoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSenhaLiberaAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(161, 161, 161)
                            .addComponent(btnSenhaLiberaAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel1))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenhaLiberaAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSenhaLiberaAcesso)
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

    private void btnSenhaLiberaAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSenhaLiberaAcessoActionPerformed
        String senha = new String(txtSenhaLiberaAcesso.getPassword());
        try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));

                StringBuilder sb = new StringBuilder();

                for(byte b: messageDigest){
                     sb.append(String.format("%02X", 0xFF & b));  
                }

                String senhaHex = sb.toString();
                if(senhaHex.equals(ControladorDeUsabilidade.senhaUsuarioCdu)){
                    
                    PosicaoFormulario form = new PosicaoFormulario();   
                    switch(valorTela){
                        
                        case 1:
                            TelaCadastraAcesso telaCadastraAcesso = new TelaCadastraAcesso();
                            form.abrirFormulario(telaCadastraAcesso, TelaPrincipal.desktop);
                            break;
                        
                        default:
                            TelaCadastraUsabilidade telaCadastraUsabilidade = new TelaCadastraUsabilidade();
                            form.abrirFormulario(telaCadastraUsabilidade, TelaPrincipal.desktop);
                    }
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Senha inválida!", "Principal", JOptionPane.INFORMATION_MESSAGE);
                    txtSenhaLiberaAcesso.setText(null);
                    txtSenhaLiberaAcesso.requestFocus();
                } 
            }catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
                JOptionPane.showMessageDialog(null,  ex);
            }  
    }//GEN-LAST:event_btnSenhaLiberaAcessoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSenhaLiberaAcesso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtSenhaLiberaAcesso;
    // End of variables declaration//GEN-END:variables
}
