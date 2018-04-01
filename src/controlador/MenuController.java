
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
    }
    
    private class ManejadorDeEventos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object evento = e.getSource();
            
            if (evento.equals(vista.itemEmpleados)) {
                ventana(vista.VistaBuscarEmpleado, 400, 180);
            } else if(evento.equals(vista.itemAsistenciaDiaria)) {
                ventana(vista.VistaDeAsistenciaDiaria, 855, 540);
            }
        }
    
    }
    
}
