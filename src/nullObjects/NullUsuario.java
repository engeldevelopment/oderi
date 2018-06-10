package nullObjects;

import seguridad.Usuario;

public class NullUsuario extends Usuario {

    @Override
    public boolean esNull() {
        return true; 
    }
    
}
