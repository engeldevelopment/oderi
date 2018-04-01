
package nullObjects;

import modelo.Empleado;

public class EmpleadoNull extends Empleado {

    @Override
    public boolean esNull() {
        return true;
    }
}
