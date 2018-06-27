
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hieu bach
 */
public class find extends javax.swing.JDialog {

    /**
     * Creates new form File
     */
    boolean isUp = true;
    boolean isDown = false;
    boolean isAll = false;
    MTE parent;

    public find(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.parent = (MTE) parent;

        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        btFindNext = new javax.swing.JButton();
        btAll = new javax.swing.JButton();
        btUp = new javax.swing.JRadioButton();
        btDown = new javax.swing.JRadioButton();
        btMatch = new javax.swing.JCheckBox();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Find");

        txtFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtFindMousePressed(evt);
            }
        });
        txtFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindActionPerformed(evt);
            }
        });
        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFindKeyPressed(evt);
            }
        });

        btFindNext.setText("Find next");
        btFindNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFindNextActionPerformed(evt);
            }
        });

        btAll.setText("Find All");
        btAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAllActionPerformed(evt);
            }
        });

        buttonGroup1.add(btUp);
        btUp.setSelected(true);
        btUp.setText("Up");

        buttonGroup1.add(btDown);
        btDown.setText("Down");

        btMatch.setText("Match Case");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btFindNext)
                                .addGap(61, 61, 61)
                                .addComponent(btAll)))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btDown)
                            .addComponent(btUp)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btMatch)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btUp)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btFindNext)
                            .addComponent(btAll)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btDown)))
                .addGap(18, 18, 18)
                .addComponent(btMatch)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFindNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFindNextActionPerformed
        // TODO add your handling code here:
       
        String textFind = txtFind.getText();
        String temp = textFind.trim();
        if (temp.length() != 0) {
            if (btUp.isSelected()) {
                isUp = true;
                isDown = false;
                isAll = false;
                parent.HighLightWord(isUp, isDown, isAll, textFind,btMatch.isSelected());
            }
            if (btDown.isSelected()) {
                isUp = false;
                isDown = true;
                isAll = false;
                parent.HighLightWord(isUp, isDown, isAll, textFind,btMatch.isSelected());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please input first");
        }
    }//GEN-LAST:event_btFindNextActionPerformed

    private void btAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAllActionPerformed
        // TODO add your handling code here:

        String textFind = txtFind.getText();
        String temp = textFind.trim();
        if (temp.length() != 0) {
            isUp = false;
            isDown = false;
            isAll = true;
            parent.HighLightWord(isUp, isDown, isAll, textFind,btMatch.isSelected());
        } else {
            JOptionPane.showMessageDialog(null, "Please input first");
        }

    }//GEN-LAST:event_btAllActionPerformed

    private void txtFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtFindActionPerformed

    private void txtFindMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFindMousePressed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_txtFindMousePressed

    private void txtFindKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyPressed
        // TODO add your handling code here:
         parent.getPosition();
        System.out.println("set pos");
    }//GEN-LAST:event_txtFindKeyPressed

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
            java.util.logging.Logger.getLogger(find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                find dialog = new find(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAll;
    private javax.swing.JRadioButton btDown;
    private javax.swing.JButton btFindNext;
    private javax.swing.JCheckBox btMatch;
    private javax.swing.JRadioButton btUp;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JTextField txtFind;
    // End of variables declaration//GEN-END:variables
}
