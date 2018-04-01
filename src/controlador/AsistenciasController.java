
package controlador;

import java.awt.event.*;
import nicon.notify.core.*;
import vista.Menu;

public class AsistenciasController extends Controlador {

    private Menu vista;
    private ManejadorDeEventos manejador;
            
    public AsistenciasController(Menu vista) {
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
    protected void boton() {
        vista.btnEntrada.addActionListener(manejador);
        vista.btnSalida.addActionListener(manejador);
    }
    
    private void marcarEntrada() {
        Notification.windowMessage(vista, 
                "Listo!", 
                "Entrada marcada.",NiconEvent.NOTIFY_OK);
    }
    
    private void marcarSalida() {
        Notification.windowMessage(vista, 
                "Listo!", 
                "Salida marcada.",NiconEvent.NOTIFY_OK);
    }
    
    private class ManejadorDeEventos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object evento = e.getSource();
            
            if (evento.equals(vista.btnEntrada)) {
                marcarEntrada();
            } else if (evento.equals(vista.btnSalida)) {
                marcarSalida();
            }
        }
    
    }
    
}
