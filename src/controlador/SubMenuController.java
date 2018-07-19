
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
    }

    @Override
    protected void item() {
        vista.btnInformacionPersonal.addActionListener(manejador);
        vista.btnInasistenciasDeEmpleado.addActionListener(manejador);
        vista.btnPermisosEmpleado.addActionListener(manejador);
    }
    
    private void verPanelDeInformacion() {
       
        vista.panelInformacionDeEmpleado.setVisible(true);
    }
    
    private void establecerSolicitante() {
        vista.NuevoPermiso.setTitle("Solicitante: "+vista.lblNombreEmpleado.getText()+" "+
                        vista.lblApellidosEmpleado.getText());
    }
    
    private class ManejadorDeEventos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object evento = e.getSource();
            
            if (evento.equals(vista.btnInformacionPersonal)) {
                verPanelDeInformacion();
                
            } else if (evento.equals(vista.btnInasistenciasDeEmpleado)) {
                mostrarVentana(vista.InasistenciaPersonal, 700, 345);
            
            } else if (evento.equals(vista.btnPermisosEmpleado)) {
                establecerSolicitante();
                mostrarVentana(vista.NuevoPermiso, 400, 265);
            }
        }
    }   
}