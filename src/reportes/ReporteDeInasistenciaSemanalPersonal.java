
package reportes;

import excepciones.SinFechasException;
import java.util.*;
import modelo.Inasistencia;

public class ReporteDeInasistenciaSemanalPersonal extends ReporteDeInasistenciaSemanal {
    private String cedula;
    
    public ReporteDeInasistenciaSemanalPersonal(Date fechaDeSolicitud, String cedula) 
            throws SinFechasException {
        super(fechaDeSolicitud);
        this.cedula = cedula;
    }

    @Override
    protected List<Inasistencia> buscarInasistencias() {
         return (List<Inasistencia>)
               servicio.inasistenciasDeEmpleadoDurante(cedula, 
                       fechaDeIncio.plusDays(-1), fechaDeCorte);
    }    
}