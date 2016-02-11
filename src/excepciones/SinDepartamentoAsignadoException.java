
package excepciones;

public class SinDepartamentoAsignadoException extends Exception {

    public SinDepartamentoAsignadoException() {
    
    }
    
    public SinDepartamentoAsignadoException(String msj) {
        super(msj);
    }
}
