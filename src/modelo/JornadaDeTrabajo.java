
package modelo;

import excepciones.*;
import java.util.*;
import org.joda.time.DateTime;

public class JornadaDeTrabajo extends Jornada {
     
    public JornadaDeTrabajo() {
        estado = EstadoDeJornada.SIN_INICIAR.Valor();
    }

    @Override
    public void iniciar() throws JornadaEnCursoException,
            JornadaCerradaException {
        
        if (estaEnCurso()) {
            throw new JornadaEnCursoException("Ya hay una jornada en curso! No puedes iniciar otra.");
        }  else if (estaCerrada()) {
            throw new JornadaCerradaException("No puedes iniciar más "
                    + "jornada en el día de hoy! Ya fue iniciada y cerrada una jornada.");
        }
        fecha = new DateTime();
        horaDeInicio = JornadaBuild.HoraActual();
        estado = EstadoDeJornada.EN_CURSO.Valor();
    }

    @Override
    public void cerrar() throws AsistenciaIncompletaException, 
            JornadaCerradaException,
            SinIniciarJornadaException {
        
        if (estaSinIniciar()) {
            throw new SinIniciarJornadaException("No haz iniciado una jornada");
        } else if (estaCerrada()) {
            throw new JornadaCerradaException("La jornada de hoy ya fue cerrada.");
        }
        List<Asistencia> listado = (List<Asistencia>) servicio.asistenciasDeHoy();
        for (Asistencia asistencia : listado) {
            if (!asistencia.estaSinFirmar() && !asistencia.estaMarcadaLaSalida()){
                
                throw new AsistenciaIncompletaException("Faltan empleados por marcar su salida");   
            }
        }
        
        horaDeCierre = JornadaBuild.HoraActual();
        estado = EstadoDeJornada.CERRADA.Valor();
    }
}