
package controlador;

import dao.*;
import excepciones.*;
import java.awt.event.*;
import java.util.List;
import modelo.*;
import nicon.notify.core.*;
import presenter.*;
import vista.Menu;

public class EmpleadosController extends Controlador {

    private Menu vista;
    private ManejadorDeEventos manejador;
    private EmpleadoDAO servicioEmpleado;
    private Empleado empleado;
    private ValidacionDeTexto validacion;
    private DepartamentoDAO servicioDepartamento;
    private Departamento departamento;
    private DepartamentoPresenter dptoPresenter;
    private EmpleadoPresenter empleadoPresenter;
    private ValidacionDeTexto texto;
    private String nombre;
    private String apellido;
    private Cedula cedula;
    
    public EmpleadosController(Menu vista) {
        this.vista = vista;
    }
    
    @Override
    protected void instancias() {
         manejador = new ManejadorDeEventos();
         servicioEmpleado = new EmpleadoDAO();
         validacion = new ValidacionDeTexto();
         servicioDepartamento = new DepartamentoDAO();
         dptoPresenter = new DepartamentoPresenter(vista);
         empleadoPresenter = new EmpleadoPresenter(vista);
         texto = new ValidacionDeTexto();
    }

    @Override
    protected void cargarInformacionDeLaBDs() {
        listarDepartamentos();
    }

    @Override
    protected void boton() {
        vista.btnBuscarEmpleado.addActionListener(manejador);
        vista.btnAgregarDepartamento.addActionListener(manejador);
        vista.btnAsignarDepartamento.addActionListener(manejador);
        vista.NuevoEmpleado.addWindowListener(manejador);
        vista.btnGuardarEmpleado.addActionListener(manejador);
        vista.cmbFiltrarPorDepartamento.addActionListener(manejador);
    }

    @Override
    protected void item() {
        vista.itemEmpleadosConsulta.addActionListener(manejador);
    }
    
    @Override
    protected void campo() {
        vista.txtCedulaEmpleadoBuscar.addKeyListener(manejador);
        vista.txtEmpleadoABuscar.addKeyListener(manejador);
    }
    
    private void listarDepartamentos() {
        List<Departamento> listado = (List<Departamento>) 
                servicioDepartamento.buscarTodos();
        
        dptoPresenter.ver(listado);
        enComboxDelListadoDeEmpleado(listado);
    }
    
    private void enComboxDelListadoDeEmpleado(List<Departamento> listado) {
        vista.cmbFiltrarPorDepartamento.removeAllItems();
        for (Departamento d: listado) {
            vista.cmbFiltrarPorDepartamento.addItem(d.getNombre());
        }
    }

    String ced;
    private void buscarEmpleado() {
       ced = vista.txtCedulaEmpleadoBuscar.getText();
        try {
            cedula = new Cedula(ced);
            buscar();
        } catch (ContenidoInvalidoException e) {
            Notification.windowMessage(vista, 
                    "Disculpe!", e.getMessage());
        }
    }
    
    private void buscar() {
        empleado = servicioEmpleado.buscar(cedula.get());
        verficarExistencia();
    }
    
