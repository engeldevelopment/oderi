
package controlador;

import java.awt.event.*;
import vista.Menu;

public class SubMenuController extends Controlador {

    private Menu vista;
    private ManejadorDeEventos manejador;
    
    public SubMenuController(Menu vista) {
        this.vista = vista;
    }
    
    @Override
    protected void instancias() {
        manejador = new ManejadorDeEventos();
        vista.panelInformacionDeEmpleado.setVisible(false);
        
    }

    @Override
    protected void cargarInformacionDeLaBDs() {
        
    }

    @Override
    protected void item() {
        vista.btnInformacionPersonal.addActionListener(manejador);
        vista.btnInasistenciasDeEmpleado.addActionListener(manejador);
        vista.btnPermisosEmpleado.addActionListener(manejador);
    }

    @Override
    protected void boton() {
        vista.VistaSubMenu.addWindowListener(manejador);
    }
    
    private void verPanelDeInformacion() {
       
        vista.panelInformacionDeEmpleado.setVisible(true);
    }
    
    private void ocultarPaneles() {
        vista.panelInformacionDeEmpleado.setVisible(false);
    }
    
    private void establecerSolicitante() {
        vista.NuevoPermiso.setTitle("Solicitante: "+vista.lblNombreEmpleado.getText()+" "+
                        vista.lblApellidosEmpleado.getText());
    }
    
    private class ManejadorDeEventos implements ActionListener, WindowListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object evento = e.getSource();
            
            if (evento.equals(vista.btnInformacionPersonal)) {
                verPanelDeInformacion();
                
            } else if (evento.equals(vista.btnInasistenciasDeEmpleado)) {
                ventana(vista.InasistenciaPersonal, 680, 345);
            
            } else if (evento.equals(vista.btnPermisosEmpleado)) {
                establecerSolicitante();
                ventana(vista.NuevoPermiso, 400, 265);
            }
        }

        @Override
        public void windowOpened(WindowEvent e) {
            
        }

        @Override
        public void windowClosing(WindowEvent e) {
            Object evento = e.getSource();
            
            if (evento.equals(vista.VistaSubMenu)) {
                ocultarPaneles();
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