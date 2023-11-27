/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TELAS;

import JDBC.ConnectionFactory;
import java.sql.*;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Gabriel
 */
public class Home extends javax.swing.JFrame {
    int idUser;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
   
    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        conexao = ConnectionFactory.Conector();
        PesquisarLivro();
    }
    
    private void PesquisarLivro(){
        String sql = "select * from livro where Nome like ? ORDER BY Nota_Media DESC";
        try {
            pst = conexao.prepareStatement(sql);
            //captura barra de pesquisa
            pst.setString(1,txtBusca.getText() + "%");
            rs = pst.executeQuery();
            //usando biblioteca rs2xml.jar para preencher a tabela.
            tbBuscas.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
        //avaliar Livro
    public void AvaliarLivro(){
            int setar = tbBuscas.getSelectedRow();
            String sql = "insert into Avaliacao(Nota,ID_Livro,ID_Usuario) values(?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1,Integer.parseInt(comNota.getSelectedItem().toString()));
            pst.setInt(2, Integer.parseInt(tbBuscas.getModel().getValueAt(setar,0).toString()));
            pst.setInt(3,idUser);
            //Valida se todos os campos estão preenchidos
            //Adiciona no banco de dados
            int adicionado = pst.executeUpdate();
            if (adicionado > 0){
                PesquisarLivro();
                JOptionPane.showMessageDialog(null, "Avaliacao Cadastrada!");
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) { // Código de erro para violação de chave única
                    JOptionPane.showMessageDialog(null,"Você já avaliou este livro!");
            } else {
                JOptionPane.showMessageDialog(null,e);
            }   
        }catch(Exception e){
            if(e.getMessage().equals("Index -1 out of bounds for length 10")){
                JOptionPane.showMessageDialog(null,"Selecione um Livro!");
            }else{
               JOptionPane.showMessageDialog(null,e); 
            }
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

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Desktop = new javax.swing.JDesktopPane();
        txtBusca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBuscas = new javax.swing.JTable();
        btnAvaliar = new javax.swing.JButton();
        comNota = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        menCad = new javax.swing.JMenu();
        menCadLiv = new javax.swing.JMenuItem();
        menCadUser = new javax.swing.JMenuItem();

        jLabel6.setText("Usuário");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Book Check");
        setPreferredSize(new java.awt.Dimension(1200, 800));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        Desktop.setBackground(new java.awt.Color(204, 204, 255));
        Desktop.setPreferredSize(new java.awt.Dimension(990, 691));

        txtBusca.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaActionPerformed(evt);
            }
        });
        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaKeyReleased(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/findUser.png"))); // NOI18N

        tbBuscas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbBuscas);

        btnAvaliar.setBackground(new java.awt.Color(204, 204, 255));
        btnAvaliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/avaliar.png"))); // NOI18N
        btnAvaliar.setToolTipText("AVALIAR");
        btnAvaliar.setBorderPainted(false);
        btnAvaliar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnAvaliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaliarActionPerformed(evt);
            }
        });

        comNota.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comNota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        Desktop.setLayer(txtBusca, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Desktop.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Desktop.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Desktop.setLayer(btnAvaliar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Desktop.setLayer(comNota, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopLayout.createSequentialGroup()
                .addGroup(DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DesktopLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(DesktopLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(0, 138, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(DesktopLayout.createSequentialGroup()
                .addGap(686, 686, 686)
                .addGroup(DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAvaliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopLayout.createSequentialGroup()
                .addGroup(DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DesktopLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DesktopLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5)))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAvaliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setName("Book Check"); // NOI18N

        lblUser.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblUser.setText("Usuário");

        lblData.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblData.setForeground(new java.awt.Color(51, 51, 255));
        lblData.setText("Data");

        jLabel4.setFont(new java.awt.Font("Vivaldi", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 102, 255));
        jLabel4.setText("Book Check");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblData)
                                    .addComponent(lblUser)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblData)
                .addGap(101, 101, 101)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(160, Short.MAX_VALUE))
        );

        menCad.setText("Cadastro");

        menCadLiv.setText("Livro");
        menCadLiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadLivActionPerformed(evt);
            }
        });
        menCad.add(menCadLiv);

        menCadUser.setText("Usuário");
        menCadUser.setEnabled(false);
        menCadUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadUserActionPerformed(evt);
            }
        });
        menCad.add(menCadUser);

        Menu.add(menCad);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(363, 363, 363)
                .addComponent(jLabel1)
                .addGap(265, 265, 265))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1)
                .addGap(225, 225, 225)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1280, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       // Substitui o Texto da lblData pela data atual
       Date data = new Date();
       DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
       lblData.setText(formatador.format(data));
    }//GEN-LAST:event_formWindowActivated

    private void menCadUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadUserActionPerformed
        // Acessar Formulário Usuário no DesktopPane
        Usuario usuarioForm = new Usuario();
        usuarioForm.setVisible(true);
        Desktop.add(usuarioForm);
    }//GEN-LAST:event_menCadUserActionPerformed

    private void menCadLivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadLivActionPerformed
        Livro livroForm = new Livro();
        livroForm.setVisible(true);
        Desktop.add(livroForm);
    }//GEN-LAST:event_menCadLivActionPerformed

    private void txtBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaActionPerformed

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased
        //Evento de quando digita algo
        PesquisarLivro();
    }//GEN-LAST:event_txtBuscaKeyReleased

    private void btnAvaliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaliarActionPerformed
        //Comando Avalia
        AvaliarLivro();
    }//GEN-LAST:event_btnAvaliarActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JButton btnAvaliar;
    private javax.swing.JComboBox<String> comNota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblData;
    public static javax.swing.JLabel lblUser;
    private javax.swing.JMenu menCad;
    private javax.swing.JMenuItem menCadLiv;
    public static javax.swing.JMenuItem menCadUser;
    private javax.swing.JTable tbBuscas;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
