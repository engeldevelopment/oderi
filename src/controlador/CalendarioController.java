
package controlador;

import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import vista.Menu;

public class CalendarioController extends Controlador {
    private Menu vista;
    private ManejadorDeEventos manejador;
    
    public CalendarioController(Menu vista) {
        this.vista = vista;
    }

    @Override
    protected void instancias() {
        manejador = new ManejadorDeEventos();
    }

    @Override
    protected void campo() {
        vista.fechaInasistenciaSemanal.addKeyListener(manejador);
    }
    
    private void bloquearText(KeyEvent e, JDateChooser jd) {
        e.consume();
    }
    
    private class ManejadorDeEventos implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
    
    }
}
