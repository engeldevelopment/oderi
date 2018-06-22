
package modelo;

import excepciones.ContenidoInvalidoException;
import modelo.ValidacionDeTexto;

public class Cedula {
    private ValidacionDeTexto validacion = new ValidacionDeTexto();
    private String cedula;
    
    public Cedula(String cedula) throws ContenidoInvalidoException {
        if (validacion.estaVacio(cedula)) {
            throw new ContenidoInvalidoException("Debe ingresar un número de cédula.");
        }else if (cedula.length() < 6 || cedula.length() > 8) {
            throw new ContenidoInvalidoException("El número de cédula no "
                    + "puede ser menor que 6 digitos ó mayor que 8");
        } else if (!validacion.esDigito(cedula)) {
            throw new ContenidoInvalidoException("La cédula no puede contener letras y/o caracteres especiales.");
        }
        this.cedula = cedula;
    }
    
    public String get() {
        return cedula;
    }
}
