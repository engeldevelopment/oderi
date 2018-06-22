
package modelo;

import excepciones.*;
import dao.*;
import java.util.*;
import org.joda.time.DateTime;

public class JornadaDeTrabajo extends Jornada {
    
    private Long id;
    private GeneradorDeInasistencia generador;
   
    public JornadaDeTrabajo() {
        fecha = new DateTime();
        estado = EstadoDeJornada.SIN_INICIAR.Valor();
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    @Override
    public void iniciar() throws JornadaEnCursoException,
            JornadaCerradaException {
        
        if (estaEnCurso()) {
            throw new JornadaEnCursoException();
        }  else if (estaCerrada()) {
            throw new JornadaCerradaException();
        }
        
        horaDeInicio = JornadaBuild.HoraActual();
        estado = EstadoDeJornada.EN_CURSO.Valor();
    }

    @Override
    public void cerrar() throws AsistenciaIncompletaException {
        List<Asistencia> listado = (List<Asistencia>) servicio.asistenciasDeHoy();
        for (Asistencia asistencia : listado) {
            if (!asistencia.estaSinFirmar()){
                if (!asistencia.estaMarcadaLaSalida()){
                    throw new AsistenciaIncompletaException();
                }
            }
        }
        
        horaDeCierre = JornadaBuild.HoraActual();
        estado = EstadoDeJornada.CERRADA.Valor();
    }
}