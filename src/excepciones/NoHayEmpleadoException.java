
package excepciones;

public class NoHayEmpleadoException extends Exception {

    public NoHayEmpleadoException() {
    }
    
    public NoHayEmpleadoException(String msj) {
        super(msj);
    }
}
