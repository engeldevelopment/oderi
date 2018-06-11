
package reportes;

import excepciones.*;
import dao.IServicioAsistencia;
import java.util.*;
import modelo.Asistencia;
import org.joda.time.DateTime;

public class ReporteDeAsistencia {
    
    private Date fechaDeConsulta;
    private Date fechaActual;
    private IServicioAsistencia servicio;
    private List<Asistencia> listado;
    
    public ReporteDeAsistencia(Date fechaDeConsulta, Date fechaActual) {
        this.fechaDeConsulta = fechaDeConsulta;
        this.fechaActual = fechaActual;
    }
    
    public void setServicio(IServicioAsistencia servicio) {
        this.servicio = servicio;
    }

    public void generar() throws FechaAcualException, 
            FechaPosteriorException, SinFechasException, FechaSinActividad {
        
        if (fechaDeConsulta == null){
            throw new SinFechasException();
        } else if (fechaDeConsulta.equals(fechaActual)) {
            throw new FechaAcualException();
        } else if (fechaDeConsulta.after(fechaActual)) {
            throw new FechaPosteriorException();
        }
        
        listado = (List<Asistencia>) servicio.asistenciasDelDia(new DateTime(fechaDeConsulta));
        
        if (listado.isEmpty()){
            throw new FechaSinActividad();
        }
    }
    
    public Date getFecha() {
        return fechaDeConsulta;
    }
    
    public List<Asistencia> getAsistencias() {
        return listado;
    }
}