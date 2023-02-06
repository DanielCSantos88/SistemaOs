
package br.com.sistemaos.telas;

import Jm.JMascara;
import br.com.sistemaos.dao.ConfiguradorDeUsabilidadeDao;
import br.com.sistemaos.dao.ControladorDeAcessoDao;
import br.com.sistemaos.dao.PessoaDao;
import br.com.sistemaos.modelo.ConfiguradorDeUsabilidade;
import br.com.sistemaos.modelo.ControladorDeUsabilidade;
import br.com.sistemaos.modelo.Pessoa;
import br.com.sistemaos.util.LimitaCaracteres;
import br.com.sistemaos.util.PosicaoFormulario;
import br.com.sistemaos.util.TipoPessoa;
import javax.swing.JOptionPane;

public class TelaCadastraUsabilidade extends javax.swing.JInternalFrame {
  
    public static Long idCadastraUsabilidade;
    public static Long idPessoa;
     
    public TelaCadastraUsabilidade() {
        initComponents();
        txtCpfTelaConfiguraAcesso.setDocument(new LimitaCaracteres(14, LimitaCaracteres.TipoEntrada.CARACTERES_LETRAS));
    }
    
    private void configuraTelaIniciarCadastraUsabilidade(){
        idCadastraUsabilidade = null;
        txtCpfTelaConfiguraAcesso.setText(null);
        txtIdPessoaTelaConfiguraAcesso.setText(null);
        txtNomeTelaConfiguraAcesso.setText(null);
        txtCpfTelaConfiguraAcesso.requestFocus();
        btnAdicionarConfigurador.setEnabled(false);
        btnEditarConfigurador.setEnabled(false);
        btnDeletarConfigurador.setEnabled(false);
        desabilitarCheckCadastraUsabilidade();
        desmarcarCheckCadastraUsabilidade();
     }
    
    private void habilitarCheckCadastraUsabilidade(){
        jcbTelaCadastraOs.setEnabled(true);
        jcbTelaCadastraPessoa.setEnabled(true);
        jcbTelaCadastraAcesso.setEnabled(true);
        jcbTelaCadastraUsabilidade.setEnabled(true);
        jcbTelaCadastraSetor.setEnabled(true);
        jcbTelaRelatorioOs.setEnabled(true);
        jcbTelaRelatorioPessoa.setEnabled(true);
        jcbDeletarOs.setEnabled(true);
        jcbTelaDadosCliente.setEnabled(true);
        jcbTelaDadosFornecedor.setEnabled(true);
        jcbTelaDadosFuncionario.setEnabled(true);
        jcbTelaCadastraTelefone.setEnabled(true);
        jcbTelaCadastraEmail.setEnabled(true);
        jcbTelaCadastraEndereco.setEnabled(true);
        jcbDeletarPessoa.setEnabled(true);
        jcbReferenciaCliente.setEnabled(true);
        jcbReferenciaFornecedor.setEnabled(true);
        jcbReferenciaFuncionario.setEnabled(true);
        jcbDeletarDadosCliente.setEnabled(true);
        jcbDeletarDadosFornecedor.setEnabled(true);
        jcbDeletarDadosFuncionario.setEnabled(true);
        jcbDeletarTelefone.setEnabled(true);
        jcbDeletarEmail.setEnabled(true);
        jcbDeletarEndereco.setEnabled(true);
        jcbDeletarAcesso.setEnabled(true);
    }
     
    private void desabilitarCheckCadastraUsabilidade(){
        jcbTelaCadastraOs.setEnabled(false);
        jcbTelaCadastraPessoa.setEnabled(false);
        jcbTelaCadastraAcesso.setEnabled(false);
        jcbTelaCadastraUsabilidade.setEnabled(false);
        jcbTelaCadastraSetor.setEnabled(false);
        jcbTelaRelatorioOs.setEnabled(false);
        jcbTelaRelatorioPessoa.setEnabled(false);
        jcbDeletarOs.setEnabled(false);
        jcbTelaDadosCliente.setEnabled(false);
        jcbTelaDadosFornecedor.setEnabled(false);
        jcbTelaDadosFuncionario.setEnabled(false);
        jcbTelaCadastraTelefone.setEnabled(false);
        jcbTelaCadastraEmail.setEnabled(false);
        jcbTelaCadastraEndereco.setEnabled(false);
        jcbDeletarPessoa.setEnabled(false);
        jcbReferenciaCliente.setEnabled(false);
        jcbReferenciaFornecedor.setEnabled(false);
        jcbReferenciaFuncionario.setEnabled(false);
        jcbDeletarDadosCliente.setEnabled(false);
        jcbDeletarDadosFornecedor.setEnabled(false);
        jcbDeletarDadosFuncionario.setEnabled(false);
        jcbDeletarTelefone.setEnabled(false);
        jcbDeletarEmail.setEnabled(false);
        jcbDeletarEndereco.setEnabled(false);
        jcbDeletarAcesso.setEnabled(false);
    }
    
