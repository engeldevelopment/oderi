
package modelo;

import dao.IServicioAsistencia;
import excepciones.NoHayEmpleadoException;
import java.util.*;

public class GeneradorDeAsistencia {
    private List<Empleado> listado;
    private List<Asistencia> listadoDeAsistencia = new ArrayList();
    private IServicioAsistencia servicio;
    
    public GeneradorDeAsistencia(List<Empleado> list, IServicioAsistencia servicio) {
        this.listado = list;
        this.servicio = servicio;
    }

    public void generar() throws NoHayEmpleadoException {
        if (listado.isEmpty()) {
            throw new NoHayEmpleadoException("No hay empleados disponibles.");
        }
        for (Empleado empleado: listado) {
            crearAsistenciaPor(empleado);
        }
    }
    
    private void crearAsistenciaPor(Empleado e) {
        Asistencia asistencia = new Asistencia(e, AsistenciaBuild.fechaActual());
            listadoDeAsistencia.add(asistencia);
            servicio.guardar(asistencia);
    }

    public int getNumeroDeAsistenciasGeneradas() {
        return listadoDeAsistencia.size();
    }
    
    public List<Asistencia> getAsistencias() {
        return listadoDeAsistencia;
    }
}