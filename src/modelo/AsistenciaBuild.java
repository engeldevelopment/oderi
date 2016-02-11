
package modelo;

import java.sql.Time;
import java.util.Date;
import org.joda.time.DateTime;

public class AsistenciaBuild {

    public AsistenciaBuild() {
    
    }
    
    public static Time horaSinFirmar() {
        return new Time(new Date(0, 0, 0, 0, 0, 0).getTime());
    }
    
    public static Time marcarHoraActual() {
        return new Time(new Date().getTime());
    }
    
    public static DateTime fechaActual() {
        return new DateTime();
    }
}
