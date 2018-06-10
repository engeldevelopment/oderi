
package controlador;

import seguridad.*;
import excepciones.*;
import vista.Menu;
import dao.*;
import java.awt.event.*;
import javax.swing.JFrame;
import nicon.notify.core.*;

public class UsuariosController extends Controlador {
    
    private IServicioDeUsuario servicio;
    private ServicioDeLogin acceso;
    private ManejadorDeEventos manejador;
    private Menu vista;
    private Usuario usuario;
    
    
    public UsuariosController(Menu vista){
        this.vista = vista;
    }
    
    @Override
    protected void instancias() {
        servicio = new UsuarioDAO();
        acceso = new ServicioDeLogin(servicio);
        manejador = new ManejadorDeEventos();
    }
    
    
    @Override
    protected void cargarInformacionDeLaBDs() {
        servicio.buscarTodos();
    }
    
    @Override
    protected void boton(){
        vista.btnEntrar.addActionListener(manejador);
        vista.Login.addWindowListener(manejador);
    }
    
    private void entrar() {
        try {
            
            String nombre = vista.txtNombreDeUsuario.getText();
            String clave = vista.txtClave.getText();
            usuario = acceso.login(nombre, clave);
            vista.Login.dispose();
            vistaMenu();
        
        } catch (CamposVaciosException   e) {
           
            Notification.windowMessage(vista, 
                    "Disculpe!", 
                    "Faltan campos por ingresar!", 
                    NiconEvent.NOTIFY_WARNING);
        
        } catch (ClaveIncorrectaException e){
        
            Notification.windowMessage(vista, 
                    "Disculpe!", 
                    "Clave incorrecta!", 
                    NiconEvent.NOTIFY_ERROR);
        
        } catch (UsuarioIncorrectoException e){
        
            Notification.windowMessage(vista, 
                    "Disculpe!", 
                    "Usuario incorrecto!", 
                    NiconEvent.NOTIFY_ERROR);
        }
        
    }
    
    private void vistaMenu() {
        vista.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vista.setResizable(false);
        vista.setVisible(true);
    }
    
    public void vistaLogin() {
        vista.Login.setSize(420, 245);
        vista.Login.setResizable(false);
        vista.Login.setLocationRelativeTo(vista);
        vista.Login.setModal(true);
        vista.Login.setVisible(true);
    }
    
    private class ManejadorDeEventos extends WindowAdapter implements ActionListener  {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object evento = e.getSource();
            if (evento.equals(vista.btnEntrar)) {
                entrar();
            }
        }

        @Override
        public void windowClosing(WindowEvent e) {
            Object evento = e.getSource();
            if (evento.equals(vista.Login)){
                confirmar();
            }
        }
        
        private void confirmar() {
            int respuesta = Notification.windowConfirmMessage(vista, 
                    "Salir?", 
                    "¿Quiere salir del sistema?");
                    if (respuesta == 1) {
                        System.exit(0);
                    }
        }
    }
}
