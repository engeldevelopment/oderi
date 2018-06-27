
package modelo;

import excepciones.*;
import dao.IServicioAsistencia;
import java.sql.Time;
import org.joda.time.DateTime;

public abstract class Jornada {
    protected Long id;
    protected DateTime fecha;
    protected int estado;
    protected Time horaDeInicio;
    protected Time horaDeCierre;
    protected IServicioAsistencia servicio;
    
    public Jornada() {
    
    }
    
    public abstract void iniciar() throws JornadaEnCursoException, 
             JornadaCerradaException;
    
    public abstract void cerrar() throws AsistenciaIncompletaException, 
            JornadaCerradaException, SinIniciarJornadaException;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public int getEstado() {
        return estado;
    }
    
    public boolean estaCerrada() {
        return estado == 2;
    }
    
    public boolean estaEnCurso() {
        return estado == 1;
    }
    
    public boolean estaSinIniciar() {
        return estado == 0;
    }
    
    public DateTime getFecha() {
        return fecha;
    }

    private void setFecha(DateTime fecha) {
        this.fecha = fecha;
    }
    
    public Time getHoraDeInicio() {
        return horaDeInicio;
    }

    private void setHoraDeInicio(Time horaDeInicio) {
        this.horaDeInicio = horaDeInicio;
    }

    public Time getHoraDeCierre() {
        return horaDeCierre;
    }

    private void setHoraDeCierre(Time horaDeCierre) {
        this.horaDeCierre = horaDeCierre;
    }
    
    public void setServicio(IServicioAsistencia servicio) {
        this.servicio = servicio;
    }
}