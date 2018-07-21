
package controlador;

import java.awt.event.KeyEvent;
import javax.swing.JDialog;
import javax.swing.JTextField;

public abstract class Controlador implements IControlador {
   
    
    @Override
    public void iniciar() {
        instancias();
        eventos();
        cargarInformacionDeLaBDs();
    }
    
    protected abstract void instancias();
    
    private void eventos() {
        boton();
        item();
        raton();
        campo();
    }
    
    protected void boton() {
    
    }
    
    protected void item() {
    
    }
    
    protected void raton() {
    
    }
    
    protected void campo() {
    
    }

    
    protected void cargarInformacionDeLaBDs() {
    
    }
    
    protected void mostrarVentana(JDialog dialogo, int ancho, int alto) {
        dialogo.setSize(ancho, alto);
        dialogo.setResizable(false);
        dialogo.setLocationRelativeTo(null);
        dialogo.setModal(true);
        dialogo.setVisible(true);
    }
    
    protected void limitarDigitos(KeyEvent e, JTextField campo, int limite) {
        if (campo.getText().length() == limite) {
            e.consume();
        }
    }
}
