/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package TELAS;

/**
 *
 * @author Gabriel
 */
import java.sql.*;
import JDBC.ConnectionFactory;
import javax.swing.JOptionPane;

public class Usuario extends javax.swing.JInternalFrame {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form Usuario
     */
    public Usuario() {
        initComponents();
        conexao = ConnectionFactory.Conector();
    }
    private void adicionar(){
        String sql = "insert into usuario(ADM,Genero,Idade,Nome_Usuario,senha) values(?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setBoolean(1, ckUsuAdm.isSelected());
            pst.setString(2, comUsuGenero.getSelectedItem().toString().toUpperCase());
            pst.setString(3, txtUsuIdade.getText().toUpperCase());
            pst.setString(4, txtUsuNome.getText().toUpperCase());
            pst.setString(5,txtUsuSenha.getText().toUpperCase());
            //Valida se todos os campos estão preenchidos
            if((txtUsuIdade.getText().isEmpty()) || (txtUsuNome.getText().isEmpty()) || (txtUsuSenha.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Preencha todos os Campos!");
            }else{
                //Adiciona no banco de dados
                int adicionado = pst.executeUpdate();
                if (adicionado > 0){
                    JOptionPane.showMessageDialog(null, "Usuário Cadastrado");
                }
                ckUsuAdm.setSelected(false);
                txtUsuIdade.setText(null);
                txtUsuIdade.setText(null);
                txtUsuNome.setText(null);
                txtUsuSenha.setText(null);
            }
        } catch(SQLException e){
            if (e.getErrorCode() == 1062) { // Código de erro para violação de chave única
                    JOptionPane.showMessageDialog(null,"Nome de Usuário já Cadastrado!");
            } else {
                JOptionPane.showMessageDialog(null,e);
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        txtEmail1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ckUsuAdm = new javax.swing.JCheckBox();
        txtUsuSenha = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtUsuIdade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtUsuNome = new javax.swing.JTextField();
        btnUsuCad = new javax.swing.JButton();
        comUsuGenero = new javax.swing.JComboBox<>();

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("E-mail:");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastrar Usuários");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(979, 689));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Cadastro Usuário");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("ADM:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Senha:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Gênero:");

        ckUsuAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckUsuAdmActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Idade:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Nome:");

        txtUsuNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuNomeActionPerformed(evt);
            }
        });

        btnUsuCad.setBackground(new java.awt.Color(204, 204, 255));
        btnUsuCad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUsuCad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/adicionarUser.png"))); // NOI18N
        btnUsuCad.setToolTipText("ADICIONAR");
        btnUsuCad.setBorderPainted(false);
        btnUsuCad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuCad.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsuCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuCadActionPerformed(evt);
            }
        });

        comUsuGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", "Outro" }));
        comUsuGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comUsuGeneroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtUsuSenha)
                            .addComponent(txtUsuIdade, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comUsuGenero, 0, 321, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ckUsuAdm)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(394, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(380, 380, 380))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnUsuCad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(441, 441, 441))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(121, 121, 121)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsuNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtUsuIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtUsuSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(comUsuGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(ckUsuAdm))
                .addGap(64, 64, 64)
                .addComponent(btnUsuCad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
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

        setBounds(0, 0, 979, 689);
    }// </editor-fold>//GEN-END:initComponents

    private void ckUsuAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckUsuAdmActionPerformed
        //
    }//GEN-LAST:event_ckUsuAdmActionPerformed

    private void txtUsuNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuNomeActionPerformed

    private void btnUsuCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuCadActionPerformed
        adicionar();
    }//GEN-LAST:event_btnUsuCadActionPerformed

    private void comUsuGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comUsuGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comUsuGeneroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUsuCad;
    private javax.swing.JCheckBox ckUsuAdm;
    private javax.swing.JComboBox<String> comUsuGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtUsuIdade;
    private javax.swing.JTextField txtUsuNome;
    private javax.swing.JTextField txtUsuSenha;
    // End of variables declaration//GEN-END:variables
}
