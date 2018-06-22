
package reportes;

import dao.IServicioInasistencia;
import excepciones.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Inasistencia;
import modelo.Jornada;

public class ReporteDeInasistenciaDiaria {
    private IServicioInasistencia servicio;
    private Jornada jornada;
    private List<Inasistencia> listado = new ArrayList();
    
    public ReporteDeInasistenciaDiaria(IServicioInasistencia servicio, Jornada jornada) {
        this.servicio = servicio;
        this.jornada = jornada;
    }
    
    public void generar() throws SinIniciarJornadaException, 
            JornadaEnCursoException,
            SinInasistenciasException {
       
        if (jornada.estaSinIniciar()) {
            throw new SinIniciarJornadaException("Debe haber una jornada "
                    + "iniciada y cerrada para poder ver el reporte.");
        } else if (jornada.estaEnCurso()) {
            throw new JornadaEnCursoException("Debes cerrar la jornada para poder ver el reporte.");
        }
        
        listado = (List<Inasistencia>) servicio.inasistenciasDeHoy();
        
        if (listado.isEmpty())  {
            throw  new SinInasistenciasException("No hubo inasistencias.");
        }
    }
    
    public List<Inasistencia> getListado() {
        return listado;
    }
}