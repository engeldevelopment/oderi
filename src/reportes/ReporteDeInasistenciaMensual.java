
package reportes;

import dao.IServicioInasistencia;
import excepciones.SinInasistenciasException;
import java.util.*;
import modelo.Inasistencia;

public class ReporteDeInasistenciaMensual {
    
    private List<Inasistencia> listado;
    private IServicioInasistencia servicio;
    private String cedula;
    private int mes;
    private int year;

    public ReporteDeInasistenciaMensual(IServicioInasistencia servicio, String cedula, 
            int mes, int year) {
        this.servicio = servicio;
        this.cedula = cedula;
        this.mes = mes;
        this.year = year;
        this.listado = new ArrayList();
    }
    
    public void generar() throws SinInasistenciasException {
        listado = (List<Inasistencia>) 
                servicio.inasistenciasMensualDelEmpleado(cedula, mes, year);
        
        if (listado.isEmpty()) {
            throw new SinInasistenciasException("No tiene inasistencias en este mes!");
        }
    }
    
    public List<Inasistencia> getInasistencias() {
        return listado;
    }
}