    private void verficarExistencia() {
        if (empleado.esNull()) {
            int deseaRegistrarlo = Notification.windowConfirmMessage(vista, 
                    "Disculpe!", 
                    "Este empleado no existe. ¿Desea registrarlo?");
            if (deseaRegistrarlo == 1) {
                vista.txtCedula.setText(cedula.get());
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
    
    private void guardar() {
        
        try {
            obtenerLosDatosDelEmpleado();
            validarDatosDelEmpleado();
            procesarEmpleado();
                 
        } catch (SinDepartamentoAsignadoException ex) {
           
            Notification.windowMessage(vista, 
                    "Disculpe!", 
                    "Debe asignar el departamento por favor..");
        } catch (CamposVaciosException | ContenidoInvalidoException ex) {
            Notification.windowMessage(vista, "Disculpe!", ex.getMessage());
        }
    }
    
    private void obtenerLosDatosDelEmpleado() {
        nombre = vista.txtNombreEmpleado.getText();
        apellido = vista.txtApellidoEmpleado.getText();
    }
    
    private void validarDatosDelEmpleado() throws CamposVaciosException, ContenidoInvalidoException {
        if (texto.estaVacio(nombre) || texto.estaVacio(apellido)) {
            throw new CamposVaciosException("Todos los campos son obligatorios.");
        } else if (!texto.esValido(nombre) || !texto.esValido(apellido)) {
           throw new ContenidoInvalidoException("No se permiten caracteres especiales y/o números en los campos.");
        }
    }
    
    private void procesarEmpleado() throws SinDepartamentoAsignadoException {
        empleado = new Empleado(cedula.get(), nombre, apellido, departamento);
        empleado.listo();
        servicioEmpleado.guardar(empleado);
        empleadoPresenter.limpiarCampos();
                
        Notification.windowMessage(vista, 
                    "Listo!", 
                    "Ha sido registrado el empleado exitosamente!",
                    NiconEvent.NOTIFY_OK);
    }
   
   long idDepartamento = 0; 
   private void asignarDepartamento() {
        if (noSeleccionoUnDepartamento()) {
            Notification.windowMessage(vista, 
                    "Disculpe!", 
                    "Debe seleccionar el departamento para asignarlo al empleado.");
        } else {
            idDepartamento = Integer.parseInt(vista.listadoDeDepartamentos.getValueAt(fila, 0).toString());
            departamento = servicioDepartamento.buscar(idDepartamento);
            vista.txtDepartamentoAsignado.setText(departamento.getNombre());
            vista.VistaSeleccionarDepartamento.dispose();
        }
    }
    
    int fila = 0;
    private boolean noSeleccionoUnDepartamento() {
        fila = vista.listadoDeDepartamentos.getSelectedRow();
        return fila == -1;
    }
    
    private void listarEmpleados() {
        List<Empleado> listado = (List<Empleado>) servicioEmpleado.buscarTodos();
        empleadoPresenter.ver(listado);
        ventana(vista.Empleados, 660, 303);
    }
    
    private void buscarEmpleadoPorDepartamentoYCedula() {
        List<Empleado> listado = (List<Empleado>) 
                servicioEmpleado.buscarEmpleadoPor(vista.txtEmpleadoABuscar.getText(), 
                        vista.cmbFiltrarPorDepartamento.getSelectedItem().toString());
        empleadoPresenter.ver(listado);
    }
    
    private class ManejadorDeEventos implements ActionListener, KeyListener, 
            WindowListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object evento = e.getSource();
            
            if(evento.equals(vista.btnBuscarEmpleado)) {
               buscarEmpleado();
               
            } else if (evento.equals(vista.btnAgregarDepartamento)) {
                ventana(vista.VistaSeleccionarDepartamento, 400, 217);
            } else if (evento.equals(vista.btnAsignarDepartamento)) {
                asignarDepartamento();
                
            } else if (evento.equals(vista.btnGuardarEmpleado)) {
                guardar();
                
            } else if (evento.equals(vista.itemEmpleadosConsulta)) {
                listarEmpleados();
                
            } else if (evento.equals(vista.cmbFiltrarPorDepartamento)) {
                buscarEmpleadoPorDepartamentoYCedula();
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            Object evento = e.getSource();
            
            if (evento.equals(vista.txtCedulaEmpleadoBuscar)) {
                limitarDigitos(e, vista.txtCedulaEmpleadoBuscar, 8);
            }
            
            if (evento.equals(vista.txtEmpleadoABuscar)) {
                limitarDigitos(e, vista.txtEmpleadoABuscar, 8);
                buscarEmpleadoPorDepartamentoYCedula();
            }
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }

        @Override
        public void windowOpened(WindowEvent e) {
            
        }

        @Override
        public void windowClosing(WindowEvent e) {
            Object evento = e.getSource();
            if (evento.equals(vista.NuevoEmpleado)) {
                empleadoPresenter.limpiarCampos();
            }
        }

        @Override
        public void windowClosed(WindowEvent e) {
            
        }

        @Override
        public void windowIconified(WindowEvent e) {
            
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            
        }

        @Override
        public void windowActivated(WindowEvent e) {
            
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            
        }
    
    }
    
}