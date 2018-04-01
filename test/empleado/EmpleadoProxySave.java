
package empleado;

import java.util.regex.Pattern;
import modelo.Empleado;


public class EmpleadoProxySave extends EmpleadoProxy {
    
    private Empleado empleado;
    private Pattern letras = Pattern.compile("[a-zA-Z]");
    
    public EmpleadoProxySave(Empleado empleado) {
        this.empleado = empleado;
    }
    
    @Override
    public void verificar() throws CampoVacioException, 
            CedulaIncorrectaException {
        if (empleado.getCedula().isEmpty() || 
                (empleado.getCedula().startsWith(" ") && empleado.getCedula().endsWith(" "))) {
            throw new CampoVacioException();
        } else if (empleado.getCedula().length() < 6 || empleado.getCedula().length() > 8 ) {
            throw new CedulaIncorrectaException();
        }
    }
    
}
