
package nullObjects;

import modelo.Departamento;

public class NullDepartamento extends Departamento {

    public NullDepartamento() {
    
    }
    
    @Override
    public boolean esNull() {
        return true;
    }
    
}
