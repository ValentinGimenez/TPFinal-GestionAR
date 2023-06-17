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
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jmCrearEquipo = new javax.swing.JMenuItem();
        jmAsignarMiembro = new javax.swing.JMenuItem();
        jmConsultarEquipo = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmCrearMiembro = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jmActualizarEstado = new javax.swing.JMenu();
        jmAsignarTarea = new javax.swing.JMenuItem();
        jmRegistrarAvances = new javax.swing.JMenuItem();
        jmConsultarAvance = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

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

        jMenuItem2.setText("Modificar Proyecto");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem2);

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

        jMenuItem4.setText("Modificar Equipo");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar2.add(jMenu1);

        jMenu2.setText("Miembro");

        jmCrearMiembro.setText("Crear Miembro");
        jmCrearMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCrearMiembroActionPerformed(evt);
            }
        });
        jMenu2.add(jmCrearMiembro);

        jMenuItem3.setText("Modificar Miembro");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar2.add(jMenu2);

        jmActualizarEstado.setText("Tarea");

        jmAsignarTarea.setText("Asignar Tarea");
        jmAsignarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAsignarTareaActionPerformed(evt);
            }
        });
        jmActualizarEstado.add(jmAsignarTarea);

        jmRegistrarAvances.setText("Registrar Avances");
        jmRegistrarAvances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRegistrarAvancesActionPerformed(evt);
            }
        });
        jmActualizarEstado.add(jmRegistrarAvances);

        jmConsultarAvance.setText("Consultar Avances");
        jmConsultarAvance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmConsultarAvanceActionPerformed(evt);
            }
        });
        jmActualizarEstado.add(jmConsultarAvance);

        jMenuItem1.setText("Modificar Tarea");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmActualizarEstado.add(jMenuItem1);

        jMenuBar2.add(jmActualizarEstado);

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

    private void jmRegistrarAvancesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmRegistrarAvancesActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        RegistrarAvancesTareaView actv = new RegistrarAvancesTareaView();
        centrar(actv);
    }//GEN-LAST:event_jmRegistrarAvancesActionPerformed

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

    private void jmConsultarAvanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmConsultarAvanceActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        ConsultarAvancesTareaView catv = new ConsultarAvancesTareaView();
        centrar(catv);
    }//GEN-LAST:event_jmConsultarAvanceActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        ModificarTareaView mtv = new ModificarTareaView();
        centrar(mtv);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        ModificarProyectoView mpw = new ModificarProyectoView();
        centrar(mpw);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        ModificarMiembroView mvw = new ModificarMiembroView();
        centrar(mvw);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        ModificarEquipoView mev = new ModificarEquipoView();
        centrar(mev);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenu jmActualizarEstado;
    private javax.swing.JMenuItem jmAsignarMiembro;
    private javax.swing.JMenuItem jmAsignarTarea;
    private javax.swing.JMenuItem jmConsultarAvance;
    private javax.swing.JMenuItem jmConsultarEquipo;
    private javax.swing.JMenuItem jmConsultarProyecto;
    private javax.swing.JMenuItem jmCrearEquipo;
    private javax.swing.JMenuItem jmCrearMiembro;
    private javax.swing.JMenuItem jmCrearProyecto;
    private javax.swing.JMenuItem jmRegistrarAvances;
    // End of variables declaration//GEN-END:variables
}