    private void desmarcarCheckCadastraUsabilidade(){
        jcbTelaCadastraOs.setSelected(false);
        jcbTelaCadastraPessoa.setSelected(false);
        jcbTelaCadastraAcesso.setSelected(false);
        jcbTelaCadastraUsabilidade.setSelected(false);
        jcbTelaCadastraSetor.setSelected(false);
        jcbTelaRelatorioOs.setSelected(false);
        jcbTelaRelatorioPessoa.setSelected(false);
        jcbDeletarOs.setSelected(false);
        jcbTelaDadosCliente.setSelected(false);
        jcbTelaDadosFornecedor.setSelected(false);
        jcbTelaDadosFuncionario.setSelected(false);
        jcbTelaCadastraTelefone.setSelected(false);
        jcbTelaCadastraEmail.setSelected(false);
        jcbTelaCadastraEndereco.setSelected(false);
        jcbDeletarPessoa.setSelected(false);
        jcbReferenciaCliente.setSelected(false);
        jcbReferenciaFornecedor.setSelected(false);
        jcbReferenciaFuncionario.setSelected(false);
        jcbDeletarDadosCliente.setSelected(false);
        jcbDeletarDadosFornecedor.setSelected(false);
        jcbDeletarDadosFuncionario.setSelected(false);
        jcbDeletarTelefone.setSelected(false);
        jcbDeletarEmail.setSelected(false);
        jcbDeletarEndereco.setSelected(false);
        jcbDeletarAcesso.setSelected(false);
    }
    
    private void configuraBotoesEditarDeletarCadastraUsabilidade(){
        btnAdicionarConfigurador.setEnabled(false);
        btnEditarConfigurador.setEnabled(true);
        btnDeletarConfigurador.setEnabled(true);
    }
    
    private void configuraBotoesAdicionarCadastraUsabilidade(){
        btnAdicionarConfigurador.setEnabled(true);
        btnEditarConfigurador.setEnabled(false);
        btnDeletarConfigurador.setEnabled(false);
    }
    
    private void desmarcaDeletarDadosCliente(){
        if(!jcbTelaDadosCliente.isSelected()){
            jcbDeletarDadosCliente.setSelected(false);
        }
    }
    
    private void desmarcaDeletarDadosFornecedor(){
        if(!jcbTelaDadosFornecedor.isSelected()){
            jcbDeletarDadosFornecedor.setSelected(false);
        }
    }
    
    private void desmarcaDeletarDadosFuncionario(){
        if(!jcbTelaDadosFuncionario.isSelected()){
            jcbDeletarDadosFuncionario.setSelected(false);
        }
    }
    
    private void desmarcaDeletarTelefone(){
        if(!jcbTelaCadastraTelefone.isSelected()){
            jcbDeletarTelefone.setSelected(false);
        }
    }
    
    private void desmarcaDeletarEmail(){
        if(!jcbTelaCadastraEmail.isSelected()){
            jcbDeletarEmail.setSelected(false);
        }
    }
    
     private void desmarcaDeletarEndereco(){
        if(!jcbTelaCadastraEndereco.isSelected()){
            jcbDeletarEndereco.setSelected(false);
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtCpfTelaConfiguraAcesso = new javax.swing.JTextField();
        btnBuscarTelaCadastraAcesso = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtIdPessoaTelaConfiguraAcesso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNomeTelaConfiguraAcesso = new javax.swing.JTextField();
        btnAdicionarConfigurador = new javax.swing.JButton();
        btnEditarConfigurador = new javax.swing.JButton();
        btnDeletarConfigurador = new javax.swing.JButton();
        btnCancelarConfigurador = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jcbTelaCadastraPessoa = new javax.swing.JCheckBox();
        jcbReferenciaCliente = new javax.swing.JCheckBox();
        jcbReferenciaFornecedor = new javax.swing.JCheckBox();
        jcbReferenciaFuncionario = new javax.swing.JCheckBox();
        jcbDeletarPessoa = new javax.swing.JCheckBox();
        jcbTelaDadosCliente = new javax.swing.JCheckBox();
        jcbDeletarDadosCliente = new javax.swing.JCheckBox();
        jcbTelaDadosFornecedor = new javax.swing.JCheckBox();
        jcbDeletarDadosFornecedor = new javax.swing.JCheckBox();
        jcbTelaDadosFuncionario = new javax.swing.JCheckBox();
        jcbDeletarDadosFuncionario = new javax.swing.JCheckBox();
        jcbTelaCadastraTelefone = new javax.swing.JCheckBox();
        jcbDeletarTelefone = new javax.swing.JCheckBox();
        jcbTelaCadastraEmail = new javax.swing.JCheckBox();
        jcbDeletarEmail = new javax.swing.JCheckBox();
        jcbTelaCadastraEndereco = new javax.swing.JCheckBox();
        jcbDeletarEndereco = new javax.swing.JCheckBox();
        jcbTelaCadastraOs = new javax.swing.JCheckBox();
        jcbDeletarOs = new javax.swing.JCheckBox();
        jcbTelaCadastraAcesso = new javax.swing.JCheckBox();
        jcbDeletarAcesso = new javax.swing.JCheckBox();
        jcbTelaCadastraUsabilidade = new javax.swing.JCheckBox();
        jcbTelaCadastraSetor = new javax.swing.JCheckBox();
        jcbTelaRelatorioOs = new javax.swing.JCheckBox();
        jcbTelaRelatorioPessoa = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Tela Cadastra Usabilidade - Sistema Os");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Configurar Usabilidade"));
        jPanel2.setToolTipText("");

