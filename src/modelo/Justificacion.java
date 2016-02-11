
package modelo;

import java.sql.Time;
import org.joda.time.DateTime;

public class Justificacion {

    private Long id;
    private DateTime fecha;
    private String descripcion;
    private Time hora;
    private Inasistencia inasistencia;

    public Justificacion() {
    
    }
    
    public  Justificacion(String descripcion) {
        this.descripcion = descripcion;
        fecha = new DateTime();
        hora = new Time(fecha.getHourOfDay(),fecha.getMinuteOfHour(), fecha.getSecondOfMinute());
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public DateTime getFecha() {
        return fecha;
    }

    private void setFecha(DateTime fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    private void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Time getHora() {
        return hora;
    }

    private void setHora(Time hora) {
        this.hora = hora;
    }

    public Inasistencia getInasistencia() {
        return inasistencia;
    }

    public void setInasistencia(Inasistencia inasistencia) {
        this.inasistencia = inasistencia;
    }
}
