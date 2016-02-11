
package reportes;

import excepciones.*;
import vista.Menu;
import dao.IServicioAsistencia;
import java.util.*;
import javax.swing.SwingConstants;
import javax.swing.table.*;
import modelo.Asistencia;
import org.joda.time.DateTime;

public class ReporteDeAsistencia {
    
    private Date fechaDeConsulta;
    private Date fechaActual;
    private IServicioAsistencia servicio;
    private List<Asistencia> listado;
    private Menu vista;
    private DefaultTableModel tabla;
    private DefaultTableCellRenderer redender;
    
    public ReporteDeAsistencia(Date fechaDeConsulta, Date fechaActual, Menu vista) {
        this.fechaDeConsulta = fechaDeConsulta;
        this.fechaActual = fechaActual;
        this.vista = vista;
        redender = new DefaultTableCellRenderer();
        ajustarTabla();
    }
    
    public void setServicio(IServicioAsistencia servicio) {
        this.servicio = servicio;
    }

    public void ver() throws FechaAcualException, 
            FechaPosteriorException, SinFechasException, FechaSinActividad {
        
        if (fechaDeConsulta == null){
            throw new SinFechasException();
        } else if (fechaDeConsulta.equals(fechaActual)) {
            throw new FechaAcualException();
        } else if (fechaDeConsulta.after(fechaActual)) {
            throw new FechaPosteriorException();
        }
        
        listado = (List<Asistencia>) servicio.asistenciasDelDia(new DateTime(fechaDeConsulta));
        
        if (listado.isEmpty()){
            borrarListado();
            throw new FechaSinActividad();
        }
        Reporte();
    }
    
    private void ajustarTabla() {
        tabla = (DefaultTableModel) vista.tablaReportAsistencia.getModel();
        redender.setHorizontalAlignment(SwingConstants.CENTER);
        vista.tablaReportAsistencia.getColumnModel().getColumn(0).setCellRenderer(redender);
        vista.tablaReportAsistencia.getColumnModel().getColumn(1).setCellRenderer(redender);
        vista.tablaReportAsistencia.getColumnModel().getColumn(2).setCellRenderer(redender);
        vista.tablaReportAsistencia.getColumnModel().getColumn(3).setCellRenderer(redender);
        vista.tablaReportAsistencia.getColumnModel().getColumn(4).setCellRenderer(redender);
    }
    
    private void Reporte() {
        tabla.setNumRows(listado.size());
        int index = 0;
        for (Asistencia asistencia : listado) {
                tabla.setValueAt(asistencia.getEmpleado().getCedula(), index, 0);
                tabla.setValueAt(asistencia.getEmpleado().getNombre(), index, 1);
                tabla.setValueAt(asistencia.getHoraDeEntrada(), index, 2);
                tabla.setValueAt(asistencia.getHoraDeSalida(), index, 3);
                
                if (!asistencia.estaSinFirmar()) {
                    tabla.setValueAt(asistencia.HorasTrabajadas()+"h", index, 4);
                } else {
                    tabla.setValueAt("Inasistente", index, 4);
                }
                index = index + 1;
        }
    }
    
    private void borrarListado() {
        while (tabla.getRowCount() > 0) {
            tabla.removeRow(0);
        }    
    }
}