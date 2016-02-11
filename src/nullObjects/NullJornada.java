
package nullObjects;

import modelo.*;

public class NullJornada extends Jornada {
    
    public NullJornada() {
        estado = EstadoDeJornada.SIN_INICIAR.Valor();
        horaDeInicio = JornadaBuild.horaCero();
        horaDeCierre = JornadaBuild.horaCero();
    }

    @Override
    public void iniciar() {
        
    }

    @Override
    public void cerrar() {
        
    }
    
}
