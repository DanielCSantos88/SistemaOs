
package br.com.sistemaos.telas;

import br.com.sistemaos.dal.ModuloConexao;
import br.com.sistemaos.modelo.ControladorDeUsabilidade;
import br.com.sistemaos.util.PosicaoFormulario;import br.com.sistemaos.util.TipoServico;
import br.com.sistemaos.util.ValorTela;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.*;

public class TelaPrincipal extends javax.swing.JFrame {
    
    Connection conexao = null;
    
    public TelaPrincipal() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        desktop = new javax.swing.JDesktopPane();
        lblUsuario = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menCad = new javax.swing.JMenu();
        menCadOs = new javax.swing.JMenuItem();
        menCadPessoa = new javax.swing.JMenuItem();
        menCadFuncionario = new javax.swing.JMenu();
        menCadFuncionarioAcesso = new javax.swing.JMenuItem();
        menCadFuncionarioUsabilidade = new javax.swing.JMenuItem();
        menCadSetor = new javax.swing.JMenuItem();
        menAju = new javax.swing.JMenu();
        menAjuSob = new javax.swing.JMenuItem();
        menOpc = new javax.swing.JMenu();
        menOpcTro = new javax.swing.JMenuItem();
        menOpcSai = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema OS - Principal");
        setExtendedState(6);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuario.setText("Usuário");

        lblData.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblData.setText("Data");

        menCad.setText("Cadastros");

