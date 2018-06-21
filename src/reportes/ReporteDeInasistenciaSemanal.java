
package reportes;

import excepciones.*;
import dao.IServicioInasistencia;
import java.util.*;
import modelo.Inasistencia;
import org.joda.time.DateTime;

public abstract class ReporteDeInasistenciaSemanal {
    protected DateTime fechaDeIncio;
    protected DateTime fechaDeCorte;
    private List<Inasistencia> lunes = new ArrayList();
    private List<Inasistencia> martes = new ArrayList();
    private List<Inasistencia> miercoles = new ArrayList();
    private List<Inasistencia> jueves = new ArrayList();
    private List<Inasistencia> viernes = new ArrayList();
    private List<Inasistencia> listado;
    protected IServicioInasistencia servicio;
    
    public ReporteDeInasistenciaSemanal(Date fechaDeSolicitud) throws SinFechasException {
        if (fechaDeSolicitud == null) {
            throw new SinFechasException("Debe seleccionar una fecha por favor.");
        }
        this.fechaDeIncio = new DateTime(fechaDeSolicitud);
    }

    public void generar() throws FechaIncorrectaException, 
            SinInasistenciasException {
       if (fechaDeIncio.getDayOfWeek() != 1) {
           throw new FechaIncorrectaException("El día de la fecha de inicio debe ser un lunes.");
       }
       establecerFechaDeCorteComoViernes();
       
       listado = buscarInasistencias();
       if (listado.isEmpty()) {
           throw new SinInasistenciasException("No hay inasistencias en esta semana!");
       }
        agruparInasistencias(listado);
    }
    
    public void establecerFechaDeCorteComoViernes() {
        fechaDeCorte = fechaDeIncio.plusDays(4);
    }
    
    protected abstract List<Inasistencia> buscarInasistencias();
    
    private void agruparInasistencias(List<Inasistencia> lista) {
        for (Inasistencia i: lista) {
            porDia(i); 
        }
    }
    
    private void porDia(Inasistencia inasistencia) {
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
    
    public void setListado(List<Inasistencia> listado) {
        this.listado = listado;
    }
    
    public List<Inasistencia> getListado() {
        return listado;
    }
    
    public void setFechaDeCorte(DateTime fecha) {
        this.fechaDeCorte = fecha;
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