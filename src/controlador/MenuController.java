
package controlador;

import java.awt.event.*;
import vista.Menu;

public class MenuController extends Controlador {

    private Menu vista;
    private ManejadorDeEventos manejador;
    
    public MenuController(Menu vista) {
        this.vista = vista;
    }
    
    @Override
    protected void instancias() {
        manejador = new ManejadorDeEventos();
    }

    @Override
    protected void cargarInformacionDeLaBDs() {
        
    }

    @Override
    protected void item() {
       vista.itemEmpleados.addActionListener(manejador);
       vista.itemAsistenciaDiaria.addActionListener(manejador);
       vista.itemEntradaSalida.addActionListener(manejador);
       vista.itemInasistenciaSemanalGeneral.addActionListener(manejador);
       vista.itemInasistenciaQuincenalGeneral.addActionListener(manejador);
    }
    
    private class ManejadorDeEventos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object evento = e.getSource();
            
            if (evento.equals(vista.itemEmpleados)) {
                ventana(vista.VistaBuscarEmpleado, 400, 180);
            } 
            
            if(evento.equals(vista.itemAsistenciaDiaria)) {
                ventana(vista.VistaDeAsistenciaDiaria, 880, 540);
            }
            
            if (evento.equals(vista.itemEntradaSalida)) {
                ventana(vista.VistaReporteDeAsistencia, 700, 500);
            }
            
            if (evento.equals(vista.itemInasistenciaSemanalGeneral)) {
                ventana(vista.VistaSeleccionDeFecha, 400, 175);
            }
            
            if (evento.equals(vista.itemInasistenciaQuincenalGeneral)) {
                ventana(vista.VistaSeleccionDeMesYQuincena, 420, 220);
            }
        }
    }  
}
