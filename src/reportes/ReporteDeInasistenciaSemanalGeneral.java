
package reportes;

import excepciones.SinFechasException;
import java.util.Date;
import java.util.List;
import modelo.Inasistencia;

public class ReporteDeInasistenciaSemanalGeneral extends ReporteDeInasistenciaSemanal {

    public ReporteDeInasistenciaSemanalGeneral(Date fechaDeSolicitud) throws SinFechasException {
        super(fechaDeSolicitud);
    }

    @Override
    protected List<Inasistencia> buscarInasistencias() {
        return (List<Inasistencia>) 
               servicio.inasistenciasDurante(fechaDeIncio.plusDays(-1), fechaDeCorte);
    }
    
}
