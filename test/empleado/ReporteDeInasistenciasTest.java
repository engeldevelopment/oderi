
package empleado;

import reportes.ReporteDeInasistenciaSemanal;
import excepciones.SinInasistenciasException;
import dao.InasistenciaDAO;
import excepciones.FechaDeInicioIncorrecta;
import excepciones.SinFechasException;
import java.util.ArrayList;
import java.util.List;
import modelo.Inasistencia;
import org.joda.time.DateTime;
import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ReporteDeInasistenciasTest {
    
    private ReporteDeInasistenciaSemanal reporte;
    private DateTime diaDeSolicitud;
    private DateTime viernes;
    private InasistenciaDAO servicio;
    private List<Inasistencia> listado;
    
    public ReporteDeInasistenciasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        servicio = mock(InasistenciaDAO.class);
        listado = mock(ArrayList.class);
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = FechaDeInicioIncorrecta.class)
    public void laFechaDeInicioDebeSerUnDiaLunes() throws FechaDeInicioIncorrecta, 
            SinInasistenciasException,
            SinFechasException {
        
        diaDeSolicitud = new DateTime("2018-04-04");
        reporte = new ReporteDeInasistenciaSemanal(diaDeSolicitud.toDate());
        
        reporte.generar();
    }
    
    @Test
    public void laFechaEsUnDiaLunes() throws FechaDeInicioIncorrecta, 
            SinInasistenciasException,
            SinFechasException {
        
        diaDeSolicitud = new DateTime("2018-04-02");
        reporte = new ReporteDeInasistenciaSemanal(diaDeSolicitud.toDate());
        int dia = diaDeSolicitud.getDayOfWeek();
        int diaLunes = 1;
        
        assertEquals(dia, diaLunes);
    }
    
    @Test(expected = SinFechasException.class)
    public void debeSeleccionarUnaFecha() throws FechaDeInicioIncorrecta, 
            SinInasistenciasException,
            SinFechasException {
        
        reporte = new ReporteDeInasistenciaSemanal(null);
    }
}
