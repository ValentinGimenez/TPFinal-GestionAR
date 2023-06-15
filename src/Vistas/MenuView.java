/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import javax.swing.JInternalFrame;

/**
 *
 * @author Valentin
 */
public class MenuView extends javax.swing.JFrame {

    /**
     * Creates new form MenuView
     *
     * @param ventana
     */
    public void centrar(JInternalFrame ventana) {
        int x = (jDesktopPane1.getWidth() / 2) - ventana.getWidth() / 2;
        int y = (jDesktopPane1.getHeight() / 2) - ventana.getHeight() / 2;
        if (ventana.isShowing()) {
            ventana.setLocation(x, y);
        } else {
            ventana.setVisible(true);
            jDesktopPane1.add(ventana);
            ventana.setLocation(x, y);
        }
    }

    public MenuView() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jmCrearProyecto = new javax.swing.JMenuItem();
        jmConsultarProyecto = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jmCrearEquipo = new javax.swing.JMenuItem();
        jmAsignarMiembro = new javax.swing.JMenuItem();
        jmConsultarEquipo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmCrearMiembro = new javax.swing.JMenuItem();
        jmActualizarEstado = new javax.swing.JMenu();
        jmAsignarTarea = new javax.swing.JMenuItem();
        jmActualizarTarea = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GestionAR");

        jDesktopPane1.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        jMenu6.setText("Proyecto");

        jmCrearProyecto.setText("Crear Proyecto");
        jmCrearProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCrearProyectoActionPerformed(evt);
            }
        });
        jMenu6.add(jmCrearProyecto);

        jmConsultarProyecto.setText("Consultar Proyecto");
        jmConsultarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmConsultarProyectoActionPerformed(evt);
            }
        });
        jMenu6.add(jmConsultarProyecto);

        jMenuBar2.add(jMenu6);

        jMenu1.setText("Equipo");

        jmCrearEquipo.setText("Crear Equipo");
        jmCrearEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCrearEquipoActionPerformed(evt);
            }
        });
        jMenu1.add(jmCrearEquipo);

        jmAsignarMiembro.setText("Asignar Miembro");
        jmAsignarMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAsignarMiembroActionPerformed(evt);
            }
        });
        jMenu1.add(jmAsignarMiembro);

        jmConsultarEquipo.setText("Consultar Equipos");
        jmConsultarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmConsultarEquipoActionPerformed(evt);
            }
        });
        jMenu1.add(jmConsultarEquipo);

        jMenuBar2.add(jMenu1);

        jMenu2.setText("Miembro");

        jmCrearMiembro.setText("Crear Miembro");
        jmCrearMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCrearMiembroActionPerformed(evt);
            }
        });
        jMenu2.add(jmCrearMiembro);

        jMenuBar2.add(jMenu2);

        jmActualizarEstado.setText("Tarea");

        jmAsignarTarea.setText("Asignar Tarea");
        jmAsignarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAsignarTareaActionPerformed(evt);
            }
        });
        jmActualizarEstado.add(jmAsignarTarea);

        jmActualizarTarea.setText("Actualizar Tarea");
        jmActualizarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmActualizarTareaActionPerformed(evt);
            }
        });
        jmActualizarEstado.add(jmActualizarTarea);

        jMenuBar2.add(jmActualizarEstado);

        jMenu3.setText("Salir");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmCrearProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCrearProyectoActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        CrearProyectoView cpv = new CrearProyectoView();
        centrar(cpv);
    }//GEN-LAST:event_jmCrearProyectoActionPerformed

    private void jmActualizarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmActualizarTareaActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        ActualizarTareaView actv = new ActualizarTareaView();
        centrar(actv);
    }//GEN-LAST:event_jmActualizarTareaActionPerformed

    private void jmConsultarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmConsultarProyectoActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        ConsultarProyectosView cpsv = new ConsultarProyectosView();
        centrar(cpsv);
    }//GEN-LAST:event_jmConsultarProyectoActionPerformed

    private void jmCrearEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCrearEquipoActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        CrearEquipoView cev = new CrearEquipoView();
        centrar(cev);
    }//GEN-LAST:event_jmCrearEquipoActionPerformed

    private void jmCrearMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCrearMiembroActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        CrearMiembroView cmv = new CrearMiembroView();
        centrar(cmv);
    }//GEN-LAST:event_jmCrearMiembroActionPerformed

    private void jmAsignarMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAsignarMiembroActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        AsignarMiembroView amv = new AsignarMiembroView();
        centrar(amv);
    }//GEN-LAST:event_jmAsignarMiembroActionPerformed

    private void jmAsignarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAsignarTareaActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        AsignarTareaView atv = new AsignarTareaView();
        centrar(atv);
    }//GEN-LAST:event_jmAsignarTareaActionPerformed

    private void jmConsultarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmConsultarEquipoActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        ConsultarEquiposView cev = new ConsultarEquiposView();
        centrar(cev);
    }//GEN-LAST:event_jmConsultarEquipoActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenu3ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu jmActualizarEstado;
    private javax.swing.JMenuItem jmActualizarTarea;
    private javax.swing.JMenuItem jmAsignarMiembro;
    private javax.swing.JMenuItem jmAsignarTarea;
    private javax.swing.JMenuItem jmConsultarEquipo;
    private javax.swing.JMenuItem jmConsultarProyecto;
    private javax.swing.JMenuItem jmCrearEquipo;
    private javax.swing.JMenuItem jmCrearMiembro;
    private javax.swing.JMenuItem jmCrearProyecto;
    // End of variables declaration//GEN-END:variables
}
