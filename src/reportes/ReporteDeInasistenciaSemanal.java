
package reportes;

import excepciones.*;
import dao.IServicioInasistencia;
import java.util.*;
import modelo.Inasistencia;
import org.joda.time.DateTime;

public class ReporteDeInasistenciaSemanal {
    private DateTime fechaDeIncio;
    private DateTime fechaDeCorte;
    private List<Inasistencia> lunes = new ArrayList();
    private List<Inasistencia> martes = new ArrayList();
    private List<Inasistencia> miercoles = new ArrayList();
    private List<Inasistencia> jueves = new ArrayList();
    private List<Inasistencia> viernes = new ArrayList();
    private List<Inasistencia> listado;
    private IServicioInasistencia servicio;
    
    public ReporteDeInasistenciaSemanal(DateTime fechaDeSolicitud) {
        this.fechaDeIncio = fechaDeSolicitud;
    }

    public void generar() throws FechaDeInicioIncorrecta, 
            SinInasistenciasException {
       if (fechaDeIncio.getDayOfWeek() != 1) {
           throw new FechaDeInicioIncorrecta("El día de la fecha de inicio debe ser un lunes.");
       }
       establecerFechaDeCorteComoViernes();
       
       listado = (List<Inasistencia>) 
               servicio.inasistenciasDurante(fechaDeIncio, fechaDeCorte);
       if (listado.isEmpty()) {
           throw new SinInasistenciasException("No hubo inasistencias en esta semana!");
       }
       for (Inasistencia i: listado) {
           agruparPorDia(i); 
       }
    }
    
    private void establecerFechaDeCorteComoViernes() {
        fechaDeCorte = fechaDeIncio.plusDays(4);
    }
    
    private void agruparPorDia(Inasistencia inasistencia) {
        switch (inasistencia.getDia().getDayOfWeek()) {
            case 1: lunes.add(inasistencia);
                break;
            case 2: martes.add(inasistencia);
                break;    
            case 3: miercoles.add(inasistencia);
                break;
            case 4: jueves.add(inasistencia);
                break;
            case 5: viernes.add(inasistencia);
                break;    
        }
    }
    
    public DateTime getFechaDeInicio() {
        return fechaDeIncio;
    }
    
    public DateTime getFechaDeCorte() {
        return fechaDeCorte;
    }
    
    public List<Inasistencia> listaDelDiaLunes() {
        return lunes;
    }
    
    public List<Inasistencia> listaDelDiaMartes() {
        return martes;
    }
    
    public List<Inasistencia> listaDelDiaMiercoles() {
        return miercoles;
    }
    
    public List<Inasistencia> listaDelDiaJueves() {
        return jueves;
    }
    
    public List<Inasistencia> listaDelDiaViernes() {
        return viernes;
    }

    public void setServicio(IServicioInasistencia servicio) {
        this.servicio = servicio;
    }   
}