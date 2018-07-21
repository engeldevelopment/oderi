
package controlador;

import excepciones.*;
import modelo.*;
import vista.Menu;
import dao.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import nicon.notify.core.*;
import presenter.ReporteDeInasistenciaDiariaPresenter;
import reportes.ReporteDeInasistenciaDiaria;

public class JornadaController extends Controlador {

    private Jornada jornada;
    private JornadaDAO servicioDeJornada;
    private List<Empleado> empleados;
    private EmpleadoDAO servicioDeEmpleados;
    private Menu vista;
    private ManejadorDeEventosAction manejador;
    private GeneradorDeInasistencia generador;
    private GeneradorDeAsistencia generadorDeAsistencia;
    private IServicioAsistencia servicioDeAsistencia;
    private IServicioInasistencia servicioDeInasistencia;
    private MotivoDeInasistenciaDAO servicioDeMotivo;
    private SimpleDateFormat formatoDeHora;
    private ReporteDeInasistenciaDiariaPresenter reporteDeInasistencia;
    
    public JornadaController(Menu vista) {
        this.vista = vista;
    }

    @Override
    protected void instancias() {
        servicioDeJornada = new JornadaDAO();
        manejador = new ManejadorDeEventosAction();
        servicioDeAsistencia = new AsistenciaDAO();
        servicioDeInasistencia =  new InasistenciaDAO();
        servicioDeEmpleados = new EmpleadoDAO();
        servicioDeMotivo = new MotivoDeInasistenciaDAO();
        formatoDeHora = new SimpleDateFormat("h:m:s a");
        reporteDeInasistencia = new ReporteDeInasistenciaDiariaPresenter(vista);
    }

    @Override
    protected void cargarInformacionDeLaBDs() {
        analizar();
    }
    
    @Override
    protected void boton() {
        vista.btnFinalizarJornada.addActionListener(manejador);
        vista.btnIniciarJornada.addActionListener(manejador);
        vista.btnReporte.addActionListener(manejador);
    }
    
    private void analizar() {
        buscarJornada();
        if (jornada.estaSinIniciar()) {
            deshabilitarBotonesParaMarcarAsistencias();
        }
        
        if (jornada.estaEnCurso())  {
            habilitarBotonesParaMarcarAsistencias();
            vista.lblHoraInicio.setText(formatoDeHora.format(jornada.getHoraDeInicio()));
        }
        
        if (jornada.estaCerrada()) {
            deshabilitarBotonesParaMarcarAsistencias();
            vista.lblHoraInicio.setText(formatoDeHora.format(jornada.getHoraDeInicio()));
            vista.lblHoraCierre.setText(formatoDeHora.format(jornada.getHoraDeCierre()));
        }
        vista.lblEstado.setText(NombreDeJornada.establecer(jornada));
    }
    
    private void iniciarJornada() {
        buscarJornada(); 
        crearNuevaJornada();
    }
    
    private void buscarJornada() {
        jornada = servicioDeJornada.jornadaDeHoy();
    }
    
    private void crearNuevaJornada() {
        try {
       
            jornada.iniciar();     
            generarListadoDeAsistencia();
            servicioDeJornada.guardar(jornada);
            vista.lblHoraInicio.setText(formatoDeHora.format(jornada.getHoraDeInicio()));
            habilitarBotonesParaMarcarAsistencias();
            Notification.windowMessage(vista, 
                    "Listo!", 
                    "Nueva jornada de trabajo iniciada!", 
                    NiconEvent.NOTIFY_OK);
        } catch (JornadaCerradaException | JornadaEnCursoException | 
                NoHayEmpleadoException ex) {
            
            Notification.windowMessage(vista, 
                    "Disculpe!", 
                    ex.getMessage());
        
        } 
        vista.lblEstado.setText(NombreDeJornada.establecer(jornada));
    }
    
    private void generarListadoDeAsistencia() throws NoHayEmpleadoException {
        empleados = (List<Empleado>) servicioDeEmpleados.buscarTodos();    
        generadorDeAsistencia = new GeneradorDeAsistencia(empleados, servicioDeAsistencia);
            
        generadorDeAsistencia.generar();   
    }
    
    private void habilitarBotonesParaMarcarAsistencias() {
        vista.btnEntrada.setEnabled(true);
        vista.btnSalida.setEnabled(true);
        vista.txtBusquedaPorCedula.setEnabled(true);
    }
    
    private void finalizarJornada() {
        buscarJornada();
        int respuesta = Notification.windowConfirmMessage(vista, 
                    "Confirma", 
                    "¿Estás seguro que deseas finalizar la jornada?");
        if (respuesta == 1) {
             cerrar();
        }
    }
    
    private void cerrar() {
        try {
            jornada.setServicio(servicioDeAsistencia);
            jornada.cerrar();
            servicioDeJornada.actualizar(jornada);
                    
            MotivoDeInasistencia motivo = servicioDeMotivo.buscar(1l);
            generador = new GeneradorDeInasistencia(servicioDeInasistencia,
                            servicioDeAsistencia, motivo);
            
            generador.evaluar();
            
            deshabilitarBotonesParaMarcarAsistencias();        
            vista.lblEstado.setText(NombreDeJornada.establecer(jornada));
            vista.lblHoraCierre.setText(formatoDeHora.format(jornada.getHoraDeCierre()));
                    Notification.windowMessage(vista, "Listo!",
                            "Fin de la jornada!",
                            NiconEvent.NOTIFY_OK);
        } catch (AsistenciaIncompletaException | 
                JornadaCerradaException | SinIniciarJornadaException ex) {
             Notification.windowMessage(vista, "Disculpe!", 
                    ex.getMessage());
        } 
    }
   
    private void deshabilitarBotonesParaMarcarAsistencias() {
        vista.btnEntrada.setEnabled(false);
        vista.btnSalida.setEnabled(false);
        vista.txtBusquedaPorCedula.setEnabled(false);
    }
    
    private void verReporteDeInasistenciaDeHoy() {
        buscarJornada();
        try {
            ReporteDeInasistenciaDiaria reporte = 
                    new ReporteDeInasistenciaDiaria(servicioDeInasistencia, jornada);
            
            reporte.generar();
            reporteDeInasistencia.ver(reporte);
            mostrarVentana(vista.ReporteDeInasistenciaActual, 410, 270);
            
        } catch (SinIniciarJornadaException | SinInasistenciasException | 
                JornadaEnCursoException ex) {
           Notification.windowMessage(vista, "Disculpe!", 
                       ex.getMessage());
        } 
    }
    
    private class ManejadorDeEventosAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           Object evento = e.getSource();           
           if (evento.equals(vista.btnIniciarJornada)) {
               iniciarJornada();
           } else if (evento.equals(vista.btnFinalizarJornada)) {
               finalizarJornada();
           } else if(evento.equals(vista.btnReporte)) {
                verReporteDeInasistenciaDeHoy();
           }
        }
    }
}