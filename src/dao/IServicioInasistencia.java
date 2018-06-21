
package dao;

import modelo.Inasistencia;
import java.util.Collection;
import org.joda.time.DateTime;

public interface IServicioInasistencia extends IDAO<Inasistencia>{
    public Collection<Inasistencia> inasistenciasDeHoy();
    public Collection<Inasistencia> inasistenciasDurante(DateTime inicio, DateTime fin);
    public Collection<Inasistencia> inasistenciasDeEmpleadoDurante(String cedula, DateTime inicio, DateTime fin);
    public Collection<Inasistencia> inasistenciasMensualDelEmpleado(String cedula, int mes, int year);
}
