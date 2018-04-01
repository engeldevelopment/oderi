
package modelo;

import java.sql.Time;
import java.util.Date;

public class JornadaBuild {
    
    public static Time HoraActual() {
        return new Time(new Date().getTime());
    }
    
     public static Time horaCero() {
        return new Time(new Date(0, 0, 0, 0, 0, 0).getTime());
     }
}
