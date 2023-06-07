package tpfinal.gestionar;

import Control.DataProyecto;
import Modelo.Proyecto;
import java.time.LocalDate;
public class TPFinalGestionAR {

    public static void main(String[] args) {
        DataProyecto pr= new DataProyecto();
        
        pr.guardarProyecto(new Proyecto("GestionAr","Tp final de lab",LocalDate.of(2001, 9, 19),3));
        
    }

}
