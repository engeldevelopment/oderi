package seguridad;

import excepciones.*;
import dao.IServicioDeUsuario;

public class ServicioDeLogin {
    
    private IServicioDeUsuario servicio;
    private Usuario user;
    
    public ServicioDeLogin(IServicioDeUsuario servicio) {
        this.servicio = servicio;
    }
    
    public Usuario login(String usuario, String clave) throws 
            CamposVaciosException, 
            UsuarioIncorrectoException,
            ClaveIncorrectaException {
        
        if (usuario.isEmpty() || clave.isEmpty()) {
            throw new CamposVaciosException();
        }
        
        if ((usuario.startsWith(" ") && usuario.endsWith(" ")) || 
                (clave.startsWith(" ") && clave.endsWith(" "))) {
            throw new CamposVaciosException();
        }
        
        user = servicio.buscar(usuario);
        if (user.esNull()) {
            throw new UsuarioIncorrectoException();
        }
        
        if (!clave.equals(user.getClave())) {
            throw new ClaveIncorrectaException();
        }
        
        return user;
    }
}
