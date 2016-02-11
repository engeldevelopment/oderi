
package presenter;

import modelo.Inasistencia;
import vista.Menu;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import org.joda.time.format.*;

public class InasistenciaPresenter {
    
    private List<Inasistencia> inasistencias;
    private Menu vista;
    private DefaultTableModel tabla;
    private DefaultTableCellRenderer alinear;
    private DateTimeFormatter formato = DateTimeFormat.forPattern("EEEE, dd MMM");
    
    public InasistenciaPresenter(Menu vista) {
        this.vista = vista;
        tabla = (DefaultTableModel) vista.listaDeInasistenciaPorEmpleado.getModel();
        alinear = new DefaultTableCellRenderer();
        formatearDeTabla();
    }
    
    private void formatearDeTabla() {
        vista.listaDeInasistenciaPorEmpleado.getColumnModel()
                .getColumn(0).setPreferredWidth(5);
        alinearTexto();
    }
    
    private void alinearTexto() {
        alinear.setHorizontalAlignment(SwingConstants.CENTER);
        vista.listaDeInasistenciaPorEmpleado.getColumnModel()
                .getColumn(0).setCellRenderer(alinear);
        vista.listaDeInasistenciaPorEmpleado.getColumnModel()
                .getColumn(1).setCellRenderer(alinear);
        vista.listaDeInasistenciaPorEmpleado.getColumnModel()
                .getColumn(2).setCellRenderer(alinear);
        vista.listaDeInasistenciaPorEmpleado.getColumnModel()
                .getColumn(3).setCellRenderer(alinear);     
    }
    
    
    public void setLista(List<Inasistencia> inasistencias) {
        this.inasistencias = inasistencias;
    }
    
    public void verListado() {
        tabla.setNumRows(inasistencias.size());
        int index = 0;
        for (Inasistencia inasistencia : inasistencias) {
            tabla.setValueAt(inasistencia.getId(), index, 0);
            tabla.setValueAt(formato.print(inasistencia.getDia()), index, 1);
            tabla.setValueAt(inasistencia.getMotivo().getNombre(), index, 2);
            if (inasistencia.estaJustificada()) {
                tabla.setValueAt("Sí", index, 3);
            } else {
                tabla.setValueAt("No", index, 3);
            }
            index = index + 1;
        }
    }
    
    public void borrarListado() {
        while (tabla.getRowCount() > 0) {
            tabla.removeRow(0);
        }    
    }
}
