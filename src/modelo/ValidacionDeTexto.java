
package modelo;

import java.util.regex.*;

public class ValidacionDeTexto {

    private Pattern letras = Pattern.compile("[^A-Za-z s]");
    private Pattern numeros = Pattern.compile("[^0-9]");
    private Matcher m;
    
    public boolean esValido(String cadena) {
        m = letras.matcher(cadena);
        return !m.find();
    }
    
    public boolean estaVacio(String cadena) {
        return (cadena.startsWith(" ") && cadena.endsWith(" ")) || cadena.isEmpty();
    }

    public boolean esDigito(String cadena) {
        m = numeros.matcher(cadena);
        return !m.find();
    }
}
