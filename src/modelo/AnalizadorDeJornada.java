
package modelo;

import excepciones.AsistenciaIncompletaException;
import excepciones.JornadaCerradaException;
import java.util.*;
import org.joda.time.DateTime;

public class AnalizadorDeJornada {
    
    private List<Jornada> jornadas;
    private DateTime fechaActual;
    
    public AnalizadorDeJornada(List<Jornada> jornadas, DateTime fechaDeAnalisis) {
        this.jornadas = jornadas;
        this.fechaActual = fechaDeAnalisis;
    }

    public void analizar() throws AsistenciaIncompletaException, JornadaCerradaException {
        for (Jornada jornada : jornadas) {
            if (jornada.estaEnCurso() && jornada.getFecha().isBefore(fechaActual)) {
                jornada.cerrar();
            }
        }
    }
}
