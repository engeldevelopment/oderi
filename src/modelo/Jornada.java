
package modelo;

import excepciones.*;
import dao.IServicioAsistencia;
import java.sql.Time;
import java.util.Date;

public abstract class Jornada {
    
    protected Date fecha;
    protected EstadoDeJornada estado;
    protected Time horaDeInicio;
    protected Time horaDeCierre;
    protected IServicioAsistencia servicio;
    
    public Jornada() {
    
    }
    
    public abstract void iniciar() throws JornadaEnCursoException, 
            NoHayEmpleadoException, JornadaCerradaException;
    
    public abstract void cerrar() throws AsistenciaIncompletaException;
    
    public void setEstado(EstadoDeJornada estado) {
        this.estado = estado;
    }
    
    public EstadoDeJornada getEstado() {
        return estado;
    }
    
    public boolean estaCerrada() {
        return estado == EstadoDeJornada.CERRADA;
    }
    
    public boolean estaEnCurso() {
        return estado == EstadoDeJornada.EN_CURSO;
    }
    
    public boolean estaSinIniciar() {
        return estado == EstadoDeJornada.SIN_INICIAR;
    }
    
    public Date getFecha() {
        return fecha;
    }

    private void setFecha(Date fecha) {
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
