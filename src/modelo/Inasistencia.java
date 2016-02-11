
package modelo;

import java.sql.Time;
import org.joda.time.DateTime;

public class Inasistencia {
    
    private Long id;
    private DateTime dia;
    private Time horaDeGeneracion;
    private MotivoDeInasistencia motivo;
    private Empleado empleado;
    private boolean justificada;
    private Justificacion justificacion;
    
    public Inasistencia(Empleado empleado, DateTime dia, Time horaDeGeneracion, 
             MotivoDeInasistencia motivo) {
        this.empleado = empleado;
        this.dia = dia;
        this.horaDeGeneracion = horaDeGeneracion;
        this.motivo = motivo;
        this.justificada = false;
    }
    
    public Inasistencia() {
        justificada = false;
    }
    
    private void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    private void setDia(DateTime dia) {
        this.dia = dia;
    }
    
    public DateTime getDia() {
        return dia;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Time getHoraDeGeneracion() {
        return horaDeGeneracion;
    }

    private void setHoraDeGeneracion(Time horaDeGeneracion) {
        this.horaDeGeneracion = horaDeGeneracion;
    }
   
    public MotivoDeInasistencia getMotivo() {
        return motivo;
    }

    private void setMotivo(MotivoDeInasistencia motivo) {
        this.motivo = motivo;
    }
    
    public boolean isNull() {
        return false;
    }

    public boolean isJustificada() {
        return justificada;
    }

    private void setJustificada(boolean justificada) {
        this.justificada = justificada;
    }
   
    public boolean estaJustificada() {
        return justificada;
    }

    public void justificar() {
        justificada = true;
    }
    
    private void setJustificacion(Justificacion justificacion) {
        this.justificacion = justificacion;
    }
    
    public Justificacion getJustificacion() {
        return justificacion;
    }
    
    public void CrearJustificacion(String descripcion) {
        justificacion = new Justificacion(descripcion);
        justificacion.setInasistencia(this);
        justificar();
    }
}