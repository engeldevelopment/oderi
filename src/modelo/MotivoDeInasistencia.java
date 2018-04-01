
package modelo;

public class MotivoDeInasistencia {
    
    private Long id;
    private String nombre;

    public MotivoDeInasistencia() {
    
    }

    public MotivoDeInasistencia(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
