
package controlador;

import reportes.*;
import modelo.*;
import excepciones.*;
import presenter.*;
import vista.Menu;
import dao.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
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
    private DateTimeFormatter formatoCortoFecha;
    private SimpleDateFormat formatoHora;
    private ReporteDeInasistenciaSemanal reporteSemanal;
    private ReporteDeInasistenciaMensual reporteMensual;
    private InasistenciaSemanalPresenter inasistenciaSemanalPresenter;
    private ReporteDeInasistenciaSemanalPersonalPresenter reporteInasistenciaPersonal;
    
    public InasistenciasController(Menu vista) {
        this.vista = vista;
    }
    
    @Override
    protected void instancias() {
        manejador = new ManejadorDeEventos();
        servicioDeInasistencia = new InasistenciaDAO();
        formato = DateTimeFormat.forPattern("EEEE, dd MMM YYYY");
        formatoCortoFecha = DateTimeFormat.forPattern("dd MMM YYYY");
        formatoHora = new SimpleDateFormat("hh:mm:s a");
        vista.lblFechaDeInasistencia.setText(formato.print(DateTime.now()));
        presenter = new InasistenciaPresenter(vista);
        inasistenciaSemanalPresenter = new InasistenciaSemanalPresenter(vista);
        reporteInasistenciaPersonal = new ReporteDeInasistenciaSemanalPersonalPresenter(vista);
    }
    
    @Override
    protected void boton() {
        vista.btnReporte.addActionListener(manejador);
        vista.btnConsultarInasistencia.addActionListener(manejador);
        vista.btnCrearJustificacion.addActionListener(manejador);
        vista.btnJustificar.addActionListener(manejador);
        vista.VistaSubMenu.addWindowListener(manejador);
        vista.btnVerInasistenciaSemanal.addActionListener(manejador);
        vista.btnVerJustificacion.addActionListener(manejador);
        vista.btnVerInasistenciasSemnalDeEmpleado.addActionListener(manejador);
        vista.btnVerInasistenciaSemanalPersonal.addActionListener(manejador);
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
            String observacion = vista.areaObservacion.getText();
            justificacion = new JustificacionDeInasistencia(inasistencia, 
                    DateTime.now(), servicioDeInasistencia);
           
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
    
    private void seleccionarInasistencia() {
        if (noHaConsultadoUnaFecha()) {
            Notification.windowMessage(vista, 
                    "Disculpe!", 
                    "Primero debe realizar una consulta.", 
                    NiconEvent.NOTIFY_DEFAULT);
        } else if (noHaSeleccionadoUnaInasistencia()) {
            Notification.windowMessage(vista, 
                    "Disculpe!", 
                    "Debe seleccionar una inasistencia", 
                    NiconEvent.NOTIFY_WARNING);
        } else {
            buscar();
            verificarSiEstaJustifica();
        }   
    }
    
    private boolean noHaConsultadoUnaFecha() {
        int nroDeInasistencia = vista.listaDeInasistenciaPorEmpleado.getRowCount();
        return nroDeInasistencia <= 0;
    }
    
    int inasistenciaSeleccionada;
    private boolean noHaSeleccionadoUnaInasistencia() {
        inasistenciaSeleccionada = vista.listaDeInasistenciaPorEmpleado.getSelectedRow();
        return inasistenciaSeleccionada == -1;
    }
    
    private void buscar() {
        inasistencia = servicioDeInasistencia.buscar(obtenerIdDeLaInasistenciaSeleccionada());
    }
    
    private long obtenerIdDeLaInasistenciaSeleccionada() {
        return (long) vista.listaDeInasistenciaPorEmpleado.
                    getValueAt(inasistenciaSeleccionada, 0);
    }
    
    private void verificarSiEstaJustifica() {
        if (inasistencia.estaJustificada()) {
            Notification.windowMessage(vista, 
                    "Disculpe!", 
                    "Esta inasistencia ya está justificada.", 
                    NiconEvent.NOTIFY_DEFAULT);
        } else {
            mostrarVistaDeJustificacion();
        }
    }
    
    private void mostrarVistaDeJustificacion() {   
        vista.lblHoraDeGeneracion.setText(String.valueOf(inasistencia.getHoraDeGeneracion()));
        mostrarVentana(vista.VistaJustificacion, 373, 300);
    }
    
    private void verJustificacion() { 
        if (noHaConsultadoUnaFecha()) {
            Notification.windowMessage(vista, 
                    "Disculpe!", 
                    "Primero debe realizar una consulta.", 
                    NiconEvent.NOTIFY_DEFAULT);
        } else if (noHaSeleccionadoUnaInasistencia()) {
            Notification.windowMessage(vista, 
                    "Disculpe!", 
                    "Debe seleccionar una inasistencia", 
                    NiconEvent.NOTIFY_WARNING);
        } else {
            buscar();
            verificarSiEstaJustificaParaMostrarLaJustificacion();
        }
    }
    
    private void verificarSiEstaJustificaParaMostrarLaJustificacion() {
        if (inasistencia.estaJustificada()) {
            vista.lblFechaDeJustificacion.setText(formatoCortoFecha.print(inasistencia.getJustificacion().getFecha()));
            vista.lblHoraDeJustificacion.setText(formatoHora.format(inasistencia.getJustificacion().getHora()));
            vista.txtObservacionJustificacion.setText(inasistencia.getJustificacion().getDescripcion());
            mostrarVentana(vista.VistaVerJustificacion, 400, 300);
        } else {
            Notification.windowMessage(vista, 
                    "Disculpe!", 
                    "Debe seleccionar una inasistencia justificada.", 
                    NiconEvent.NOTIFY_DEFAULT);
        }
    }
    
    private void verInasistenciaSemanalGeneral() {
        try {
           
            reporteSemanal = new ReporteDeInasistenciaSemanalGeneral(vista.fechaInasistenciaSemanal.getDate());
            reporteSemanal.setServicio(servicioDeInasistencia);
            
            reporteSemanal.generar();
            inasistenciaSemanalPresenter.ver(reporteSemanal);
            mostrarVentana(vista.VistaInasistenciaSemanal, 729, 736);
            
        } catch (SinInasistenciasException | SinFechasException | FechaIncorrectaException e) {
            Notification.windowMessage(vista, "Disculpe!", 
                    e.getMessage(),
                    NiconEvent.NOTIFY_DEFAULT);
        }
    }
    
    private void verInasistenciaSemanalPersonal() {
        try {
           
            reporteSemanal = new ReporteDeInasistenciaSemanalPersonal(vista.fechaInasistenciaSemanalPersonal.getDate(),
                            vista.lblCedulaEmpleado.getText());
            reporteSemanal.setServicio(servicioDeInasistencia);
            
            reporteSemanal.generar();
            reporteInasistenciaPersonal.ver(reporteSemanal);
            mostrarVentana(vista.VistaInasistenciasSemanalPersonal, 650, 270);
            
        } catch (SinInasistenciasException | SinFechasException | FechaIncorrectaException e) {
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
                seleccionarInasistencia();
            }
            
            if (evento.equals(vista.btnJustificar)) {
                JustificarInasistencia();
            }
            
            if (evento.equals(vista.btnVerInasistenciaSemanal)) {
                verInasistenciaSemanalGeneral();
            }
            
            if (evento.equals(vista.btnVerJustificacion)) {
                verJustificacion();
            }
            
            if (evento.equals(vista.btnVerInasistenciasSemnalDeEmpleado)) {
                mostrarVentana(vista.VistaSeleccionarFechaInasistenciaSemanalPersonal, 
                        500, 375);
            }
            
            if (evento.equals(vista.btnVerInasistenciaSemanalPersonal)) {
                verInasistenciaSemanalPersonal();
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