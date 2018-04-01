
package empleado;

public class CedulaIncorrectaException extends Exception {

    public CedulaIncorrectaException() {
    
    }
    
    public CedulaIncorrectaException(String msj) {
        super(msj);
    }
}
