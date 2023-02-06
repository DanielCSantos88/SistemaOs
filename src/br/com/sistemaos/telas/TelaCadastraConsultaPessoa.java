
package br.com.sistemaos.telas;

import Jm.JMascara;
import br.com.sistemaos.dao.ConfiguradorDeUsabilidadeDao;
import br.com.sistemaos.dao.ControladorDeAcessoDao;
import br.com.sistemaos.dao.DadosClienteDao;
import br.com.sistemaos.dao.DadosFornecedorDao;
import br.com.sistemaos.dao.EmailDao;
import br.com.sistemaos.dao.EnderecoDao;
import br.com.sistemaos.dao.DadosFuncionarioDao;
import br.com.sistemaos.dao.OsDao;
import br.com.sistemaos.dao.PessoaDao;
import br.com.sistemaos.dao.TelefoneDao;
import br.com.sistemaos.modelo.ControladorDeUsabilidade;
import br.com.sistemaos.modelo.Email;
import br.com.sistemaos.modelo.Endereco;
import br.com.sistemaos.modelo.Pessoa;
import br.com.sistemaos.modelo.Telefone;
import br.com.sistemaos.util.TipoPessoa;
import br.com.sistemaos.util.PosicaoFormulario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class TelaCadastraConsultaPessoa extends javax.swing.JInternalFrame {
    
    public static Long idPessoaTelaConsultaPessoa;
    public static int tipoPessoaTelaConsultaPessoa;
    
    public TelaCadastraConsultaPessoa() {
        initComponents();
    }
    
    public static void buscarTelefoneTabelaConsultaPessoa(Long id){

        DefaultTableModel modeloTelefone = (DefaultTableModel) tblTelefonePessoa.getModel();
        modeloTelefone.setNumRows(0);
       
        TelefoneDao telefoneDao = new TelefoneDao();
        for(Telefone telefone: telefoneDao.buscarTelefoneTabelas(id)){

            modeloTelefone.addRow(new Object[]{
                telefone.getTelefoneTel(),
                telefone.getResponsavelTel(),
                telefone.getDataAniversarioTel(),
                telefone.getDepartamentoTel(),
            });
        }
    }
    
    public static void buscarEmailTabelaConsultaPessoa(Long id){
        
        DefaultTableModel modeloEmail = (DefaultTableModel) tblEmailPessoa.getModel();
        modeloEmail.setNumRows(0);
        
        EmailDao emailDao = new EmailDao();
        
        for(Email email: emailDao.buscarEmailTabelas(id)){

            
            modeloEmail.addRow(new Object[]{
             
                email.getEmailEma(),
                email.getResponsavelEma(),
                email.getDataAniversarioEma(),
                email.getDepartamentoEma(),
            });
        }
    }
     
    public static void buscarEnderecoTabelaConsultaPessoa(Long id){
        
        DefaultTableModel modeloEndereco = (DefaultTableModel) tblEnderecoPessoa.getModel();
        modeloEndereco.setNumRows(0); 

        EnderecoDao enderecoDao = new EnderecoDao();
    
        for(Endereco endereco: enderecoDao.buscarEndereco(id)){

           
            modeloEndereco.addRow(new Object[]{
                
                endereco.getCepEnd(),
                endereco.getRuaEnd(),
                endereco.getNumEnd(),
                endereco.getComplementoEnd(),
                endereco.getBairroEnd(),
                endereco.getCidadeEnd(),
                endereco.getUfEnd(),
            });
        }
    }
    
    private void limparDadosConsultaPessoa(){
        txtNomeTelaConsultaPessoa.setText(null);
    }
    
    private boolean validarDadosConsultaPessoa(){
        boolean retorno = true;
        if(txtNomeTelaConsultaPessoa.getText().isEmpty()){
            retorno = false;
        }
        return retorno; 
    }
    
    public static void habilitaRadioReferenciaTipoPessoa(){
        rbtClienteConsultaPessoa.setEnabled(true);
        rbtFornecedorConsultaPessoa.setEnabled(true);
        rbtFuncionarioConsultaPessoa.setEnabled(true);
    }
    
    public static void desabilitaRadioReferenciaTipoPessoa(){
        rbtClienteConsultaPessoa.setEnabled(false);
        rbtFornecedorConsultaPessoa.setEnabled(false);
        rbtFuncionarioConsultaPessoa.setEnabled(false);
    }
    
    private void configurarBotoesDados(){
        switch(tipoPessoaTelaConsultaPessoa){
            case 1: 
                btnDadosClienteConsultaPessoa.setEnabled(true);
                btnDadosFornecedorConsultaPessoa.setEnabled(false);
                btnDadosFuncionarioConsultaPessoa.setEnabled(false);
            break;
            case 2: 
                btnDadosClienteConsultaPessoa.setEnabled(false);
                btnDadosFornecedorConsultaPessoa.setEnabled(true);
                btnDadosFuncionarioConsultaPessoa.setEnabled(false);
            break;
            default: 
                btnDadosClienteConsultaPessoa.setEnabled(false);
                btnDadosFornecedorConsultaPessoa.setEnabled(false);
                btnDadosFuncionarioConsultaPessoa.setEnabled(true);
        }   
    }
     
    private void deletarPessoa(){
        PessoaDao pessoaDao = new PessoaDao();
        int tipoReferencia = 0;
        for (Pessoa pessoa : pessoaDao.buscarDadosPessoa(JMascara.GetJmascaraLimpar(txtCpfCnpjTelaConsultaPessoa.getText()))) {
            tipoReferencia = pessoa.getReferenciaTipoPessoaPes();
        }     
        switch (tipoReferencia){
        case 1:
            DadosClienteDao dadosClienteDao = new DadosClienteDao();
            Long idDadosCliente = dadosClienteDao.buscarIdDadosCliente(idPessoaTelaConsultaPessoa);
            if(idDadosCliente != null){
                dadosClienteDao.deletarDadosCliente(idDadosCliente);
            }
            break;
        case 2:
            DadosFornecedorDao dadosFornecedorDao = new DadosFornecedorDao();  
            Long idDadosFornecedor = dadosFornecedorDao.buscarIdDadosFornecedor(idPessoaTelaConsultaPessoa);
            if(idDadosFornecedor != null){
               dadosFornecedorDao.deletarDadosFornecedor(idDadosFornecedor);
            }  
            break;    
        case 3:
            DadosFuncionarioDao dadosFuncionarioDao = new DadosFuncionarioDao();
            Long idDadosFuncionario = dadosFuncionarioDao.buscarIdDadosFuncionario(idPessoaTelaConsultaPessoa);
            if(idDadosFuncionario != null){
                dadosFuncionarioDao.deletarDadosFuncionario(idDadosFuncionario);
            }            
            break;          
        }
        ControladorDeAcessoDao controladorDeAcessoDao = new ControladorDeAcessoDao();
        controladorDeAcessoDao.deletarCadastroAcesso(idPessoaTelaConsultaPessoa);
        ConfiguradorDeUsabilidadeDao configuradorDeUsabilidadeDao = new ConfiguradorDeUsabilidadeDao();
        configuradorDeUsabilidadeDao.deletarUsabilidade(idPessoaTelaConsultaPessoa);
        
        pessoaDao.deletarTodosTelefonesPessoa(idPessoaTelaConsultaPessoa);
        pessoaDao.deletarTodosEmailsPessoa(idPessoaTelaConsultaPessoa);
        pessoaDao.deletarTodosEnderecosPessoa(idPessoaTelaConsultaPessoa);
        boolean retornoPessoa = pessoaDao.deletarPessoa(idPessoaTelaConsultaPessoa);
        
        if(retornoPessoa){
            int confirmaPessoa = JOptionPane.showConfirmDialog(null, "Dados apagados com sucesso. Deseja realizar outra operação!", "Consulta Pessoa", JOptionPane.YES_NO_OPTION);
            if (confirmaPessoa == JOptionPane.YES_OPTION) {        
                configuraTelaReiniciarCadastraConsultaPessoa();
            }else{
                dispose();
            }          
        } 
    }
    
    private void configuraTelaReiniciarCadastraConsultaPessoa(){
        habilitaRadioReferenciaTipoPessoa();
        idPessoaTelaConsultaPessoa = null;
        tipoPessoaTelaConsultaPessoa = 1;
        txtCpfCnpjTelaConsultaPessoa.setEditable(true);
        txtCpfCnpjTelaConsultaPessoa.setText(null);
        txtCpfCnpjTelaConsultaPessoa.requestFocus();
        txtNomeTelaConsultaPessoa.setText(null);
        btnBuscarConsultaPessoa.setEnabled(true);
        btnLimparConsultaPessoa.setEnabled(false);
        btnAdicionarConsultaPessoa.setEnabled(false);
        btnEditarConsultaPessoa.setEnabled(false);
        btnDeletarConsultaPessoa.setEnabled(false);
        btnCancelarConsultaPessoa.setEnabled(false);
        btnDadosClienteConsultaPessoa.setEnabled(false);
        btnDadosFornecedorConsultaPessoa.setEnabled(false);
        btnDadosFuncionarioConsultaPessoa.setEnabled(false);
        btnCadastarEndereco.setEnabled(false);
        btnCadastrarEmail.setEnabled(false);
        btnCadastrarTelefone.setEnabled(false);
        rbtClienteConsultaPessoa.setSelected(true);
        DefaultTableModel modeloTelefone = (DefaultTableModel) tblTelefonePessoa.getModel();
        modeloTelefone.setNumRows(0);
        DefaultTableModel modeloEmail = (DefaultTableModel) tblEmailPessoa.getModel();
        modeloEmail.setNumRows(0);
        DefaultTableModel modeloEndereco = (DefaultTableModel) tblEnderecoPessoa.getModel();
        modeloEndereco.setNumRows(0);
    }
    
    public static boolean editarPessoa(){
        boolean retorno;
        PessoaDao pessoaDao = new PessoaDao();
        Pessoa pessoa = new Pessoa();
        pessoa.setNomePes(TelaCadastraConsultaPessoa.txtNomeTelaConsultaPessoa.getText());
        pessoa.setReferenciaTipoPessoaPes(TelaCadastraConsultaPessoa.tipoPessoaTelaConsultaPessoa);
        pessoa.setIdPes(TelaCadastraConsultaPessoa.idPessoaTelaConsultaPessoa);
        retorno = pessoaDao.editarPessoa(pessoa);
        return retorno;
    }
    
    public static void configuraAdicionar(){
        btnBuscarConsultaPessoa.setEnabled(false);
        btnCancelarConsultaPessoa.setEnabled(true);
        btnAdicionarConsultaPessoa.setEnabled(true);
        txtCpfCnpjTelaConsultaPessoa.setEditable(false);
        txtNomeTelaConsultaPessoa.requestFocus();
    }
    
    private void defineRadioTipoPessoa(){
        switch(tipoPessoaTelaConsultaPessoa){
            case 1:
                rbtClienteConsultaPessoa.setSelected(true);
                break;
            case 2:
                rbtFornecedorConsultaPessoa.setSelected(true);
            default:
                rbtFuncionarioConsultaPessoa.setSelected(true);
        }
    }
    
    private void configuracoesComunsAdicionarBuscarCadastraConsultaPessoa(){
        btnEditarConsultaPessoa.setEnabled(true);
        btnDeletarConsultaPessoa.setEnabled(true);
        btnCancelarConsultaPessoa.setEnabled(true);
        btnLimparConsultaPessoa.setEnabled(true);   
        btnCadastarEndereco.setEnabled(true);
        btnCadastrarEmail.setEnabled(true);
        btnCadastrarTelefone.setEnabled(true);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCpfCnpjTelaConsultaPessoa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNomeTelaConsultaPessoa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rbtClienteConsultaPessoa = new javax.swing.JRadioButton();
        rbtFornecedorConsultaPessoa = new javax.swing.JRadioButton();
        rbtFuncionarioConsultaPessoa = new javax.swing.JRadioButton();
        btnLimparConsultaPessoa = new javax.swing.JButton();
        btnEditarConsultaPessoa = new javax.swing.JButton();
        btnDeletarConsultaPessoa = new javax.swing.JButton();
        btnDadosClienteConsultaPessoa = new javax.swing.JButton();
        btnDadosFuncionarioConsultaPessoa = new javax.swing.JButton();
        btnDadosFornecedorConsultaPessoa = new javax.swing.JButton();
        btnAdicionarConsultaPessoa = new javax.swing.JButton();
        btnBuscarConsultaPessoa = new javax.swing.JButton();
        btnCancelarConsultaPessoa = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTelefonePessoa = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmailPessoa = new javax.swing.JTable();
        btnCadastrarEmail = new javax.swing.JButton();
        btnCadastrarTelefone = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnCadastarEndereco = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblEnderecoPessoa = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Consulta de Pessoas - Sistema Os");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Pessoais"));

        jLabel1.setText("*CPF/CNPJ");

        txtCpfCnpjTelaConsultaPessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCpfCnpjTelaConsultaPessoaKeyPressed(evt);
            }
        });

        jLabel3.setText("*Nome");

        jLabel4.setText("*Referência");

        buttonGroup1.add(rbtClienteConsultaPessoa);
        rbtClienteConsultaPessoa.setText("Cliente");
        rbtClienteConsultaPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtClienteConsultaPessoaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtFornecedorConsultaPessoa);
        rbtFornecedorConsultaPessoa.setText("Fornecedor");
        rbtFornecedorConsultaPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtFornecedorConsultaPessoaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtFuncionarioConsultaPessoa);
        rbtFuncionarioConsultaPessoa.setText("Funcionário");
        rbtFuncionarioConsultaPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtFuncionarioConsultaPessoaActionPerformed(evt);
            }
        });

        btnLimparConsultaPessoa.setText("Limpar");
        btnLimparConsultaPessoa.setEnabled(false);
        btnLimparConsultaPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparConsultaPessoaActionPerformed(evt);
            }
        });

        btnEditarConsultaPessoa.setText("Editar");
        btnEditarConsultaPessoa.setEnabled(false);
        btnEditarConsultaPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarConsultaPessoaActionPerformed(evt);
            }
        });

        btnDeletarConsultaPessoa.setText("Deletar");
        btnDeletarConsultaPessoa.setEnabled(false);
        btnDeletarConsultaPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarConsultaPessoaActionPerformed(evt);
            }
        });

        btnDadosClienteConsultaPessoa.setText("Dados Cliente");
        btnDadosClienteConsultaPessoa.setEnabled(false);
        btnDadosClienteConsultaPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDadosClienteConsultaPessoaActionPerformed(evt);
            }
        });

        btnDadosFuncionarioConsultaPessoa.setText("Dados Funcionario");
        btnDadosFuncionarioConsultaPessoa.setEnabled(false);
        btnDadosFuncionarioConsultaPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDadosFuncionarioConsultaPessoaActionPerformed(evt);
            }
        });

        btnDadosFornecedorConsultaPessoa.setText("Dados Fornecedor");
        btnDadosFornecedorConsultaPessoa.setEnabled(false);
        btnDadosFornecedorConsultaPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDadosFornecedorConsultaPessoaActionPerformed(evt);
            }
        });

        btnAdicionarConsultaPessoa.setText("Adicionar");
        btnAdicionarConsultaPessoa.setEnabled(false);
        btnAdicionarConsultaPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarConsultaPessoaActionPerformed(evt);
            }
        });

        btnBuscarConsultaPessoa.setText("Buscar");
        btnBuscarConsultaPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarConsultaPessoaActionPerformed(evt);
            }
        });

        btnCancelarConsultaPessoa.setText("Cancelar");
        btnCancelarConsultaPessoa.setEnabled(false);
        btnCancelarConsultaPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarConsultaPessoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDadosClienteConsultaPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDadosFornecedorConsultaPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDadosFuncionarioConsultaPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(btnLimparConsultaPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdicionarConsultaPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarConsultaPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeletarConsultaPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarConsultaPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCpfCnpjTelaConsultaPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarConsultaPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeTelaConsultaPessoa)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(rbtClienteConsultaPessoa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtFornecedorConsultaPessoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtFuncionarioConsultaPessoa)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtClienteConsultaPessoa)
                            .addComponent(rbtFornecedorConsultaPessoa)
                            .addComponent(rbtFuncionarioConsultaPessoa)
                            .addComponent(txtNomeTelaConsultaPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCpfCnpjTelaConsultaPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarConsultaPessoa))))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimparConsultaPessoa)
                    .addComponent(btnEditarConsultaPessoa)
                    .addComponent(btnDeletarConsultaPessoa)
                    .addComponent(btnDadosClienteConsultaPessoa)
                    .addComponent(btnDadosFuncionarioConsultaPessoa)
                    .addComponent(btnDadosFornecedorConsultaPessoa)
                    .addComponent(btnAdicionarConsultaPessoa)
                    .addComponent(btnCancelarConsultaPessoa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("*Campos Obrigatórios");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Contatos"));

        tblTelefonePessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "TELEFONE", "RESPONSAVEL", "ANIVERSÁRIO", "DEPARTAMENTO"
            }
        ));
        jScrollPane1.setViewportView(tblTelefonePessoa);
        if (tblTelefonePessoa.getColumnModel().getColumnCount() > 0) {
            tblTelefonePessoa.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblTelefonePessoa.getColumnModel().getColumn(1).setPreferredWidth(70);
            tblTelefonePessoa.getColumnModel().getColumn(2).setPreferredWidth(57);
            tblTelefonePessoa.getColumnModel().getColumn(3).setPreferredWidth(70);
        }

        tblEmailPessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "E-MAIL", "RESPONSAVEL", "ANIVERSÁRIO", "DEPARTAMENTO"
            }
        ));
        jScrollPane2.setViewportView(tblEmailPessoa);
        if (tblEmailPessoa.getColumnModel().getColumnCount() > 0) {
            tblEmailPessoa.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblEmailPessoa.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblEmailPessoa.getColumnModel().getColumn(2).setPreferredWidth(70);
            tblEmailPessoa.getColumnModel().getColumn(3).setPreferredWidth(70);
        }

        btnCadastrarEmail.setText("Cadastro de e-mails");
        btnCadastrarEmail.setEnabled(false);
        btnCadastrarEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarEmailActionPerformed(evt);
            }
        });

        btnCadastrarTelefone.setText("Cadastro de telefones");
        btnCadastrarTelefone.setEnabled(false);
        btnCadastrarTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarTelefoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrarTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCadastrarEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarEmail)
                    .addComponent(btnCadastrarTelefone))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereços"));

        btnCadastarEndereco.setText("Cadastro de endereços");
        btnCadastarEndereco.setEnabled(false);
        btnCadastarEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastarEnderecoActionPerformed(evt);
            }
        });

        tblEnderecoPessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CEP", "RUA", "N°", "COMPLEMENTO", "BAIRRO", "CIDADE", "UF"
            }
        ));
        jScrollPane4.setViewportView(tblEnderecoPessoa);
        if (tblEnderecoPessoa.getColumnModel().getColumnCount() > 0) {
            tblEnderecoPessoa.getColumnModel().getColumn(0).setMinWidth(80);
            tblEnderecoPessoa.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblEnderecoPessoa.getColumnModel().getColumn(0).setMaxWidth(80);
            tblEnderecoPessoa.getColumnModel().getColumn(2).setMinWidth(60);
            tblEnderecoPessoa.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblEnderecoPessoa.getColumnModel().getColumn(2).setMaxWidth(60);
            tblEnderecoPessoa.getColumnModel().getColumn(3).setMinWidth(110);
            tblEnderecoPessoa.getColumnModel().getColumn(3).setPreferredWidth(110);
            tblEnderecoPessoa.getColumnModel().getColumn(3).setMaxWidth(110);
            tblEnderecoPessoa.getColumnModel().getColumn(4).setMinWidth(200);
            tblEnderecoPessoa.getColumnModel().getColumn(4).setPreferredWidth(200);
            tblEnderecoPessoa.getColumnModel().getColumn(4).setMaxWidth(200);
            tblEnderecoPessoa.getColumnModel().getColumn(5).setMinWidth(150);
            tblEnderecoPessoa.getColumnModel().getColumn(5).setPreferredWidth(150);
            tblEnderecoPessoa.getColumnModel().getColumn(5).setMaxWidth(150);
            tblEnderecoPessoa.getColumnModel().getColumn(6).setMinWidth(40);
            tblEnderecoPessoa.getColumnModel().getColumn(6).setPreferredWidth(40);
            tblEnderecoPessoa.getColumnModel().getColumn(6).setMaxWidth(40);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1082, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCadastarEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btnCadastarEndereco)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtClienteConsultaPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtClienteConsultaPessoaActionPerformed
        if(ControladorDeUsabilidade.telaCadastraConsultaPessoaReferenciaClienteCdu == 1){
             tipoPessoaTelaConsultaPessoa = TipoPessoa.CLIENTE.getValor();
             if(idPessoaTelaConsultaPessoa != null){           
                configurarBotoesDados();
             }
        }else{
            ControladorDeUsabilidade.acessoNegado();
            defineRadioTipoPessoa();
            
        }
    }//GEN-LAST:event_rbtClienteConsultaPessoaActionPerformed

    private void rbtFornecedorConsultaPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtFornecedorConsultaPessoaActionPerformed
        if(ControladorDeUsabilidade.telaCadastraConsultaPessoaReferenciaFornecedorCdu == 1){
            tipoPessoaTelaConsultaPessoa = TipoPessoa.FORNECEDOR.getValor();
            if(idPessoaTelaConsultaPessoa != null){            
                configurarBotoesDados();
            }         
        }else{
            ControladorDeUsabilidade.acessoNegado();
            defineRadioTipoPessoa();
        }   
    }//GEN-LAST:event_rbtFornecedorConsultaPessoaActionPerformed

    private void rbtFuncionarioConsultaPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtFuncionarioConsultaPessoaActionPerformed
        if(ControladorDeUsabilidade.telaCadastraConsultaPessoaReferenciaFuncionarioCdu == 1){
            tipoPessoaTelaConsultaPessoa = TipoPessoa.FUNCIONARIO.getValor();
            if(idPessoaTelaConsultaPessoa != null){               
                configurarBotoesDados();
            }         
        }else{
            ControladorDeUsabilidade.acessoNegado();
            defineRadioTipoPessoa();
        }  
    }//GEN-LAST:event_rbtFuncionarioConsultaPessoaActionPerformed

    private void btnDadosClienteConsultaPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDadosClienteConsultaPessoaActionPerformed
        if(ControladorDeUsabilidade.telaCadastraConsultaPessoaDadosClienteCdu == 1){
            TelaCadastraDadosCliente telaCadastraDadosCliente = new TelaCadastraDadosCliente();
            PosicaoFormulario form = new PosicaoFormulario();
            form.abrirFormulario(telaCadastraDadosCliente, TelaPrincipal.desktop);
            DadosClienteDao dadosClienteDao = new DadosClienteDao();
            boolean retorno = dadosClienteDao.buscarDadosCliente(idPessoaTelaConsultaPessoa);         
            if(retorno){
                TelaCadastraDadosCliente.btnEditarCadastraCliente.setEnabled(true);
                TelaCadastraDadosCliente.btnDeletarCadastraCliente.setEnabled(true);
            }else{
                TelaCadastraDadosCliente.btnAdicionarCadastraCliente.setEnabled(true);
            }
        }else{
            ControladorDeUsabilidade.acessoNegado();
        }   
    }//GEN-LAST:event_btnDadosClienteConsultaPessoaActionPerformed

    private void btnDadosFornecedorConsultaPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDadosFornecedorConsultaPessoaActionPerformed
        if(ControladorDeUsabilidade.telaCadastraConsultaPessoaDadosFornecedorCdu == 1){
            TelaCadastraDadosFornecedor telaCadastraDadosFornecedor = new TelaCadastraDadosFornecedor();
            PosicaoFormulario form = new PosicaoFormulario();
            form.abrirFormulario(telaCadastraDadosFornecedor, TelaPrincipal.desktop);
            DadosFornecedorDao dadosFornecedorDao = new DadosFornecedorDao();
            boolean retorno = dadosFornecedorDao.buscarDadosFornecedor(idPessoaTelaConsultaPessoa);
            if(retorno){
                TelaCadastraDadosFornecedor.btnEditarCadastraFornecedor.setEnabled(true);
                TelaCadastraDadosFornecedor.btnDeletarCadastraFornecedor.setEnabled(true);
            }else{
                TelaCadastraDadosFornecedor.btnAdicionarCadastraFornecedor.setEnabled(true);
            }
        }else{
            ControladorDeUsabilidade.acessoNegado();
        }  
    }//GEN-LAST:event_btnDadosFornecedorConsultaPessoaActionPerformed

    private void btnDadosFuncionarioConsultaPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDadosFuncionarioConsultaPessoaActionPerformed
         if(ControladorDeUsabilidade.telaCadastraConsultaPessoaDadosFuncionarioCdu == 1){
            TelaCadastraDadosFuncionario telaCadastraDadosFuncionario = new TelaCadastraDadosFuncionario();
            PosicaoFormulario form = new PosicaoFormulario();
            form.abrirFormulario(telaCadastraDadosFuncionario, TelaPrincipal.desktop);
            DadosFuncionarioDao dadosFuncionarioDao = new DadosFuncionarioDao();
            telaCadastraDadosFuncionario.buscarTblDadosFuncionario();
            boolean retorno = dadosFuncionarioDao.buscarDadosFuncionario(idPessoaTelaConsultaPessoa);
            if(retorno){
                TelaCadastraDadosFuncionario.bntEditarDadosFuncionario.setEnabled(true);
                TelaCadastraDadosFuncionario.btnDeletarDadosFuncionario.setEnabled(true);
            }else{
                TelaCadastraDadosFuncionario.btnAdicionarCadastraFuncionario.setEnabled(true);
            }
        }else{
            ControladorDeUsabilidade.acessoNegado();
        } 
    }//GEN-LAST:event_btnDadosFuncionarioConsultaPessoaActionPerformed

    private void btnLimparConsultaPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparConsultaPessoaActionPerformed
       limparDadosConsultaPessoa();
    }//GEN-LAST:event_btnLimparConsultaPessoaActionPerformed

    private void btnEditarConsultaPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarConsultaPessoaActionPerformed
        if(validarDadosConsultaPessoa()){
            if(editarPessoa()){
              JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Consulta Pessoa", JOptionPane.INFORMATION_MESSAGE);  
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Consulta Pessoa", JOptionPane.WARNING_MESSAGE);
        }  
    }//GEN-LAST:event_btnEditarConsultaPessoaActionPerformed

    private void btnDeletarConsultaPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarConsultaPessoaActionPerformed
        if(ControladorDeUsabilidade.telaCadastraConsultaPessoaDeletarCdu == 1){
            OsDao osDao = new OsDao();
            Long idOs = osDao.buscarIdOs(idPessoaTelaConsultaPessoa);
            if(idOs != null){
                int confirmaOs = JOptionPane.showConfirmDialog(null, "Cadastro com registro de Ordem de serviço, caso queira proseguir o registro de Ordem de Serviço também será apagada!", "Consulta Pessoa", JOptionPane.YES_NO_OPTION);
                if (confirmaOs == JOptionPane.YES_OPTION) { 
                    PessoaDao pessoaDao = new PessoaDao();
                    pessoaDao.deletarTodasOs(idPessoaTelaConsultaPessoa);
                    deletarPessoa();
                }
            }else{
                int confirmaPessoa = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usuário", "Consulta Pessoa", JOptionPane.YES_NO_OPTION);
                if (confirmaPessoa == JOptionPane.YES_OPTION) {
                    deletarPessoa();
                }
            }         
        }else{
            ControladorDeUsabilidade.acessoNegado();
        }  
    }//GEN-LAST:event_btnDeletarConsultaPessoaActionPerformed

    private void btnCadastrarTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarTelefoneActionPerformed
        if(ControladorDeUsabilidade.telaCadastraConsultaPessoaCadastraTelefoneCdu == 1){
            TelaCadastraTelefone telaCadastrarTelefonePessoa = new TelaCadastraTelefone();
            PosicaoFormulario form = new PosicaoFormulario();
            form.abrirFormulario(telaCadastrarTelefonePessoa, TelaPrincipal.desktop);
            TelaCadastraTelefone.txtTelefoneTelaCadastraTelefone.requestFocus();
            TelaCadastraTelefone.bntEditarTelaCadastraTelefone.setEnabled(false);
            TelaCadastraTelefone.bntDeletarTelaCadastraTelefone.setEnabled(false);
            telaCadastrarTelefonePessoa.buscarCadastraTelefone(idPessoaTelaConsultaPessoa);
        }else{
            ControladorDeUsabilidade.acessoNegado();
        }   
    }//GEN-LAST:event_btnCadastrarTelefoneActionPerformed

    private void btnCadastrarEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarEmailActionPerformed
         if(ControladorDeUsabilidade.telaCadastraConsultaPessoaCadastraEmailCdu == 1){
            TelaCadastraEmail telaCadastrarEmailPessoa = new TelaCadastraEmail();
            PosicaoFormulario form = new PosicaoFormulario();
            form.abrirFormulario(telaCadastrarEmailPessoa, TelaPrincipal.desktop);
            TelaCadastraEmail.txtEmailTelaCadastraEmail.requestFocus();
            TelaCadastraEmail.bntEditarTelaCadastraEmail.setEnabled(false);
            TelaCadastraEmail.bntDeletarTelaCadastraEmail.setEnabled(false);
            telaCadastrarEmailPessoa.buscarCasdastraEmail(idPessoaTelaConsultaPessoa);
        }else{
            ControladorDeUsabilidade.acessoNegado();
        }
    }//GEN-LAST:event_btnCadastrarEmailActionPerformed

    private void btnCadastarEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastarEnderecoActionPerformed
        if(ControladorDeUsabilidade.telaCadastraConsultaPessoaCadastraEnderecoCdu == 1){
            TelaCadastraEndereco telaCadastrarEndereco = new TelaCadastraEndereco();
            PosicaoFormulario form = new PosicaoFormulario();
            form.abrirFormulario(telaCadastrarEndereco, TelaPrincipal.desktop);
            TelaCadastraEndereco.txtCepTelaCadastraEndereco.requestFocus();
            TelaCadastraEndereco.bntEditarTelaCadastraEndereco.setEnabled(false);
            TelaCadastraEndereco.bntDeletarTelaCadastraEndereco.setEnabled(false);
            telaCadastrarEndereco.buscaCadastraEndereco(idPessoaTelaConsultaPessoa);
            
        }else{
            ControladorDeUsabilidade.acessoNegado();
        }  
    }//GEN-LAST:event_btnCadastarEnderecoActionPerformed

    private void btnAdicionarConsultaPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarConsultaPessoaActionPerformed
        if(validarDadosConsultaPessoa()){
            Pessoa pessoa = new Pessoa();
            PessoaDao pessoaDao = new PessoaDao();
            pessoa.setNomePes(txtNomeTelaConsultaPessoa.getText());
            pessoa.setCpfCnpjPes(JMascara.GetJmascaraLimpar(txtCpfCnpjTelaConsultaPessoa.getText()));
            pessoa.setReferenciaTipoPessoaPes(tipoPessoaTelaConsultaPessoa);
            boolean retorno = pessoaDao.adicionarPessoa(pessoa);
            if(retorno){
                JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!", "Cadastra Telefone", JOptionPane.INFORMATION_MESSAGE);
                pessoaDao.buscarPessoa(JMascara.GetJmascaraLimpar(txtCpfCnpjTelaConsultaPessoa.getText()));
                btnAdicionarConsultaPessoa.setEnabled(false);
                configuracoesComunsAdicionarBuscarCadastraConsultaPessoa();
                switch(tipoPessoaTelaConsultaPessoa){
                    case 1:
                        btnDadosClienteConsultaPessoa.setEnabled(true);
                        break;
                    case 2:
                        btnDadosFornecedorConsultaPessoa.setEnabled(true);
                        break;
                    default:
                        btnDadosFuncionarioConsultaPessoa.setEnabled(true);
                }
                habilitaRadioReferenciaTipoPessoa();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Consulta Pessoa", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAdicionarConsultaPessoaActionPerformed

    private void btnBuscarConsultaPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarConsultaPessoaActionPerformed
        String cpfCnpj = JMascara.GetJmascaraLimpar(txtCpfCnpjTelaConsultaPessoa.getText());
        if(cpfCnpj.length() != 11 && cpfCnpj.length()!= 14){
            JOptionPane.showMessageDialog(null, "Favor inserir CPF/CNPJ valido!","Consulta Pessoa", JOptionPane.WARNING_MESSAGE);
        }else {
            PessoaDao pessoaDao = new PessoaDao();
            boolean retorno = pessoaDao.buscarPessoa(cpfCnpj);
            if(retorno){
                txtCpfCnpjTelaConsultaPessoa.setEditable(false);
                btnBuscarConsultaPessoa.setEnabled(false);
                configuracoesComunsAdicionarBuscarCadastraConsultaPessoa();
                configurarBotoesDados();
                switch(tipoPessoaTelaConsultaPessoa){
                    case 1:
                        rbtClienteConsultaPessoa.setSelected(true);
                        DadosClienteDao dadosClienteDao = new DadosClienteDao();
                        Long idDadosCliente = dadosClienteDao.buscarIdDadosCliente(idPessoaTelaConsultaPessoa);
                        if(idDadosCliente != null){
                           desabilitaRadioReferenciaTipoPessoa();
                        }
                    break;
                    case 2:
                        rbtFornecedorConsultaPessoa.setSelected(true);
                        DadosFornecedorDao dadosFornecedorDao = new DadosFornecedorDao();
                        Long idDadosFornecedor = dadosFornecedorDao.buscarIdDadosFornecedor(idPessoaTelaConsultaPessoa);
                        if(idDadosFornecedor != null){
                           desabilitaRadioReferenciaTipoPessoa();
                        }
                    break;
                    default:
                        rbtFuncionarioConsultaPessoa.setSelected(true);
                        DadosFuncionarioDao dadosFuncionarioDao = new DadosFuncionarioDao();
                        Long idDadosFuncionario = dadosFuncionarioDao.buscarIdDadosFuncionario(idPessoaTelaConsultaPessoa);
                        if(idDadosFuncionario != null){
                            desabilitaRadioReferenciaTipoPessoa();
                        }
                }
                buscarTelefoneTabelaConsultaPessoa(idPessoaTelaConsultaPessoa);
                buscarEmailTabelaConsultaPessoa(idPessoaTelaConsultaPessoa);
                buscarEnderecoTabelaConsultaPessoa(idPessoaTelaConsultaPessoa);                
            }else{
                int confirma = JOptionPane.showConfirmDialog(null, "Pessoa não encontrada, Deseja Cadastrar!", "Atençao", JOptionPane.YES_NO_OPTION);
                if (confirma == JOptionPane.YES_OPTION){
                    rbtClienteConsultaPessoa.setSelected(true);
                    configuraAdicionar();
                }   
            }
        }
    }//GEN-LAST:event_btnBuscarConsultaPessoaActionPerformed

    private void txtCpfCnpjTelaConsultaPessoaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpfCnpjTelaConsultaPessoaKeyPressed
        txtCpfCnpjTelaConsultaPessoa.setText(JMascara.GetJmascaraCpfCnpj(txtCpfCnpjTelaConsultaPessoa.getText()));
    }//GEN-LAST:event_txtCpfCnpjTelaConsultaPessoaKeyPressed

    private void btnCancelarConsultaPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarConsultaPessoaActionPerformed
        configuraTelaReiniciarCadastraConsultaPessoa();
    }//GEN-LAST:event_btnCancelarConsultaPessoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAdicionarConsultaPessoa;
    public static javax.swing.JButton btnBuscarConsultaPessoa;
    public static javax.swing.JButton btnCadastarEndereco;
    public static javax.swing.JButton btnCadastrarEmail;
    public static javax.swing.JButton btnCadastrarTelefone;
    public static javax.swing.JButton btnCancelarConsultaPessoa;
    public static javax.swing.JButton btnDadosClienteConsultaPessoa;
    public static javax.swing.JButton btnDadosFornecedorConsultaPessoa;
    public static javax.swing.JButton btnDadosFuncionarioConsultaPessoa;
    public static javax.swing.JButton btnDeletarConsultaPessoa;
    public static javax.swing.JButton btnEditarConsultaPessoa;
    public static javax.swing.JButton btnLimparConsultaPessoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JRadioButton rbtClienteConsultaPessoa;
    public static javax.swing.JRadioButton rbtFornecedorConsultaPessoa;
    public static javax.swing.JRadioButton rbtFuncionarioConsultaPessoa;
    public static javax.swing.JTable tblEmailPessoa;
    public static javax.swing.JTable tblEnderecoPessoa;
    public static javax.swing.JTable tblTelefonePessoa;
    public static javax.swing.JTextField txtCpfCnpjTelaConsultaPessoa;
    public static javax.swing.JTextField txtNomeTelaConsultaPessoa;
    // End of variables declaration//GEN-END:variables
}
