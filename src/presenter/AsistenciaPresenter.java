
package presenter;

import modelo.Asistencia;
import vista.Menu;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.*;

public class AsistenciaPresenter {

    private Menu vista;
    private DefaultTableModel tabla;
    private DefaultTableCellRenderer alinear;
    
    public AsistenciaPresenter(Menu vista) {
        this.vista = vista;
        tabla = (DefaultTableModel) vista.listaDeAsistencia.getModel();
        alinear = new DefaultTableCellRenderer();
        formatearDeTabla();
    }
    
    private void formatearDeTabla() {
        vista.listaDeAsistencia.getColumnModel()
                .getColumn(0).setPreferredWidth(5);
        alinearTexto();
    }
    
    private void alinearTexto() {
        alinear.setHorizontalAlignment(SwingConstants.CENTER);
        vista.listaDeAsistencia.getColumnModel().getColumn(0).setCellRenderer(alinear);
        vista.listaDeAsistencia.getColumnModel().getColumn(1).setCellRenderer(alinear);
        vista.listaDeAsistencia.getColumnModel().getColumn(2).setCellRenderer(alinear);
        vista.listaDeAsistencia.getColumnModel().getColumn(3).setCellRenderer(alinear);
        vista.listaDeAsistencia.getColumnModel().getColumn(4).setCellRenderer(alinear);
    }
    
    public void ver(List<Asistencia> listado) {
        tabla.setNumRows(listado.size());
        int index = 0;
        for (Asistencia asistencia : listado) {
            tabla.setValueAt(asistencia.getId(), index, 0);
            tabla.setValueAt(asistencia.getEmpleado().getNombre(), index, 1);
            tabla.setValueAt(asistencia.getEmpleado().getDepartamento().getNombre(), index, 2);
            tabla.setValueAt(asistencia.getHoraDeEntrada(), index, 3);
            tabla.setValueAt(asistencia.getHoraDeSalida(), index, 4);
            index = index + 1;
        }
    }
}