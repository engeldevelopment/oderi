
package modelo;

import excepciones.*;
import dao.*;

public class RelacionDeAsistencia {
    
    private Jornada jornada;
    private IServicioInasistencia servicio;
    
    public RelacionDeAsistencia(Jornada jornada) {
        this.jornada = jornada;
    }

    public RelacionDeAsistencia(Jornada jornada, InasistenciaDAO servicio) {
        this.jornada = jornada;
        this.servicio = servicio;
    }

    public void imprimir() throws SinIniciarJornadaException, 
            JornadaEnCursoException {
        if (jornada.estaSinIniciar()) {
            throw new SinIniciarJornadaException();
        } else if (jornada.estaEnCurso()) {
            throw new JornadaEnCursoException();
        }        
    }   
}