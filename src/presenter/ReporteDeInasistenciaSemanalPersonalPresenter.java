
package presenter;

import javax.swing.JList;
import modelo.Inasistencia;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import reportes.ReporteDeInasistenciaSemanal;
import vista.Menu;

public class ReporteDeInasistenciaSemanalPersonalPresenter {
    private Menu vista;
    private JList listaDeInasistencias;
    private DateTimeFormatter fechaFormateada;
    private DateTimeFormatter fechaCorta;
            
    public ReporteDeInasistenciaSemanalPersonalPresenter(Menu vista) {
        this.vista = vista;
        this.listaDeInasistencias = vista.listaDeInasistenciasSemanalDeEmpleado;
        this.fechaFormateada = DateTimeFormat.forPattern("EEEE, dd MMM yyyy");
        this.fechaCorta = DateTimeFormat.forPattern("dd-MM-yyyy");
    }
    
    public void ver(ReporteDeInasistenciaSemanal reporte) {
        int index = 0;
        String dias[] = new String[reporte.getListado().size()];
        
        for (Inasistencia i: reporte.getListado()) {
            dias[index] = fechaFormateada.print(i.getDia());
            index++;
        }
        
        listaDeInasistencias.setListData(dias);
        vista.lblCedulaInasistenciaSemanal.setText(vista.lblCedulaEmpleado.getText());
        vista.lblEmpleadoInasistenciaSemanal.setText(vista.lblNombreEmpleado.getText());
        vista.lblDepartamentoInasistenciaSemanal.setText(vista.lblDepartamentoEmpleado.getText());
        vista.lblTotalInasistenciaSemanal.setText(String.valueOf(reporte.getListado().size()));
        vista.VistaInasistenciasSemanalPersonal
                .setTitle("Inasistencias Semanal desde "+fechaCorta.print(reporte.getFechaDeInicio())+
                        " hasta "+fechaCorta.print(reporte.getFechaDeCorte()));
    }
}
