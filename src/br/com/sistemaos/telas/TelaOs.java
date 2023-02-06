
package br.com.sistemaos.telas;

import Jm.JMascara;
import br.com.sistemaos.dao.OsDao;
import br.com.sistemaos.dao.PessoaDao;
import br.com.sistemaos.dao.TelefoneDao;
import br.com.sistemaos.modelo.ControladorDeUsabilidade;
import br.com.sistemaos.modelo.Os;
import br.com.sistemaos.modelo.Pessoa;
import br.com.sistemaos.modelo.Telefone;
import br.com.sistemaos.util.LimitaCaracteres;
import br.com.sistemaos.util.PosicaoFormulario;
import br.com.sistemaos.util.TipoServico;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class TelaOs extends javax.swing.JInternalFrame {
    
    public static Long idMarcaOs;
    public static Long idProdutoOs;
    public static Long idDefeitoOs;
    public static Long idServicoOs;
    public static int tipoServicoOs;
    public static Long idFuncionarioOs; 
    public static Long idClienteOs;

    public TelaOs() {
        initComponents();
        txtIdOs.setDocument(new LimitaCaracteres(10, LimitaCaracteres.TipoEntrada.SOMENTE_NUMEROS));
    }
    
    public void buscarTelefoneTblOs(Long idPessoa){
        
        DefaultTableModel tel = (DefaultTableModel) tblTelefoneOs.getModel();
        tel.setNumRows(0); 

        TelefoneDao telefoneDao = new TelefoneDao();
       
        for(Telefone telefone: telefoneDao.buscarTelefoneTabelas(idPessoa)){

           
            tel.addRow(new Object[]{
           
                telefone.getTelefoneTel(),
            });
        }  
    }
    
  
    public void buscarHistoricoTblOs(Long id){
        
        DefaultTableModel his = (DefaultTableModel) tblHistoricoOs.getModel();
        his.setNumRows(0); 
  
        OsDao osDao = new OsDao();
        for(Os os: osDao.buscarHistoricoPessoaOs(id)){

        
            his.addRow(new Object[]{
              
                os.getIdOs(),
                os.getDataOs(),
                os.getNomeTipoOs(),
                os.getSituacaoOs(),
                os.getNomeMarcaOs(),
                os.getNomeProdutoOs(),
                os.getNomeDefeitoOs(),
                os.getNomeServicoOs(),
                os.getNomeFuncionarioOs(),
                os.getValorOs(),
   
            });  
        }  
    }
     
    private void limparCamposOs(){
        txtIdOs.setText(null);
        txtDataOs.setText(null);
        rbtOrcamentoOs.setSelected(true);
        cboSituacaoOs.setSelectedItem("NA BANCADA");
        txtNomeMarcaOs.setText(null);
        txtNomeProdutoOs.setText(null);
        txtNomeDefeitoOs.setText(null);
        txtNomeServicoOs.setText(null);
        txtNomeFuncionarioOs.setText(null);
        txtValorOs.setText("0,00");
    }
    
    private boolean validarDadosOs(){
        boolean retorno = true;
        
        if(txtNomeMarcaOs.getText().isEmpty()){
            retorno = false;
        }
        if(txtNomeProdutoOs.getText().isEmpty()){
            retorno = false;
        }
        if(txtNomeDefeitoOs.getText().isEmpty()){
            retorno = false;
        }
        if(txtNomeServicoOs.getText().isEmpty()){
            retorno = false;
        }
        if(txtNomeFuncionarioOs.getText().isEmpty()){
            retorno = false;
        }
        return retorno;
    }
    
    private void configuraTelaIniciarOs(){
        idClienteOs = null;
        idFuncionarioOs = null;
        idMarcaOs = null;
        idProdutoOs = null;
        idDefeitoOs = null;
        idServicoOs = null;
        tipoServicoOs = 1;
        txtIdOs.requestFocus();
        btnBuscarMarcaOs.setEnabled(false);
        btnBuscarProdutoOs.setEnabled(false);
        btnBuscarDefeitoOs.setEnabled(false);
        btnBuscarServicoOs.setEnabled(false);
        btnBuscarFuncionarioOs.setEnabled(false);
        btnLimparOs.setEnabled(false);
        btnAdicionarOs.setEnabled(false);
        desabilitaBotoesEditarDeletarImprimirCancelar();
        DefaultTableModel tel = (DefaultTableModel) tblTelefoneOs.getModel();
        tel.setNumRows(0);
        DefaultTableModel his = (DefaultTableModel) tblHistoricoOs.getModel();
        his.setNumRows(0); 
        limparCamposOs();
    }
    
    private void desabilitaBotoesEditarDeletarImprimirCancelar(){
        btnEditarOs.setEnabled(false);
        btnDeletarOs.setEnabled(false);
        btnCancelarOs.setEnabled(true);
    }
    
    private void habilitaBotoesBuscarPreencherCadastro(){
        btnBuscarMarcaOs.setEnabled(true);
        btnBuscarProdutoOs.setEnabled(true);
        btnBuscarServicoOs.setEnabled(true);
        btnBuscarDefeitoOs.setEnabled(true);
        btnBuscarFuncionarioOs.setEnabled(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jScrollBar1 = new javax.swing.JScrollBar();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblDefeitoOs = new javax.swing.JLabel();
        txtNomeDefeitoOs = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNomeServicoOs = new javax.swing.JTextField();
        lblValorOs = new javax.swing.JLabel();
        cboSituacaoOs = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        lblMarcaOs = new javax.swing.JLabel();
        txtNomeMarcaOs = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNomeFuncionarioOs = new javax.swing.JTextField();
        btnBuscarFuncionarioOs = new javax.swing.JButton();
        txtValorOs = new br.com.sistemaos.util.JMoneyField();
        btnBuscarMarcaOs = new javax.swing.JButton();
        txtNomeProdutoOs = new javax.swing.JTextField();
        btnBuscarProdutoOs = new javax.swing.JButton();
        lblProdutoOs = new javax.swing.JLabel();
        btnBuscarDefeitoOs = new javax.swing.JButton();
        btnBuscarServicoOs = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHistoricoOs = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnBuscarClienteOs = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTelefoneOs = new javax.swing.JTable();
        txtcpfCnpjClienteOs = new javax.swing.JTextField();
        txtNomeClienteOs = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblNumeroOs = new javax.swing.JLabel();
        txtIdOs = new javax.swing.JTextField();
        lblDataOs = new javax.swing.JLabel();
        txtDataOs = new javax.swing.JTextField();
        rbtOrdemDeServicoOs = new javax.swing.JRadioButton();
        rbtOrcamentoOs = new javax.swing.JRadioButton();
        btnBuscarCodigoOs = new javax.swing.JButton();
        btnAdicionarOs = new javax.swing.JButton();
        btnDeletarOs = new javax.swing.JButton();
        btnEditarOs = new javax.swing.JButton();
        btnLimparOs = new javax.swing.JButton();
        btnCancelarOs = new javax.swing.JButton();

        jScrollPane2.setViewportView(jEditorPane1);

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);
        setTitle("Sistema OS - Ordem de Seriço");
        setPreferredSize(new java.awt.Dimension(640, 480));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Os"));

        lblDefeitoOs.setText("*Defeito");

        txtNomeDefeitoOs.setEditable(false);

        jLabel7.setText("*Serviço");

        txtNomeServicoOs.setEditable(false);

        lblValorOs.setText("Valor Total");

        cboSituacaoOs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NA BANCADA", "ENTREGA OK", "ORÇAMENTO REPROVADO", "AGUARDANDO APROVAÇÃO", "AGUARDANDO PEÇAS", "ABANDONADO PELO CLIENTE", "RETORNOU" }));

        jLabel3.setText("Stuação");

        lblMarcaOs.setText("*Marca");

        txtNomeMarcaOs.setEditable(false);

        jLabel8.setText("*Funcionário");

        txtNomeFuncionarioOs.setEditable(false);

        btnBuscarFuncionarioOs.setText("Buscar");
        btnBuscarFuncionarioOs.setEnabled(false);
        btnBuscarFuncionarioOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFuncionarioOsActionPerformed(evt);
            }
        });

        txtValorOs.setEditable(true);

        btnBuscarMarcaOs.setText("Buscar");
        btnBuscarMarcaOs.setEnabled(false);
        btnBuscarMarcaOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMarcaOsActionPerformed(evt);
            }
        });

        txtNomeProdutoOs.setEditable(false);

        btnBuscarProdutoOs.setText("Buscar");
        btnBuscarProdutoOs.setEnabled(false);
        btnBuscarProdutoOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProdutoOsActionPerformed(evt);
            }
        });

        lblProdutoOs.setText("*Produto");

        btnBuscarDefeitoOs.setText("Buscar");
        btnBuscarDefeitoOs.setEnabled(false);
        btnBuscarDefeitoOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDefeitoOsActionPerformed(evt);
            }
        });

        btnBuscarServicoOs.setText("Buscar");
        btnBuscarServicoOs.setEnabled(false);
        btnBuscarServicoOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarServicoOsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(lblDefeitoOs))
                                .addGap(272, 272, 272)
                                .addComponent(jLabel7))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cboSituacaoOs, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMarcaOs)
                                    .addComponent(txtNomeMarcaOs, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(8, 8, 8)
                        .addComponent(btnBuscarMarcaOs, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtNomeProdutoOs)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarProdutoOs, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblProdutoOs)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtNomeDefeitoOs, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarDefeitoOs, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNomeServicoOs, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarServicoOs, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtNomeFuncionarioOs)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarFuncionarioOs, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValorOs)
                            .addComponent(txtValorOs, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarcaOs)
                    .addComponent(jLabel3)
                    .addComponent(lblProdutoOs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeMarcaOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSituacaoOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarMarcaOs)
                    .addComponent(txtNomeProdutoOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProdutoOs))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorOs)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDefeitoOs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarFuncionarioOs)
                    .addComponent(txtValorOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeFuncionarioOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeServicoOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarServicoOs)
                    .addComponent(txtNomeDefeitoOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarDefeitoOs))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Histórico"));

        tblHistoricoOs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "DATA", "TIPO", "SITUAÇÃO", "MARCA", "PRODUTO", "DEFEITO", "SERVIÇO", "FUNCIONÁRIO", "VALOR"
            }
        ));
        tblHistoricoOs.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblHistoricoOs);
        if (tblHistoricoOs.getColumnModel().getColumnCount() > 0) {
            tblHistoricoOs.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblHistoricoOs.getColumnModel().getColumn(1).setPreferredWidth(40);
            tblHistoricoOs.getColumnModel().getColumn(2).setPreferredWidth(55);
            tblHistoricoOs.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblHistoricoOs.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblHistoricoOs.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblHistoricoOs.getColumnModel().getColumn(6).setPreferredWidth(80);
            tblHistoricoOs.getColumnModel().getColumn(9).setPreferredWidth(30);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("*Campos Obrigatórios");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        btnBuscarClienteOs.setText("Buscar");
        btnBuscarClienteOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteOsActionPerformed(evt);
            }
        });

        tblTelefoneOs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null}
            },
            new String [] {
                "TELEFONE"
            }
        ));
        jScrollPane1.setViewportView(tblTelefoneOs);

        txtcpfCnpjClienteOs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcpfCnpjClienteOsKeyReleased(evt);
            }
        });

        jLabel2.setText("Nome");

        jLabel6.setText("CPF/CNPJ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtcpfCnpjClienteOs, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarClienteOs, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeClienteOs)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 240, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeClienteOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcpfCnpjClienteOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarClienteOs)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Os"));

        lblNumeroOs.setText("Código");

        lblDataOs.setText("Data");

        txtDataOs.setEditable(false);

        buttonGroup1.add(rbtOrdemDeServicoOs);
        rbtOrdemDeServicoOs.setText("Ordem de Serviço");
        rbtOrdemDeServicoOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtOrdemDeServicoOsActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtOrcamentoOs);
        rbtOrcamentoOs.setText("Orçamento");
        rbtOrcamentoOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtOrcamentoOsActionPerformed(evt);
            }
        });

        btnBuscarCodigoOs.setText("Buscar");
        btnBuscarCodigoOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCodigoOsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNumeroOs)
                            .addComponent(txtIdOs, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarCodigoOs, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDataOs, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDataOs)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbtOrcamentoOs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtOrdemDeServicoOs)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataOs)
                    .addComponent(lblNumeroOs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataOs)
                    .addComponent(btnBuscarCodigoOs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtOrcamentoOs)
                    .addComponent(rbtOrdemDeServicoOs))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        btnAdicionarOs.setText("Adicionar");
        btnAdicionarOs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionarOs.setEnabled(false);
        btnAdicionarOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarOsActionPerformed(evt);
            }
        });

        btnDeletarOs.setText("Deletar");
        btnDeletarOs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeletarOs.setEnabled(false);
        btnDeletarOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarOsActionPerformed(evt);
            }
        });

        btnEditarOs.setText("Editar");
        btnEditarOs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarOs.setEnabled(false);
        btnEditarOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarOsActionPerformed(evt);
            }
        });

        btnLimparOs.setText("Limpar");
        btnLimparOs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimparOs.setEnabled(false);
        btnLimparOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparOsActionPerformed(evt);
            }
        });

        btnCancelarOs.setText("Cancelar");
        btnCancelarOs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelarOs.setEnabled(false);
        btnCancelarOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarOsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addComponent(btnLimparOs, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdicionarOs, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEditarOs, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDeletarOs, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCancelarOs, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimparOs)
                    .addComponent(btnDeletarOs)
                    .addComponent(btnEditarOs)
                    .addComponent(btnAdicionarOs)
                    .addComponent(btnCancelarOs))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1093, 592);
    }// </editor-fold>//GEN-END:initComponents

    private void rbtOrcamentoOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtOrcamentoOsActionPerformed
        tipoServicoOs = TipoServico.ORCAMENTO.getValor();
    }//GEN-LAST:event_rbtOrcamentoOsActionPerformed

    private void rbtOrdemDeServicoOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtOrdemDeServicoOsActionPerformed
        tipoServicoOs = TipoServico.ORDEM_DE_SERVICO.getValor();
    }//GEN-LAST:event_rbtOrdemDeServicoOsActionPerformed

    private void txtcpfCnpjClienteOsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcpfCnpjClienteOsKeyReleased
        txtcpfCnpjClienteOs.setText(JMascara.GetJmascaraCpfCnpj(txtcpfCnpjClienteOs.getText()));
    }//GEN-LAST:event_txtcpfCnpjClienteOsKeyReleased

    private void btnBuscarClienteOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteOsActionPerformed
        String cpfCnpj = JMascara.GetJmascaraLimpar(txtcpfCnpjClienteOs.getText());

        if(cpfCnpj.length() != 11 && cpfCnpj.length() != 14){
            JOptionPane.showMessageDialog(null, "Favor inserir CPF/CNPJ Valido!", "Os", JOptionPane.INFORMATION_MESSAGE);
        } else{
            Long idCliente = null;
            String nomeCliente = null;
            PessoaDao pessoaDao = new PessoaDao();
            for (Pessoa pessoa : pessoaDao.buscarDadosPessoa(cpfCnpj)) {
                idCliente = pessoa.getIdPes();
                nomeCliente = pessoa.getNomePes();
            }  
            if(idCliente != null){
                idClienteOs = idCliente;
                txtNomeClienteOs.setText(nomeCliente);
                btnAdicionarOs.setEnabled(true);                        
                desabilitaBotoesEditarDeletarImprimirCancelar();
                habilitaBotoesBuscarPreencherCadastro();
                limparCamposOs();
                buscarTelefoneTblOs(idCliente);
                buscarHistoricoTblOs(idCliente);
            }else{
                int confirma = JOptionPane.showConfirmDialog(null, "Pessoa não encontrada, Deseja Cadastrar!", "Os", JOptionPane.YES_NO_OPTION);     
                if (confirma == JOptionPane.YES_OPTION){
                    TelaCadastraConsultaPessoa telaCadastraConsultaPessoa = new TelaCadastraConsultaPessoa();
                    PosicaoFormulario form = new PosicaoFormulario();
                    form.abrirFormulario(telaCadastraConsultaPessoa, TelaPrincipal.desktop);
                    TelaCadastraConsultaPessoa.rbtClienteConsultaPessoa.setSelected(true);   
                    TelaCadastraConsultaPessoa.txtCpfCnpjTelaConsultaPessoa.setText(txtcpfCnpjClienteOs.getText());
                    TelaCadastraConsultaPessoa.configuraAdicionar();
                    TelaCadastraConsultaPessoa.desabilitaRadioReferenciaTipoPessoa();      
                }
            }
        }
    }//GEN-LAST:event_btnBuscarClienteOsActionPerformed

    private void btnBuscarCodigoOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCodigoOsActionPerformed
        if(txtIdOs.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Favor inserir OS Valida!", "Os", JOptionPane.INFORMATION_MESSAGE);
        }else{
            OsDao osDao = new OsDao();
            boolean retorno = osDao.buscarOs(Long.parseLong(txtIdOs.getText()));
            if(retorno){
                btnAdicionarOs.setEnabled(false); 
                btnEditarOs.setEnabled(true);
                btnDeletarOs.setEnabled(true);
                btnCancelarOs.setEnabled(true);
                habilitaBotoesBuscarPreencherCadastro();
                buscarTelefoneTblOs(idClienteOs);
                buscarHistoricoTblOs(idClienteOs);   
            }else{
                JOptionPane.showMessageDialog(null, "Os não encontrada!", "Os", JOptionPane.INFORMATION_MESSAGE);
                txtIdOs.setText(null);
                txtIdOs.requestFocus();
            }
        }     
    }//GEN-LAST:event_btnBuscarCodigoOsActionPerformed

    private void btnBuscarFuncionarioOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFuncionarioOsActionPerformed
       OsDao osDao = new OsDao();
       String idFuncionario = JOptionPane.showInputDialog(null, "Favor inserir seu identificador!", "Os", JOptionPane.INFORMATION_MESSAGE);
       String nomeFuncionario = osDao.buscarNomeFuncionario(Long.parseLong(idFuncionario));

       if(nomeFuncionario != null){
           txtNomeFuncionarioOs.setText(nomeFuncionario);
           idFuncionarioOs = Long.parseLong(idFuncionario);
       }else{
           JOptionPane.showMessageDialog(null, "Funcionário não encontrado!", "Os", JOptionPane.INFORMATION_MESSAGE);
       }  
    }//GEN-LAST:event_btnBuscarFuncionarioOsActionPerformed

    private void btnLimparOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparOsActionPerformed
        limparCamposOs();
    }//GEN-LAST:event_btnLimparOsActionPerformed

    private void btnAdicionarOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarOsActionPerformed
        if(validarDadosOs()){
            Os os = new Os();
            OsDao osDao = new OsDao();
            
            os.setTipoOs(tipoServicoOs);
            os.setSituacaoOs(cboSituacaoOs.getSelectedItem().toString());
            os.setIdMarcaFkOs(idMarcaOs);
            os.setIdProdutoFkOs(idProdutoOs);
            os.setIdDefeitoFkOs(idDefeitoOs);
            os.setIdServicoFkOs(idServicoOs);
            os.setIdFuncionarioFkOs(idFuncionarioOs);
            os.setIdClienteFkOs(idClienteOs);
            os.setValorOs(txtValorOs.getText());
           
            boolean retorno = osDao.adicionarOs(os);
            if(retorno){
                JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!", "Os", JOptionPane.INFORMATION_MESSAGE);
                buscarHistoricoTblOs(idClienteOs);
            }
        }else {
             JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Os", JOptionPane.INFORMATION_MESSAGE);
        } 
    }//GEN-LAST:event_btnAdicionarOsActionPerformed

    private void btnEditarOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarOsActionPerformed
        if(validarDadosOs()){
            Os os = new Os();
            OsDao osDao = new OsDao();
            
            os.setTipoOs(tipoServicoOs);
            os.setSituacaoOs(cboSituacaoOs.getSelectedItem().toString());
            os.setIdMarcaFkOs(idMarcaOs);
            os.setIdProdutoFkOs(idProdutoOs);
            os.setIdDefeitoFkOs(idDefeitoOs);
            os.setIdServicoFkOs(idServicoOs);
            os.setIdFuncionarioFkOs(idFuncionarioOs);
            os.setIdClienteFkOs(idClienteOs);
            os.setValorOs(txtValorOs.getText());
            os.setIdOs(Long.parseLong(txtIdOs.getText()));
            
            boolean retorno = osDao.editarOs(os);
            if(retorno){
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Os", JOptionPane.INFORMATION_MESSAGE);
                buscarHistoricoTblOs(idClienteOs);
            }
        }else {
             JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Os", JOptionPane.INFORMATION_MESSAGE);
        } 
    }//GEN-LAST:event_btnEditarOsActionPerformed

    private void btnDeletarOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarOsActionPerformed
        if(ControladorDeUsabilidade.telaOsDeletarCdu == 1){
           int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esta Os", "Os", JOptionPane.YES_NO_OPTION);
            if (confirma == JOptionPane.YES_OPTION) {
                OsDao osDao = new OsDao();
                boolean retorno = osDao.deletarOs(Long.parseLong(txtIdOs.getText()));
                if(retorno){
                    JOptionPane.showMessageDialog(null, "Dados apagados com sucesso!", "Os", JOptionPane.INFORMATION_MESSAGE);
                    configuraTelaIniciarOs();
                }     
            } 
        }else{
            ControladorDeUsabilidade.acessoNegado();
        } 
    }//GEN-LAST:event_btnDeletarOsActionPerformed

    private void btnCancelarOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarOsActionPerformed
        configuraTelaIniciarOs();
    }//GEN-LAST:event_btnCancelarOsActionPerformed

    private void btnBuscarMarcaOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMarcaOsActionPerformed
        TelaMarca telaMarca = new TelaMarca();
        PosicaoFormulario form = new PosicaoFormulario();
        form.abrirFormulario(telaMarca, TelaPrincipal.desktop);
        telaMarca.buscarMarcaTbl();    
    }//GEN-LAST:event_btnBuscarMarcaOsActionPerformed

    private void btnBuscarProdutoOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProdutoOsActionPerformed
       if(!txtNomeMarcaOs.getText().isEmpty()){
            TelaProduto telaProduto = new TelaProduto();
            PosicaoFormulario form = new PosicaoFormulario();
            form.abrirFormulario(telaProduto, TelaPrincipal.desktop);
            TelaProduto.idMarcaFk = idMarcaOs;
            telaProduto.buscarProdutoTbl(TelaProduto.idMarcaFk);
       }else{
           JOptionPane.showMessageDialog(null, "Necessário informar a marca!", "Os", JOptionPane.INFORMATION_MESSAGE);
       }       
    }//GEN-LAST:event_btnBuscarProdutoOsActionPerformed

    private void btnBuscarDefeitoOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDefeitoOsActionPerformed
        TelaDefeito telaDefeito = new TelaDefeito();
        PosicaoFormulario form = new PosicaoFormulario();
        form.abrirFormulario(telaDefeito, TelaPrincipal.desktop);
        telaDefeito.buscarDefeitoTbl();
    }//GEN-LAST:event_btnBuscarDefeitoOsActionPerformed

    private void btnBuscarServicoOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarServicoOsActionPerformed
        TelaServico telaServico = new TelaServico();
        PosicaoFormulario form = new PosicaoFormulario();
        form.abrirFormulario(telaServico, TelaPrincipal.desktop);
        telaServico.buscarServicoTbl();
    }//GEN-LAST:event_btnBuscarServicoOsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAdicionarOs;
    public static javax.swing.JButton btnBuscarClienteOs;
    private javax.swing.JButton btnBuscarCodigoOs;
    private javax.swing.JButton btnBuscarDefeitoOs;
    private javax.swing.JButton btnBuscarFuncionarioOs;
    private javax.swing.JButton btnBuscarMarcaOs;
    private javax.swing.JButton btnBuscarProdutoOs;
    private javax.swing.JButton btnBuscarServicoOs;
    public static javax.swing.JButton btnCancelarOs;
    public static javax.swing.JButton btnDeletarOs;
    public static javax.swing.JButton btnEditarOs;
    public static javax.swing.JButton btnLimparOs;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    public static javax.swing.JComboBox<String> cboSituacaoOs;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDataOs;
    private javax.swing.JLabel lblDefeitoOs;
    private javax.swing.JLabel lblMarcaOs;
    private javax.swing.JLabel lblNumeroOs;
    private javax.swing.JLabel lblProdutoOs;
    private javax.swing.JLabel lblValorOs;
    public static javax.swing.JRadioButton rbtOrcamentoOs;
    public static javax.swing.JRadioButton rbtOrdemDeServicoOs;
    public static javax.swing.JTable tblHistoricoOs;
    public static javax.swing.JTable tblTelefoneOs;
    public static javax.swing.JTextField txtDataOs;
    public static javax.swing.JTextField txtIdOs;
    public static javax.swing.JTextField txtNomeClienteOs;
    public static javax.swing.JTextField txtNomeDefeitoOs;
    public static javax.swing.JTextField txtNomeFuncionarioOs;
    public static javax.swing.JTextField txtNomeMarcaOs;
    public static javax.swing.JTextField txtNomeProdutoOs;
    public static javax.swing.JTextField txtNomeServicoOs;
    public static br.com.sistemaos.util.JMoneyField txtValorOs;
    public static javax.swing.JTextField txtcpfCnpjClienteOs;
    // End of variables declaration//GEN-END:variables
}
