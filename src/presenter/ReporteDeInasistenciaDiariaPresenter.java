
package presenter;

import javax.swing.table.DefaultTableModel;
import modelo.Inasistencia;
import reportes.ReporteDeInasistenciaDiaria;
import vista.Menu;

public class ReporteDeInasistenciaDiariaPresenter {
    private Menu vista;
    private DefaultTableModel tabla;
    
    public ReporteDeInasistenciaDiariaPresenter(Menu vista) {
        this.vista = vista;
        this.tabla = (DefaultTableModel) vista.listaDeInasistenciasDiaria.getModel();
    }
    
    public void ver(ReporteDeInasistenciaDiaria reporte) {
        tabla.setNumRows(reporte.getListado().size());
        int index = 0;
        for(Inasistencia inasistencia: reporte.getListado()) {
            tabla.setValueAt(inasistencia.getEmpleado().getCedula(), index, 0);
            tabla.setValueAt(inasistencia.getEmpleado().getNombre()+" "+inasistencia.getEmpleado().getApellido(), index, 1);
            tabla.setValueAt(inasistencia.getMotivo().getNombre(), index, 2);
            index = index + 1;
        }
    }
}
