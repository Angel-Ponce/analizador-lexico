/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.awt.Desktop;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Angel
 */
public class Analizador extends javax.swing.JFrame {
    File tokens = new File("src/Files/Tokens.txt");
    Txt txtTokens = new Txt(tokens);
    File file = null;
    Txt txtFile = null;
    /**
     * Creates new form Analizador
     */
    public Analizador() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        sidebar = new javax.swing.JPanel();
        buttonOpenFile = new javax.swing.JButton();
        buttonViewReport = new javax.swing.JButton();
        buttonSaveReport = new javax.swing.JButton();
        buttonSeeTokens = new javax.swing.JButton();
        buttonAddToken = new javax.swing.JButton();
        buttonClearWindow = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buttonGitHub = new javax.swing.JButton();
        buttonViewMinimalReport = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        console = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setForeground(new java.awt.Color(255, 255, 255));

        sidebar.setBackground(new java.awt.Color(206, 240, 255));

        buttonOpenFile.setBackground(new java.awt.Color(51, 51, 51));
        buttonOpenFile.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonOpenFile.setForeground(new java.awt.Color(0, 0, 0));
        buttonOpenFile.setText("Abrir archivo");
        buttonOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpenFileActionPerformed(evt);
            }
        });

        buttonViewReport.setBackground(new java.awt.Color(51, 51, 51));
        buttonViewReport.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonViewReport.setForeground(new java.awt.Color(0, 0, 0));
        buttonViewReport.setText("Ver reporte");
        buttonViewReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewReportActionPerformed(evt);
            }
        });

        buttonSaveReport.setBackground(new java.awt.Color(51, 51, 51));
        buttonSaveReport.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonSaveReport.setForeground(new java.awt.Color(0, 0, 0));
        buttonSaveReport.setText("Guardar reporte");

        buttonSeeTokens.setBackground(new java.awt.Color(51, 51, 51));
        buttonSeeTokens.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonSeeTokens.setForeground(new java.awt.Color(0, 0, 0));
        buttonSeeTokens.setText("Ver tokens");
        buttonSeeTokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSeeTokensActionPerformed(evt);
            }
        });

        buttonAddToken.setBackground(new java.awt.Color(51, 51, 51));
        buttonAddToken.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonAddToken.setForeground(new java.awt.Color(0, 0, 0));
        buttonAddToken.setText("Agregar token");
        buttonAddToken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddTokenActionPerformed(evt);
            }
        });

        buttonClearWindow.setBackground(new java.awt.Color(51, 51, 51));
        buttonClearWindow.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonClearWindow.setForeground(new java.awt.Color(0, 0, 0));
        buttonClearWindow.setText("Limpiar");
        buttonClearWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearWindowActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("ANALIZADOR LÉXICO");

        buttonGitHub.setForeground(new java.awt.Color(0, 0, 0));
        buttonGitHub.setText("GitHub");
        buttonGitHub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGitHubActionPerformed(evt);
            }
        });

        buttonViewMinimalReport.setBackground(new java.awt.Color(51, 51, 51));
        buttonViewMinimalReport.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        buttonViewMinimalReport.setForeground(new java.awt.Color(0, 0, 0));
        buttonViewMinimalReport.setText("Ver repote minimo");
        buttonViewMinimalReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewMinimalReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidebarLayout = new javax.swing.GroupLayout(sidebar);
        sidebar.setLayout(sidebarLayout);
        sidebarLayout.setHorizontalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonGitHub)
                    .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonClearWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonAddToken, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonSeeTokens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonSaveReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonViewReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonOpenFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonViewMinimalReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        sidebarLayout.setVerticalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(buttonOpenFile)
                .addGap(18, 18, 18)
                .addComponent(buttonViewReport)
                .addGap(19, 19, 19)
                .addComponent(buttonViewMinimalReport)
                .addGap(18, 18, 18)
                .addComponent(buttonSaveReport)
                .addGap(18, 18, 18)
                .addComponent(buttonSeeTokens)
                .addGap(18, 18, 18)
                .addComponent(buttonAddToken)
                .addGap(18, 18, 18)
                .addComponent(buttonClearWindow)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(buttonGitHub)
                .addGap(17, 17, 17))
        );

        console.setColumns(20);
        console.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        console.setRows(5);
        jScrollPane1.setViewportView(console);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClearWindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearWindowActionPerformed
        console.setText("");
        this.file = null;
        this.txtFile = null;
    }//GEN-LAST:event_buttonClearWindowActionPerformed

    private void buttonOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpenFileActionPerformed
        JFileChooser open = new JFileChooser();
        open.setFileFilter( new FileNameExtensionFilter(".txt (hola inge)", "txt", "text"));
        open.showOpenDialog(this);
        console.setText("");
        File myFile = open.getSelectedFile();
        if(myFile != null){
            Txt file = new Txt(myFile);
            ArrayList<String> lines = file.getLines();
            lines.forEach((o)->console.append(o+"\n"));
            this.file = myFile;
            this.txtFile = file;
        }
        
    }//GEN-LAST:event_buttonOpenFileActionPerformed

    private void buttonGitHubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGitHubActionPerformed
        Desktop d = Desktop.getDesktop();
        try {
            d.browse(new URI("https://github.com/Angel-Ponce/analizador-lexico"));
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }//GEN-LAST:event_buttonGitHubActionPerformed

    private void buttonSeeTokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSeeTokensActionPerformed
        this.file = null;
        this.txtFile = null;
        ArrayList<String> lines = txtTokens.getLines();
        lines.forEach((String s) -> {
            console.append(s+"\n");
        });
    }//GEN-LAST:event_buttonSeeTokensActionPerformed

    private void buttonAddTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddTokenActionPerformed
      String newToken = JOptionPane.showInputDialog(null,"Ingrese el nuevo token");
      if(newToken != null){
        if(newToken.length()>0){
           txtTokens.addLine(newToken);
           JOptionPane.showMessageDialog(null, "Se agrego correctamente","Exito",JOptionPane.INFORMATION_MESSAGE);
           console.setText("");
        }else{
            JOptionPane.showMessageDialog(null,"No se ingreso un token valido","Error",JOptionPane.ERROR_MESSAGE);
        }   
      }
    }//GEN-LAST:event_buttonAddTokenActionPerformed

    private void buttonViewReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonViewReportActionPerformed
        if(this.file != null){
            ArrayList<String> t = txtTokens.getLines();
            String[] tokens = new String[t.size()];
            for(String s: t){
                tokens[t.indexOf(s)] = s;
            }
            console.setText("");
            Report report = new Report(this.file, this.txtFile,tokens);
            ArrayList<String> r = report.getReport();
            r.forEach((String e)->{
                console.append(e+"\n");
            });
         }else{
             JOptionPane.showMessageDialog(null, "No hay ningún archivo de texto para generar el reporte","Error",JOptionPane.ERROR_MESSAGE);
         }
    }//GEN-LAST:event_buttonViewReportActionPerformed

    private void buttonViewMinimalReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonViewMinimalReportActionPerformed
       
        if(this.file != null){
            ArrayList<String> t = txtTokens.getLines();
            String[] tokens = new String[t.size()];
            for(String s: t){
                tokens[t.indexOf(s)] = s;
            }
            
            console.setText("");
            Report report = new Report(this.file, this.txtFile);
            report.setTokens(tokens);
            ArrayList<String> r = report.getMinimalReport();
            r.forEach((String e)->{
                console.append(e+"\n");
            });
         }else{
             JOptionPane.showMessageDialog(null, "No hay ningún archivo de texto para generar el reporte","Error",JOptionPane.ERROR_MESSAGE);
         }
    }//GEN-LAST:event_buttonViewMinimalReportActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Analizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Analizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Analizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Analizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Analizador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddToken;
    private javax.swing.JButton buttonClearWindow;
    private javax.swing.JButton buttonGitHub;
    private javax.swing.JButton buttonOpenFile;
    private javax.swing.JButton buttonSaveReport;
    private javax.swing.JButton buttonSeeTokens;
    private javax.swing.JButton buttonViewMinimalReport;
    private javax.swing.JButton buttonViewReport;
    private javax.swing.JTextArea console;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel sidebar;
    // End of variables declaration//GEN-END:variables
}
