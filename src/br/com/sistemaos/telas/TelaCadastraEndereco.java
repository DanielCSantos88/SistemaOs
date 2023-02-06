
package br.com.sistemaos.telas;

import Jm.JMascara;
import br.com.sistemaos.dao.EnderecoDao;
import br.com.sistemaos.modelo.ControladorDeUsabilidade;
import br.com.sistemaos.modelo.Endereco;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class TelaCadastraEndereco extends javax.swing.JInternalFrame {
   
    public static Long idPessoa = TelaCadastraConsultaPessoa.idPessoaTelaConsultaPessoa;
    protected Long idEndereco;
    
    public TelaCadastraEndereco() {
        initComponents();
    }
    
    public void buscaCadastraEndereco(Long idPessoa){

        DefaultTableModel modelo = (DefaultTableModel) tblTelaCadastraEndereco.getModel();
        modelo.setNumRows(0);
 
        EnderecoDao enderecoDao = new EnderecoDao();
 
        for(Endereco endereco: enderecoDao.buscarEndereco(idPessoa)){

            modelo.addRow(new Object[]{

                endereco.getIdEnd(),
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
     
    private void buscarCepCadastraEndereco(String cep){
        String logradouro = "";
        String tipoLogradouro = "";
        String resultado;
        
        try {
            URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
            SAXReader xml = new SAXReader(); //
            Document documento = xml.read(url);
            Element root = documento.getRootElement();
            for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
                Element element = it.next();
                if(element.getQualifiedName().equals("cidade")){
                    txtCidadelTelaCadastraEndereco.setText(element.getText());
                }
                if(element.getQualifiedName().equals("bairro")){
                    txtBairrolTelaCadastraEndereco.setText(element.getText());
                }
                if(element.getQualifiedName().equals("uf")){
                    cboUflTelaCadastraEndereco.setSelectedItem(element.getText());
                }
                if(element.getQualifiedName().equals("tipo_logradouro")){
                    tipoLogradouro = element.getText();
                }
                if(element.getQualifiedName().equals("logradouro")){
                    logradouro = element.getText();
                }
                txtIRualTelaCadastraEndereco.setText(tipoLogradouro + " " + logradouro);
                if(element.getQualifiedName().equals("resultado")){
                    resultado = element.getText();
                    if(!resultado.equals("1")){
                        JOptionPane.showMessageDialog(null, "CEP não encontrado");
                        txtCepTelaCadastraEndereco.setText(null);
                        txtCepTelaCadastraEndereco.requestFocus();
                    }
                }        
            }       
        } catch (MalformedURLException | DocumentException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void setarCamposCadastraEndereco() {
        int setar = tblTelaCadastraEndereco.getSelectedRow();
        idEndereco = Long.parseLong(tblTelaCadastraEndereco.getModel().getValueAt(setar, 0).toString());
        txtCepTelaCadastraEndereco.setText(tblTelaCadastraEndereco.getModel().getValueAt(setar, 1).toString());
        txtIRualTelaCadastraEndereco.setText(tblTelaCadastraEndereco.getModel().getValueAt(setar, 2).toString());
        txtINumerolTelaCadastraEndereco.setText(tblTelaCadastraEndereco.getModel().getValueAt(setar, 3).toString());
        txtComplementolTelaCadastraEndereco.setText(tblTelaCadastraEndereco.getModel().getValueAt(setar, 4).toString()); 
        txtBairrolTelaCadastraEndereco.setText(tblTelaCadastraEndereco.getModel().getValueAt(setar, 5).toString()); 
        txtCidadelTelaCadastraEndereco.setText(tblTelaCadastraEndereco.getModel().getValueAt(setar, 6).toString());
        cboUflTelaCadastraEndereco.setSelectedItem(tblTelaCadastraEndereco.getModel().getValueAt(setar, 7).toString());
        bntAdicionarTelaCadastraEndereco.setEnabled(false);
        bntEditarTelaCadastraEndereco.setEnabled(true);
        bntDeletarTelaCadastraEndereco.setEnabled(true);
    }
       
    private void limparDadosCadastraEndereco(){
        txtCepTelaCadastraEndereco.setText(null);
        txtIRualTelaCadastraEndereco.setText(null);
        txtINumerolTelaCadastraEndereco.setText(null);
        txtComplementolTelaCadastraEndereco.setText(null);
        txtBairrolTelaCadastraEndereco.setText(null);
        txtCidadelTelaCadastraEndereco.setText(null);
        cboUflTelaCadastraEndereco.setSelectedItem(null);
        bntAdicionarTelaCadastraEndereco.setEnabled(true);
        bntEditarTelaCadastraEndereco.setEnabled(false);
        bntDeletarTelaCadastraEndereco.setEnabled(false);
    }
    
    private void finalizarAcoesCadastraEndereco(){
        dispose();
        TelaCadastraConsultaPessoa.buscarEnderecoTabelaConsultaPessoa(idPessoa);
    }
    
    private boolean validarDadosCadastraEmail(){
        boolean retorno = true;
        if(txtCepTelaCadastraEndereco.getText().isEmpty()){
            retorno = false;
        }
        if(txtIRualTelaCadastraEndereco.getText().isEmpty()){
            retorno = false;
        }
        if(txtINumerolTelaCadastraEndereco.getText().isEmpty()){
            retorno = false;
        }
        if(txtBairrolTelaCadastraEndereco.getText().isEmpty()){
            retorno = false;
        }
        if(txtCidadelTelaCadastraEndereco.getText().isEmpty()){
            retorno = false;
        }
        if(cboUflTelaCadastraEndereco.getSelectedItem().toString().isEmpty()){
            retorno = false;
        }
        return retorno;
    }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCamposObrigatoriosTelaCadastrarEndereco = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblCepTelaCadastraEndereco = new javax.swing.JLabel();
        txtCepTelaCadastraEndereco = new javax.swing.JTextField();
        lblRualTelaCadastraEndereco = new javax.swing.JLabel();
        txtIRualTelaCadastraEndereco = new javax.swing.JTextField();
        bnLimparTelaCadastraEndereco = new javax.swing.JButton();
        bntAdicionarTelaCadastraEndereco = new javax.swing.JButton();
        bntEditarTelaCadastraEndereco = new javax.swing.JButton();
        bntDeletarTelaCadastraEndereco = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTelaCadastraEndereco = new javax.swing.JTable();
        bnBuscarCepTelaCadastraEndereco = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtINumerolTelaCadastraEndereco = new javax.swing.JTextField();
        lblComplementolTelaCadastraEndereco = new javax.swing.JLabel();
        txtComplementolTelaCadastraEndereco = new javax.swing.JTextField();
        lblBairrolTelaCadastraEndereco = new javax.swing.JLabel();
        txtBairrolTelaCadastraEndereco = new javax.swing.JTextField();
        lblCidadelTelaCadastraEndereco = new javax.swing.JLabel();
        txtCidadelTelaCadastraEndereco = new javax.swing.JTextField();
        cboUflTelaCadastraEndereco = new javax.swing.JComboBox<>();
        lblUfelTelaCadastraEndereco = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Consulta de Endereço - Sistema Os");

        lblCamposObrigatoriosTelaCadastrarEndereco.setText("*Campos Obrigatórios");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereços"));

        lblCepTelaCadastraEndereco.setText("*CEP");

        txtCepTelaCadastraEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCepTelaCadastraEnderecoKeyReleased(evt);
            }
        });

        lblRualTelaCadastraEndereco.setText("*Rua");

        bnLimparTelaCadastraEndereco.setText("Limpar");
        bnLimparTelaCadastraEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnLimparTelaCadastraEnderecoActionPerformed(evt);
            }
        });

        bntAdicionarTelaCadastraEndereco.setText("Adicionar");
        bntAdicionarTelaCadastraEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAdicionarTelaCadastraEnderecoActionPerformed(evt);
            }
        });

        bntEditarTelaCadastraEndereco.setText("Editar");
        bntEditarTelaCadastraEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEditarTelaCadastraEnderecoActionPerformed(evt);
            }
        });

        bntDeletarTelaCadastraEndereco.setText("Deletar");
        bntDeletarTelaCadastraEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDeletarTelaCadastraEnderecoActionPerformed(evt);
            }
        });

        tblTelaCadastraEndereco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CEP", "RUA", "N°", "COMPLEMENTO", "BAIRRO", "CIDADE", "UF"
            }
        ));
        tblTelaCadastraEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTelaCadastraEnderecoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblTelaCadastraEndereco);
        if (tblTelaCadastraEndereco.getColumnModel().getColumnCount() > 0) {
            tblTelaCadastraEndereco.getColumnModel().getColumn(0).setMinWidth(50);
            tblTelaCadastraEndereco.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblTelaCadastraEndereco.getColumnModel().getColumn(0).setMaxWidth(50);
            tblTelaCadastraEndereco.getColumnModel().getColumn(1).setMinWidth(80);
            tblTelaCadastraEndereco.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblTelaCadastraEndereco.getColumnModel().getColumn(1).setMaxWidth(80);
            tblTelaCadastraEndereco.getColumnModel().getColumn(3).setMinWidth(50);
            tblTelaCadastraEndereco.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblTelaCadastraEndereco.getColumnModel().getColumn(3).setMaxWidth(50);
            tblTelaCadastraEndereco.getColumnModel().getColumn(4).setMinWidth(90);
            tblTelaCadastraEndereco.getColumnModel().getColumn(4).setPreferredWidth(90);
            tblTelaCadastraEndereco.getColumnModel().getColumn(4).setMaxWidth(90);
            tblTelaCadastraEndereco.getColumnModel().getColumn(5).setMinWidth(200);
            tblTelaCadastraEndereco.getColumnModel().getColumn(5).setPreferredWidth(200);
            tblTelaCadastraEndereco.getColumnModel().getColumn(5).setMaxWidth(200);
            tblTelaCadastraEndereco.getColumnModel().getColumn(6).setMinWidth(150);
            tblTelaCadastraEndereco.getColumnModel().getColumn(6).setPreferredWidth(150);
            tblTelaCadastraEndereco.getColumnModel().getColumn(6).setMaxWidth(150);
            tblTelaCadastraEndereco.getColumnModel().getColumn(7).setMinWidth(40);
            tblTelaCadastraEndereco.getColumnModel().getColumn(7).setPreferredWidth(40);
            tblTelaCadastraEndereco.getColumnModel().getColumn(7).setMaxWidth(40);
        }

        bnBuscarCepTelaCadastraEndereco.setText("Buscar");
        bnBuscarCepTelaCadastraEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnBuscarCepTelaCadastraEnderecoActionPerformed(evt);
            }
        });

        jLabel1.setText("*N°");

        lblComplementolTelaCadastraEndereco.setText("Complemento");

        lblBairrolTelaCadastraEndereco.setText("*Bairro");

        lblCidadelTelaCadastraEndereco.setText("*Cidade");

        cboUflTelaCadastraEndereco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cboUflTelaCadastraEndereco.setToolTipText("");

        lblUfelTelaCadastraEndereco.setText("*Uf");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCepTelaCadastraEndereco)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCepTelaCadastraEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bnBuscarCepTelaCadastraEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIRualTelaCadastraEndereco)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblRualTelaCadastraEndereco)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtINumerolTelaCadastraEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblComplementolTelaCadastraEndereco)
                            .addComponent(txtComplementolTelaCadastraEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBairrolTelaCadastraEndereco)
                            .addComponent(txtBairrolTelaCadastraEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCidadelTelaCadastraEndereco)
                            .addComponent(txtCidadelTelaCadastraEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUfelTelaCadastraEndereco)
                            .addComponent(cboUflTelaCadastraEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 918, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(bnLimparTelaCadastraEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bntAdicionarTelaCadastraEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bntEditarTelaCadastraEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bntDeletarTelaCadastraEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(lblRualTelaCadastraEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIRualTelaCadastraEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtINumerolTelaCadastraEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblCepTelaCadastraEndereco)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCepTelaCadastraEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bnBuscarCepTelaCadastraEndereco)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBairrolTelaCadastraEndereco)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblUfelTelaCadastraEndereco)
                                .addComponent(lblCidadelTelaCadastraEndereco)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBairrolTelaCadastraEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCidadelTelaCadastraEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboUflTelaCadastraEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblComplementolTelaCadastraEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtComplementolTelaCadastraEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntDeletarTelaCadastraEndereco)
                    .addComponent(bntEditarTelaCadastraEndereco)
                    .addComponent(bntAdicionarTelaCadastraEndereco)
                    .addComponent(bnLimparTelaCadastraEndereco))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCamposObrigatoriosTelaCadastrarEndereco)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCamposObrigatoriosTelaCadastrarEndereco)
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

    private void bnLimparTelaCadastraEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnLimparTelaCadastraEnderecoActionPerformed
        limparDadosCadastraEndereco();
    }//GEN-LAST:event_bnLimparTelaCadastraEnderecoActionPerformed

    private void bntAdicionarTelaCadastraEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAdicionarTelaCadastraEnderecoActionPerformed
        if(validarDadosCadastraEmail()){
            Endereco endereco = new Endereco();
            EnderecoDao enderecoDao = new EnderecoDao();        
            endereco.setCepEnd(JMascara.GetJmascaraLimpar(txtCepTelaCadastraEndereco.getText()));
            endereco.setRuaEnd(txtIRualTelaCadastraEndereco.getText());
            endereco.setNumEnd(txtINumerolTelaCadastraEndereco.getText());
            endereco.setComplementoEnd(txtComplementolTelaCadastraEndereco.getText());
            endereco.setBairroEnd(txtBairrolTelaCadastraEndereco.getText());
            endereco.setCidadeEnd(txtCidadelTelaCadastraEndereco.getText());
            endereco.setUfEnd(cboUflTelaCadastraEndereco.getSelectedItem().toString());
            endereco.setIdPessoaFkEnd(idPessoa);            
            boolean retorno = enderecoDao.adicionarEndereco(endereco);
            if(retorno){
                JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!", "Cadastra Endereço", JOptionPane.INFORMATION_MESSAGE);
                finalizarAcoesCadastraEndereco();
            }           
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Endereço", JOptionPane.WARNING_MESSAGE);
        }
       
    }//GEN-LAST:event_bntAdicionarTelaCadastraEnderecoActionPerformed

    private void bntEditarTelaCadastraEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEditarTelaCadastraEnderecoActionPerformed
        if(validarDadosCadastraEmail()){
            Endereco endereco = new Endereco();
            EnderecoDao enderecoDao = new EnderecoDao();
            endereco.setCepEnd(JMascara.GetJmascaraLimpar(txtCepTelaCadastraEndereco.getText()));
            endereco.setRuaEnd(txtIRualTelaCadastraEndereco.getText());
            endereco.setNumEnd(txtINumerolTelaCadastraEndereco.getText());
            endereco.setComplementoEnd(txtComplementolTelaCadastraEndereco.getText());
            endereco.setBairroEnd(txtBairrolTelaCadastraEndereco.getText());
            endereco.setCidadeEnd(txtCidadelTelaCadastraEndereco.getText());
            endereco.setUfEnd(cboUflTelaCadastraEndereco.getSelectedItem().toString());
            endereco.setIdEnd(idEndereco);       
            boolean retorno = enderecoDao.editarEndereco(endereco);
        if(retorno){
           JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Cadastra Endereço", JOptionPane.INFORMATION_MESSAGE);
           finalizarAcoesCadastraEndereco();
        }       
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Cadastra Endereço", JOptionPane.WARNING_MESSAGE);
        } 
       
    }//GEN-LAST:event_bntEditarTelaCadastraEnderecoActionPerformed

    private void bntDeletarTelaCadastraEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDeletarTelaCadastraEnderecoActionPerformed
        if(ControladorDeUsabilidade.telaCadastraEnderecoDeletarCdu == 1){       
            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este endereço", "Cadastra Endereço", JOptionPane.YES_NO_OPTION);
            if (confirma == JOptionPane.YES_OPTION) {
                EnderecoDao enderecoDao = new EnderecoDao();
                boolean retorno = enderecoDao.deletarEndereco(idEndereco);
                if(retorno){
                    JOptionPane.showMessageDialog(null, "Dados apagados com sucesso!", "Cadastra Endereço", JOptionPane.INFORMATION_MESSAGE);
                    finalizarAcoesCadastraEndereco();
                }              
            }            
        }else{
            ControladorDeUsabilidade.acessoNegado();
        }
    }//GEN-LAST:event_bntDeletarTelaCadastraEnderecoActionPerformed

    private void bnBuscarCepTelaCadastraEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnBuscarCepTelaCadastraEnderecoActionPerformed
        String cep = txtCepTelaCadastraEndereco.getText();
        // metodo para buscar cep
        if(cep.length() != 10){
            JOptionPane.showMessageDialog(this, "Favor Digite o CEP valido!");
        }else{
             buscarCepCadastraEndereco(cep);
        }
    }//GEN-LAST:event_bnBuscarCepTelaCadastraEnderecoActionPerformed

    private void txtCepTelaCadastraEnderecoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCepTelaCadastraEnderecoKeyReleased
        txtCepTelaCadastraEndereco.setText(JMascara.GetJmascaraCep(txtCepTelaCadastraEndereco.getText()));
    }//GEN-LAST:event_txtCepTelaCadastraEnderecoKeyReleased

    private void tblTelaCadastraEnderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTelaCadastraEnderecoMouseClicked
        setarCamposCadastraEndereco();
    }//GEN-LAST:event_tblTelaCadastraEnderecoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnBuscarCepTelaCadastraEndereco;
    private javax.swing.JButton bnLimparTelaCadastraEndereco;
    public static javax.swing.JButton bntAdicionarTelaCadastraEndereco;
    public static javax.swing.JButton bntDeletarTelaCadastraEndereco;
    public static javax.swing.JButton bntEditarTelaCadastraEndereco;
    private javax.swing.JComboBox<String> cboUflTelaCadastraEndereco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblBairrolTelaCadastraEndereco;
    private javax.swing.JLabel lblCamposObrigatoriosTelaCadastrarEndereco;
    private javax.swing.JLabel lblCepTelaCadastraEndereco;
    private javax.swing.JLabel lblCidadelTelaCadastraEndereco;
    private javax.swing.JLabel lblComplementolTelaCadastraEndereco;
    private javax.swing.JLabel lblRualTelaCadastraEndereco;
    private javax.swing.JLabel lblUfelTelaCadastraEndereco;
    public static javax.swing.JTable tblTelaCadastraEndereco;
    private javax.swing.JTextField txtBairrolTelaCadastraEndereco;
    public static javax.swing.JTextField txtCepTelaCadastraEndereco;
    private javax.swing.JTextField txtCidadelTelaCadastraEndereco;
    private javax.swing.JTextField txtComplementolTelaCadastraEndereco;
    private javax.swing.JTextField txtINumerolTelaCadastraEndereco;
    private javax.swing.JTextField txtIRualTelaCadastraEndereco;
    // End of variables declaration//GEN-END:variables
}
