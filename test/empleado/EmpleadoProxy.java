
package empleado;

import modelo.Empleado;

public abstract class EmpleadoProxy {
    
    private Empleado empleado;
   
    
    public abstract void verificar() throws CampoVacioException, 
            CedulaIncorrectaException;      
}
