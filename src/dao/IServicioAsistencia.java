
package dao;

import modelo.*;
import java.util.*;
import org.joda.time.DateTime;

public interface IServicioAsistencia extends IDAO<Asistencia>{
    public Collection<Asistencia> asistenciasDelMes(int mes, int year);
    public Collection<Asistencia> buscarAsistenciaDelEmpleado(String cedula);
    public Collection<Asistencia> asistenciasDeHoy();
    public Collection<Asistencia> asistenciasDelDia(DateTime fecha);
}
