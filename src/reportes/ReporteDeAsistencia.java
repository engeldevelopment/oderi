
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

    public void generar() throws FechaIncorrectaException, 
             SinFechasException {
        
        if (fechaDeConsulta == null){
            throw new SinFechasException("Seleccione una fecha por favor");
        } else if (fechaDeConsulta.equals(fechaActual)) {
            throw new FechaIncorrectaException("No puede seleccionar la fecha de hoy.");
        } else if (fechaDeConsulta.after(fechaActual)) {
            throw new FechaIncorrectaException("Para esta fecha aún no hay asistencias");
        }
        
        listado = (List<Asistencia>) servicio.asistenciasDelDia(new DateTime(fechaDeConsulta));
        
        if (listado.isEmpty()){
            throw new FechaIncorrectaException("No huvo actividad en este día.");
        }
    }
    
    public Date getFecha() {
        return fechaDeConsulta;
    }
    
    public List<Asistencia> getAsistencias() {
        return listado;
    }
}