package modelo;

import java.util.*;

public class Departamento {
    
    private Long id;
    private String nombre;
    private Set<Empleado> empleados = new HashSet();
    
    public Departamento() {
 
    }
    
    public Departamento(String nombre) {
        this.nombre = nombre;
    }
    
    private void setId(Long id){
        this.id = id;
    }
   
    public Long getId() {
        return id;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }

    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }
    
    public boolean esNull() {
        return false;
    }
    
}