
package presenter;

import modelo.Empleado;
import vista.Menu;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.*;


public class EmpleadoPresenter {
    
    private List<Empleado> listado;
    private Menu vista;
    private DefaultTableModel tabla;
    private DefaultTableCellRenderer alinear;
            
    public EmpleadoPresenter(Menu vista) {
        this.vista = vista;
        alinear = new DefaultTableCellRenderer();
    }
    
    public void setLista(List<Empleado> listado) {
        this.listado = listado;
    }
    
    public void limpiarCampos() {
        vista.txtCedula.setText("");
        vista.txtNombreEmpleado.setText("");
        vista.txtApellidoEmpleado.setText("");
        vista.txtDepartamentoAsignado.setText("");
    }
}
