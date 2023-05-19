//13 de Agosto del 2021
//Miguel Angel Hernandez Orbe
//Programa que permite administrar el inventario y ventas de una tienda
//Practica #1 libre
package Tienda;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author MATIAS
 */
public class AbastecerInventario extends javax.swing.JFrame {

    /**
     * Creates new form Inventario
     */
    public AbastecerInventario() {
        initComponents();
        this.setLocationRelativeTo(null);
        OperacionesEnUnaTienda Ope=new OperacionesEnUnaTienda();
        Ope.ImagenAbastecer(EtiFondo);
        EtiSelección.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonCoca = new javax.swing.JButton();
        BotonLeche = new javax.swing.JButton();
        BotonValle = new javax.swing.JButton();
        BotonSabritas = new javax.swing.JButton();
        BotonDonitas = new javax.swing.JButton();
        BotonTakis = new javax.swing.JButton();
        EtiSeleccionar = new javax.swing.JLabel();
        EtiSelección = new javax.swing.JLabel();
        EtiIngrese = new javax.swing.JLabel();
        TextoCantidad = new javax.swing.JTextField();
        BotonInicio = new javax.swing.JButton();
        BotonVolver = new javax.swing.JButton();
        BotonRegistrar = new javax.swing.JButton();
        EtiFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reabastecer inventario");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonCoca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Coca.jpg"))); // NOI18N
        BotonCoca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCocaActionPerformed(evt);
            }
        });
        getContentPane().add(BotonCoca, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 13, 100, 180));

        BotonLeche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Leche.jpg"))); // NOI18N
        BotonLeche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLecheActionPerformed(evt);
            }
        });
        getContentPane().add(BotonLeche, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 100, 210));

        BotonValle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delvalle.jpg"))); // NOI18N
        BotonValle.setText("jButton3");
        BotonValle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonValleActionPerformed(evt);
            }
        });
        getContentPane().add(BotonValle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 100, 210));

        BotonSabritas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Sabritas.jpg"))); // NOI18N
        BotonSabritas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSabritasActionPerformed(evt);
            }
        });
        getContentPane().add(BotonSabritas, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 100, 180));

        BotonDonitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Donitas.jpg"))); // NOI18N
        BotonDonitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonDonitasActionPerformed(evt);
            }
        });
        getContentPane().add(BotonDonitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 100, 180));

        BotonTakis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Takis.jpg"))); // NOI18N
        BotonTakis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonTakisActionPerformed(evt);
            }
        });
        getContentPane().add(BotonTakis, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 100, 200));

        EtiSeleccionar.setText("Seleccione el producto");
        getContentPane().add(EtiSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, -1, -1));
        getContentPane().add(EtiSelección, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 130, 20));

        EtiIngrese.setText("Ingrese la cantidad");
        getContentPane().add(EtiIngrese, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 120, -1));

        TextoCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoCantidadActionPerformed(evt);
            }
        });
        TextoCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TextoCantidadKeyPressed(evt);
            }
        });
        getContentPane().add(TextoCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 160, -1));

        BotonInicio.setText("Inicio");
        BotonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInicioActionPerformed(evt);
            }
        });
        getContentPane().add(BotonInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, -1, -1));

        BotonVolver.setText("Volver");
        BotonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVolverActionPerformed(evt);
            }
        });
        getContentPane().add(BotonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, -1, -1));

        BotonRegistrar.setText("Registrar");
        BotonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(BotonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, -1));
        getContentPane().add(EtiFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonDonitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonDonitasActionPerformed
        // TODO add your handling code here:
        EtiSelección.setText("Donitas");
    }//GEN-LAST:event_BotonDonitasActionPerformed

    private void TextoCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoCantidadActionPerformed

    private void BotonCocaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCocaActionPerformed
        // TODO add your handling code here:
        EtiSelección.setText("Coca cola");
    }//GEN-LAST:event_BotonCocaActionPerformed

    private void BotonSabritasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSabritasActionPerformed
        // TODO add your handling code here:
        EtiSelección.setText("Sabritas");
    }//GEN-LAST:event_BotonSabritasActionPerformed

    private void BotonValleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonValleActionPerformed
        // TODO add your handling code here:
        EtiSelección.setText("Del valle");
    }//GEN-LAST:event_BotonValleActionPerformed

    private void BotonLecheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLecheActionPerformed
        // TODO add your handling code here:
        EtiSelección.setText("Leche alpura");
    }//GEN-LAST:event_BotonLecheActionPerformed

    private void BotonTakisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonTakisActionPerformed
        // TODO add your handling code here:
        EtiSelección.setText("Takis");
    }//GEN-LAST:event_BotonTakisActionPerformed

    private void TextoCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextoCantidadKeyPressed
        // TODO add your handling code here:
        if (evt.getExtendedKeyCode()==KeyEvent.VK_ENTER){
            if (EtiSelección.getText().equals("")||TextoCantidad.getText().equals("")){
         JOptionPane.showMessageDialog(null, "Ingrese todos los datos requeridos");
     }else{
        OperacionesEnUnaTienda Ope= new OperacionesEnUnaTienda();
        Ope.Abastecer(EtiSelección, TextoCantidad);}
        }
    }//GEN-LAST:event_TextoCantidadKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
                OperacionesEnUnaTienda Ope= new OperacionesEnUnaTienda();
        Ope.Solonumeros(TextoCantidad);
    }//GEN-LAST:event_formWindowOpened

    private void BotonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVolverActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Inventario().setVisible(true);
    }//GEN-LAST:event_BotonVolverActionPerformed

    private void BotonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInicioActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Inicio().setVisible(true);
    }//GEN-LAST:event_BotonInicioActionPerformed

    private void BotonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegistrarActionPerformed
        // TODO add your handling code here:
        if (EtiSelección.getText().equals("")||TextoCantidad.getText().equals("")){
         JOptionPane.showMessageDialog(null, "Ingrese todos los datos requeridos");
     }else{
        OperacionesEnUnaTienda Ope= new OperacionesEnUnaTienda();
        Ope.Abastecer(EtiSelección, TextoCantidad);}
    }//GEN-LAST:event_BotonRegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(AbastecerInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbastecerInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbastecerInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbastecerInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AbastecerInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCoca;
    private javax.swing.JButton BotonDonitas;
    private javax.swing.JButton BotonInicio;
    private javax.swing.JButton BotonLeche;
    private javax.swing.JButton BotonRegistrar;
    private javax.swing.JButton BotonSabritas;
    private javax.swing.JButton BotonTakis;
    private javax.swing.JButton BotonValle;
    private javax.swing.JButton BotonVolver;
    private javax.swing.JLabel EtiFondo;
    private javax.swing.JLabel EtiIngrese;
    private javax.swing.JLabel EtiSeleccionar;
    private javax.swing.JLabel EtiSelección;
    private javax.swing.JTextField TextoCantidad;
    // End of variables declaration//GEN-END:variables
}
