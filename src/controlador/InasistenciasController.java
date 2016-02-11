
package controlador;

import reportes.ReporteDeInasistenciaSemanal;
import modelo.*;
import excepciones.*;
import presenter.InasistenciaPresenter;
import vista.Menu;
import dao.*;
import java.awt.event.*;
import java.util.*;
import nicon.notify.core.*;
import org.joda.time.DateTime;
import org.joda.time.format.*;
import presenter.InasistenciaSemanalPresenter;

public class InasistenciasController extends Controlador {
    
    private Menu vista;
    private IServicioInasistencia servicioDeInasistencia;
    private ManejadorDeEventos manejador;
    private InasistenciaPresenter presenter;
    private JustificacionDeInasistencia justificacion;
    private Inasistencia inasistencia;
    private DateTimeFormatter formato;
    private ReporteDeInasistenciaSemanal reporteSemanal;
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
    protected void item() {
        vista.itemInasistenciaSemanalGeneral.addActionListener(manejador);
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
        List<Inasistencia> listado =  (List<Inasistencia>) 
                servicioDeInasistencia.inasistenciasMensualDelEmpleado(
                        vista.lblCedulaEmpleado.getText(), Mes(), Year());
        if (!listado.isEmpty()) {
             presenter.setLista(listado);
             presenter.verListado();
        } else {
            presenter.borrarListado();
            Notification.windowMessage(vista,"Aviso!",
                    "No tiene inasistencias para esta fecha!");
        }
        vista.listaDeInasistenciaPorEmpleado.clearSelection();
    }
    
    private int Mes() {
        return vista.mesInasistencia.getMonth() + 1;
    }
    
    private int Year() {
        return vista.yearInasistencia.getYear();
    }
    
    private void JustificarInasistencia() {
        DateTime fechaActual = new DateTime();
        
        try {           
            justificacion = new JustificacionDeInasistencia(inasistencia, 
                    fechaActual, servicioDeInasistencia);
           
            String observacion = vista.areaObservacion.getText();
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
            ventana(vista.VistaJustificacion, 400, 345);
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
            DateTime fechaDeSolicitud = new DateTime(
                    vista.fechaInasistenciaSemanal.getDate());
            reporteSemanal = new ReporteDeInasistenciaSemanal(fechaDeSolicitud);
            reporteSemanal.setServicio(servicioDeInasistencia);
            
            reporteSemanal.generar();
            inasistenciaSemanalPresenter.ver(reporteSemanal);
            ventana(vista.VistaInasistenciaSemanal, 729, 736);
            
        } catch (FechaDeInicioIncorrecta | SinInasistenciasException e) {
            Notification.windowMessage(vista, "Disculpe!", 
                    e.getMessage(),
                    NiconEvent.NOTIFY_DEFAULT);
        }
    }
    
    private class ManejadorDeEventos implements ActionListener, WindowListener {

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
            
            if (evento.equals(vista.itemInasistenciaSemanalGeneral)) {
                ventana(vista.VistaSeleccionDeFecha, 400, 175);
            }
            
            if (evento.equals(vista.btnVerInasistenciaSemanal)) {
                verInasistenciaSemanal();
            }
        }

        @Override
        public void windowOpened(WindowEvent e) {
            
        }

        @Override
        public void windowClosing(WindowEvent e) {
            Object evento = e.getSource();
            if (evento.equals(vista.VistaSubMenu)) {
                presenter.borrarListado();
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