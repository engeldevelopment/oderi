
package presenter;

import modelo.Empleado;
import vista.Menu;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.*;


public class EmpleadoPresenter {
    
    private Menu vista;
    private DefaultTableModel tabla;
    private DefaultTableCellRenderer alinear;
            
    public EmpleadoPresenter(Menu vista) {
        this.vista = vista;
        this.tabla = (DefaultTableModel) vista.listaDeEmpleados.getModel();
        alinear = new DefaultTableCellRenderer();
        alinearColumnasDeTabla();
    }
    
    private void alinearColumnasDeTabla() {
        alinear.setHorizontalAlignment(SwingConstants.CENTER);
        vista.listaDeEmpleados.getColumnModel().getColumn(0).setCellRenderer(alinear);
        vista.listaDeEmpleados.getColumnModel().getColumn(1).setCellRenderer(alinear);
        vista.listaDeEmpleados.getColumnModel().getColumn(2).setCellRenderer(alinear);
        vista.listaDeEmpleados.getColumnModel().getColumn(3).setCellRenderer(alinear);
    }
    
    public void ver(List<Empleado> listado) {
        tabla.setNumRows(listado.size());
        
        int index = 0;
        for (Empleado e: listado) {
            tabla.setValueAt(e.getCedula(), index, 0);
            tabla.setValueAt(e.getNombre(), index, 1);
            tabla.setValueAt(e.getApellido(), index, 2);
            tabla.setValueAt(e.getDepartamento().getNombre(), index, 3);
            index++;
        }
    }
    
    public void limpiarCampos() {
        vista.txtCedula.setText("");
        vista.txtNombreEmpleado.setText("");
        vista.txtApellidoEmpleado.setText("");
        vista.txtDepartamentoAsignado.setText("");
    }
}
