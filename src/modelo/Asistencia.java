
package modelo;

import excepciones.*;
import java.sql.Time;
import org.joda.time.*;

public class Asistencia {
    
    private Long id;
    private DateTime dia;
    private Time horaDeEntrada;
    private Time horaDeSalida;
    private Empleado empleado;
    
    public Asistencia() {
        dia = new DateTime();
        horaDeEntrada = AsistenciaBuild.horaSinFirmar();
        horaDeSalida = AsistenciaBuild.horaSinFirmar();
    }
    
    public Asistencia(Empleado empleado, DateTime fecha) {
        this.empleado = empleado;
        this.dia = fecha;
        horaDeEntrada = AsistenciaBuild.horaSinFirmar();
        horaDeSalida = AsistenciaBuild.horaSinFirmar();
    }
    
    private void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setHoraDeEntrada(Time hora){
      this.horaDeEntrada = hora;
    }

    public Time getHoraDeEntrada() {
        return horaDeEntrada;
    }
    
    public void setHoraDeSalida(Time hora){
      this.horaDeSalida = hora;
    }

    public Time getHoraDeSalida() {
        return horaDeSalida;
    }

    public DateTime getDia() {
        return dia;
    }

    private void setDia(DateTime dia) {
        this.dia = dia;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    private void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void marcarEntrada() throws AsistenciaMarcadaException {
        if (estaMarcadaLaEntrada()) {
            throw new AsistenciaMarcadaException();
        }
        setHoraDeEntrada(AsistenciaBuild.marcarHoraActual());
    }
    
    private boolean estaMarcadaLaEntrada() {
        return !"00:00:00".equals(horaDeEntrada.toString());
    }

    public void marcarSalida() throws 
            EntradaSinMarcarException, 
            AsistenciaMarcadaException {
        
        if (!estaMarcadaLaEntrada()) {
            throw new EntradaSinMarcarException();
        } else if (estaMarcadaLaSalida()) {
            throw new AsistenciaMarcadaException();
        }
        setHoraDeSalida(AsistenciaBuild.marcarHoraActual());
    }
    
    public boolean estaMarcadaLaSalida() {
        return !"00:00:00".equals(horaDeSalida.toString());
    }
    
    public boolean estaSinFirmar() {
        return String.valueOf(horaDeEntrada).equals("00:00:00") && 
               String.valueOf(horaDeSalida).equals("00:00:00");
    }

    public int HorasTrabajadas() {
        Instant entrada = new Instant(horaDeEntrada);
        Instant salida = new Instant(horaDeSalida);
        Hours horasTrabajadas = Hours.hoursBetween(entrada, salida);
        return horasTrabajadas.getHours();
    }
}
