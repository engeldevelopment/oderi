 
package modelo;

import excepciones.*;

public class Empleado {
    
    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private Departamento departamento;
    
    public Empleado(){
       
    }
    
    public Empleado(String cedula, String nombre, String apellido, 
            Departamento dpto) throws SinDepartamentoAsignadoException {
        
        if (dpto.esNull()) {
            throw new SinDepartamentoAsignadoException("Debes asignar al empleado en un departamento.");
        }
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = dpto;        
    }
    
    public Empleado(Long id, String cedula, String nombre, String apellido, 
            Departamento dpto) throws SinDepartamentoAsignadoException {
        
        if (dpto.esNull()) {
            throw new SinDepartamentoAsignadoException("Debes asignar al empleado en un departamento.");
        }
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = dpto;        
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }
       
    public void setCedula(String cedula){
        this.cedula = cedula;
    }
    
    public String getCedula(){
        return cedula;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    public String getApellido(){
        return apellido;
    }
   
    public void setDepartamento(Departamento dpto){
        this.departamento = dpto;
    }
    
    public Departamento getDepartamento(){
        return departamento;
    }
    
    public boolean esNull() {
        return false;
    }
}
