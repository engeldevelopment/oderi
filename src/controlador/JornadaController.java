
package controlador;

import excepciones.*;
import modelo.*;
import vista.Menu;
import dao.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import nicon.notify.core.*;

public class JornadaController extends Controlador {

    private Jornada jornada;
    private JornadaDAO servicioDeJornada;
    private List<Empleado> empleados;
    private EmpleadoDAO servicioDeEmpleados;
    private Menu vista;
    private ManejadorDeEventosAction manejador;
    private GeneradorDeInasistencia generador;
    private IServicioAsistencia servicioDeAsistencia;
    private IServicioInasistencia servicioDeInasistencia;
    private MotivoDeInasistenciaDAO servicioDeMotivo;
    private DefaultTableModel tabla;
    private SimpleDateFormat formatoDeHora;
    
    public JornadaController(Menu vista) {
        this.vista = vista;
    }

    @Override
    protected void instancias() {
        servicioDeJornada = new JornadaDAO();
        manejador = new ManejadorDeEventosAction();
        servicioDeAsistencia = new AsistenciaDAO();
        servicioDeInasistencia =  new InasistenciaDAO();
        servicioDeMotivo = new MotivoDeInasistenciaDAO();
        tabla = (DefaultTableModel) vista.listaDeInasistencias.getModel();
        formatoDeHora = new SimpleDateFormat("h:m:s a");
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
            deshabilitarBotones();
        }
        
        if (jornada.estaEnCurso())  {
            habilitarBotones();
            vista.lblHoraInicio.setText(formatoDeHora.format(jornada.getHoraDeInicio()));
        }
        
        if (jornada.estaCerrada()) {
            deshabilitarBotones();
            vista.lblHoraInicio.setText(formatoDeHora.format(jornada.getHoraDeInicio()));
            vista.lblHoraCierre.setText(formatoDeHora.format(jornada.getHoraDeCierre()));
        }
        vista.lblEstado.setText(NombreDeJornada.establecer(jornada));
    }
    
    private void iniciarJornada() {
        buscarJornada();
        if (jornada.estaSinIniciar()) 
             crearNuevaJornada();
    }
    
    private void buscarJornada() {
        jornada = servicioDeJornada.jornadaDeHoy();
    }
    
    private void crearNuevaJornada() {
        try {
            servicioDeEmpleados = new EmpleadoDAO();
            jornada = new JornadaDeTrabajo((List<Empleado>) servicioDeEmpleados.buscarTodos(), 
                    servicioDeAsistencia);
            jornada.iniciar();
            servicioDeJornada.guardar(jornada);
            vista.lblHoraInicio.setText(formatoDeHora.format(jornada.getHoraDeInicio()));
            habilitarBotones();
            Notification.windowMessage(vista, 
                    "Listo!", 
                    "Nueva jornada de trabajo iniciada!", 
                    NiconEvent.NOTIFY_OK);
        } catch (JornadaCerradaException ex) {
            
            Notification.windowMessage(vista, 
                    "Disculpe!", 
                    "No se pueden iniciar más jornadas por hoy!"
                            + "\nEspere otro día..");
        
        } catch (NoHayEmpleadoException e) {
            
            Notification.windowMessage(vista, 
                    "Disculpe!", 
                    "No hay empleados registrados!"
                            + "\nDebe registrar al menos uno..");
        
        } catch (JornadaEnCursoException ex) {
        
            Notification.windowMessage(vista, 
                    "Disculpe!", 
                    "Ya hay una jornada en curso!");
        }
        vista.lblEstado.setText(NombreDeJornada.establecer(jornada));
    }
    
    private void habilitarBotones() {
        vista.btnEntrada.setEnabled(true);
        vista.btnSalida.setEnabled(true);
        vista.txtBusquedaPorCedula.setEnabled(true);
    }
    
    private void finalizarJornada() {
        buscarJornada();
        if (jornada.estaEnCurso()){
            int respuesta = Notification.windowConfirmMessage(vista, 
                    "Confirma", 
                    "¿Estás seguro que deseas finalizar la jornada?");
            if (respuesta == 1) {
                try {
                    jornada.setServicio(servicioDeAsistencia);
                    jornada.cerrar();
                    servicioDeJornada.actualizar(jornada);
                    deshabilitarBotones();
                    
                    MotivoDeInasistencia motivo = servicioDeMotivo.buscar(1l);
                    generador = new GeneradorDeInasistencia(servicioDeInasistencia,
                            servicioDeAsistencia, motivo);
                    generador.evaluar();
                    
                    vista.lblEstado.setText(NombreDeJornada.establecer(jornada));
                    vista.lblHoraCierre.setText(formatoDeHora.format(jornada.getHoraDeCierre()));
                    Notification.windowMessage(vista, "Listo!",
                            "Fin de la jornada!",
                            NiconEvent.NOTIFY_OK);
                } catch (AsistenciaIncompletaException ex) {
                    Notification.windowMessage(vista, "Disculpa!", 
                            "Hay empleados que aún no han marcado su salida!\n"
                                    + "Por favor marcalas para poder cerrar la jornada.");
                }
            }
        }
    }
   
    private void deshabilitarBotones() {
        vista.btnEntrada.setEnabled(false);
        vista.btnSalida.setEnabled(false);
        vista.txtBusquedaPorCedula.setEnabled(false);
    }
    
    private void reporteDelDia() {
        buscarJornada();
        try {
            RelacionDeAsistencia relacion = new RelacionDeAsistencia(jornada);
            relacion.imprimir();
            verInasistencias();
            ventana(vista.ReporteDeInasistenciaActual, 410, 270);            
        } catch (SinIniciarJornadaException ex) {
           Notification.windowMessage(vista, "Disculpe!", 
                       "Debe haber una jornada iniciada y "
                     + "finalizada para poder imprimir el reporte de hoy!");
        } catch (JornadaEnCursoException ex) {
           Notification.windowMessage(vista, "Disculpe!", 
                        "Hay una jornada en curso!\n"
                      + "Debe finalizarla para poder imprimir el reporte de hoy");
        }
    }
    
    private void verInasistencias() {
        List<Inasistencia> listado = (List<Inasistencia>) servicioDeInasistencia.inasistenciasDeHoy();
        tabla.setNumRows(listado.size());
        int index = 0;
        for(Inasistencia inasistencia: listado) {
            tabla.setValueAt(String.valueOf(inasistencia.getEmpleado().getCedula()), index, 0);
            tabla.setValueAt(inasistencia.getEmpleado().getNombre()+" "+inasistencia.getEmpleado().getApellido(), index, 1);
            tabla.setValueAt(inasistencia.getMotivo().getNombre(), index, 2);
            index = index + 1;
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
                reporteDelDia();
           }
        }
    }
}