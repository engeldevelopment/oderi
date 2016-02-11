
package modelo;

import excepciones.*;
import dao.*;
import java.util.*;
import org.joda.time.DateTime;

public class JornadaDeTrabajo extends Jornada {
    
    private Long id;
    private List<Empleado> empleados;
    private GeneradorDeInasistencia generador;
    
    public JornadaDeTrabajo(List<Empleado> empleados, IServicioAsistencia servicio) {
        fecha = new DateTime();
        this.empleados = empleados;
        this.servicio = servicio;
        estado = EstadoDeJornada.SIN_INICIAR.Valor();
    }
    
    public JornadaDeTrabajo() {
        estado = EstadoDeJornada.SIN_INICIAR.Valor();
    }

    public JornadaDeTrabajo(IServicioAsistencia servicio) {
        this.servicio = servicio;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    @Override
    public void iniciar() throws JornadaEnCursoException,
            NoHayEmpleadoException,
            JornadaCerradaException {
        if (estaEnCurso()) {
            throw new JornadaEnCursoException();
        } else if (noHayEmpleadosRegistrados()) {
            throw new NoHayEmpleadoException();
        } else if (estaCerrada()) {
            throw new JornadaCerradaException();
        }
        for (Empleado alEmpleado : empleados) {
             agregarALaListaDeAsistencia(alEmpleado);      
        }
        horaDeInicio = JornadaBuild.HoraActual();
        estado = EstadoDeJornada.EN_CURSO.Valor();
    }
    
    private boolean noHayEmpleadosRegistrados() {
        return empleados.isEmpty() == true;
    }
        
    private void agregarALaListaDeAsistencia(Empleado empleado) {
        Asistencia asistencia = new Asistencia(empleado, 
                    AsistenciaBuild.fechaActual());
            servicio.guardar(asistencia);
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
