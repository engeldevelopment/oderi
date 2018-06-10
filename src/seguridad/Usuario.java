package seguridad;


public class Usuario {
    
    private Long id;
    private String nombre;
    private String clave;

    public Usuario() {
    
    }

    public Usuario(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
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

    public String getClave() {
        return clave;
    }

    private void setClave(String clave) {
        this.clave = clave;
    }
    
    public boolean esNull() {
        return false;
    }
}
