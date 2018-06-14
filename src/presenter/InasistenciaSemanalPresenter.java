
package presenter;

import java.util.ArrayList;
import reportes.ReporteDeInasistenciaSemanal;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import modelo.*;
import org.joda.time.format.*;
import vista.Menu;

public class InasistenciaSemanalPresenter {
    private Menu vista;
    private DateTimeFormatter formato = DateTimeFormat.forPattern("dd-MM-yyyy");
    private DateTimeFormatter formatoDos = DateTimeFormat.forPattern("EEE, dd MMM.");
    private DefaultTableModel diaLunes;
    private DefaultTableModel diaMartes;
    private DefaultTableModel diaMiercoles;
    private DefaultTableModel diaJueves;
    private DefaultTableModel diaViernes;
    private DefaultTableCellRenderer redender;
    
    public InasistenciaSemanalPresenter(Menu vista) {
        this.vista = vista;
        diaLunes = (DefaultTableModel) vista.tablaInasistenciaLunes.getModel();
        diaMartes = (DefaultTableModel) vista.tablaInasistenciaMartes.getModel();
        diaMiercoles = (DefaultTableModel) vista.tablaInasistenciaMiercoles.getModel();
        diaJueves = (DefaultTableModel) vista.tablaInasistenciaJueves.getModel();
        diaViernes = (DefaultTableModel) vista.tablaInasistenciaViernes.getModel();
        redender = new DefaultTableCellRenderer();
        alinearTextoDeTablas();
    }
    
    private void alinearTextoDeTablas() {
        ajustarAnchoDeTablas();
        alinearTextoDe(vista.tablaInasistenciaLunes);
        alinearTextoDe(vista.tablaInasistenciaMartes);
        alinearTextoDe(vista.tablaInasistenciaMiercoles);
        alinearTextoDe(vista.tablaInasistenciaJueves);
        alinearTextoDe(vista.tablaInasistenciaViernes);
    }
    
    private void alinearTextoDe(JTable tabla) {
        redender.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.getColumnModel()
                .getColumn(0).setCellRenderer(redender);
        tabla.getColumnModel()
                .getColumn(1).setCellRenderer(redender);
        tabla.getColumnModel()
                .getColumn(2).setCellRenderer(redender);
    }
    
    private void ajustarAnchoDeTablas() {
        List<JTable> tablasDeInasistencias = new ArrayList();
        tablasDeInasistencias.add(vista.tablaInasistenciaLunes);
        tablasDeInasistencias.add(vista.tablaInasistenciaMartes);
        tablasDeInasistencias.add(vista.tablaInasistenciaMiercoles);
        tablasDeInasistencias.add(vista.tablaInasistenciaJueves);
        tablasDeInasistencias.add(vista.tablaInasistenciaViernes);
        
        for (JTable t: tablasDeInasistencias) {
            ajustarAnchoDeTabla(t, 0, 8);
            ajustarAnchoDeTabla(t, 1, 140);
            ajustarAnchoDeTabla(t, 2, 8);
        }
    }
    
    private void ajustarAnchoDeTabla(JTable tabla, int col, int ancho) {
        tabla.getColumnModel().getColumn(col).setPreferredWidth(ancho);
    }
    
    public void ver(ReporteDeInasistenciaSemanal reporte) {
        vista.VistaInasistenciaSemanal.setTitle("Inasistencia Semanal desde "+
                formato.print(reporte.getFechaDeInicio())+" hasta "+
                formato.print(reporte.getFechaDeCorte()));
        establecerFechas(reporte);
        verLista(diaLunes, reporte.listaDelDiaLunes());
        verLista(diaMartes, reporte.listaDelDiaMartes());
        verLista(diaMiercoles, reporte.listaDelDiaMiercoles());
        verLista(diaJueves, reporte.listaDelDiaJueves());
        verLista(diaViernes, reporte.listaDelDiaViernes());
    }
    
    private void verLista(DefaultTableModel tabla, List<Inasistencia> lista) {
        tabla.setNumRows(lista.size());
        int index = 0;
        
        for (Inasistencia inasistencia: lista) {
            tabla.setValueAt(inasistencia.getEmpleado().getCedula(), index, 0);
            tabla.setValueAt(inasistencia.getEmpleado().getNombre(), index, 1);
            if (inasistencia.estaJustificada()) {
                tabla.setValueAt("Sí", index, 2);
            } else {
                tabla.setValueAt("No", index, 2);
            }
            index = index + 1;
        }
    }
    
    private void establecerFechas(ReporteDeInasistenciaSemanal reporte) {
        if (!reporte.listaDelDiaLunes().isEmpty()) {
            vista.lblFechaLunes.setText(formatoDos.print(reporte.getFechaDeInicio()));    
        } else {
            vista.lblFechaLunes.setText(formatoDos.print(reporte.getFechaDeInicio())+" ¡No hubo!");
        } 
        
        if (!reporte.listaDelDiaMartes().isEmpty()) {
            vista.lblFechaMartes.setText(formatoDos.print(reporte.getFechaDeInicio().plusDays(1)));
        } else {
            vista.lblFechaMartes.setText(formatoDos.print(reporte.getFechaDeInicio().plusDays(1))+" ¡No hubo!");
        }
        
        if (!reporte.listaDelDiaMiercoles().isEmpty()) {
            vista.lblFechaMiercoles.setText(formatoDos.print(reporte.getFechaDeInicio().plusDays(2)));
        } else {
            vista.lblFechaMiercoles.setText(formatoDos.print(reporte.getFechaDeInicio().plusDays(2))+" ¡No hubo!");
        }
        
        if (!reporte.listaDelDiaJueves().isEmpty()) {
            vista.lblFechaJueves.setText(formatoDos.print(reporte.getFechaDeInicio().plusDays(3)));
        } else {
            vista.lblFechaJueves.setText(formatoDos.print(reporte.getFechaDeInicio().plusDays(3))+" ¡No hubo!");
        }
        
        if (!reporte.listaDelDiaViernes().isEmpty()) {
            vista.lblFechaViernes.setText(formatoDos.print(reporte.getFechaDeCorte()));
        } else {
            vista.lblFechaViernes.setText(formatoDos.print(reporte.getFechaDeCorte())+" ¡No hubo!");
        }
    }
}