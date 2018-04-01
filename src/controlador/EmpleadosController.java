
package controlador;

import dao.EmpleadoDAO;
import java.awt.event.*;
import modelo.Empleado;
import modelo.ValidacionDeTexto;
import nicon.notify.core.*;
import vista.Menu;

public class EmpleadosController extends Controlador {

    private Menu vista;
    private ManejadorDeEventos manejador;
    private EmpleadoDAO servicioEmpleado;
    private Empleado empleado;
    private ValidacionDeTexto validacion;
    
    public EmpleadosController(Menu vista) {
        this.vista = vista;
    }
    
    @Override
    protected void instancias() {
         manejador = new ManejadorDeEventos();
         servicioEmpleado = new EmpleadoDAO();
         validacion = new ValidacionDeTexto();
    }

    @Override
    protected void cargarInformacionDeLaBDs() {
        
    }

    @Override
    protected void boton() {
        vista.btnBuscarEmpleado.addActionListener(manejador);
    }

    @Override
    protected void campo() {
        vista.txtCedulaEmpleadoBuscar.addKeyListener(manejador);
    }

    String cedula;
    private void validarCedulaABuscar() {
       cedula = vista.txtCedulaEmpleadoBuscar.getText();
       if (validacion.estaVacio(cedula)) {
           Notification.windowMessage(vista, 
                   "Disculpe!", 
                   "Debe ingresar un número de cédula.",
                   NiconEvent.NOTIFY_WARNING);
       } else if (!validacion.esDigito(cedula)) {
           Notification.windowMessage(vista, 
                   "Disculpe!", 
                   "La cédula no debe contener caracteres especiales ni letras.",
                   NiconEvent.NOTIFY_WARNING);
       }else if (!esValidaLaCedula()) {
           Notification.windowMessage(vista, 
                   "Disculpe!", 
                   "El número de cédula es incorrecto.",
                   NiconEvent.NOTIFY_WARNING);
       } else {
           buscar();
       }
    }
    
    private boolean esValidaLaCedula() {
        return cedula.length() >= 6 && cedula.length() <= 8;
    }
    
    private void buscar() {
        empleado = servicioEmpleado.buscar(cedula);
        verficarExistencia();
    }
    
    private void verficarExistencia() {
        if (empleado.esNull()) {
            int respuesta = Notification.windowConfirmMessage(vista, 
                    "Disculpe!", 
                    "Este empleado no existe. ¿Desea registrarlo?");
            if (respuesta == 1) {
                vista.txtCedula.setText(cedula);
                ventana(vista.NuevoEmpleado, 360, 295);
            }
        } else {
            establecerInformacionDelEmpleado();
            vista.txtCedulaEmpleadoBuscar.setText("");
            ventana(vista.VistaSubMenu, 700, 500);
        }
    }
    
    private void establecerInformacionDelEmpleado() {
        vista.VistaSubMenu.setTitle("Empleado: "+empleado.getNombre() +" "+empleado.getApellido());
        vista.lblCedulaEmpleado.setText(empleado.getCedula());
        vista.lblNombreEmpleado.setText(empleado.getNombre());
        vista.lblApellidosEmpleado.setText(empleado.getApellido());
        vista.lblDepartamentoEmpleado.setText(empleado.getDepartamento().getNombre());
    }
    
    private class ManejadorDeEventos implements ActionListener, KeyListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object evento = e.getSource();
            
            if(evento.equals(vista.btnBuscarEmpleado)) {
               validarCedulaABuscar();
            } 
        }

        @Override
        public void keyTyped(KeyEvent e) {
            Object evento = e.getSource();
            
            if (evento.equals(vista.txtCedulaEmpleadoBuscar)) {
                limitarDigitos(e, vista.txtCedulaEmpleadoBuscar, 8);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
    
    }
    
}