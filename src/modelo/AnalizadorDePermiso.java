
package modelo;

import modelo.Permiso;
import org.joda.time.DateTime;

public class AnalizadorDePermiso {
    
    private DateTime fechaDeAnalisis;
    
    public AnalizadorDePermiso(DateTime fechaDeAnalisis) {
        this.fechaDeAnalisis = fechaDeAnalisis;
    }

    public boolean estaVencido(Permiso permiso) {
        return permiso.getFechaDeCorte()
                .isBefore(fechaDeAnalisis) ||
                permiso.getFechaDeCorte().equals(fechaDeAnalisis);
    }
    
}
