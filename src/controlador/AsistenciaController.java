
package controlador;

import reportes.ReporteDeAsistencia;
import modelo.*;
import excepciones.*;
import presenter.AsistenciaPresenter;
import dao.*;
import vista.Menu;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import nicon.notify.core.*;
import presenter.ReporteDeEntradaSalidaPresenter;

public class AsistenciaController extends Controlador {
    
    private IServicioAsistencia servicio;
    private Asistencia asistencia;
    private AsistenciaPresenter presenter;
    private List<Asistencia> listadoDeAsistencias;
    private ReporteDeAsistencia reporte;
    private ReporteDeEntradaSalidaPresenter reporteDeEntradaSalidaP;
    private Menu vista;
    private ManejadorDeEventoAction manejador;
    private SimpleDateFormat formatoDeFecha;
    
    public AsistenciaController(Menu vista) {
        this.vista = vista;
    }

    @Override
    protected void instancias() {
        servicio = new AsistenciaDAO();
        manejador = new ManejadorDeEventoAction();
        formatoDeFecha = new SimpleDateFormat("EEEE, dd MMM YYYY");
        vista.lblFecha.setText(""+formatoDeFecha.format(new Date()));
        presenter = new AsistenciaPresenter(vista);
        reporteDeEntradaSalidaP = new ReporteDeEntradaSalidaPresenter(vista);
    }
    
    @Override
    protected void cargarInformacionDeLaBDs() {
         cargarAsistencias();
    }
    
    @Override
    protected void boton() {
        vista.btnEntrada.addActionListener(manejador);
        vista.btnSalida.addActionListener(manejador);
        vista.btnIniciarJornada.addActionListener(manejador);
        vista.txtBusquedaPorCedula.addKeyListener(manejador);
        vista.btnVerReporteDeAsistencia.addActionListener(manejador);
    }
    
    private void cargarAsistencias(){
        buscarAsistenciaDeHoy();
        if (hayAsistencias()) {
            presenter.ver(listadoDeAsistencias);
        } 
    }
    
    private void buscarAsistenciaDeHoy() {
        listadoDeAsistencias = (List<Asistencia>) servicio.asistenciasDeHoy();
    }
    
    private boolean hayAsistencias() {
        return !listadoDeAsistencias.isEmpty();
    }
    
    private void BuscarPorCedula() {
        listadoDeAsistencias = (List<Asistencia>) 
                servicio.buscarAsistenciaDelEmpleado(Filtro());
        presenter.ver(listadoDeAsistencias);
    }
    
    private String Filtro() {
        return vista.txtBusquedaPorCedula.getText();
    }
    
    int asistenciaSeleccionada = 0; 
    private void marcarEntrada() {
        try {
            
            ubicarAsistencia();
            asistencia.marcarEntrada();
            procesarAsistencia();
            Notification.windowMessage(vista, 
                "Listo!", 
                "Entrada Marcada", NiconEvent.NOTIFY_OK);
        
        } catch (AsistenciaMarcadaException e) {
            
            Notification.windowMessage(vista, 
                "Disculpe!", 
                "Ya a este empleado se le marcó la entrada!",
                NiconEvent.NOTIFY_DEFAULT);
            
        } catch (SinSeleccionarAsistencia e) {
            
            Notification.windowMessage(vista,
                "Disculpe!",
                "Debe seleccionar una asistencia.", 
                NiconEvent.NOTIFY_WARNING);
        }
    }
    
    private void ubicarAsistencia() throws SinSeleccionarAsistencia {
        seleccionarAsistencia(); 
        asistencia = servicio.buscar(asistenciaSeleccionada());
    }
    
    private void seleccionarAsistencia() throws SinSeleccionarAsistencia {
        asistenciaSeleccionada = vista.listaDeAsistencia.getSelectedRow();
        if (asistenciaSeleccionada == -1)
            throw new SinSeleccionarAsistencia();
    }
    
    private Long asistenciaSeleccionada() {
        return Long.parseLong(vista.listaDeAsistencia.getValueAt(
                asistenciaSeleccionada, 
                        0).toString());
    }
    
    private void procesarAsistencia() {
        servicio.guardar(asistencia);
        actualizarListaDeAsistencia();
    }
    
    private void marcarSalida() {
        try {
            
            ubicarAsistencia();
            asistencia.marcarSalida();
            procesarAsistencia();
            Notification.windowMessage(vista, 
                "Listo!", 
                "Salida Marcada", NiconEvent.NOTIFY_OK);
        
        } catch (AsistenciaMarcadaException  e) {
            
            Notification.windowMessage(vista, 
                "Disculpe!", 
                "Ya a este empleado se le marcó su salida!",
                NiconEvent.NOTIFY_DEFAULT);
        
        } catch(EntradaSinMarcarException e) {
            
            Notification.windowMessage(vista, 
                "Disculpe!", 
                "Primero marque la entrada!",
                NiconEvent.NOTIFY_DEFAULT);
        
        } catch (SinSeleccionarAsistencia ex) {
        
            Notification.windowMessage(vista,
                "Disculpe!",
                "Debe seleccionar una asistencia.", 
                NiconEvent.NOTIFY_WARNING);
        } 
    }
    
    private void actualizarListaDeAsistencia() {
        cargarAsistencias();
    }
    
    private void VerReporteDeEntadaSalida() {
        try {
            reporte = new ReporteDeAsistencia(
                        vista.calendarFechaConsulta.getDate(), new Date());
            reporte.setServicio(servicio);
            reporte.generar();
            reporteDeEntradaSalidaP.ver(reporte);
            mostrarVentana(vista.VistaReporteDeAsistencia, 700, 490);
        } catch (SinFechasException | FechaIncorrectaException e  ) {
            Notification.windowMessage(vista, 
                    "Disculpe!", e.getMessage(),
                    NiconEvent.NOTIFY_DEFAULT); 
        }  
    }
    
    private class ManejadorDeEventoAction implements ActionListener, KeyListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object evento = e.getSource();
            
            if (evento.equals(vista.btnIniciarJornada)) {
                cargarAsistencias();
            }
            
            if (evento.equals(vista.btnEntrada)) {
                marcarEntrada();
            }
            
            if (evento.equals(vista.btnSalida)) {
                marcarSalida();
            }
           
            if (evento.equals(vista.btnVerReporteDeAsistencia)) {
                VerReporteDeEntadaSalida();
            }
            
        }

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
             Object eventoLetras = e.getSource();
            if (eventoLetras.equals(vista.txtBusquedaPorCedula)) {
                BuscarPorCedula();
            }
        }
    }
}