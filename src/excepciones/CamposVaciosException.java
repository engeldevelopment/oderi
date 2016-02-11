
package excepciones;

public class CamposVaciosException extends Exception {

    public CamposVaciosException() {
    }
    
    public CamposVaciosException(String msj) {
        super(msj);
    }
}
