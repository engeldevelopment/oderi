
package presenter;

import java.text.SimpleDateFormat;
import javax.swing.SwingConstants;
import javax.swing.table.*;
import modelo.Asistencia;
import reportes.ReporteDeAsistencia;
import vista.Menu;

public class ReporteDeEntradaSalidaPresenter {
    private Menu vista;
    private DefaultTableModel tabla;
    private DefaultTableCellRenderer redender;
    private SimpleDateFormat formatoDeFechaCorta;
    
    public ReporteDeEntradaSalidaPresenter(Menu vista) {
        this.vista = vista;
        redender = new DefaultTableCellRenderer();
        tabla = (DefaultTableModel) vista.tablaReportAsistencia.getModel();
        formatoDeFechaCorta = new SimpleDateFormat("dd MMM yyyy");
        ajustarTabla();
    }
    
    private void ajustarTabla() {
        redender.setHorizontalAlignment(SwingConstants.CENTER);
        vista.tablaReportAsistencia.getColumnModel().getColumn(0).setCellRenderer(redender);
        vista.tablaReportAsistencia.getColumnModel().getColumn(1).setCellRenderer(redender);
        vista.tablaReportAsistencia.getColumnModel().getColumn(2).setCellRenderer(redender);
        vista.tablaReportAsistencia.getColumnModel().getColumn(3).setCellRenderer(redender);
        vista.tablaReportAsistencia.getColumnModel().getColumn(4).setCellRenderer(redender);
    }
    
    public void ver(ReporteDeAsistencia reporte) {
        vista.lblFechaEntradaSalida.setText(formatoDeFechaCorta.format(reporte.getFecha()));
        tabla.setNumRows(reporte.getAsistencias().size());
        int index = 0;
        for (Asistencia asistencia : reporte.getAsistencias()) {
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
    
    public void borrarListado() {
        while (tabla.getRowCount() > 0) {
            tabla.removeRow(0);
        }    
    }
}
