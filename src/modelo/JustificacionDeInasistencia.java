
package modelo;

import excepciones.*;
import dao.*;
import org.joda.time.*;

public class JustificacionDeInasistencia {
    
    private Inasistencia inasistencia;
    private DateTime fechaActual;
    private IServicioInasistencia servicio;
    
    public JustificacionDeInasistencia(Inasistencia inasistencia, 
            DateTime fechaActual, IServicioInasistencia servicio) {
        
        this.inasistencia = inasistencia;
        this.fechaActual = fechaActual;
        this.servicio = servicio;
    }
   
    public void Justificar(String descripcion) throws TiempoDeJustificacionCaducadoException, 
            InasistenciaJustificadaException {
        
        if (inasistencia.estaJustificada()){
            throw new InasistenciaJustificadaException();
        } else if (tieneMasDeUnDiaGenerada()) {
            throw new TiempoDeJustificacionCaducadoException("Esta inasistencia tiene mas de 24 horas.");
        }
        inasistencia.CrearJustificacion(descripcion);
        servicio.guardar(inasistencia);
    }
    
    private boolean tieneMasDeUnDiaGenerada() {
        return Days.daysBetween(inasistencia.getDia(), 
                fechaActual).getDays() > 1;
                
    }
}