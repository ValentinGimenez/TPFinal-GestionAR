package tpfinal.gestionar;

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
public class TPFinalGestionAR {

    public static void main(String[] args) {
        DataProyecto pr= new DataProyecto();
        DataTarea dt = new DataTarea();
        DataEquipo de = new DataEquipo();
        DataMiembro dm = new DataMiembro();
        DataEquipoMiembros dem = new DataEquipoMiembros();
        DataComentarios dc = new DataComentarios();
        
        Proyecto proyecto = new Proyecto("proyecto1", "descripcion", LocalDate.now(), 1);
        
        Equipo equipo = new Equipo(proyecto, "equipo1", LocalDate.now(), 1);
        
        Miembro miembro = new Miembro(12, "apellido", "nombre", 1);
        
        EquipoMiembros equipoMiembros = new EquipoMiembros(equipo, miembro, LocalDate.now());
        
        Tarea tarea = new Tarea(equipoMiembros, "tarea1", LocalDate.now(), LocalDate.now(), 1);
        
        Comentarios comentarios = new Comentarios(tarea, "Se avanzo", LocalDate.now());
        
        // Crear proyecto
        //pr.guardarProyecto(new Proyecto("GestionAr","Tp final de lab",LocalDate.of(2001, 9, 19),3));
        //pr.guardarProyecto(proyecto);
        
        // Consultar todos los proyectos
        System.out.println(pr.consultarProyectos());
        
        // Consultar todas las tareas
        System.out.println(dt.consultarTareas());
        
        // Asignar nueva tarea
        //de.guardarEquipo(equipo);
        //dm.guardarMiembro(miembro);
        
        //dem.guardarEquipoMiembros(equipoMiembros);
        
        //dt.guardarTarea(tarea);
        //dt.modificarTarea(1, 9);
        //dc.guardarComentario(comentarios);
        
        //Consultar miembros por id equipo
        System.out.println(dem.consultarMiembrosPorIdEquipo(5));
        
        
    }

}
