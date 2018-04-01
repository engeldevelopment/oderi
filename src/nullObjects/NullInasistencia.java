
package nullObjects;

import modelo.Inasistencia;

public class NullInasistencia extends Inasistencia {

    public NullInasistencia() {
    
    }
    
    @Override
    public boolean isNull() {
        return true;
    }
}
