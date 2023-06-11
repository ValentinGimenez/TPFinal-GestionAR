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
        DataProyecto pr = new DataProyecto();
        DataTarea dt = new DataTarea();
        DataEquipo de = new DataEquipo();
        DataMiembro dm = new DataMiembro();
        DataEquipoMiembros dem = new DataEquipoMiembros();
        DataComentarios dc = new DataComentarios();

        // Crear proyecto;
        Proyecto proyecto = new Proyecto("GestionAR ", "Proyecto Final de Lab1", LocalDate.now(), 1);
        pr.guardarProyecto(proyecto);

        // Consultar todos los proyectos
        System.out.println(pr.consultarProyectos());

        // Asignar equipo
        Equipo equipo = new Equipo(proyecto, "Grupo 7", LocalDate.now(), 1);
        de.guardarEquipo(equipo);

        //Asignar miembro
        Miembro miembro = new Miembro(43764888, "Gimenez", "Valentin", 1);
        dm.guardarMiembro(miembro);

        //Buscar miembro por dni
        dm.buscarMiembroPorDNI(43764888);

        //Asignar equipo miembros
        EquipoMiembros equipoMiembros = new EquipoMiembros(equipo, miembro, LocalDate.now());
        dem.guardarEquipoMiembros(equipoMiembros);

        // Asignar tarea
        Tarea tarea = new Tarea(equipoMiembros, "Entrega 2", LocalDate.now(), LocalDate.now(), 1);
        dt.guardarTarea(tarea);

        //Se modifico la Tarea
        dt.actualizarEstadoTarea(1, 3);

        // Consultar todas las tareas
        System.out.println(dt.consultarTareas());

        // Asignar comentario
        Comentarios comentarios = new Comentarios(tarea, "Se finalizo la Entrega 2", LocalDate.now());
        dc.guardarComentario(comentarios);

        //Consultar miembros por id equipo
        System.out.println(dem.consultarMiembrosPorIdEquipo(5));

    }

}
