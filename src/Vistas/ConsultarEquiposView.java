/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Control.DataComentarios;
import Control.DataEquipo;
import Control.DataEquipoMiembros;
import Control.DataMiembro;
import Control.DataProyecto;
import Control.DataTarea;
import Modelo.Comentarios;
import Modelo.Equipo;
import Modelo.EquipoMiembros;
import Modelo.Miembro;
import Modelo.Proyecto;
import Modelo.Tarea;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Valentin
 */
public class ConsultarEquiposView extends javax.swing.JInternalFrame {

    DataEquipo dataequipo = new DataEquipo();
    Equipo equipo = null;
    DataMiembro datamiembro = new DataMiembro();
    Miembro miembro = null;
    DataProyecto dataproyecto = new DataProyecto();
    Proyecto proyecto = null;
    DataTarea datatarea = new DataTarea();
    Tarea tarea = null;
    DataEquipoMiembros dataequipomiembros = new DataEquipoMiembros();
    EquipoMiembros equipomiembros = null;
    DataComentarios datacomentario = new DataComentarios();
    Comentarios comentarios = null;
    private DefaultTableModel tabla = new DefaultTableModel();

    public ConsultarEquiposView() {
        initComponents();
        cargarEquipo();
        armarModelo();
        cargarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jcbEquipo = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();

        setTitle("Consultar Equipos");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Verdana", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Consultar Equipos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Seleccionar Equipo");

        jcbEquipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbEquipoItemStateChanged(evt);
            }
        });

        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtTabla);
        if (jtTabla.getColumnModel().getColumnCount() > 0) {
            jtTabla.getColumnModel().getColumn(0).setResizable(false);
            jtTabla.getColumnModel().getColumn(1).setResizable(false);
            jtTabla.getColumnModel().getColumn(2).setResizable(false);
            jtTabla.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbEquipo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(112, 112, 112))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jcbEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbEquipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbEquipoItemStateChanged
        // TODO add your handling code here:
        cargarTabla();
    }//GEN-LAST:event_jcbEquipoItemStateChanged
    private void cargarEquipo() {
        DefaultComboBoxModel<Equipo> cbox = new DefaultComboBoxModel();
        jcbEquipo.setModel(cbox);
        for (Equipo equip : dataequipo.listarEquipos()) {
            jcbEquipo.addItem(equip);
        }
    }

    private void armarModelo() {
        ArrayList titulos = new ArrayList();
        titulos.add("NOMBRE");
        titulos.add("APELLIDO");
        titulos.add("DNI");
        titulos.add("INCORPORADO");
        titulos.add("TAREA/s");
        for (Object titulo : titulos) {
            tabla.addColumn(titulo);
        }
        jtTabla.setModel(tabla);
    }

    private void cargarTabla() {
        tabla.setRowCount(0);
        for (EquipoMiembros em : dataequipomiembros.listarEquipoMiembrosPorEquipo(((Equipo) jcbEquipo.getSelectedItem()).getIdEquipo())) {
            List<Tarea> tareasMiembro = datatarea.consultarTareasPorEquipoyMiembro(((Equipo) jcbEquipo.getSelectedItem()).getIdEquipo(), em.getMiembro().getIdMiembro());
            String tareas = "";
            for (Tarea tarea : tareasMiembro) {
                tareas += tarea.getNombre() + "; ";
            }
            tabla.addRow(new Object[]{em.getMiembro().getNombre(), em.getMiembro().getApellido(), em.getMiembro().getDni(), em.getFechaIncorporacion(), tareas});
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<Equipo> jcbEquipo;
    private javax.swing.JTable jtTabla;
    // End of variables declaration//GEN-END:variables
}
