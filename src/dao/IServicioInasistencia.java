
package dao;

import modelo.Inasistencia;
import java.util.Collection;
import java.util.Date;
import org.joda.time.DateTime;

public interface IServicioInasistencia extends IDAO<Inasistencia>{
    public Collection<Inasistencia> inasistenciasDeHoy();
    public Collection<Inasistencia> inasistenciasDurante(DateTime inicio, DateTime fin);
    public Collection<Inasistencia> inasistenciasMensualDelEmpleado(String cedula, int mes, int year);
}