        jLabel6.setText("CPF");

        txtCpfTelaConfiguraAcesso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCpfTelaConfiguraAcessoKeyPressed(evt);
            }
        });

        btnBuscarTelaCadastraAcesso.setText("Buscar");
        btnBuscarTelaCadastraAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTelaCadastraAcessoActionPerformed(evt);
            }
        });

        jLabel2.setText("Id");

        txtIdPessoaTelaConfiguraAcesso.setEditable(false);

        jLabel3.setText("Nome");

        txtNomeTelaConfiguraAcesso.setEditable(false);

        btnAdicionarConfigurador.setText("Adicionar");
        btnAdicionarConfigurador.setEnabled(false);
        btnAdicionarConfigurador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarConfiguradorActionPerformed(evt);
            }
        });

        btnEditarConfigurador.setText("Editar");
        btnEditarConfigurador.setEnabled(false);
        btnEditarConfigurador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarConfiguradorActionPerformed(evt);
            }
        });

        btnDeletarConfigurador.setText("Deletar");
        btnDeletarConfigurador.setEnabled(false);
        btnDeletarConfigurador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarConfiguradorActionPerformed(evt);
            }
        });

        btnCancelarConfigurador.setText("Cancelar");
        btnCancelarConfigurador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarConfiguradorActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 640));

        jcbTelaCadastraPessoa.setBackground(new java.awt.Color(255, 255, 255));
        jcbTelaCadastraPessoa.setText("Tela Cadastra Pessoa");
        jcbTelaCadastraPessoa.setEnabled(false);
        jcbTelaCadastraPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTelaCadastraPessoaActionPerformed(evt);
            }
        });

        jcbReferenciaCliente.setBackground(new java.awt.Color(255, 255, 255));
        jcbReferenciaCliente.setText("Cadastrar Cliente");
        jcbReferenciaCliente.setEnabled(false);

        jcbReferenciaFornecedor.setBackground(new java.awt.Color(255, 255, 255));
        jcbReferenciaFornecedor.setText("Cadastrar Fornecedor");
        jcbReferenciaFornecedor.setEnabled(false);

        jcbReferenciaFuncionario.setBackground(new java.awt.Color(255, 255, 255));
        jcbReferenciaFuncionario.setText("Cadastrar Funcionário");
        jcbReferenciaFuncionario.setEnabled(false);

        jcbDeletarPessoa.setBackground(new java.awt.Color(255, 255, 255));
        jcbDeletarPessoa.setText("Deletar Pessoa");
        jcbDeletarPessoa.setEnabled(false);

        jcbTelaDadosCliente.setBackground(new java.awt.Color(255, 255, 255));
        jcbTelaDadosCliente.setText("Tela Dados Cliente");
        jcbTelaDadosCliente.setEnabled(false);
        jcbTelaDadosCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTelaDadosClienteActionPerformed(evt);
            }
        });

        jcbDeletarDadosCliente.setBackground(new java.awt.Color(255, 255, 255));
        jcbDeletarDadosCliente.setText("Deletar Dados Cliente");
        jcbDeletarDadosCliente.setEnabled(false);

        jcbTelaDadosFornecedor.setBackground(new java.awt.Color(255, 255, 255));
        jcbTelaDadosFornecedor.setText("Tela Dados Fornecedor");
        jcbTelaDadosFornecedor.setEnabled(false);
        jcbTelaDadosFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTelaDadosFornecedorActionPerformed(evt);
            }
        });

        jcbDeletarDadosFornecedor.setBackground(new java.awt.Color(255, 255, 255));
        jcbDeletarDadosFornecedor.setText("Deletar Dados Fornecedor");
        jcbDeletarDadosFornecedor.setEnabled(false);

        jcbTelaDadosFuncionario.setBackground(new java.awt.Color(255, 255, 255));
        jcbTelaDadosFuncionario.setText("Tela Dados Funcionario");
        jcbTelaDadosFuncionario.setEnabled(false);
        jcbTelaDadosFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTelaDadosFuncionarioActionPerformed(evt);
            }
        });

        jcbDeletarDadosFuncionario.setBackground(new java.awt.Color(255, 255, 255));
        jcbDeletarDadosFuncionario.setText("Deletar Dados Funcionário");
        jcbDeletarDadosFuncionario.setEnabled(false);

        jcbTelaCadastraTelefone.setBackground(new java.awt.Color(255, 255, 255));
        jcbTelaCadastraTelefone.setText("Tela Cadastra Telefone");
        jcbTelaCadastraTelefone.setEnabled(false);
        jcbTelaCadastraTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTelaCadastraTelefoneActionPerformed(evt);
            }
        });

        jcbDeletarTelefone.setBackground(new java.awt.Color(255, 255, 255));
        jcbDeletarTelefone.setText("Deletar Telefone");
        jcbDeletarTelefone.setEnabled(false);

        jcbTelaCadastraEmail.setBackground(new java.awt.Color(255, 255, 255));
        jcbTelaCadastraEmail.setText("Tela Cadastra Email");
        jcbTelaCadastraEmail.setEnabled(false);
        jcbTelaCadastraEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTelaCadastraEmailActionPerformed(evt);
            }
        });

        jcbDeletarEmail.setBackground(new java.awt.Color(255, 255, 255));
        jcbDeletarEmail.setText("Deletar Email");
        jcbDeletarEmail.setEnabled(false);

        jcbTelaCadastraEndereco.setBackground(new java.awt.Color(255, 255, 255));
        jcbTelaCadastraEndereco.setText("Tela Cadastra Endereço");
        jcbTelaCadastraEndereco.setEnabled(false);
        jcbTelaCadastraEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTelaCadastraEnderecoActionPerformed(evt);
            }
        });

        jcbDeletarEndereco.setBackground(new java.awt.Color(255, 255, 255));
        jcbDeletarEndereco.setText("Deletar Endereço");
        jcbDeletarEndereco.setEnabled(false);

        jcbTelaCadastraOs.setBackground(new java.awt.Color(255, 255, 255));
        jcbTelaCadastraOs.setText("Tela CadastraOs");
        jcbTelaCadastraOs.setEnabled(false);
        jcbTelaCadastraOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTelaCadastraOsActionPerformed(evt);
            }
        });

        jcbDeletarOs.setBackground(new java.awt.Color(255, 255, 255));
        jcbDeletarOs.setText("Deletar Os");
        jcbDeletarOs.setEnabled(false);

        jcbTelaCadastraAcesso.setBackground(new java.awt.Color(255, 255, 255));
        jcbTelaCadastraAcesso.setText("Tela Cadastra Acesso");
        jcbTelaCadastraAcesso.setEnabled(false);
        jcbTelaCadastraAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTelaCadastraAcessoActionPerformed(evt);
            }
        });

        jcbDeletarAcesso.setBackground(new java.awt.Color(255, 255, 255));
        jcbDeletarAcesso.setText("Deletar Acesso");
        jcbDeletarAcesso.setEnabled(false);

        jcbTelaCadastraUsabilidade.setBackground(new java.awt.Color(255, 255, 255));
        jcbTelaCadastraUsabilidade.setText("Tela Cadastra Usabilidade");
        jcbTelaCadastraUsabilidade.setEnabled(false);

        jcbTelaCadastraSetor.setBackground(new java.awt.Color(255, 255, 255));
        jcbTelaCadastraSetor.setText("Tela Cadastra Setor");
        jcbTelaCadastraSetor.setEnabled(false);

        jcbTelaRelatorioOs.setBackground(new java.awt.Color(255, 255, 255));
        jcbTelaRelatorioOs.setText("Tela Relatorio Os");
        jcbTelaRelatorioOs.setEnabled(false);

        jcbTelaRelatorioPessoa.setBackground(new java.awt.Color(255, 255, 255));
        jcbTelaRelatorioPessoa.setText("Tela Relatório Pessoa");
        jcbTelaRelatorioPessoa.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbTelaCadastraPessoa)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jcbReferenciaFornecedor))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jcbReferenciaCliente))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jcbReferenciaFuncionario))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jcbDeletarPessoa))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jcbTelaDadosCliente))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jcbTelaDadosFornecedor))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jcbTelaCadastraEndereco))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jcbTelaCadastraEmail))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jcbTelaDadosFuncionario))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jcbTelaCadastraTelefone))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbDeletarDadosCliente)
                                    .addComponent(jcbDeletarDadosFornecedor)
                                    .addComponent(jcbDeletarDadosFuncionario)
                                    .addComponent(jcbDeletarTelefone)
                                    .addComponent(jcbDeletarEmail)
                                    .addComponent(jcbDeletarEndereco)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbTelaCadastraAcesso)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jcbDeletarAcesso))
                                    .addComponent(jcbTelaCadastraUsabilidade)
                                    .addComponent(jcbTelaCadastraSetor)
                                    .addComponent(jcbTelaRelatorioOs)
                                    .addComponent(jcbTelaRelatorioPessoa))
                                .addGap(42, 42, 42)))
                        .addGap(0, 147, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jcbDeletarOs))
                            .addComponent(jcbTelaCadastraOs))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbTelaCadastraOs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbDeletarOs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbTelaCadastraPessoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbReferenciaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbReferenciaFornecedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbReferenciaFuncionario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbDeletarPessoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbTelaDadosCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbDeletarDadosCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbTelaDadosFornecedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbDeletarDadosFornecedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbTelaDadosFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbDeletarDadosFuncionario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbTelaCadastraTelefone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbDeletarTelefone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbTelaCadastraEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbDeletarEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbTelaCadastraEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbDeletarEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbTelaCadastraAcesso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbDeletarAcesso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbTelaCadastraUsabilidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbTelaCadastraSetor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbTelaRelatorioOs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbTelaRelatorioPessoa)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCpfTelaConfiguraAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarTelaCadastraAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAdicionarConfigurador, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditarConfigurador, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeletarConfigurador, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelarConfigurador, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdPessoaTelaConfiguraAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNomeTelaConfiguraAcesso))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpfTelaConfiguraAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarTelaCadastraAcesso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdPessoaTelaConfiguraAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeTelaConfiguraAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarConfigurador)
                    .addComponent(btnEditarConfigurador)
                    .addComponent(btnDeletarConfigurador)
                    .addComponent(btnCancelarConfigurador))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(444, 444, 444))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCpfTelaConfiguraAcessoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpfTelaConfiguraAcessoKeyPressed
        txtCpfTelaConfiguraAcesso.setText(JMascara.GetJmascaraCpfCnpj(txtCpfTelaConfiguraAcesso.getText()));
    }//GEN-LAST:event_txtCpfTelaConfiguraAcessoKeyPressed

    private void btnBuscarTelaCadastraAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTelaCadastraAcessoActionPerformed
        String cpfCnpj = JMascara.GetJmascaraLimpar(txtCpfTelaConfiguraAcesso.getText());
        if(cpfCnpj.length() != 11){
            JOptionPane.showMessageDialog(null, "Favor inserir CPF valido!","Cadasro de Usabilidade", JOptionPane.WARNING_MESSAGE);
        }else{
            if(cpfCnpj.equals(ControladorDeUsabilidade.cpfCnpjUsuarioCdu)){
                JOptionPane.showMessageDialog(null, "Por motivo de sergurança, não é possivel alterar permissão a si mesmo!","Cadasro de Usabilidade", JOptionPane.WARNING_MESSAGE);
            }else{
               PessoaDao pessoaDao = new PessoaDao();
                idPessoa = null;
                String nome = null;
                for (Pessoa pessoa : pessoaDao.buscarDadosPessoa(cpfCnpj)) {
                    idPessoa = pessoa.getIdPes();
                    nome = pessoa.getNomePes();
                }
                if(idPessoa != null){
                    ControladorDeAcessoDao controladorDeAcessoDao = new ControladorDeAcessoDao();
                    boolean retornoAcesso = controladorDeAcessoDao.verificarCadastroAcesso(idPessoa);
                    if(!retornoAcesso){
                        int confirma = JOptionPane.showConfirmDialog(null, "Cadastro de Acesso não encontrado, Deseja Cadastrar!", "Cadasro de Usabilidade", JOptionPane.YES_NO_OPTION);
                        if (confirma == JOptionPane.YES_OPTION){
                            TelaCadastraAcesso telaCadastroAcesso = new TelaCadastraAcesso();
                            PosicaoFormulario form = new PosicaoFormulario();
                            form.abrirFormulario(telaCadastroAcesso, TelaPrincipal.desktop);
                            TelaCadastraAcesso.txtCpfTelaCadastraAcesso.setText(JMascara.GetJmascaraCpfCnpj(cpfCnpj));
                            TelaCadastraAcesso.txtIdPessoaCadastraAcesso.setText(idPessoa.toString());
                            TelaCadastraAcesso.txtNomeTelaCadastraAcesso.setText(nome);
                            TelaCadastraAcesso.txtLoginTelaCadastraAcesso.requestFocus();
                            TelaCadastraAcesso.btnAdicionarTelaCadastraAcesso.setEnabled(true);
                            dispose();
                        }else{
                            configuraTelaIniciarCadastraUsabilidade();
                        }
                    }else{
                        ConfiguradorDeUsabilidadeDao configuradorDeUsabilidadeDao = new ConfiguradorDeUsabilidadeDao();
                        boolean retornoUsabilidade = configuradorDeUsabilidadeDao.buscarConfiguracao(idPessoa);
                        if(retornoUsabilidade){                     
                            configuraBotoesEditarDeletarCadastraUsabilidade();
                        }else{
                            configuraBotoesAdicionarCadastraUsabilidade();
                        }
                        txtIdPessoaTelaConfiguraAcesso.setText(idPessoa.toString());
                        txtNomeTelaConfiguraAcesso.setText(nome);
                        habilitarCheckCadastraUsabilidade();
                    }
                }else{
                    int confirma = JOptionPane.showConfirmDialog(null, "Pessoa não encontrada, Deseja Cadastrar!", "Cadasro de Usabilidade", JOptionPane.YES_NO_OPTION);
                    if (confirma == JOptionPane.YES_OPTION){
                        TelaCadastraConsultaPessoa telaConsultaPessoa = new TelaCadastraConsultaPessoa();
                        PosicaoFormulario form = new PosicaoFormulario();
                        form.abrirFormulario(telaConsultaPessoa, TelaPrincipal.desktop);
                        TelaCadastraConsultaPessoa.rbtFuncionarioConsultaPessoa.setSelected(true);
                        TelaCadastraConsultaPessoa.tipoPessoaTelaConsultaPessoa = TipoPessoa.FUNCIONARIO.getValor();
                        TelaCadastraConsultaPessoa.txtCpfCnpjTelaConsultaPessoa.setText(JMascara.GetJmascaraCpfCnpj(cpfCnpj));
                        TelaCadastraConsultaPessoa.configuraAdicionar();
                        TelaCadastraConsultaPessoa.desabilitaRadioReferenciaTipoPessoa();
                        dispose();
                    }
                } 
            }   
        }
    }//GEN-LAST:event_btnBuscarTelaCadastraAcessoActionPerformed

    private void btnAdicionarConfiguradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarConfiguradorActionPerformed
        ConfiguradorDeUsabilidadeDao configuradorDeUsabilidadeDao = new ConfiguradorDeUsabilidadeDao();
        ConfiguradorDeUsabilidade configuradorDeUsabilidade = new ConfiguradorDeUsabilidade();
        configuradorDeUsabilidade.setTelaPrincipalCadastraOsCdu((jcbTelaCadastraOs.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaPrincipalCadastraConsultaPessoaCdu((jcbTelaCadastraPessoa.isSelected() ? 1 : 0));      
        configuradorDeUsabilidade.setTelaPrincipalCadastraAcessoCdu((jcbTelaCadastraAcesso.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaPrincipalCadastraUsabilidadeCdu((jcbTelaCadastraUsabilidade.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaPrincipalCadastraSetorCdu((jcbTelaCadastraSetor.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaPrincipalRelatorioOsCdu((jcbTelaRelatorioOs.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaPrincipalRelatorioPessoaCdu((jcbTelaRelatorioPessoa.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaOsDeletarCdu((jcbDeletarOs.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraConsultaPessoaDadosClienteCdu((jcbTelaDadosCliente.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraConsultaPessoaDadosFornecedorCdu((jcbTelaDadosFornecedor.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraConsultaPessoaDadosFuncionarioCdu((jcbTelaDadosFuncionario.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraConsultaPessoaDeletarCdu((jcbDeletarPessoa.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraConsultaPessoaCadastraTelefoneCdu((jcbTelaCadastraTelefone.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraConsultaPessoaCadastraEmailCdu((jcbTelaCadastraEmail.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraConsultaPessoaCadastraEnderecoCdu((jcbTelaCadastraEndereco.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraConsultaPessoaReferenciaClienteCdu((jcbReferenciaCliente.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraConsultaPessoaReferenciaFornecedorCdu((jcbReferenciaFornecedor.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraConsultaPessoaReferenciaFuncionarioCdu((jcbReferenciaFuncionario.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraDadosClienteDeletarCdu((jcbDeletarDadosCliente.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraDadosFornecedorDeletarCdu((jcbDeletarDadosFornecedor.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraDadosFuncionarioDeletarCdu((jcbDeletarDadosFuncionario.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraTelefoneDeletarCdu((jcbDeletarTelefone.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraEmailDeletarCdu((jcbDeletarEmail.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraEnderecoDeletarCdu((jcbDeletarEndereco.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraAcessoDeletarCdu((jcbDeletarAcesso.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setIdPessoaFkCdu(Long.parseLong(txtIdPessoaTelaConfiguraAcesso.getText()));
        boolean retorno = configuradorDeUsabilidadeDao.adicionarUsabilidade(configuradorDeUsabilidade);
        if(retorno){
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!", "Cadastra Usabilidade", JOptionPane.INFORMATION_MESSAGE);
            configuradorDeUsabilidadeDao.buscarConfiguracao(idPessoa);
            configuraBotoesEditarDeletarCadastraUsabilidade();
        }
        
    }//GEN-LAST:event_btnAdicionarConfiguradorActionPerformed

    private void btnEditarConfiguradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarConfiguradorActionPerformed
        ConfiguradorDeUsabilidadeDao configuradorDeUsabilidadeDao = new ConfiguradorDeUsabilidadeDao();
        ConfiguradorDeUsabilidade configuradorDeUsabilidade = new ConfiguradorDeUsabilidade();
        configuradorDeUsabilidade.setTelaPrincipalCadastraOsCdu((jcbTelaCadastraOs.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaPrincipalCadastraConsultaPessoaCdu((jcbTelaCadastraPessoa.isSelected() ? 1 : 0));      
        configuradorDeUsabilidade.setTelaPrincipalCadastraAcessoCdu((jcbTelaCadastraAcesso.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaPrincipalCadastraUsabilidadeCdu((jcbTelaCadastraUsabilidade.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaPrincipalCadastraSetorCdu((jcbTelaCadastraSetor.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaPrincipalRelatorioOsCdu((jcbTelaRelatorioOs.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaPrincipalRelatorioPessoaCdu((jcbTelaRelatorioPessoa.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaOsDeletarCdu((jcbDeletarOs.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraConsultaPessoaDadosClienteCdu((jcbTelaDadosCliente.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraConsultaPessoaDadosFornecedorCdu((jcbTelaDadosFornecedor.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraConsultaPessoaDadosFuncionarioCdu((jcbTelaDadosFuncionario.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraConsultaPessoaDeletarCdu((jcbDeletarPessoa.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraConsultaPessoaCadastraTelefoneCdu((jcbTelaCadastraTelefone.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraConsultaPessoaCadastraEmailCdu((jcbTelaCadastraEmail.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraConsultaPessoaCadastraEnderecoCdu((jcbTelaCadastraEndereco.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraConsultaPessoaReferenciaClienteCdu((jcbReferenciaCliente.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraConsultaPessoaReferenciaFornecedorCdu((jcbReferenciaFornecedor.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraConsultaPessoaReferenciaFuncionarioCdu((jcbReferenciaFuncionario.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraDadosClienteDeletarCdu((jcbDeletarDadosCliente.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraDadosFornecedorDeletarCdu((jcbDeletarDadosFornecedor.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraDadosFuncionarioDeletarCdu((jcbDeletarDadosFuncionario.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraTelefoneDeletarCdu((jcbDeletarTelefone.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraEmailDeletarCdu((jcbDeletarEmail.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraEnderecoDeletarCdu((jcbDeletarEndereco.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setTelaCadastraAcessoDeletarCdu((jcbDeletarAcesso.isSelected() ? 1 : 0));
        configuradorDeUsabilidade.setIdPessoaFkCdu(Long.parseLong(txtIdPessoaTelaConfiguraAcesso.getText()));
        configuradorDeUsabilidade.setIdCdu(idCadastraUsabilidade);
        boolean retorno = configuradorDeUsabilidadeDao.editarUsabilidade(configuradorDeUsabilidade);
        if(retorno){
            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Cadastra Usabilidade", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarConfiguradorActionPerformed

    private void btnDeletarConfiguradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarConfiguradorActionPerformed
        ConfiguradorDeUsabilidadeDao configuradorDeUsabilidadeDao = new ConfiguradorDeUsabilidadeDao();
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esta configuração", "Cadastra Usabilidade", JOptionPane.YES_NO_OPTION);
        if(confirma == JOptionPane.YES_OPTION){
             boolean retorno = configuradorDeUsabilidadeDao.deletarUsabilidade(idPessoa);
            if(retorno){
                JOptionPane.showMessageDialog(null, "Dados apadados com sucesso!", "Cadastra Usabilidade", JOptionPane.INFORMATION_MESSAGE);
                configuraTelaIniciarCadastraUsabilidade();
            }
        }  
    }//GEN-LAST:event_btnDeletarConfiguradorActionPerformed

    private void btnCancelarConfiguradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarConfiguradorActionPerformed
        configuraTelaIniciarCadastraUsabilidade();
    }//GEN-LAST:event_btnCancelarConfiguradorActionPerformed

    private void jcbTelaCadastraOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTelaCadastraOsActionPerformed
        if(!jcbTelaCadastraOs.isSelected()){
            jcbDeletarOs.setSelected(false);
        }
    }//GEN-LAST:event_jcbTelaCadastraOsActionPerformed

    private void jcbTelaCadastraPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTelaCadastraPessoaActionPerformed
        if(!jcbTelaCadastraPessoa.isSelected()){
            jcbReferenciaCliente.setSelected(false);
            jcbReferenciaFornecedor.setSelected(false);
            jcbReferenciaFuncionario.setSelected(false);
            jcbDeletarPessoa.setSelected(false);
            jcbTelaDadosCliente.setSelected(false);
            desmarcaDeletarDadosCliente();
            jcbTelaDadosFornecedor.setSelected(false);
            desmarcaDeletarDadosFornecedor();
            jcbTelaDadosFuncionario.setSelected(false);
            desmarcaDeletarDadosFuncionario();
            jcbTelaCadastraTelefone.setSelected(false);
            desmarcaDeletarTelefone();
            jcbTelaCadastraEmail.setSelected(false);
            desmarcaDeletarEmail();
            jcbTelaCadastraEndereco.setSelected(false);
            desmarcaDeletarEndereco();
        }
    }//GEN-LAST:event_jcbTelaCadastraPessoaActionPerformed

    private void jcbTelaDadosClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTelaDadosClienteActionPerformed
        desmarcaDeletarDadosCliente();
    }//GEN-LAST:event_jcbTelaDadosClienteActionPerformed

    private void jcbTelaDadosFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTelaDadosFornecedorActionPerformed
        desmarcaDeletarDadosFornecedor();
    }//GEN-LAST:event_jcbTelaDadosFornecedorActionPerformed

    private void jcbTelaDadosFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTelaDadosFuncionarioActionPerformed
        desmarcaDeletarDadosFuncionario();
    }//GEN-LAST:event_jcbTelaDadosFuncionarioActionPerformed

    private void jcbTelaCadastraTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTelaCadastraTelefoneActionPerformed
        desmarcaDeletarTelefone();
    }//GEN-LAST:event_jcbTelaCadastraTelefoneActionPerformed

    private void jcbTelaCadastraEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTelaCadastraEmailActionPerformed
        desmarcaDeletarEmail();
    }//GEN-LAST:event_jcbTelaCadastraEmailActionPerformed

    private void jcbTelaCadastraEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTelaCadastraEnderecoActionPerformed
        desmarcaDeletarEndereco();
    }//GEN-LAST:event_jcbTelaCadastraEnderecoActionPerformed

    private void jcbTelaCadastraAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTelaCadastraAcessoActionPerformed
        if(!jcbTelaCadastraAcesso.isSelected()){
            jcbDeletarAcesso.setSelected(false);
        }
    }//GEN-LAST:event_jcbTelaCadastraAcessoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarConfigurador;
    private javax.swing.JButton btnBuscarTelaCadastraAcesso;
    private javax.swing.JButton btnCancelarConfigurador;
    private javax.swing.JButton btnDeletarConfigurador;
    private javax.swing.JButton btnEditarConfigurador;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JCheckBox jcbDeletarAcesso;
    public static javax.swing.JCheckBox jcbDeletarDadosCliente;
    public static javax.swing.JCheckBox jcbDeletarDadosFornecedor;
    public static javax.swing.JCheckBox jcbDeletarDadosFuncionario;
    public static javax.swing.JCheckBox jcbDeletarEmail;
    public static javax.swing.JCheckBox jcbDeletarEndereco;
    public static javax.swing.JCheckBox jcbDeletarOs;
    public static javax.swing.JCheckBox jcbDeletarPessoa;
    public static javax.swing.JCheckBox jcbDeletarTelefone;
    public static javax.swing.JCheckBox jcbReferenciaCliente;
    public static javax.swing.JCheckBox jcbReferenciaFornecedor;
    public static javax.swing.JCheckBox jcbReferenciaFuncionario;
    public static javax.swing.JCheckBox jcbTelaCadastraAcesso;
    public static javax.swing.JCheckBox jcbTelaCadastraEmail;
    public static javax.swing.JCheckBox jcbTelaCadastraEndereco;
    public static javax.swing.JCheckBox jcbTelaCadastraOs;
    public static javax.swing.JCheckBox jcbTelaCadastraPessoa;
    public static javax.swing.JCheckBox jcbTelaCadastraSetor;
    public static javax.swing.JCheckBox jcbTelaCadastraTelefone;
    public static javax.swing.JCheckBox jcbTelaCadastraUsabilidade;
    public static javax.swing.JCheckBox jcbTelaDadosCliente;
    public static javax.swing.JCheckBox jcbTelaDadosFornecedor;
    public static javax.swing.JCheckBox jcbTelaDadosFuncionario;
    public static javax.swing.JCheckBox jcbTelaRelatorioOs;
    public static javax.swing.JCheckBox jcbTelaRelatorioPessoa;
    private javax.swing.JTextField txtCpfTelaConfiguraAcesso;
    public static javax.swing.JTextField txtIdPessoaTelaConfiguraAcesso;
    public static javax.swing.JTextField txtNomeTelaConfiguraAcesso;
    // End of variables declaration//GEN-END:variables
}
