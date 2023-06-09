package tpfinal.gestionar;

import Control.DataProyecto;
import Control.DataTarea;
import Modelo.Equipo;
import Modelo.EquipoMiembros;
import Modelo.Miembro;
import Modelo.Proyecto;
import Modelo.Tarea;
import java.time.LocalDate;
public class TPFinalGestionAR {

    public static void main(String[] args) {
        DataProyecto pr= new DataProyecto();
        DataTarea dt = new DataTarea();
        
        Proyecto proyecto = new Proyecto("proyecto1", "descripcion", LocalDate.now(), 1);
        
        Equipo equipo = new Equipo(proyecto, "equipo1", LocalDate.now(), 1);
        
        Miembro miembro = new Miembro(12345678, "apellido", "nombre", 1);
        
        EquipoMiembros equipoMiembros = new EquipoMiembros(equipo, miembro, LocalDate.now());
        
        Tarea tarea = new Tarea(equipoMiembros, "tarea1", LocalDate.now(), LocalDate.now(), 1);
        
        // Crear proyecto
        pr.guardarProyecto(new Proyecto("GestionAr","Tp final de lab",LocalDate.of(2001, 9, 19),3));
        
        // Consultar todos los proyectos
        System.out.println(pr.consultarProyectos());
        
        // Consultar todas las tareas
        System.out.println(dt.consultarTareas());
        
        // Asignar nueva tarea
        dt.guardarTarea(tarea);
        
        
    }

}
