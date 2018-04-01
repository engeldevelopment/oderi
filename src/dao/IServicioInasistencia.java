
package dao;

import modelo.Inasistencia;
import java.util.Collection;
import java.util.Date;

public interface IServicioInasistencia extends IDAO<Inasistencia>{
    public Collection<Inasistencia> inasistenciasDeHoy();
    public Collection<Inasistencia> inasistenciasDurante(Date inicio, Date fin);
    public Collection<Inasistencia> inasistenciasMensualDelEmpleado(String cedula, int mes, int year);
}
