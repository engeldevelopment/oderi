
package modelo;

public class NombreDeJornada {
    
    private static String nombre;
    
    public static String establecer(Jornada jornada){
        if (jornada.estaSinIniciar()) {
            nombre = "Sin iniciar";
        } else if (jornada.estaEnCurso()) {
            nombre = "En curso";
        } else {
            nombre = "Cerrada";
        }
        return nombre;
    }
}
