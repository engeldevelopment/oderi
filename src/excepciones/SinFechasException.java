
package excepciones;

public class SinFechasException extends Exception {

    public SinFechasException() {
    }
    
    public SinFechasException(String msj) {
        super(msj);
    }
}
