
package controlador;

import excepciones.*;
import java.awt.event.*;
import modelo.Permiso;
import nicon.notify.core.*;
import org.joda.time.DateTime;
import org.joda.time.format.*;
import vista.Menu;

public class PermisosController extends Controlador {
    
    private Menu vista;
    private ManejadoDeEventos manejador;
    private Permiso permiso;
    private DateTimeFormatter formato;
    
    public PermisosController(Menu vista) {
        this.vista = vista;
    }

    @Override
    protected void instancias() {
        manejador = new ManejadoDeEventos();
        formato = DateTimeFormat.forPattern("EEE. dd MMM yyyy");
        vista.lblFechaDeEmision.setText(formato.print(DateTime.now()));
        
    }

    @Override
    protected void boton() {
        vista.btnEmitir.addActionListener(manejador);
    }
    
    private void emitir() {
        int dias = 0;
        try {
            DateTime fechaDeIncio = new DateTime(vista.fechaDeIncio.getDate());
            dias = (int) vista.txtDiasDePermiso.getValue();
            permiso = new Permiso(fechaDeEmision(), fechaDeIncio, dias);
            permiso.emitir();
            
             Notification.windowMessage(vista, "Listo!", 
                     "Fecha de inicio: "+
                             formato.print(permiso.getFechaDeInicio())+
                             "\n Fecha de corte: "+formato.print(permiso.getFechaDeCorte()),
                     NiconEvent.NOTIFY_OK);
            
        } catch (NumberFormatException | NumeroDeDiaIncorrectoException | 
                FechaIncorrectaException e) {
            Notification.windowMessage(vista, "Disculpe!", 
                    e.getMessage(), NiconEvent.NOTIFY_WARNING);
        } 
    }
    
    private DateTime fechaDeEmision() {
        return DateTime.now();
    }
    
    private void definirRemuneracionDelPermiso() {
       
    }
    
    private class ManejadoDeEventos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object evento = e.getSource();
            if (evento.equals(vista.btnEmitir)) {
                emitir();
            }
        }
    }
}