        menCadOs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        menCadOs.setText("Os");
        menCadOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadOsActionPerformed(evt);
            }
        });
        menCad.add(menCadOs);

        menCadPessoa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        menCadPessoa.setText("Pessoas");
        menCadPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadPessoaActionPerformed(evt);
            }
        });
        menCad.add(menCadPessoa);

        menCadFuncionario.setText("Funcionarios");

        menCadFuncionarioAcesso.setText("Definir Acesso");
        menCadFuncionarioAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadFuncionarioAcessoActionPerformed(evt);
            }
        });
        menCadFuncionario.add(menCadFuncionarioAcesso);

        menCadFuncionarioUsabilidade.setText("Definir Usabilidade");
        menCadFuncionarioUsabilidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadFuncionarioUsabilidadeActionPerformed(evt);
            }
        });
        menCadFuncionario.add(menCadFuncionarioUsabilidade);

        menCad.add(menCadFuncionario);

        menCadSetor.setText("Setores");
        menCadSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadSetorActionPerformed(evt);
            }
        });
        menCad.add(menCadSetor);

        menu.add(menCad);

        menAju.setText("Ajuda");

        menAjuSob.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_MASK));
        menAjuSob.setText("Sobre");
        menAjuSob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menAjuSobActionPerformed(evt);
            }
        });
        menAju.add(menAjuSob);

        menu.add(menAju);

        menOpc.setText("Opções");

        menOpcTro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        menOpcTro.setText("Trocar Usuário");
        menOpcTro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOpcTroActionPerformed(evt);
            }
        });
        menOpc.add(menOpcTro);

        menOpcSai.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.ALT_MASK));
        menOpcSai.setText("Sair");
        menOpcSai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOpcSaiActionPerformed(evt);
            }
        });
        menOpc.add(menOpcSai);

        menu.add(menOpc);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktop)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(949, Short.MAX_VALUE)
                .addComponent(lblUsuario)
                .addGap(113, 113, 113)
                .addComponent(lblData)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(lblData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktop)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1222, 771));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menAjuSobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menAjuSobActionPerformed
        TelaSobre telaSobre = new TelaSobre();
        PosicaoFormulario form = new PosicaoFormulario();
        form.abrirFormulario(telaSobre, desktop);
    }//GEN-LAST:event_menAjuSobActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        lblData.setText(formatador.format(data));
    }//GEN-LAST:event_formWindowActivated

    private void menOpcTroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOpcTroActionPerformed
        TelaTrocarUsuario telaTrocarUsuario = new TelaTrocarUsuario();
        PosicaoFormulario form = new PosicaoFormulario();
        form.abrirFormulario(telaTrocarUsuario, desktop);
    }//GEN-LAST:event_menOpcTroActionPerformed

    private void menOpcSaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOpcSaiActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja saír?", "Principal", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        } 
    }//GEN-LAST:event_menOpcSaiActionPerformed

    private void menCadOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadOsActionPerformed
        if(ControladorDeUsabilidade.telaPrincipalCadastraOsCdu == 1){
            TelaOs telaOs = new TelaOs();
            PosicaoFormulario form = new PosicaoFormulario();
            form.abrirFormulario(telaOs, desktop);
            TelaOs.rbtOrcamentoOs.setSelected(true);
            TelaOs.tipoServicoOs = TipoServico.ORCAMENTO.getValor();
        }else{
            ControladorDeUsabilidade.acessoNegado();
        }    
    }//GEN-LAST:event_menCadOsActionPerformed

    private void menCadPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadPessoaActionPerformed
       if(ControladorDeUsabilidade.telaPrincipalCadastraConsultaPessoaCdu == 1){
           TelaCadastraConsultaPessoa telaConsultaPessoa = new TelaCadastraConsultaPessoa();
           PosicaoFormulario form = new PosicaoFormulario();
           form.abrirFormulario(telaConsultaPessoa, TelaPrincipal.desktop);
           TelaCadastraConsultaPessoa.rbtClienteConsultaPessoa.setSelected(true);
       }else{
            ControladorDeUsabilidade.acessoNegado();
        }      
    }//GEN-LAST:event_menCadPessoaActionPerformed

    private void menCadFuncionarioAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadFuncionarioAcessoActionPerformed
        if(ControladorDeUsabilidade.telaPrincipalCadastraAcessoCdu == 1){
            TelaLiberaAcesso telaLiberaAcesso = new TelaLiberaAcesso();
            PosicaoFormulario form = new PosicaoFormulario();
            form.abrirFormulario(telaLiberaAcesso, desktop);
            telaLiberaAcesso.valorTela = ValorTela.TELA_CADASTRA_ACESSO.getValor();
        }else{
            ControladorDeUsabilidade.acessoNegado();
        }   
    }//GEN-LAST:event_menCadFuncionarioAcessoActionPerformed

    private void menCadSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadSetorActionPerformed
        if(ControladorDeUsabilidade.telaPrincipalCadastraSetorCdu == 1){
            TelaCadastraSetor telaCadastraSetor = new TelaCadastraSetor();
            PosicaoFormulario form = new PosicaoFormulario();
            form.abrirFormulario(telaCadastraSetor, desktop);
            telaCadastraSetor.buscarSetorTbl();
        }else{
            ControladorDeUsabilidade.acessoNegado();
        }  
    }//GEN-LAST:event_menCadSetorActionPerformed

    private void menCadFuncionarioUsabilidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadFuncionarioUsabilidadeActionPerformed
        if(ControladorDeUsabilidade.telaPrincipalCadastraUsabilidadeCdu == 1){
            TelaLiberaAcesso telaLiberaAcesso = new TelaLiberaAcesso();
            PosicaoFormulario form = new PosicaoFormulario();
            form.abrirFormulario(telaLiberaAcesso, desktop);
            telaLiberaAcesso.valorTela = ValorTela.TELA_CADASTRA_USABILIDADE.getValor();
        }else{
            ControladorDeUsabilidade.acessoNegado();
        } 
    }//GEN-LAST:event_menCadFuncionarioUsabilidadeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lblData;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu menAju;
    private javax.swing.JMenuItem menAjuSob;
    private javax.swing.JMenu menCad;
    public static javax.swing.JMenu menCadFuncionario;
    public static javax.swing.JMenuItem menCadFuncionarioAcesso;
    public static javax.swing.JMenuItem menCadFuncionarioUsabilidade;
    public static javax.swing.JMenuItem menCadOs;
    public static javax.swing.JMenuItem menCadPessoa;
    public static javax.swing.JMenuItem menCadSetor;
    private javax.swing.JMenu menOpc;
    private javax.swing.JMenuItem menOpcSai;
    private javax.swing.JMenuItem menOpcTro;
    private javax.swing.JMenuBar menu;
    // End of variables declaration//GEN-END:variables
}
