
package modelo;

import excepciones.*;
import org.joda.time.DateTime;

public class Permiso {
   
    private Long id;
    private DateTime fechaDeEmision;
    private DateTime fechaDeInicio;
    private DateTime fechaDeCorte;
    private int numeroDeDias;
    
    public Permiso(DateTime fechaDeEmision, DateTime fechaDeInicio, int dias) {
       this.fechaDeEmision = fechaDeEmision;
       this.fechaDeInicio = fechaDeInicio;
       this.numeroDeDias = dias;
    }

    public Permiso() {
    
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public DateTime getFechaDeEmision() {
        return fechaDeEmision;
    }

    private void setFechaDeEmision(DateTime fechaDeEmision) {
        this.fechaDeEmision = fechaDeEmision;
    }

    public DateTime getFechaDeInicio() {
        return fechaDeInicio;
    }

    private void setFechaDeInicio(DateTime fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public DateTime getFechaDeCorte() {
        return fechaDeCorte;
    }

    private void setFechaDeCorte(DateTime fechaDeCorte) {
        this.fechaDeCorte = fechaDeCorte;
    }

    public int getNumeroDeDias() {
        return numeroDeDias;
    }

    private void setNumeroDeDias(int numeroDeDias) {
        this.numeroDeDias = numeroDeDias;
    }
    

    public void emitir() throws NumeroDeDiaIncorrectoException,
            FechaIncorrectaException {
        
        if (fechaDeInicio == null) {
          throw new FechaIncorrectaException("Ingresa la fecha de inicio por favor.");
        } else if (ingresoUnaFechaPasadaOIgualALaFechaDeEmision()){
            throw new FechaIncorrectaException("No puedes seleccionar la fecha de hoy o fechas anteriores.");
        } else if(esIncorrectoElNumeroDeDias()) {
            throw new NumeroDeDiaIncorrectoException("Debes ingresar de 1 a 3 días de permiso.");
        }     
        
        generarFechaDeCorte();
        
    }
    
    private boolean ingresoUnaFechaPasadaOIgualALaFechaDeEmision() {
        return fechaDeInicio.isBefore(fechaDeEmision);
    }
    
    private boolean esIncorrectoElNumeroDeDias() {
        return numeroDeDias <= 0;
    }
    
    private boolean esViernes() {
        return fechaDeInicio.getDayOfWeek() == 5;
    }
    
    private boolean sonTresDias() {
        return numeroDeDias == 3;
    }
    private void generarFechaDeCorteConDiasAdicionales() {
        int diasAdicionales = numeroDeDias + 1;
        this.fechaDeCorte = fechaDeInicio;
        this.fechaDeCorte.plusDays(diasAdicionales);
    }
    
    private void generarFechaDeCorte() {
        this.fechaDeCorte = fechaDeInicio.plusDays(getNumeroDeDias());
    }
}