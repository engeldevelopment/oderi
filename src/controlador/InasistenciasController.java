
package controlador;

import reportes.*;
import modelo.*;
import excepciones.*;
import presenter.*;
import vista.Menu;
import dao.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import nicon.notify.core.*;
import org.joda.time.DateTime;
import org.joda.time.format.*;

public class InasistenciasController extends Controlador {
    
    private Menu vista;
    private IServicioInasistencia servicioDeInasistencia;
    private ManejadorDeEventos manejador;
    private InasistenciaPresenter presenter;
    private JustificacionDeInasistencia justificacion;
    private Inasistencia inasistencia;
    private DateTimeFormatter formato;
    private ReporteDeInasistenciaSemanal reporteSemanal;
    private ReporteDeInasistenciaMensual reporteMensual;
    private InasistenciaSemanalPresenter inasistenciaSemanalPresenter;
    
    public InasistenciasController(Menu vista) {
        this.vista = vista;
    }
    
    @Override
    protected void instancias() {
        manejador = new ManejadorDeEventos();
        servicioDeInasistencia = new InasistenciaDAO();
        formato = DateTimeFormat.forPattern("EEEE, dd MMM YYYY");
        vista.lblFechaDeInasistencia.setText(""+formato.print(DateTime.now()));
        presenter = new InasistenciaPresenter(vista);
        inasistenciaSemanalPresenter = new InasistenciaSemanalPresenter(vista);
    }

    @Override
    protected void cargarInformacionDeLaBDs() {
         
    }
    
    @Override
    protected void boton() {
        vista.btnReporte.addActionListener(manejador);
        vista.btnConsultarInasistencia.addActionListener(manejador);
        vista.btnCrearJustificacion.addActionListener(manejador);
        vista.btnJustificar.addActionListener(manejador);
        vista.VistaSubMenu.addWindowListener(manejador);
        vista.btnVerInasistenciaSemanal.addActionListener(manejador);
    }
    
    private void buscarInasistenciaDelEmpleado() {
        try {
            reporteMensual = new ReporteDeInasistenciaMensual(servicioDeInasistencia, 
                Empleado(), Mes(), Year());
            reporteMensual.generar();
            presenter.ver(reporteMensual);
            
        } catch (SinInasistenciasException e) {
            Notification.windowMessage(vista, "Aviso", 
                    e.getMessage());
            presenter.borrarListado();
        }
        vista.listaDeInasistenciaPorEmpleado.clearSelection();
    }
    
    private String Empleado() {
        return vista.lblCedulaEmpleado.getText();
    }
    
    private int Mes() {
        return vista.mesInasistencia.getMonth() + 1;
    }
    
    private int Year() {
        return vista.yearInasistencia.getYear();
    }
    
    private void JustificarInasistencia() {
      
        try {
            DateTime fechaActual = new DateTime();
            String observacion = vista.areaObservacion.getText();
            justificacion = new JustificacionDeInasistencia(inasistencia, 
                    fechaActual, servicioDeInasistencia);
           
            justificacion.Justificar(observacion);
            
            Notification.windowMessage(vista, 
                    "Listo!", 
                    "La inasistencia ha sido justificada exitosamente.",
                    NiconEvent.NOTIFY_OK);
            reestablecerVistaDeJustificacionDeInasistencia();
            buscarInasistenciaDelEmpleado();
            
        } catch (TiempoDeJustificacionCaducadoException ex) {
            Notification.windowMessage(vista, "Disculpe!", 
                    "Esta inasistencia tiene más de 24 horas generada."
                            + "\nNo puede justificarla",
                    NiconEvent.NOTIFY_WARNING);
        } catch (InasistenciaJustificadaException ex) {
            Notification.windowMessage(vista, "Disculpe!", 
                    "Esta inasistencia ya fue justifiada.",
                    NiconEvent.NOTIFY_WARNING);
        }
    }
    
    private void reestablecerVistaDeJustificacionDeInasistencia() {
        vista.lblHoraDeGeneracion.setText("");
        vista.areaObservacion.setText("");
        vista.VistaJustificacion.setVisible(false);
    }
    
    private void crearJustificacion() {
        if (noHaSeleccionadoUnaInasistencia()) {
            Notification.windowMessage(vista, 
                    "Disculpe!", 
                    "Debe seleccionar una inasistencia", 
                    NiconEvent.NOTIFY_WARNING);
        } else {
            inasistencia = servicioDeInasistencia.buscar(obtenerIdDeLaInasistenciaSeleccionada());
            vista.lblHoraDeGeneracion.setText(String.valueOf(inasistencia.getHoraDeGeneracion()));
            ventana(vista.VistaJustificacion, 373, 300);
        }
    }
    
    int inasistenciaSeleccionada;
    private boolean noHaSeleccionadoUnaInasistencia() {
        inasistenciaSeleccionada = vista.listaDeInasistenciaPorEmpleado.getSelectedRow();
        return inasistenciaSeleccionada == -1;
    }
    
    private long obtenerIdDeLaInasistenciaSeleccionada() {
        return (long) vista.listaDeInasistenciaPorEmpleado.
                    getValueAt(inasistenciaSeleccionada, 0);
    }
    
    private void verInasistenciaSemanal() {
        try {
           
            reporteSemanal = new ReporteDeInasistenciaSemanal(vista.fechaInasistenciaSemanal.getDate());
            reporteSemanal.setServicio(servicioDeInasistencia);
            
            reporteSemanal.generar();
            inasistenciaSemanalPresenter.ver(reporteSemanal);
            ventana(vista.VistaInasistenciaSemanal, 729, 736);
            
        } catch (FechaDeInicioIncorrecta | SinInasistenciasException | SinFechasException e) {
            Notification.windowMessage(vista, "Disculpe!", 
                    e.getMessage(),
                    NiconEvent.NOTIFY_DEFAULT);
        } 
    }
    
    private class ManejadorDeEventos extends WindowAdapter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object evento = e.getSource();
            
            if (evento.equals(vista.btnConsultarInasistencia)) {
                buscarInasistenciaDelEmpleado();
            }
            
            if (evento.equals(vista.btnCrearJustificacion)) {
                crearJustificacion();
            }
            
            if (evento.equals(vista.btnJustificar)) {
                JustificarInasistencia();
            }
            
            if (evento.equals(vista.btnVerInasistenciaSemanal)) {
                verInasistenciaSemanal();
            }
        }
        
        @Override
        public void windowClosing(WindowEvent e) {
            Object evento = e.getSource();
            if (evento.equals(vista.VistaSubMenu)) {
                presenter.borrarListado();
            }
        }
    }
}