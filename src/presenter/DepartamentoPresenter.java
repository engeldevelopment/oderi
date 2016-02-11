
package presenter;

import modelo.Departamento;
import vista.Menu;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class DepartamentoPresenter {
    
    private Menu vista;
    private List<Departamento> listado;
    private DefaultTableModel tabla;
    
    public DepartamentoPresenter(Menu vista) {
        this.vista = vista;
        tabla = (DefaultTableModel) vista.listadoDeDepartamentos.getModel();
    }
    
    public void setLista(List<Departamento> listado) {
        this.listado = listado;
    }
    
    public void verLista() {
        tabla.setNumRows(listado.size());
        int index = 0;
        for(Departamento departamento : listado) {
            tabla.setValueAt(departamento.getId(), index, 0);
            tabla.setValueAt(departamento.getNombre(), index, 1);
            index = index + 1;
        }
    }
}
