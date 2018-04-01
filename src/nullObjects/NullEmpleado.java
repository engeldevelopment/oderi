
package nullObjects;

import modelo.Empleado;

public class NullEmpleado extends Empleado {

    public NullEmpleado() {
    
    }
    
    @Override
    public boolean esNull() {
        return true;
    }
    
}
