
package br.com.sistemaos.telas;

import br.com.sistemaos.dao.ControladorDeAcessoDao;
import br.com.sistemaos.dao.ControladorDeUsabilidadeDao;
import br.com.sistemaos.modelo.ControladorDeAcesso;
import java.awt.Color;
import java.util.Arrays;
import javax.swing.JOptionPane;


public class TelaTrocarUsuario extends javax.swing.JInternalFrame {

    
    public TelaTrocarUsuario() {
        initComponents();
    }
    
    public boolean validarDadosLogin(){
        boolean retorno = true;
        if(txtLoginTrocar.getText().isEmpty()){
            retorno = false;
        }
        if(Arrays.toString(txtSenhaTrocar.getPassword()).isEmpty()){
            retorno = false;
        }
        return retorno;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblUsuarioTrocar = new javax.swing.JLabel();
        txtLoginTrocar = new javax.swing.JTextField();
        lblSenhaTrocar = new javax.swing.JLabel();
        txtSenhaTrocar = new javax.swing.JPasswordField();
        btnLoginTrocar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Trocar Usuario - Sistema Os");

        lblUsuarioTrocar.setText("Login");

        lblSenhaTrocar.setText("Senha");

        btnLoginTrocar.setText("Login");
        btnLoginTrocar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginTrocarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLoginTrocar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblSenhaTrocar)
                        .addComponent(lblUsuarioTrocar)
                        .addComponent(txtLoginTrocar, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                        .addComponent(txtSenhaTrocar)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuarioTrocar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLoginTrocar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSenhaTrocar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenhaTrocar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLoginTrocar)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setBounds(0, 0, 345, 199);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginTrocarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginTrocarActionPerformed
       // chamando o método logar
        if(validarDadosLogin()){
            ControladorDeAcessoDao controladorDeAcessoDao = new ControladorDeAcessoDao();
            String captura = new String(txtSenhaTrocar.getPassword());
            for (ControladorDeAcesso controladorDeAcesso : controladorDeAcessoDao.logar(txtLoginTrocar.getText(), captura)) {
               
                Long idPessoa = controladorDeAcesso.getIdPessoaFkCda();
                String nomePessoa = controladorDeAcesso.getNomePessoaFkCda();
                if(idPessoa != null){
                ControladorDeUsabilidadeDao controladorDeUsabilidadeDao = new ControladorDeUsabilidadeDao();
                controladorDeUsabilidadeDao.setarConfiguracao(idPessoa);
                TelaPrincipal.lblUsuario.setText(nomePessoa); 
                TelaPrincipal.lblUsuario.setForeground(Color.red); 
                dispose(); 
                }else{
                     JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválido", "Trocar Usuário", JOptionPane.INFORMATION_MESSAGE);
                }          
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor informar login e senha!", "Trocar Usuário", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnLoginTrocarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginTrocar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblSenhaTrocar;
    private javax.swing.JLabel lblUsuarioTrocar;
    public static javax.swing.JTextField txtLoginTrocar;
    public static javax.swing.JPasswordField txtSenhaTrocar;
    // End of variables declaration//GEN-END:variables
}
